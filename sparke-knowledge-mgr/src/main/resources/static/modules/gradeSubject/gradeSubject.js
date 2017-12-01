/**
 * 年级科目管理初始化
 */
var GradeSubject = {
    id: "GradeSubjectTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
GradeSubject.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '科目名称', field: 'name', align: 'center', valign: 'middle'},
        {title: '操作', field: 'caozuo', align: 'center', valign: 'middle', formatter: editFormatter}
    ];
};

/**
 * 检查是否选中
 */
GradeSubject.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        GradeSubject.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加年级科目
 */
GradeSubject.openAddGradeSubject = function () {
    var index = layer.open({
        type: 2,
        title: '年级科目关系绑定',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/gradeSubject/'+gradeSubjectDefaultParam.siteSectionId+"?type=0&gradeId="+gradeSubjectDefaultParam.gradeId
    });
    this.layerIndex = index;
};

/**
 * 删除年级科目
 */
GradeSubject.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/gradeSubject/delete", function (data) {
            Feng.success("删除成功!");
            GradeSubject.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("gradeSubjectId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询年级科目列表
 */
GradeSubject.search = function () {
    var queryData = {};
       queryData['siteSectionId'] = $("#siteSectionId").val();
       queryData['siteId'] = $("#siteId").val();
       queryData['sectionId'] = $("#sectionId").val();
       queryData['gradeId'] = $("#gradeId").val();
       queryData['subjectId'] = $("#subjectId").val();
    GradeSubject.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = GradeSubject.initColumn();
    var table = new BSTable(GradeSubject.id, "/gradeSubject/list?siteSectionId="+gradeSubjectDefaultParam.siteSectionId+"&type="+gradeSubjectDefaultParam.type+"&gradeId="+gradeSubjectDefaultParam.gradeId, defaultColunms);
    table.setPaginationType("client");
    GradeSubject.table = table.init();
});

GradeSubject.openRelationChapter = function (id) {
    var index = layer.open({
        type: 2,
        title: '科目章节列表',
        area: ['800px', '450px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/chapter/'+id
    });
    this.layerIndex = index;
    layer.full(index);
};
function editFormatter(value, row, index) {
    var menu = "";
    if (gradeSubjectPermission.relationChapter) {
        menu += ' <a onclick="GradeSubject.openRelationChapter(\'' + row.id + '\')" title="创建章节"><span class="label label-default">创建章节</span></a>';
    }
    return menu;
}