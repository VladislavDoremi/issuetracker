package com.axmor.comment;

import com.axmor.login.LoginController;
import com.axmor.util.Path;
import com.axmor.util.UuidGenerator;
import com.axmor.util.ViewUtil;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.axmor.Application.*;

public class CommentController {

    public static Route fetchAllByIssue = (Request request, Response response) -> {

        //Проверка пользователя
        LoginController.ensureUserIsLoggedIn(request, response);

        Map<String, Object> model = new HashMap<String, Object>();
        QueryParamsMap map = request.queryMap();
        String uuid = map.get("issueUuid").value();
        List<Comment> comments = commentModel.fetchAllByIssue(uuid);
        model.put("comments", comments);
        return ViewUtil.render(request, model, Path.Template.COMMENTS);
    };

    public static Route create = (Request request, Response response) -> {

        try {
            QueryParamsMap map = request.queryMap();
            UUID uuid = UuidGenerator.getUuid();
            String issue = map.get("issueUuid").value();
            UUID user = userModel.getUserByUsername(request.session().attribute("currentUser")).getUserUuid();
            String description = map.get("description").value();
            commentModel.create(uuid, issue, user, description);
            if (response.status() == 200) {
                return 0;
            }
        }
        catch (Exception e){
            return "Error: " + e.getMessage();
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

}
