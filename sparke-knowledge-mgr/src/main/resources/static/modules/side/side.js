/**
 * 网站管理初始化
 */
var Side = {
    id: "SideTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Side.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '网站名称', field: 'name', align: 'center', valign: 'middle'},
        {title: '网站地址', field: 'url', align: 'center', valign: 'middle'},
        {title: '操作', field: 'caozuo', align: 'center', valign: 'middle', formatter: editFormatter}
    ];
};

/**
 * 检查是否选中
 */
Side.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Side.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加网站
 */
Side.openAddSide = function () {
    var index = layer.open({
        type: 2,
        title: '添加网站',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/side/side_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看网站详情
 */
Side.openSideDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '网站详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/side/side_update/' + Side.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除网站
 */
Side.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/side/delete", function (data) {
            Feng.success("删除成功!");
            Side.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("sideId", this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询网站列表
 */
Side.search = function () {
    var queryData = {};
    queryData['name'] = $("#name").val();
    queryData['url'] = $("#url").val();
    Side.table.refresh({query: queryData});
};
Side.openRelationSection = function (id) {
    var index = layer.open({
        type: 2,
        title: '网站学段关系列表',
        area: ['800px', '450px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/siteSection/'+id+"?type=1"
    });
    this.layerIndex = index;
    layer.full(index);
};
$(function () {
    var defaultColunms = Side.initColumn();
    var table = new BSTable(Side.id, "/side/list", defaultColunms);
    table.setPaginationType("server");
    Side.table = table.init();
});

function editFormatter(value, row, index) {
    var menu = "";
    if (sidePermission.relationSection) {
        menu += ' <a onclick="Side.openRelationSection(\'' + row.id + '\')" title="关联学段"><span class="label label-default">关联学段</span></a>';
    }
    return menu;
}