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
<body>
<div class="row">
    <div class="col-md-12">
        <ul id="zTree" class="ztree"></ul>
    </div>
</div>
<%@ include file="/common/basejs.jsp" %>
<%@ include file="/common/tablejs.jsp" %>
<script src="/js/table.js"></script>
<script>
    $(function () {
        var zNodes;
        $.ajax({
            type: "GET",
            url: "${basePath}/sysMenu/ztree",
            dataType: "json",
            async: false,
            success: function (data) {
                zNodes = data;
            }
        });
        var setting = {
            check: {enable: true},
        };
        setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
        $.fn.zTree.init($("#zTree"), setting, zNodes);
        zTree_Menu = $.fn.zTree.getZTreeObj("zTree");

    })

</script>
</body>
</html>
