package com.axmor.index;

import com.axmor.util.Path;
import com.axmor.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class IndexController {

    public static Route serveIndexPage = (Request request, Response response) -> {

        response.redirect(Path.Web.DASHBOARD);

        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.INDEX);
    };

}
