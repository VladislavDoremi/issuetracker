package com.axmor.issue;

import com.axmor.login.LoginController;
import com.axmor.user.UserModel;
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

import static com.axmor.Application.issueModel;
import static com.axmor.Application.userModel;
import static com.axmor.util.RequestUtil.clientAcceptsHtml;
import static com.axmor.util.RequestUtil.clientAcceptsJson;

public class IssueController {

    public static Route form = (Request request, Response response) -> {

        //Проверка пользователя
        LoginController.ensureUserIsLoggedIn(request, response);

        if (clientAcceptsHtml(request)) {
            try {
                Map<String, Object> model = new HashMap<String, Object>();
                return ViewUtil.render(request, model, Path.Template.CREATE_ISSUE);
            }
            catch (Exception e){
                return "Error: " + e.getMessage();
            }
        }

        if (clientAcceptsJson(request)) {
            //TODO: Вернуть контент в Json
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route fetchAll = (Request request, Response response) -> {

        //Проверка пользователя
        LoginController.ensureUserIsLoggedIn(request, response);

        if (clientAcceptsHtml(request)) {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Issue> issueList = issueModel.fetchAll();
            model.put("issueList", issueList);
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
            try {
                Map<String, Object> model = new HashMap<String, Object>();
                QueryParamsMap map = request.queryMap();
                String uuid = map.get("issueUuid").value();
                Issue issue = issueModel.fetchById(uuid);
                model.put("issue", issue);
                return ViewUtil.render(request, model, Path.Template.ISSUE);
            }
            catch (Exception e){
                return "Error: " + e.getMessage();
            }
        }

        if (clientAcceptsJson(request)) {
            //TODO: Вернуть контент в Json
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route create = (Request request, Response response) -> {

        try {
            QueryParamsMap map = request.queryMap();
            UUID uuid = UuidGenerator.getUuid();
            String title = map.get("title").value();
            String description = map.get("description").value();
            Integer status = map.get("status").integerValue();
            UUID user = userModel.getUserByUsername(request.session().attribute("currentUser")).getUserUuid();
            issueModel.create(uuid, title, description, status, user);
            if (response.status() == 200) {
                return 0;
            }
        }
        catch (Exception e){
            return "Error: " + e.getMessage();
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route update = (Request request, Response response) -> {

        try {
            QueryParamsMap map = request.queryMap();
            String uuid = map.get("issueUuid").value();
            String title = map.get("title").value();
            String description = map.get("description").value();
            Integer status = map.get("status").integerValue();
            issueModel.update(uuid, title, description, status);
            if (response.status() == 200) {
                return 0;
            }
        }
        catch (Exception e){
            return "Error: " + e.getMessage();
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route delete = (Request request, Response response) -> {

        try {
            QueryParamsMap map = request.queryMap();
            String uuid = map.get("issueUuid").value();
            issueModel.delete(uuid);
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
