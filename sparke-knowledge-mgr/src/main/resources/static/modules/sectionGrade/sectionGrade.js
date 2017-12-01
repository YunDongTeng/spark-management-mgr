/**
 * 学段年级管理初始化
 */
var SectionGrade = {
    id: "SectionGradeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SectionGrade.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '名称', field: 'name', align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
SectionGrade.check = function () {
    var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        SectionGrade.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加学段年级
 */
SectionGrade.openAddSectionGrade = function () {
    var parentId = 0;
    var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
    if (selected.length != 0) {
        parentId = selected[0].id;
    }
    var index = layer.open({
        type: 2,
        title: '添加学段年级',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/sectionGrade/sectionGrade_add?parentId=' + parentId
    });
    this.layerIndex = index;
};

/**
 * 打开查看学段年级详情
 */
SectionGrade.openSectionGradeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '学段年级详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/sectionGrade/sectionGrade_update/' + SectionGrade.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除学段年级
 */
SectionGrade.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/sectionGrade/delete", function (data) {
            Feng.success("删除成功!");
            SectionGrade.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("sectionGradeId", this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询学段年级列表
 */
SectionGrade.search = function () {
    var queryData = {};
    queryData['name'] = $("#name").val();
    queryData['parentId'] = $("#parentId").val();
    queryData['level'] = $("#level").val();
    SectionGrade.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SectionGrade.initColumn();
    var table = new BSTreeTable(SectionGrade.id, "/sectionGrade/list", defaultColunms);
    table.setExpandColumn(1);
    table.setIdField("id");
    table.setCodeField("id");
    table.setParentCodeField("parentId");
    table.setExpandAll(true);
    SectionGrade.table = table.init();
});
