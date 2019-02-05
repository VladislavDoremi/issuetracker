package com.axmor.controller;

import com.axmor.entity.Issue;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueController {

    public static String form(FreeMarkerEngine freeMarkerEngine) {
        Map<String, Object> model = new HashMap<String, Object>();

        return freeMarkerEngine.render(new ModelAndView(model, "issue.ftl"));
    }

    public static String create() {
        return new String();
    }

    public static String update() {
        return new String();
    }

    public static String delete() {
        return new String();
    }

    public static String getById(int id) {
        return new String();
    }

    public static String getAll() {
        return new String();
    }

}
