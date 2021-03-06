/**
 * 初始化科目详情对话框
 */
var SubjectInfoDlg = {
    subjectInfoData : {},
    validateFields: {

            name: {
                validators: {
                 notEmpty: {
                    message: '名称不能为空'
                   }
                }
            }
      }
};

/**
 * 清除数据
 */
SubjectInfoDlg.clearData = function() {
    this.subjectInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SubjectInfoDlg.set = function(key, val) {
     if(val!=undefined){
        this.subjectInfoData[key] = val;
    }else{
        this.subjectInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    }
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SubjectInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SubjectInfoDlg.close = function() {
    parent.layer.close(window.parent.Subject.layerIndex);
}

/**
 * 收集数据
 */
SubjectInfoDlg.collectData = function() {
    this.set('id');
        this.set('name');
}
/**
 *  验证
 */
SubjectInfoDlg.validate = function () {
    $('#subjectForm').data("bootstrapValidator").resetForm();
    $('#subjectForm').bootstrapValidator('validate');
    return $("#subjectForm").data('bootstrapValidator').isValid();
};
/**
 * 提交添加
 */
SubjectInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/subject/add", function(data){
        Feng.success("添加成功!");
        window.parent.Subject.table.refresh();
        SubjectInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.subjectInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SubjectInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/subject/update", function(data){
        Feng.success("修改成功!");
        window.parent.Subject.table.refresh();
        SubjectInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.subjectInfoData);
    ajax.start();
}

$(function() {
    Feng.initValidator("subjectForm", SubjectInfoDlg.validateFields);
});
