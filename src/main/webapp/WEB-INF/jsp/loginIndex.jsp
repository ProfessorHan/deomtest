<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/common/base.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="HanFei">
    <%@ include file="/common/basecss.jsp" %>

</head>
<script>
    if (window != top) {
        top.location.href = location.href;
    }
</script>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">欢迎光临测试系统</h3>
                </div>
                <div class="panel-body">
                    <form role="form">
                        <fieldset>
                            <div class="form-group">
                                <input id="username" class="form-control" placeholder="请输入用户名" name="username"
                                       type="username" autofocus>
                            </div>
                            <div class="form-group">
                                <input id="password" class="form-control" placeholder="请输入密码" name="password"
                                       type="password"
                                       value="">
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <button id="login-button" class="btn btn-lg btn-success btn-block">登录</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/common/basejs.jsp" %>
<script>


    $(function () {
        //回车事件
        $('#username').keypress(function (e) {
            if (e.which == 13) {
                $('#password').focus();
                return false;
            }
        });
        $('#password').keypress(function (e) {
            if (e.which == 13) {
                $("#login-btn").click();
                return false;
            }
        });

        $('#login-button').click(function (event) {
            var $btn = $(this);
            if ($btn.hasClass("disabled")) {
                return false;
            }
            var $loginname = $('#username');
            var $password = $('#password');
            if (!$loginname.val()) {
                layer.msg('请输入用户名！', {
                    icon: 0,
                    time: 1000
                });
                $loginname.focus();
                return false;
            }
            if (!$password.val()) {
                layer.msg('请输入密码！', {
                    icon: 0,
                    time: 1000
                });
                $password.focus();
                return false;
            }
            var submitData = {
                username: $loginname.val(),
                password: $password.val(),
                url: "${url}"
            };
            $btn.addClass("disabled");
            $.post("${basePath}/login/save", submitData, function (data) {
                $btn.removeClass("disabled");
                if (data.code == 0) {
                    layer.msg("登录成功", {
                        icon: 1,
                        time: 1000
                    }, function () {
                        window.top.location.href = "${base}";
                    });
                } else {
                    layer.msg(data.msg, {
                        icon: 0,
                        time: 1000
                    });
                }
            }, "json");
            return false;
        });
    })

</script>

</body>

</html>

