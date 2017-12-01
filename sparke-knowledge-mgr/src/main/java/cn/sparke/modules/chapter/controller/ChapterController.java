package cn.sparke.modules.chapter.controller;

import cn.sparke.modules.gradeSubject.entity.GradeSubjectEntity;
import cn.sparke.modules.gradeSubject.mapper.GradeSubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import cn.sparke.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import cn.sparke.core.modules.mybatis.bean.PageInfo;
import cn.sparke.modules.chapter.service.ChapterService;
import cn.sparke.modules.chapter.entity.ChapterEntity;

/**
 * 章节控制器
 *
 * @author spark
 * @Date 2017-12-01 15:48:20
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController extends BaseController {

    private String PREFIX = "/chapter/";

    @Autowired
    private ChapterService chapterService;
    @Autowired
    private GradeSubjectMapper gradeSubjectMapper;

    /**
     * 跳转到章节首页
     */
    @RequestMapping("/{gradeSubjectId}")
    public String index(@PathVariable String gradeSubjectId, Model model) {
        model.addAttribute("gradeSubjectId", gradeSubjectId);
        return PREFIX + "chapter.html";
    }

    /**
     * 跳转到添加章节
     */
    @RequestMapping("/chapter_add/{gradeSubjectId}")
    public String chapterAdd(@PathVariable String gradeSubjectId, Model model) {
        GradeSubjectEntity gradeSubject = gradeSubjectMapper.getById(gradeSubjectId);
        model.addAttribute("gradeSubject", gradeSubject);
        return PREFIX + "chapter_add.html";
    }

    /**
     * 跳转到修改章节
     */
    @RequestMapping("/chapter_update/{chapterId}")
    public String chapterUpdate(@PathVariable String chapterId, Model model) {
        ChapterEntity bean = chapterService.getById(chapterId);
        model.addAttribute("chapter", bean);
        return PREFIX + "chapter_edit.html";
    }

    /**
     * 获取章节列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(ChapterEntity entity) {
        return new PageInfo<>(chapterService.findList(entity));
    }

    /**
     * 新增章节
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Validated ChapterEntity entity) {
        chapterService.save(entity);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除章节
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(String chapterId) {
        chapterService.deleteById(chapterId);
        return SUCCESS_TIP;
    }


    /**
     * 修改章节
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Validated ChapterEntity entity) {
        chapterService.update(entity);
        return super.SUCCESS_TIP;
    }

    /**
     * 章节详情
     */
    @RequestMapping(value = "/detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable String id) {
        return chapterService.getById(id);
    }
}
