package com.axmor.comment;

import com.axmor.issue.Issue;
import com.axmor.login.LoginController;
import com.axmor.util.Path;
import com.axmor.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.axmor.Application.issueModel;
import static com.axmor.util.RequestUtil.clientAcceptsHtml;
import static com.axmor.util.RequestUtil.clientAcceptsJson;

public class CommentController {

    public static Route fetchAll = (Request request, Response response) -> {

        //Проверка пользователя
        LoginController.ensureUserIsLoggedIn(request, response);

        if (clientAcceptsHtml(request)) {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Issue> commentList = issueModel.fetchAll();
            model.put("commentList", commentList);
            return ViewUtil.render(request, model, Path.Template.DASHBOARD);
        }

        if (clientAcceptsJson(request)) {
            //TODO: Вернуть контент в Json
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route fetchById = (Request request, Response response) -> {

        //Проверка пользователя
        LoginController.ensureUserIsLoggedIn(request, response);

        if (clientAcceptsHtml(request)) {
            Map<String, Object> model = new HashMap<String, Object>();
            Issue issue = issueModel.fetchById("1");
            model.put("issue", issue);
            return ViewUtil.render(request, model, Path.Template.ISSUE);
        }

        if (clientAcceptsJson(request)) {
            //TODO: Вернуть контент в Json
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route create = (Request request, Response response) -> {

        if (clientAcceptsHtml(request)) {

        }

        if (clientAcceptsJson(request)) {
            //TODO: Вернуть контент в Json
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route update = (Request request, Response response) -> {

        if (clientAcceptsHtml(request)) {

        }

        if (clientAcceptsJson(request)) {
            //TODO: Вернуть контент в Json
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route delete = (Request request, Response response) -> {

        if (clientAcceptsHtml(request)) {

        }

        if (clientAcceptsJson(request)) {
            //TODO: Вернуть контент в Json
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

}
