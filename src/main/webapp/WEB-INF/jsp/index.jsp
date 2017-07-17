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
    <title>测试系统</title>
    <%@ include file="/common/basecss.jsp" %>

</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">测试系统</a>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i>${session_user.nickname}<i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <%--<li>
                        <a href="javascript:void(0)"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>--%>
                    <li>
                        <a id="pwdChange" href="javascript:void(0)"><i class="fa fa-gear fa-fw"></i>修改密码</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="${basePath}/login/logout"><i class="fa fa-sign-out fa-fw"></i>注销</a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- /.navbar-top-links -->
        <div class="navbar-default sidebar" role="navigation">${menus}</div>
    </nav>


    <div id="page-wrapper">
        <iframe id="iframe" name="innerhtml" src="${basePath}/sysUser/index"
                style="width: 100%;height: 700px;border:1px solid #c2d2d7;border-left:0px; border-bottom: 0px;"></iframe>
    </div>

</div><!-- /#wrapper -->
<%@ include file="/common/basejs.jsp" %>
<!-- Morris Charts JavaScript -->
<script>
    $("#pwdChange").click(function () {
        layer.open({
            type: 2,
            title: "修改密码",
            area: ['30%', '50%'],
            fixed: false, //不固定
            maxmin: true,
            content: '${basePath}/sysUser/toPwdChange'
        });
    })
</script>

</body>
</html>
