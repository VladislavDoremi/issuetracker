package com.axmor.issue;

import com.axmor.login.LoginController;
import com.axmor.util.Path;
import com.axmor.util.ViewUtil;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.axmor.Application.issueDao;
import static com.axmor.util.RequestUtil.clientAcceptsHtml;
import static com.axmor.util.RequestUtil.clientAcceptsJson;

public class IssueController {

    public static Route form = (Request request, Response response) -> {

        //Проверка пользователя
        LoginController.ensureUserIsLoggedIn(request, response);

        if (clientAcceptsHtml(request)) {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Issue> issueList = issueDao.getAll();
            model.put("issueList", issueList);
            return ViewUtil.render(request, model, Path.Template.DASHBOARD);
        }

        if (clientAcceptsJson(request)) {
            //TODO: Вернуть контент в Json
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

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

}
