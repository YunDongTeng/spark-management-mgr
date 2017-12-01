package cn.sparke.modules.siteSection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import cn.sparke.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import cn.sparke.core.modules.mybatis.bean.PageInfo;
import cn.sparke.modules.siteSection.service.SiteSectionService;
import cn.sparke.modules.siteSection.entity.SiteSectionEntity;

import java.util.List;

/**
 * 网站学段关系控制器
 *
 * @author spark
 * @Date 2017-12-01 12:33:58
 */
@Controller
@RequestMapping("/siteSection")
public class SiteSectionController extends BaseController {

    private String PREFIX = "/siteSection/";

    @Autowired
    private SiteSectionService siteSectionService;

    /**
     * 跳转到网站学段关系首页
     */
    @RequestMapping("/{siteId}")
    public String index(@PathVariable String siteId, @RequestParam int type, Model model) {
        model.addAttribute("siteId", siteId);
        if (type == 0) {//获取未绑定的列表
            return PREFIX + "siteSection_add.html";
        } else if (type == 1) {//获取已绑定的列表
            return PREFIX + "siteSection.html";
        }
        return "";
    }

    /**
     * 获取网站学段关系列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(SiteSectionEntity entity) {
        if (entity.getType() == 0) {//获取未绑定的列表
            return siteSectionService.findUnbindList(entity);
        } else if (entity.getType() == 1) {//获取已绑定的列表
            return siteSectionService.findBindList(entity);
        }
        return null;
    }

    /**
     * 新增网站学段关系
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody List<SiteSectionEntity> list) {
        siteSectionService.batchInsert(list);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除网站学段关系
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(String siteSectionId) {
        siteSectionService.deleteById(siteSectionId);
        return SUCCESS_TIP;
    }
}
