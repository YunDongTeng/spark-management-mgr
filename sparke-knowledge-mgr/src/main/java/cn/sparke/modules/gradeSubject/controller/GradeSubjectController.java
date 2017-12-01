package cn.sparke.modules.gradeSubject.controller;

import cn.sparke.core.common.controller.BaseController;
import cn.sparke.modules.gradeSubject.entity.GradeSubjectEntity;
import cn.sparke.modules.gradeSubject.service.GradeSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 年级科目控制器
 *
 * @author spark
 * @Date 2017-12-01 14:11:43
 */
@Controller
@RequestMapping("/gradeSubject")
public class GradeSubjectController extends BaseController {

    private String PREFIX = "/gradeSubject/";

    @Autowired
    private GradeSubjectService gradeSubjectService;

    /**
     * 跳转到年级科目首页
     */
    @RequestMapping("/{siteSectionId}")
    public String index(@PathVariable String siteSectionId, @RequestParam int type, @RequestParam String gradeId, Model model) {
        model.addAttribute("siteSectionId", siteSectionId);
        model.addAttribute("gradeId", gradeId);
        if (type == 0) {//获取未绑定的列表
            return PREFIX + "gradeSubject_add.html";
        } else if (type == 1) {//获取已绑定的列表
            return PREFIX + "gradeSubject.html";
        }
        return "";
    }


    /**
     * 获取年级科目列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(GradeSubjectEntity entity) {
        if (entity.getType() == 0) {//获取未绑定的列表
            return gradeSubjectService.findUnbindList(entity);
        } else if (entity.getType() == 1) {//获取已绑定的列表
            return gradeSubjectService.findBindList(entity);
        }
        return null;
    }

    /**
     * 新增年级科目
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestBody List<GradeSubjectEntity> list) {
        gradeSubjectService.batchInsert(list);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除年级科目
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(String gradeSubjectId) {
        gradeSubjectService.deleteById(gradeSubjectId);
        return SUCCESS_TIP;
    }

}
