/**
 * 年份管理初始化
 */
var Year = {
    id: "YearTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Year.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '年份', field: 'name', align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Year.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Year.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加年份
 */
Year.openAddYear = function () {
    var index = layer.open({
        type: 2,
        title: '添加年份',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/year/year_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看年份详情
 */
Year.openYearDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '年份详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/year/year_update/' + Year.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除年份
 */
Year.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/year/delete", function (data) {
            Feng.success("删除成功!");
            Year.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("yearId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询年份列表
 */
Year.search = function () {
    var queryData = {};
       queryData['name'] = $("#name").val();
    Year.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Year.initColumn();
    var table = new BSTable(Year.id, "/year/list", defaultColunms);
    table.setPaginationType("server");
    Year.table = table.init();
});
