/**
 * 科目管理初始化
 */
var Subject = {
    id: "SubjectTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Subject.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '名称', field: 'name', align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Subject.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Subject.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加科目
 */
Subject.openAddSubject = function () {
    var index = layer.open({
        type: 2,
        title: '添加科目',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/subject/subject_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看科目详情
 */
Subject.openSubjectDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '科目详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/subject/subject_update/' + Subject.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除科目
 */
Subject.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/subject/delete", function (data) {
            Feng.success("删除成功!");
            Subject.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("subjectId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询科目列表
 */
Subject.search = function () {
    var queryData = {};
       queryData['name'] = $("#name").val();
    Subject.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Subject.initColumn();
    var table = new BSTable(Subject.id, "/subject/list", defaultColunms);
    table.setPaginationType("server");
    Subject.table = table.init();
});
