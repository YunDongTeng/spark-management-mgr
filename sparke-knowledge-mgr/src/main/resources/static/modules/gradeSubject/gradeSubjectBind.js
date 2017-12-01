/**
 * 年级科目管理初始化
 */
var GradeSubjectBind = {
    id: "GradeSubjectBindTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
GradeSubjectBind.initColumn = function () {
    return [
        {field: 'selectItem', checked: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '科目名称', field: 'name', align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
GradeSubjectBind.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        GradeSubjectBind.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加年级科目
 */
GradeSubjectBind.bind = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }
    var requestList = [];
    $.each(selected, function (index, object) {
        requestList.push({
            siteSectionId: gradeSubjectBindDefaultParam.siteSectionId,
            subjectId: object.id,
            gradeId: gradeSubjectBindDefaultParam.gradeId
        })
    });
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/gradeSubject/add", function (data) {
        Feng.success("添加成功!");
        window.parent.GradeSubject.table.refresh();
        parent.layer.close(window.parent.GradeSubject.layerIndex);
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    }, 'json');
    ajax.setData(requestList);
    ajax.start();
};


$(function () {
    var defaultColunms = GradeSubjectBind.initColumn();
    var table = new BSTable(GradeSubjectBind.id, "/gradeSubject/list?siteSectionId=" + gradeSubjectBindDefaultParam.siteSectionId + "&type=" + gradeSubjectBindDefaultParam.type + "&gradeId=" + gradeSubjectBindDefaultParam.gradeId, defaultColunms);
    table.setPaginationType("client");
    GradeSubjectBind.table = table.init();
});