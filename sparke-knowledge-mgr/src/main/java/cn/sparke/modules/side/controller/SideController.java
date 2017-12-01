package cn.sparke.modules.side.controller;

import cn.sparke.core.modules.mybatis.bean.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import cn.sparke.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import cn.sparke.modules.side.service.SideService;
import cn.sparke.modules.side.entity.SideEntity;

/**
 * 网站控制器
 *
 * @author spark
 * @Date 2017-11-30 14:01:11
 */
@Controller
@RequestMapping("/side")
public class SideController extends BaseController {

    private String PREFIX = "/side/";

     @Autowired
     private SideService sideService;

    /**
     * 跳转到网站首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "side.html";
    }

    /**
     * 跳转到添加网站
     */
    @RequestMapping("/side_add")
    public String sideAdd() {
        return PREFIX + "side_add.html";
    }

    /**
     * 跳转到修改网站
     */
    @RequestMapping("/side_update/{sideId}")
    public String sideUpdate(@PathVariable String sideId, Model model) {
       SideEntity bean = sideService.getById(sideId);
        model.addAttribute("side",bean);
        return PREFIX + "side_edit.html";
    }

    /**
     * 获取网站列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(SideEntity entity) {
        return new PageInfo<>(sideService.findList(entity));
    }

    /**
     * 新增网站
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Validated SideEntity entity) {
        sideService.save(entity);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除网站
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(String sideId) {
        sideService.deleteById(sideId);
        return SUCCESS_TIP;
    }


    /**
     * 修改网站
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Validated SideEntity entity) {
        sideService.update(entity);
        return super.SUCCESS_TIP;
    }

    /**
     * 网站详情
     */
    @RequestMapping(value = "/detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable String id) {
        return sideService.getById(id);
    }
}
