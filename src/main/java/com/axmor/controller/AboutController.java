package com.axmor.controller;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

public class AboutController {

    public static String init(FreeMarkerEngine freeMarkerEngine) {
        Map<String, Object> model = new HashMap<String, Object>();

        return freeMarkerEngine.render(new ModelAndView(model, "about_me.ftl"));
    }

}
