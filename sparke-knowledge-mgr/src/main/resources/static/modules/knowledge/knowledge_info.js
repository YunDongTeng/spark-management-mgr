var KnowledgeInfoDlg = {
    KnowledgeInfoData: {
        section:null,
        grade:null,
        subject:null,
        chapter:null
    },
    validateFields: {

        name: {
            validators: {
                notEmpty: {
                    message: '知识点不能为空'
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
KnowledgeInfoDlg.clearData = function () {
    this.KnowledgeInfoData = {};
}



KnowledgeInfoDlg.getSectionBySite = function () {
    var treeList = window.parent.Knowledge.treeList;
    for (var i = 0; i < treeList.length; i++) {
        var temp = treeList[i];
        var tempSection = "";
        if (temp.id == $("#siteId").val()) {
            KnowledgeInfoDlg.KnowledgeInfoData.section = temp.sectionList;
            for (var j = 0; j < temp.sectionList.length; j++) {
                var str = temp.sectionList[j];
                tempSection += "<option value='" + str.id + "'>" + str.name + "</option>";
            }
            $("#sectionId").empty();
            $("#sectionId").append(tempSection);
            break;
        }
    }
}
KnowledgeInfoDlg.getGradeBySection=function () {
    for (var i = 0; i < KnowledgeInfoDlg.KnowledgeInfoData.section.length; i++) {
        var temp = KnowledgeInfoDlg.KnowledgeInfoData.section[i];
        var tempGrade = "";
        if (temp.id == $("#siteId").val()) {
            KnowledgeInfoDlg.KnowledgeInfoData.grade = temp.gradeList;
            for (var j = 0; j < temp.gradeList.length; j++) {
                var str = temp.gradeList[j];
                tempGrade += "<option value='" + str.id + "'>" + str.name + "</option>";
            }
            $("#gradeId").empty();
            $("#gradeId").append(tempGrade);
            break;
        }
    }
}


