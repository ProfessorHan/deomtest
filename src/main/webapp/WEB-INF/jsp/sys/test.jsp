<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${basePath}/admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/bootstrap-switch-3.3.4/css/bootstrap3/bootstrap-switch.min.css" rel="stylesheet">

</head>
<body>
<div class="switch switch-mini" data-on="info" data-off="success"> <input type="checkbox" checked value='1'/> </div>
<input type="checkbox" name="my-checkbox" >
</body>
<script src="${basePath}/js/jquery-1.11.1.min.js"></script>
<script src="${basePath}/admin/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap-switch-3.3.4/js/bootstrap-switch.js"></script>

<script>
    $('.switch').bootstrapSwitch();
    $("[name='my-checkbox']").bootstrapSwitch();
    $('.switch').on('switch-change', function (e, data) {
        var $el = $(data.el)
            , value = data.value;
        console.log(e, $el, value);
    });
</script>
</html>
