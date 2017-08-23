<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/common/base.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Hanfei">
    <title>列表测试</title>
    <%@ include file="/common/basecss.jsp" %>
</head>

<style>
    #page-wrapper {
        margin: 0;
    }

    input[type='text'] {
        width: 110px !important;
    }
</style>

<body>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel-body" style="margin-top: 10px">
                <form class="form-inline" role="form">
                    <div class="form-group">
                        <label class="sr-only" for="caseNo">案件编号</label>
                        <input id="caseNo" class="form-control" name="caseNo" type="text" placeholder="案件编号">
                    </div>
                    <div class="form-group" style="margin-left: 20px">
                        <label class="sr-only" for="caseName">案件名称</label>
                        <input id="caseName" class="form-control" name="caseName" type="text" placeholder="案件名称">
                    </div>
                    <%-- <div class="form-group" style="margin-left: 10px">
                         <label class="sr-only" for="caseName">案件名称</label>
                         <select id="city" class="form-control" name="caseName" type="text">
                             <option value="">选择城市</option>
                             <option value="1">北京</option>
                             <option value="2">天津</option>
                             <option value="3">上海</option>
                         </select>
                     </div>--%>

                    <div class="form-group" style="margin-left: 10px">
                        <input type="text" id="beginDate" name="beginDate"
                               class="form-control date" placeholder="开始时间"/>
                        <i class="fa fa-exchange"></i>
                        <input type="text" id="endDate" name="endDate"
                               class="form-control date" placeholder="结束时间"/>
                    </div>
                    <div class="checkbox" style="margin-left: 10px">
                        <label>
                            <input id="radio1" type="radio" name="caseType" value="0" checked>全部
                        </label>
                        <label>
                            <input id="radio3" type="radio" name="caseType" value="2">刑事案件
                        </label>
                        <label>
                            <input id="radio2" type="radio" name="caseType" value="3">行政案件
                        </label>
                    </div>
                    <button class="btn btn-success" id="search" style="margin-left: 20px">查询</button>
                    <button class="btn btn-primary" type="reset" style="margin-left: 5px">重置</button>
                </form>
                <table id="table"></table>
            </div>
        </div>
    </div>
</div>
<!-- /#wrapper -->
<%@ include file="/common/basejs.jsp" %>
<%@ include file="/common/tablejs.jsp" %>
<script src="/js/table.js"></script>
<script>
    var delUrl = "${basePath}/legalCase/delete";
    var editUrl = "${basePath}/legalCase/toSaveOrUpdate";
    var $table = $('#table');
    $table.bootstrapTable({
        url: "${basePath}/legalCase/page",
        method: "POST",
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        pagination: true, //分页
        singleSelect: false,
        pageNumber: 1,
        pageSize: 15,
        pageList: [15, 25, 30],
        locale: "zh-US", //表格汉化
        search: false, //显示搜索框
        sidePagination: "server", //服务端处理分页
        queryParamsType: '',
        searchOnEnterKey: true,
        //showToggle: true,
        showRefresh: true,
        showColumns: true,
        detailView: true,
        queryParams: function queryParams(params) {   //设置查询参数
            var caseType;
            $("input:radio").each(function () {
                if ($(this).prop("checked")) {
                    caseType = $(this).val();
                }
            });
            var param = {
                pageNumber: params.pageNumber,
                pageSize: params.pageSize,
                sortOrder: params.order,
                searchText: params.searchText,
                caseType: caseType,
                city: $("#city").val(),
                caseNo: $("#caseNo").val(),
                caseName: $("#caseName").val(),
            };
            return param;
        },
        detailFormatter: function (index, row, element) {
            var html = "";
            html += "<div><h3>" + row.caseNo + "</h3></div>";
            html += "<div><h3>" + row.caseName + "</h3></div>";
            html += "<div><h3>" + row.caseCreateDate + "</h3></div>";
            html += "<div><h3>" + row.caseStepsName + "</h3></div>";
            html += "<div><h3>" + row.caseTypeName + "</h3></div>";
            return html;
        },
        dataField: "list",
        /* responseHandler: function (res) {
         return {
         total: res.total,
         rows: res.list
         }
         },*/
        columns: [
            {
                title: '编号',
                field: 'caseNo',
                align: 'center',
                valign: 'middle',

            },
            {
                title: '案件名称',
                field: 'caseName',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '创建日期',
                field: 'caseCreateDate',
                align: 'center'
            },
            {
                title: '处理措施',
                field: 'caseStepsName',
                align: 'center',
            },
            {
                title: '案件性质',
                field: 'caseTypeName',
                align: 'center'
            },

            {
                title: '操作',
                field: 'id',
                align: 'center',
                formatter: function (value, row, index) {
                    var e = '<button class="btn btn-sm btn-info" onclick="itemEditOrSave(\'' + row.id + '\',\'' + editUrl + '\',\'70%\',\'70%\')"><i class="fa fa-edit"></i>编辑</button> ';
                    var d = '<button class="btn btn-sm btn-danger"  onclick="itemDelele(\'' + row.id + '\',\'' + delUrl + '\')"><i class="glyphicon glyphicon-remove"></i>删除</button> ';
                    return e + d;
                }
            }
        ]
    });
    $("#search").click(searchTable);
    $(".date").datetimepicker(
        {
            autoclose: true,
            clearBtn: true,
            todayHighlight: true,
            language: 'zh-CN',
            format: 'yyyy-mm-dd',
            //todayBtn: true,
            startView: 2,
            minView: 2,
        });
</script>
</body>
</html>
