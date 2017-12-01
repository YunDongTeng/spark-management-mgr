package cn.sparke.modules.year.controller;

import cn.sparke.core.modules.mybatis.bean.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import cn.sparke.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import cn.sparke.modules.year.service.YearService;
import cn.sparke.modules.year.entity.YearEntity;

/**
 * 年份控制器
 *
 * @author spark
 * @Date 2017-11-30 19:10:00
 */
@Controller
@RequestMapping("/year")
public class YearController extends BaseController {

    private String PREFIX = "/year/";

     @Autowired
     private YearService yearService;

    /**
     * 跳转到年份首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "year.html";
    }

    /**
     * 跳转到添加年份
     */
    @RequestMapping("/year_add")
    public String yearAdd() {
        return PREFIX + "year_add.html";
    }

    /**
     * 跳转到修改年份
     */
    @RequestMapping("/year_update/{yearId}")
    public String yearUpdate(@PathVariable String yearId, Model model) {
       YearEntity bean = yearService.getById(yearId);
        model.addAttribute("year",bean);
        return PREFIX + "year_edit.html";
    }

    /**
     * 获取年份列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(YearEntity entity) {
        return new PageInfo<>(yearService.findList(entity));
    }

    /**
     * 新增年份
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Validated YearEntity entity) {
        yearService.save(entity);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除年份
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(String yearId) {
        yearService.deleteById(yearId);
        return SUCCESS_TIP;
    }


    /**
     * 修改年份
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Validated YearEntity entity) {
        yearService.update(entity);
        return super.SUCCESS_TIP;
    }

    /**
     * 年份详情
     */
    @RequestMapping(value = "/detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable String id) {
        return yearService.getById(id);
    }
}
