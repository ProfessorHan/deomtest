/**
 * Created by Hanfei on 2017/7/14.
 */
function refreshTable() {
    $('#table').bootstrapTable('refresh', {silent: true});
    return false;
}
function searchTable(e) {
    // alert($("form").serialize())
    // alert(JSON.stringify($("form").serializeArray()))
    $('#table').bootstrapTable('refresh', {pageNumber: 1, pageSize: 15});
    return false;
}

function itemDelele(id, url) {
    top.layer.confirm('<span style="">确定要删除吗?</span>',
        {
            btn: ['确定', '取消'] //按钮
        }, function () {
            $.post(url, {id: id}, function (data) {
                if (data.code == 0) {
                    top.layer.msg(data.msg, {
                        icon: 1,
                        time: 1000
                    }, function () {
                        refreshTable();
                    });
                } else {
                    top.layer.msg(data.msg, {
                        icon: 1,
                        time: 1000
                    });
                }
            });
        }, function () {
        });
}

function itemEditOrSave(id, url, width, height) {
    top.layer.open({
        type: 2,
        title: "信息",
        area: [width, height],
        fixed: false, //不固定
        maxmin: true,
        content: url + "?id=" + id
    });
}
