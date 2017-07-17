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
    <style>

    </style>
</head>
<body>
<div class="container">
    <form id="submitForm" class="form-horizontal" action="">
        <input type="hidden" name="id" value="${legalCase.id}">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="caseNo" class="col-md-3 control-label">案件编号</label>
                    <div class="col-md-9">
                        <input id="caseNo" name="caseNo" class="form-control" type="text" value="${legalCase.caseNo}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="caseName" class="col-md-3 control-label">案件名称</label>
                    <div class="col-md-9">
                        <input id="caseName" name="caseName" class="form-control" type="text" value="${legalCase.caseName}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="caseCreateDate" class="col-md-3 control-label">创建日期</label>
                    <div class="col-md-9">
                        <input id="caseCreateDate" name="caseCreateDate" class="form-control date" type="text"
                               value="${legalCase.caseCreateDate}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="caseType" class="col-md-3 control-label">案件类型</label>
                    <div class="col-md-9">
                        <select id="caseType" name="caseType" class="form-control" type="text" value="${legalCase.caseType}">
                            <option value="">请选择案件类型</option>
                            <option value="2" ${legalCase.caseType==2?"selected":""}>刑事案件</option>
                            <option value="3" ${legalCase.caseType==3?"selected":""}>行政案件</option>
                        </select>
                    </div>
                </div>
                <div style="text-align: center;padding: 20px 0">
                    <span style="padding: 0 10px">
                        <button id="ok" type="submit" class="btn btn-primary">提交</button>
                    </span>
                    <span style="padding: 0 10px">
                        <button id="no" class="btn btn-warning">取消</button>
                    </span>
                </div>
            </div>
            <div class="col-md-6">
            </div>
        </div>
    </form>
</div>
</body>
<%@ include file="/common/basejs.jsp" %>
<script>

    var parentLayer = parent.layer.getFrameIndex(window.name);
    var topLayer = top.layer.getFrameIndex(window.name);
    $("#no").on("click", function (e) {
        e.preventDefault();
        top.layer.close(topLayer);
    })

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

    $("#submitForm").validate({
        rules: {
            caseNo: {
                required: true,
                minlength: 2
            },
            caseName: {
                required: true,
                minlength: 5
            },
            caseCreateDate: {
                required: true,
                date:true
            },
            caseType: {
                required: true,
            },
        },
        messages: {
            caseNo: {
                required: "请输入案件类型",
                minlength: "Your username must consist of at least 2 characters"
            },
            caseName: {
                required: "请输入案件名称",
                minlength: "Your password must be at least 5 characters long"
            },
            caseCreateDate: {
                required: "请选择日期",
                date: "请输入正确的日期格式",
            },
            caseType: {
                required: "请选择案件类型",
            },
        },
        errorElement: "em",
        errorPlacement: function ( error, element ) {
            // Add the `help-block` class to the error element
            error.addClass( "help-block" );

            if ( element.prop( "type" ) === "checkbox" ) {
                error.insertAfter( element.parent( "label" ) );
            } else {
                error.insertAfter( element );
            }
        },
        highlight: function ( element, errorClass, validClass ) {
            $( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
        },
        unhighlight: function (element, errorClass, validClass) {
            $( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
        },
        submitHandler:function (form) {
            var $form = $("#submitForm");
            var $btn = $("#ok");
            if ($btn.hasClass("disabled")){
                return false;
            }
            var postData = $form.serialize();
            $.post('${basePath}/legalCase/saveOrUpdate', postData, function (data) {
                $btn.removeClass("disabled");
                if (data.code==0) {
                    layer.msg(
                        data.msg,
                        {
                            icon: 1,
                            time: 1000
                        },
                        function () {
                            parent.document.getElementById("iframe").contentWindow.refreshTable();
                            top.layer.close(topLayer);
                        });
                } else {
                    layer.msg(
                        data.msg,
                        {
                            icon: 1,
                            time: 1000
                        },
                        function () {
                        });
                }
            }, "json");
            return false;
        },
        invalidHandler: function (form) {
        }
    });

</script>
</html>
