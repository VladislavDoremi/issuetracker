package com.axmor.dashboard;

import com.axmor.issue.Issue;
import com.axmor.login.LoginController;
import com.axmor.util.Path;
import com.axmor.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.*;

import static com.axmor.Application.issueModel;
import static com.axmor.util.RequestUtil.clientAcceptsHtml;

public class DashboardController {

    public static Route serveDashboardPage = (Request request, Response response) -> {

        //Проверка пользователя
        LoginController.ensureUserIsLoggedIn(request, response);

        if (clientAcceptsHtml(request)) {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Issue> issueList = issueModel.fetchAll();
            model.put("issueList", issueList);
            return ViewUtil.render(request, model, Path.Template.DASHBOARD);
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

}
