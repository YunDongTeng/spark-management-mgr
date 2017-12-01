package cn.sparke.modules.sectionGrade.controller;

import cn.sparke.core.common.exception.BizExceptionEnum;
import cn.sparke.core.common.exception.BussinessException;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import cn.sparke.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import cn.sparke.modules.sectionGrade.service.SectionGradeService;
import cn.sparke.modules.sectionGrade.entity.SectionGradeEntity;

/**
 * 学段年级控制器
 *
 * @author spark
 * @Date 2017-12-01 09:04:37
 */
@Controller
@RequestMapping("/sectionGrade")
public class SectionGradeController extends BaseController {

    private String PREFIX = "/sectionGrade/";

    @Autowired
    private SectionGradeService sectionGradeService;

    /**
     * 跳转到学段年级首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sectionGrade.html";
    }

    /**
     * 跳转到添加学段年级
     */
    @RequestMapping("/sectionGrade_add")
    public String sectionGradeAdd(@RequestParam String parentId, Model model) {
        model.addAttribute("parentId", parentId);
        if ("0".equals(parentId)) {
            model.addAttribute("level", 1);
        } else {
            SectionGradeEntity sectionGradeEntity = sectionGradeService.getById(parentId);
            model.addAttribute("level", sectionGradeEntity.getLevel() + 1);
        }
        return PREFIX + "sectionGrade_add.html";
    }

    /**
     * 跳转到修改学段年级
     */
    @RequestMapping("/sectionGrade_update/{sectionGradeId}")
    public String sectionGradeUpdate(@PathVariable String sectionGradeId, Model model) {
        SectionGradeEntity bean = sectionGradeService.getById(sectionGradeId);
        model.addAttribute("sectionGrade", bean);
        return PREFIX + "sectionGrade_edit.html";
    }

    /**
     * 获取学段年级列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(SectionGradeEntity entity) {
        return sectionGradeService.findList(entity);
    }

    /**
     * 新增学段年级
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Validated SectionGradeEntity entity) {
        if(entity.getLevel()>2){
            throw new BussinessException(BizExceptionEnum.SECTION_GRADE_ILLEGAL);
        }
        sectionGradeService.save(entity);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除学段年级
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(String sectionGradeId) {
        sectionGradeService.deleteById(sectionGradeId);
        return SUCCESS_TIP;
    }


    /**
     * 修改学段年级
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Validated SectionGradeEntity entity) {
        sectionGradeService.update(entity);
        return super.SUCCESS_TIP;
    }

    /**
     * 学段年级详情
     */
    @RequestMapping(value = "/detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable String id) {
        return sectionGradeService.getById(id);
    }
}
