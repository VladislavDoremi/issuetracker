package com.axmor.about;

import com.axmor.issue.Issue;
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

import static com.axmor.util.RequestUtil.clientAcceptsHtml;

public class AboutController {

    public static Route serveAboutPage = (Request request, Response response) -> {

        //Проверка пользователя
        LoginController.ensureUserIsLoggedIn(request, response);

        if (clientAcceptsHtml(request)) {
            Map<String, Object> model = new HashMap<String, Object>();
            return ViewUtil.render(request, model, Path.Template.ABOUT_ME);
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

}
