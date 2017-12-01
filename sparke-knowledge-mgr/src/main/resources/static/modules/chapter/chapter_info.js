/**
 * 初始化章节详情对话框
 */
var ChapterInfoDlg = {
    chapterInfoData : {},
    validateFields: {

            gradeSubjectId: {
                validators: {
                 notEmpty: {
                    message: '年级科目关系id不能为空'
                   }
                }
            },

            siteId: {
                validators: {
                 notEmpty: {
                    message: '网站id不能为空'
                   }
                }
            },

            sectionId: {
                validators: {
                 notEmpty: {
                    message: '学段id不能为空'
                   }
                }
            },

            gradeId: {
                validators: {
                 notEmpty: {
                    message: '年级id不能为空'
                   }
                }
            },

            subjectId: {
                validators: {
                 notEmpty: {
                    message: '科目id不能为空'
                   }
                }
            },

            name: {
                validators: {
                 notEmpty: {
                    message: '章节名称不能为空'
                   }
                }
            }
      }
};

/**
 * 清除数据
 */
ChapterInfoDlg.clearData = function() {
    this.chapterInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ChapterInfoDlg.set = function(key, val) {
     if(val!=undefined){
        this.chapterInfoData[key] = val;
    }else{
        this.chapterInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    }
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ChapterInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ChapterInfoDlg.close = function() {
    parent.layer.close(window.parent.Chapter.layerIndex);
}

/**
 * 收集数据
 */
ChapterInfoDlg.collectData = function() {
    this.set('id');
        this.set('gradeSubjectId');
        this.set('siteId');
        this.set('sectionId');
        this.set('gradeId');
        this.set('subjectId');
        this.set('name');
        this.set('sort');
}
/**
 *  验证
 */
ChapterInfoDlg.validate = function () {
    $('#chapterForm').data("bootstrapValidator").resetForm();
    $('#chapterForm').bootstrapValidator('validate');
    return $("#chapterForm").data('bootstrapValidator').isValid();
};
/**
 * 提交添加
 */
ChapterInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/chapter/add", function(data){
        Feng.success("添加成功!");
        window.parent.Chapter.table.refresh();
        ChapterInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.chapterInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ChapterInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/chapter/update", function(data){
        Feng.success("修改成功!");
        window.parent.Chapter.table.refresh();
        ChapterInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.chapterInfoData);
    ajax.start();
}

$(function() {
    Feng.initValidator("chapterForm", ChapterInfoDlg.validateFields);
});
