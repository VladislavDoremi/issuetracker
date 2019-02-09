package com.axmor.util;

import com.axmor.Application;
import freemarker.cache.ClassTemplateLoader;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.*;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Map;

public class TemplateUtil {

    public static TemplateHashModel getTemplateHashModel() throws Exception {
        BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
        TemplateHashModel statics = wrapper.getStaticModels();
        return (TemplateHashModel) statics.get("com.axmor.util.Path$Web");
    }

    public static FreeMarkerEngine templateEngine() {
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freemarkerConfiguration = new Configuration();
        freemarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Application.class, "/templates"));
        freeMarkerEngine.setConfiguration(freemarkerConfiguration);
        return freeMarkerEngine;
    }

}
