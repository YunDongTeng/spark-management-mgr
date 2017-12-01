var Knowledge = {
    id: "KnowledgeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    treeList: null
};

Knowledge.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '分类', field: 'categoryId', align: 'center', valign: 'middle'},
        {title: '章节', field: 'chapterId', align: 'center', valign: 'middle'},
        {title: '名称', field: 'name', align: 'center', valign: 'middle'},
        {title: '创建人', field: 'createBy', align: 'center', valign: 'middle'},
        {title: '创建时间', field: 'createDate', align: 'center', valign: 'middle'}
    ];
}

Knowledge.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Knowledge.seItem = selected[0];
        return true;
    }
};


Knowledge.add = function () {
    var index = layer.open({
        type: 2,
        title: '添加知识点',
        area: ['800px', '520px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/knowledge/toAddKnowledge'
    });
    this.layerIndex = index;
}

Knowledge.openDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '修改知识点',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/knowledge/detail/' + Knowledge.seItem.id
        });
        this.layerIndex = index;
    }
}

Knowledge.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/knowledge/delete/" + this.seItem.id, function (data) {
            Feng.success("删除成功!");
            Knowledge.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.start();
    }
}

$(function () {
    var defaultColunms = Knowledge.initColumn();
    var table = new BSTable(Knowledge.id, "/knowledge/list", defaultColunms);
    table.setPaginationType("server");
    Knowledge.table = table.init();

    //获取树列表
    var ajax = new $ax(Feng.ctxPath + "/knowledge/getTreeList", function (data) {
        console.log(data);
        Knowledge.treeList = data;
    }, function (data) {
    });
    ajax.start();
});
