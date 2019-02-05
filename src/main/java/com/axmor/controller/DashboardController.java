package com.axmor.controller;

import com.axmor.entity.Issue;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.*;

public class DashboardController {

    public static String init(FreeMarkerEngine freeMarkerEngine) {
        Map<String, Object> model = new HashMap<String, Object>();

        List<Issue> issueList = new ArrayList<>();

        issueList.add(new Issue(1, "DoReMi", "Issie1", "dfgdfgdgf", 0));
        issueList.add(new Issue(2, "Fart", "Issie1", "hgkjhkgh", 1));
        issueList.add(new Issue(3, "Gert", "Issie1", "dsfsfdsdsdfsdsdf324234234", 0));
        issueList.add(new Issue(4, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 2));
        issueList.add(new Issue(5, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 3));
        issueList.add(new Issue(6, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 2));
        issueList.add(new Issue(7, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 1));
        issueList.add(new Issue(8, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 3));
        issueList.add(new Issue(9, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 2));
        issueList.add(new Issue(10, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 0));
        issueList.add(new Issue(11, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 2));
        issueList.add(new Issue(12, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 2));
        issueList.add(new Issue(13, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 2));
        issueList.add(new Issue(14, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 2));
        issueList.add(new Issue(15, "Tron", "Issie1", "dsfdfgfdgdf35gdbcb", 2));

        model.put("issueList", issueList);

        return freeMarkerEngine.render(new ModelAndView(model, "dashboard.ftl"));

    }

    public static String update() {
        return new String();
    }

}
