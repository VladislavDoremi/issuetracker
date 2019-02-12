package com.axmor.util;

import org.eclipse.jetty.http.HttpStatus;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static com.axmor.util.TemplateUtil.templateEngine;
import static com.axmor.util.RequestUtil.getSessionCurrentUser;
import static com.axmor.util.RequestUtil.getSessionLocale;

public class ViewUtil {

    public static String render(Request request, Map model, String templatePath) throws Exception {

        model.put("currentUser", getSessionCurrentUser(request));
        model.put("WebPath", TemplateUtil.getTemplateHashModel());

        return templateEngine().render(new ModelAndView(model, templatePath));
    }

    public static Route notAcceptable = (Request request, Response response) -> {
        response.status(HttpStatus.NOT_ACCEPTABLE_406);
        return new MessageBundle(getSessionLocale(request)).get("ERROR_406_NOT_ACCEPTABLE");
    };

    public static Route notFound = (Request request, Response response) -> {
        response.status(HttpStatus.NOT_FOUND_404);
        return render(request, new HashMap<>(), Path.Template.NOT_FOUND);
    };



}
