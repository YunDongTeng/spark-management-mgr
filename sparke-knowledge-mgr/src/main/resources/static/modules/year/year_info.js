/**
 * 初始化年份详情对话框
 */
var YearInfoDlg = {
    yearInfoData : {},
    validateFields: {

            name: {
                validators: {
                 notEmpty: {
                    message: '不能为空'
                   }
                }
            }
      }
};

/**
 * 清除数据
 */
YearInfoDlg.clearData = function() {
    this.yearInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
YearInfoDlg.set = function(key, val) {
     if(val!=undefined){
        this.yearInfoData[key] = val;
    }else{
        this.yearInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    }
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
YearInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
YearInfoDlg.close = function() {
    parent.layer.close(window.parent.Year.layerIndex);
}

/**
 * 收集数据
 */
YearInfoDlg.collectData = function() {
    this.set('id');
        this.set('name');
}
/**
 *  验证
 */
YearInfoDlg.validate = function () {
    $('#yearForm').data("bootstrapValidator").resetForm();
    $('#yearForm').bootstrapValidator('validate');
    return $("#yearForm").data('bootstrapValidator').isValid();
};
/**
 * 提交添加
 */
YearInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/year/add", function(data){
        Feng.success("添加成功!");
        window.parent.Year.table.refresh();
        YearInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.yearInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
YearInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/year/update", function(data){
        Feng.success("修改成功!");
        window.parent.Year.table.refresh();
        YearInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.yearInfoData);
    ajax.start();
}

$(function() {
    Feng.initValidator("yearForm", YearInfoDlg.validateFields);
});
