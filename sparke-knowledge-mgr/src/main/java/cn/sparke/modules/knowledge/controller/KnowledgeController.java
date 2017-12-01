package cn.sparke.modules.knowledge.controller;

import cn.sparke.core.modules.mybatis.bean.PageInfo;
import cn.sparke.modules.knowledge.entity.KnowledgeEntity;
import cn.sparke.modules.knowledge.service.KnowledgeService;
import cn.sparke.modules.side.service.SideService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tyd on 2017-12-1.
 */
@Controller
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;

    @Autowired
    private SideService sideService;

    private String PREFIX = "/knowledge/";

    @RequestMapping("")
    public String toKnowledge() {
        return PREFIX + "knowledge.html";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageInfo<KnowledgeEntity> list(KnowledgeEntity knowledgeEntity) {

        Page<KnowledgeEntity> list = knowledgeService.findList(knowledgeEntity);

        return new PageInfo<>(list);
    }

    @RequestMapping("/toAddKnowledge")
    public String toAddKnowledge(Model model) {
        model.addAttribute("siteList",sideService.findList(null));

        return PREFIX + "knowledge_add.html";
    }

    @RequestMapping("/getTreeList")
    @ResponseBody
    public Object treeList(){
        return knowledgeService.getTreeList();
    }
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        KnowledgeEntity knowledgeEntity = knowledgeService.findOne(id);
        model.addAttribute("knowledgeEntity", knowledgeEntity);
        return PREFIX + "knowledge_edit.html";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Object delete(@PathVariable("id") String id) {
        return knowledgeService.delete(id);
    }
}
