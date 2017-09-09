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
        <input type="hidden" name="id" value="${sysRole.id}">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">角色名称</label>
                    <div class="col-md-9">
                        <input id="name" name="name" class="form-control" type="text" value="${sysRole.name}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="des" class="col-md-3 control-label">描述</label>
                    <div class="col-md-9">
                        <input id="des" name="des" class="form-control" type="text" value="${sysRole.des}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="seq" class="col-md-3 control-label">序号</label>
                    <div class="col-md-9">
                        <input id="seq" name="seq" class="form-control" type="text"
                               value="${sysRole.seq}">
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-md-3 control-label"></label>
                    <div class="col-md-9">
                        <label>
                            <input id="radio1" type="radio" name="status" value="1" ${sysRole.status==1 or sysRole.status==null ?"checked":""}>启用
                        </label>
                        <label>
                            <input id="radio2" type="radio" name="status" value="0" ${sysRole.status==0?"checked":""}>禁用
                        </label>
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
    });

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
            name: {
                required: true,
//                minlength: 2
            },
            des: {
                required: true,
//                minlength: 5
            },
            seq: {
                required: true,
                digits:true
            },
            caseType: {
                required: true,
            },
        },
        messages: {
            name: {
                required: "请输入角色名称",
                minlength: "长度不能少于2个字符"
            },
            des: {
                required: "请输入描述",
//                minlength: "长度不能少于2个字符"
            },
            seq: {
                required: "请输入排序号",
                digits: "请输入数字",
            },
            status: {
                required: "请选择状态",
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
            $.post('${basePath}/sysRole/saveOrUpdate', postData, function (data) {
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
