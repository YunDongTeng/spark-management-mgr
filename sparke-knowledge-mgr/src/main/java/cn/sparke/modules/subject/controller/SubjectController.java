package cn.sparke.modules.subject.controller;

import cn.sparke.core.modules.mybatis.bean.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import cn.sparke.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import cn.sparke.modules.subject.service.SubjectService;
import cn.sparke.modules.subject.entity.SubjectEntity;

/**
 * 科目控制器
 *
 * @author spark
 * @Date 2017-11-30 19:00:54
 */
@Controller
@RequestMapping("/subject")
public class SubjectController extends BaseController {

    private String PREFIX = "/subject/";

     @Autowired
     private SubjectService subjectService;

    /**
     * 跳转到科目首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "subject.html";
    }

    /**
     * 跳转到添加科目
     */
    @RequestMapping("/subject_add")
    public String subjectAdd() {
        return PREFIX + "subject_add.html";
    }

    /**
     * 跳转到修改科目
     */
    @RequestMapping("/subject_update/{subjectId}")
    public String subjectUpdate(@PathVariable String subjectId, Model model) {
       SubjectEntity bean = subjectService.getById(subjectId);
        model.addAttribute("subject",bean);
        return PREFIX + "subject_edit.html";
    }

    /**
     * 获取科目列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(SubjectEntity entity) {
        return new PageInfo<>(subjectService.findList(entity));
    }

    /**
     * 新增科目
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Validated SubjectEntity entity) {
        subjectService.save(entity);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除科目
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(String subjectId) {
        subjectService.deleteById(subjectId);
        return SUCCESS_TIP;
    }


    /**
     * 修改科目
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Validated SubjectEntity entity) {
        subjectService.update(entity);
        return super.SUCCESS_TIP;
    }

    /**
     * 科目详情
     */
    @RequestMapping(value = "/detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable String id) {
        return subjectService.getById(id);
    }
}
