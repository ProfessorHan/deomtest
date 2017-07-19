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
                <button class="btn btn-success" id="add">新增</button>
                <div style="margin-top: 15px"></div>
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
    var delUrl = "${basePath}/sysMenu/delete";
    var editUrl = "${basePath}/sysMenu/toEdit";
    var $table = $('#table');
    $table.bootstrapTable({
        url: "${basePath}/sysMenu/page",
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
                email: $("#email").val(),
                nickName: $("#nickName").val(),
                beginDate: $("#beginDate").val(),
                endDate: $("#endDate").val(),
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
            return "";
        },
//        dataField: "res",
         responseHandler: function (res) {
         return {
//         total: res.total,
         rows: res
         }
         },
        columns: [
            {
                title: '主键',
                field: 'id',
                align: 'center',
                valign: 'middle',
                visible:false,
            },
            {
                title: '菜单名称',
                field: 'menuName',
                align: 'left',
                valign: 'middle',
                formatter: function (value, row, index) {
                    var menuLevel = row.menuLevel;
                    var space="&nbsp;&nbsp;&nbsp;&nbsp;";
                    var style = "black";
                    for(var i = 1;i<menuLevel;i++) {
                        space+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                    }
                    if(row.menuLevel==1) {
                        style = "style='black:red;font-size:15px'"
                    }else if(row.menuLevel==2) {
                        style = "style='color:gray;font-size:13px'"
                    }
                    //language=HTML
                    return "<span "+style+">"+space+value+"</span>";
                }
            },
            {
                title: '资源地址',
                field: 'menuUrl',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '图标',
                field: 'menuIcon',
                align: 'center',
                valign: 'middle',
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
    $("#add").click(function () {
        itemEditOrSave('','${basePath}/sysMenu/toSave','70%','70%');
    })

</script>
</body>
</html>
