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
<div style="margin-top: 30px"></div>
<div class="row">
    <div class="col-xs-offset-3 col-xs-6">
        <ul id="zTree" class="ztree"></ul>
    </div>
</div>
<div class="row">
    <div class="col-xs-offset-3 col-xs-6">
        <button id="ok" class="btn btn-success" style="margin: 0 10px;">保存</button>
        <button id="no" class="btn btn-warning">取消</button>
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
            url: "${basePath}/sysRoleRes/ztree?id=${id}",
            dataType: "json",
            async: false,
            success: function (data) {
                zNodes = data;
            }
        });
        var setting = {
            check: {enable: true},
        };
        setting.check.chkboxType = {"Y": "ps", "N": "ps"};
        $.fn.zTree.init($("#zTree"), setting, zNodes);
        zTree_Menu = $.fn.zTree.getZTreeObj("zTree");
        zTree_Menu.getCheckedNodes(true);
    })

    $("#no").on("click", function (e) {
        top.layer.close(top.layer.getFrameIndex(window.name));
        return false;
    })
    $("#ok").on("click", function (e) {
        var nodes = zTree_Menu.getCheckedNodes(true);
        var selectIds = "";
        for (var index in nodes) {
            var item = nodes[index];
            if (item.id == '10000')
                continue;
            selectIds += item.id + ",";
        }
        if(selectIds != "") {
            selectIds = selectIds.substr(0,selectIds.length-1);
        }
        console.log(selectIds)
        var submitData = {
            "resIds": selectIds,
            "id": "${id}",
        }
        $.post("${basePath}/sysRoleRes/save", submitData, function (data) {
            $("#btn_saveOrder").removeAttr("disabled");
            if (data.code == 0) {
                layer.msg(data.msg, {
                    icon: 1,
                    time: 1000
                    //2秒关闭（如果不配置，默认是3秒）
                }, function () {
                    parent.document.getElementById("iframe").contentWindow.refreshTable();
                    top.layer.close(top.layer.getFrameIndex(window.name));
                });
            } else {
                layer.msg(data.msg, {
                    icon: 2,
                    time: 1000
                    //2秒关闭（如果不配置，默认是3秒）
                }, function () {
                });
            }
        }, "json");
    })

</script>
</body>
</html>
