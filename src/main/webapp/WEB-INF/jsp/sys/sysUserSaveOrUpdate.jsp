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
        <input type="hidden" name="id" value="${sysUser.id}">
        <div class="row">
            <div class="col-xs-6">
                <div class="form-group">
                    <label for="email" class="col-md-3 control-label">用户名</label>
                    <div class="col-md-9">
                        <input id="email" name="email" class="form-control" type="text" value="${sysUser.email}">
                    </div>
                </div>
                <c:if test="${sysUser.id == null}">
                    <div class="form-group">
                        <label for="pwd" class="col-md-3 control-label">密码</label>
                        <div class="col-md-9">
                            <input id="pwd" name="pwd" class="form-control" type="text" value="${sysUser.pwd}">
                        </div>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="nickname" class="col-md-3 control-label">真实姓名</label>
                    <div class="col-md-9">
                        <input id="nickname" name="nickname" class="form-control" type="text"
                               value="${sysUser.nickname}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="mobilePhone" class="col-md-3 control-label">手机</label>
                    <div class="col-md-9">
                        <input id="mobilePhone" name="mobilePhone" class="form-control" type="text"
                               value="${sysUser.mobilePhone}">
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
            <div class="col-xs-6">
                <p class="alert alert-success">角色</p>
                <ul id="zTree" class="ztree"></ul>
            </div>
        </div>
    </form>
</div>
</body>
<%@ include file="/common/basejs.jsp" %>
<script>
    $(function () {
        var zNodes;
        $.ajax({
            type: "GET",
            url: "${basePath}/sysUser/ztree?id=${sysUser.id}",
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
    })

    $("#no").on("click", function (e) {
        top.layer.close(top.layer.getFrameIndex(window.name));
        return false;
    })
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
            email: {
                required: true,
                minlength: 2
            },
            pwd: {
                required: true,
                minlength: 6
            },
            nickname: {
                required: true,
            },
            mobilePhone: {
                phone: true
            },
        },
        messages: {
            email: {
                required: "请输入用户名",
                minlength: "用户名字符最少为2位"
            },
            pwd: {
                required: "请输入密码",
                minlength: "密码字符最少为6位"
            },
            nickname: {
                required: "请输入姓名",
            },
            mobilePhone: {
                phone: "请输入正确的手机号"
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
            var nodes = zTree_Menu.getCheckedNodes(true);
            var selectIds = "";
            for (var index in nodes) {
                var item = nodes[index];
                if (item.id == '10000')
                    continue;
                selectIds += item.id + ",";
            }
            if (selectIds != "") {
                selectIds = selectIds.substr(0, selectIds.length - 1);
            }
            postData+="&roleIds="+selectIds;
            console.log(postData)
            $.post('${basePath}/sysUser/saveOrUpdate', postData, function (data) {
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
