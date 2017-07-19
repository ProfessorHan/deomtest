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
        <input type="hidden" name="parentId" id="parentId" value="">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="parentName" class="col-md-3 control-label">上级菜单</label>
                    <div class="col-md-9">
                        <input id="parentName" name="parentName" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label for="menuName" class="col-md-3 control-label">名称</label>
                    <div class="col-md-9">
                        <input id="menuName" name="menuName" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label for="menuUrl" class="col-md-3 control-label">路径</label>
                    <div class="col-md-9">
                        <input id="menuUrl" name="menuUrl" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label for="menuIcon" class="col-md-3 control-label">图标</label>
                    <div class="col-md-9">
                        <input id="menuIcon" name="menuIcon" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label for="menuOrder" class="col-md-3 control-label">序号</label>
                    <div class="col-md-9">
                        <input id="menuOrder" name="menuOrder" class="form-control" type="text">
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
                <ul id="zTree" class="ztree"></ul>
            </div>
        </div>
    </form>
</div>
</body>
<%@ include file="/common/basejs.jsp" %>
<script>

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
        /*check: {
            enable: true,
            chkStyle: "radio",
            radioType: "all"
        },*/
        callback: {
            onClick: zTreeOnClick
        }
    };

    //    setting.check.chkboxType = {"Y": "ps", "N": "ps"};
    $.fn.zTree.init($("#zTree"), setting, zNodes);
    zTree_Menu = $.fn.zTree.getZTreeObj("zTree");

    function zTreeOnClick(event, treeId, treeNode) {
        $("#parentName").val(treeNode.name)
        $("#parentId").val(treeNode.id)
//        alert(treeNode.id + ", " + treeNode.name);
    };

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
            parentName: {
                required: true,
            },
            menuName: {
                required: true,
            },
            menuUrl: {
                required: true,
            },

            menuOrder: {
                required: true,
                digits: true
            },
        },
        messages: {
            parentName: {
                required: "请选择上级菜单",
            },
            menuName: {
                required: "请输入名称",
            },
            menuUrl: {
                required: "请输入路径",
            },
            menuOrder: {
                required: "请输入序号",
                digits: "请输入合法数字"
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
            if($("#parentId").val() == "") {
                layer.msg("请选择上级菜单", {icon: 1, time: 1000});
                return false;
            }
            var $form = $("#submitForm");
            var $btn = $("#ok");
            if ($btn.hasClass("disabled")) {
                return false;
            }
            var postData = $form.serialize();
            $.post('${basePath}/sysMenu/save', postData, function (data) {
                $btn.removeClass("disabled");
                if (data.code == 0) {
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
