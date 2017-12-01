/**
 * 网站学段关系管理初始化
 */
var SiteSectionBind = {
    id: "SiteSectionBindTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SiteSectionBind.initColumn = function () {
    return [
        {title: "", field: 'bindList', align: 'center', formatter: bindList, valign: 'middle',width:'36px'},
        {title: '学段名称', field: 'name', align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
SiteSectionBind.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        SiteSectionBind.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加网站学段关系
 */
SiteSectionBind.bind = function () {
    var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }
    var requestList = [];
    $.each(selected,function(index,object){
        requestList.push({
            siteId:SiteSectionBindDefaultParam.siteId,
            sectionId:object.id
        })
    });
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/siteSection/add", function(data){
        Feng.success("添加成功!");
        window.parent.SiteSection.table.refresh();
        parent.layer.close(window.parent.SiteSection.layerIndex);
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    },'json');
    ajax.setData(requestList);
    ajax.start();
};


/**
 * 查询网站学段关系列表
 */
SiteSectionBind.search = function () {
    var queryData = {};
    queryData['siteId'] = $("#siteId").val();
    queryData['sectionId'] = $("#sectionId").val();
    SiteSectionBind.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SiteSectionBind.initColumn();
    var table = new BSTreeTable(SiteSectionBind.id, "/siteSection/list", defaultColunms);
    table.setExpandColumn(1);
    table.setData(SiteSectionBindDefaultParam)
    table.setIdField("id");
    table.setCodeField("id");
    table.setParentCodeField("sectionGradeParentId");
    table.setExpandAll(true);
    SiteSectionBind.table = table.init();
});

function bindList(value, row, index) {
    if(row.level == 1){
        return '<input name="select_item" type="checkbox" value="' + row.id + '"></input>';
    }
    return '';
}