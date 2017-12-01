/**
 * 初始化学段年级详情对话框
 */
var SectionGradeInfoDlg = {
    sectionGradeInfoData : {},
    validateFields: {

            name: {
                validators: {
                 notEmpty: {
                    message: '名称不能为空'
                   }
                }
            },

            parentId: {
                validators: {
                 notEmpty: {
                    message: '上级id不能为空'
                   }
                }
            },

            level: {
                validators: {
                 notEmpty: {
                    message: '级别（1级为学段 2级为年级）不能为空'
                   }
                }
            }
      }
};

/**
 * 清除数据
 */
SectionGradeInfoDlg.clearData = function() {
    this.sectionGradeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SectionGradeInfoDlg.set = function(key, val) {
     if(val!=undefined){
        this.sectionGradeInfoData[key] = val;
    }else{
        this.sectionGradeInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    }
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SectionGradeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SectionGradeInfoDlg.close = function() {
    parent.layer.close(window.parent.SectionGrade.layerIndex);
}

/**
 * 收集数据
 */
SectionGradeInfoDlg.collectData = function() {
    this.set('id');
        this.set('name');
        this.set('parentId');
        this.set('level');
}
/**
 *  验证
 */
SectionGradeInfoDlg.validate = function () {
    $('#sectionGradeForm').data("bootstrapValidator").resetForm();
    $('#sectionGradeForm').bootstrapValidator('validate');
    return $("#sectionGradeForm").data('bootstrapValidator').isValid();
};
/**
 * 提交添加
 */
SectionGradeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sectionGrade/add", function(data){
        Feng.success("添加成功!");
        window.parent.SectionGrade.table.refresh();
        SectionGradeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sectionGradeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SectionGradeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sectionGrade/update", function(data){
        Feng.success("修改成功!");
        window.parent.SectionGrade.table.refresh();
        SectionGradeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sectionGradeInfoData);
    ajax.start();
}

$(function() {
    Feng.initValidator("sectionGradeForm", SectionGradeInfoDlg.validateFields);
});
