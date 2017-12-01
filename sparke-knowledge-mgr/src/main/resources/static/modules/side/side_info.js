/**
 * 初始化网站管理详情对话框
 */
var SideInfoDlg = {
    sideInfoData : {},
    validateFields: {

            name: {
                validators: {
                 notEmpty: {
                    message: '网站名称不能为空'
                   }
                }
            },

            url: {
                validators: {
                 notEmpty: {
                    message: '网站地址不能为空'
                   }
                }
            }
      }
};

/**
 * 清除数据
 */
SideInfoDlg.clearData = function() {
    this.sideInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SideInfoDlg.set = function(key, val) {
     if(val!=undefined){
        this.sideInfoData[key] = val;
    }else{
        this.sideInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    }
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SideInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SideInfoDlg.close = function() {
    parent.layer.close(window.parent.Side.layerIndex);
}

/**
 * 收集数据
 */
SideInfoDlg.collectData = function() {
    this.set('id');
        this.set('name');
        this.set('url');
}
/**
 *  验证
 */
SideInfoDlg.validate = function () {
    $('#sideForm').data("bootstrapValidator").resetForm();
    $('#sideForm').bootstrapValidator('validate');
    return $("#sideForm").data('bootstrapValidator').isValid();
};
/**
 * 提交添加
 */
SideInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/side/add", function(data){
        Feng.success("添加成功!");
        window.parent.Side.table.refresh();
        SideInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sideInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SideInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/side/update", function(data){
        Feng.success("修改成功!");
        window.parent.Side.table.refresh();
        SideInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sideInfoData);
    ajax.start();
}

$(function() {
    Feng.initValidator("sideForm", SideInfoDlg.validateFields);
});
