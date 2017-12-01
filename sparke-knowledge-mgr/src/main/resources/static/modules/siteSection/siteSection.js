/**
 * 网站学段关系管理初始化
 */
var SiteSection = {
    id: "SiteSectionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SiteSection.initColumn = function () {
    return [
        {title: "", field: 'selectItemCustom', align: 'center', formatter: selectItemCustom, valign: 'middle',width:'36px'},
        {title: '学段名称', field: 'name', align: 'center', valign: 'middle'},
        {title: '操作', field: 'caozuo', align: 'center', valign: 'middle', formatter: editFormatter}
    ];
};

/**
 * 检查是否选中
 */
SiteSection.check = function () {
    var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        SiteSection.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加网站学段关系
 */
SiteSection.openAddSiteSection = function () {
    var index = layer.open({
        type: 2,
        title: '网站学段关系绑定',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/siteSection/'+siteSectionDefaultParam.siteId+"?type=0"
    });
    this.layerIndex = index;
};

/**
 * 删除网站学段关系
 */
SiteSection.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/siteSection/delete", function (data) {
            Feng.success("删除成功!");
            SiteSection.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("siteSectionId", this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询网站学段关系列表
 */
SiteSection.search = function () {
    var queryData = {};
    queryData['siteId'] = $("#siteId").val();
    queryData['sectionId'] = $("#sectionId").val();
    SiteSection.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SiteSection.initColumn();
    var table = new BSTreeTable(SiteSection.id, "/siteSection/list", defaultColunms);
    table.setExpandColumn(1);
    table.setData(siteSectionDefaultParam)
    table.setIdField("id");
    table.setCodeField("sectionGradeId");
    table.setParentCodeField("sectionGradeParentId");
    table.setExpandAll(true);
    SiteSection.table = table.init();
});

function selectItemCustom(value, row, index) {
    if(row.level == 1){
        return '<input name="select_item" type="radio" value="' + row.id + '"></input>';
    }
    return '';
}
SiteSection.openRelationSubject = function (id,gradeId) {
    var index = layer.open({
        type: 2,
        title: '学段科目关系列表',
        area: ['800px', '450px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/gradeSubject/'+id+"?type=1&gradeId="+gradeId
    });
    this.layerIndex = index;
    layer.full(index);
};
function editFormatter(value, row, index) {
    var menu = "";
    if (siteSectionPermission.relationSubject && row.level == 2) {
        menu += ' <a onclick="SiteSection.openRelationSubject(\'' + row.id + '\',\''+row.sectionGradeId+'\')" title="关联科目"><span class="label label-default">关联科目</span></a>';
    }
    return menu;
}
