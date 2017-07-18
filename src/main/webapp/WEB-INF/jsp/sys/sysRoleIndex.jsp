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
    <link href="${basePath}/bootstrap-switch-3.3.4/css/bootstrap3/bootstrap-switch.min.css" rel="stylesheet">

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
                <%-- <form class="form-inline" role="form">
                     <div class="form-group">
                         <label class="sr-only" for="caseNo">案件编号</label>
                         <input id="caseNo" class="form-control" name="caseNo" type="text" placeholder="案件编号">
                     </div>
                     <div class="form-group" style="margin-left: 20px">
                         <label class="sr-only" for="caseName">案件名称</label>
                         <input id="caseName" class="form-control" name="caseName" type="text" placeholder="案件名称">
                     </div>
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
                 </form>--%>
                <button id="item-save" class="btn btn-success">新增</button>
                <div style="margin-top: 10px"></div>
                <table id="table"></table>
            </div>
        </div>
    </div>
</div>
<!-- /#wrapper -->
<%@ include file="/common/basejs.jsp" %>
<%@ include file="/common/tablejs.jsp" %>
<script src="/js/table.js"></script>
<script src="/bootstrap-switch-3.3.4/js/bootstrap-switch.js"></script>
<script>
    var delUrl = "${basePath}/sysRole/delete";
    var editUrl = "${basePath}/sysRole/toSaveOrUpdate";
    var $table = $('#table');
    $table.bootstrapTable({
        url: "${basePath}/sysRole/page",
        method: "POST",
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        pagination: false, //分页
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
//        showRefresh: true,
//        showColumns: true,
//        detailView: true,
        onPostBody: function () {
            $('.bootstrap-switch').bootstrapSwitch(
                {
                    onText: "启用",
                    offText: "禁用",
                    size: "mini",
                    offColor: "danger",
                    onSwitchChange: function (e, data) {
                        var id = $(this).attr("name")
                        if (data == true) {
                            data = 1;
                        } else {
                            data = 0;
                        }
                        $.get("${basePath}/sysRole/setStatus", {id: id, status: data}, function (data) {
                            if (data.code == 0) {
                                layer.msg(
                                    data.msg,
                                    {
                                        icon: 1,
                                        time: 1000
                                    });
                            } else {
                                layer.msg(
                                    data.msg,
                                    {
                                        icon: 2,
                                        time: 1000
                                    },
                                    function () {
                                        refreshTable();
                                    });
                            }
                        });
                    }
                }
            );
        },
        queryParams: function queryParams(params) {   //设置查询参数
            var caseType;
            $("input:radio").each(function () {
                if ($(this).prop("checked")) {
                    caseType = $(this).val();
                }
            })
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
                title: '主键',
                field: 'id',
                align: 'center',
                valign: 'middle',
                visible: false

            },
            {
                title: '名称',
                field: 'name',
                align: 'center',
                valign: 'middle',

            },
            {
                title: '描述',
                field: 'des',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '创建日期',
                field: 'createdate',
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    var date = new Date(value);
                    return date.pattern("yyyy-MM-dd")
                }
            },
            {
                title: '状态',
                field: 'status',
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    //language=HTML
                    var html
                    if (value == 0) {
                        html = "<input name='" + row.id + "' class='bootstrap-switch' type='checkbox'/>";
                    } else {
                        html = "<input name='" + row.id + "' class='bootstrap-switch' type=\"checkbox\" checked />";
                    }
                    return html;
                }
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                formatter: function (value, row, index) {
                    var a = '<button class="btn btn-sm btn-info" onclick="itemEditOrSave(\'' + row.id + '\',\'' + editUrl + '\',\'70%\',\'70%\')"><i class="fa fa-edit"></i>编辑</button> ';
                    var b = '<button class="btn btn-sm btn-danger"  onclick="itemDelele(\'' + row.id + '\',\'' + delUrl + '\')"><i class="glyphicon glyphicon-remove"></i>删除</button> ';
                    var c = '<button class="btn btn-sm btn-primary" onclick="itemEditOrSave(\'' + row.id + '\',\'' + '${basePath}/sysRoleRes/index' + '\',\'30%\',\'70%\')"><i class="fa fa-edit"></i>权限分配</button> ';
                    return a + b + c;
                }
            }
        ]
    });
    $("#item-save").click(function () {
        itemEditOrSave("", editUrl, "70%", "70%");
    })
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
