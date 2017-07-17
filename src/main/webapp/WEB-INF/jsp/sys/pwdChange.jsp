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
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="oldPwd" class="col-md-3 control-label">原始密码</label>
                    <div class="col-md-9">
                        <input id="oldPwd" name="oldPwd" class="form-control" type="password">
                    </div>
                </div>
                <div class="form-group">
                    <label for="newPwd" class="col-md-3 control-label">新密码</label>
                    <div class="col-md-9">
                        <input id="newPwd" name="newPwd" class="form-control" type="password">
                    </div>
                </div>
                <div class="form-group">
                    <label for="checkPwd" class="col-md-3 control-label">确认密码</label>
                    <div class="col-md-9">
                        <input id="checkPwd" name="checkPwd" class="form-control" type="password">
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
            oldPwd: {
                required: true,
            },
            newPwd: {
                required: true,
                minlength: 6
            },
            checkPwd: {
                required: true,
                equalTo: "#newPwd"
            },
        },
        messages: {
            oldPwd: {
                required: "请输入原始密码",
            },
            newPwd: {
                required: "请输入新密码",
                minlength: "新密码不能少于6位"
            },
            checkPwd: {
                required: "请输入确认密码",
                equalTo: "密码不一致"
            },
        },
        errorElement: "em",
        errorPlacement: function (error, element) {
            // Add the `help-block` class to the error element
            error.addClass("help-block");

            if (element.prop("type") === "checkbox") {
                error.insertAfter(element.parent("label"));
            } else {
                error.insertAfter(element);
            }
        },
        highlight: function (element, errorClass, validClass) {
            $(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
        },
        submitHandler: function (form) {
            var $form = $("#submitForm");
            var $btn = $("#ok");
            if ($btn.hasClass("disabled")) {
                return false;
            }
            var postData = $form.serialize();
            $.post('${basePath}/sysUser/pwdChange', postData, function (data) {
                $btn.removeClass("disabled");
                if (data.code == 0) {
                    layer.msg(
                        data.msg,
                        {
                            icon: 1,
                            time: 1000
                        },
                        function () {
                            top.layer.close(topLayer);
                        });
                } else {
                    layer.msg(
                        data.msg,
                        {
                            icon: 2,
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
