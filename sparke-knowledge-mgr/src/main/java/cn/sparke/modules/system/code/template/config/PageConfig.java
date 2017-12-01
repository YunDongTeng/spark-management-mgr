package cn.sparke.modules.system.code.template.config;

/**
 * 页面 模板生成的配置
 *
 * @author spark
 * @date 2017-05-07 22:12
 */
public class PageConfig {

    private ContextConfig contextConfig;

    private String pagePathTemplate;
    private String pageAddPathTemplate;
    private String pageEditPathTemplate;
    private String pageJsPathTemplate;
    private String pageInfoJsPathTemplate;

    public void init() {
        pagePathTemplate = "\\src\\main\\resources\\WEB-INF\\view\\" + contextConfig.getBizEnName() + "\\{}.html";
        pageAddPathTemplate = "\\src\\main\\resources\\WEB-INF\\view\\" + contextConfig.getBizEnName() + "\\{}_add.html";
        pageEditPathTemplate = "\\src\\main\\resources\\WEB-INF\\view\\" + contextConfig.getBizEnName() + "\\{}_edit.html";
        pageJsPathTemplate = "\\src\\main\\resources\\static\\modules\\" + contextConfig.getBizEnName() + "\\{}.js";
        pageInfoJsPathTemplate = "\\src\\main\\resources\\static\\modules\\" + contextConfig.getBizEnName() + "\\{}_info.js";
    }

    public String getPagePathTemplate() {
        return pagePathTemplate;
    }

    public void setPagePathTemplate(String pagePathTemplate) {
        this.pagePathTemplate = pagePathTemplate;
    }

    public String getPageJsPathTemplate() {
        return pageJsPathTemplate;
    }

    public void setPageJsPathTemplate(String pageJsPathTemplate) {
        this.pageJsPathTemplate = pageJsPathTemplate;
    }

    public String getPageAddPathTemplate() {
        return pageAddPathTemplate;
    }

    public void setPageAddPathTemplate(String pageAddPathTemplate) {
        this.pageAddPathTemplate = pageAddPathTemplate;
    }

    public String getPageEditPathTemplate() {
        return pageEditPathTemplate;
    }

    public void setPageEditPathTemplate(String pageEditPathTemplate) {
        this.pageEditPathTemplate = pageEditPathTemplate;
    }

    public String getPageInfoJsPathTemplate() {
        return pageInfoJsPathTemplate;
    }

    public void setPageInfoJsPathTemplate(String pageInfoJsPathTemplate) {
        this.pageInfoJsPathTemplate = pageInfoJsPathTemplate;
    }

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }
}
