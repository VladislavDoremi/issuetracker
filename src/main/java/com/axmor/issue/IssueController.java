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

import java.text.SimpleDateFormat;
import java.util.*;

import static com.axmor.Application.issueModel;
import static com.axmor.Application.userModel;
import static com.axmor.util.RequestUtil.clientAcceptsHtml;
import static com.axmor.util.RequestUtil.clientAcceptsJson;

public class IssueController {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Route form = (Request request, Response response) -> {

        //Проверка пользователя
        LoginController.ensureUserIsLoggedIn(request, response);

        if (clientAcceptsHtml(request)) {
            try {
                Map<String, Object> model = new HashMap<String, Object>();
                return ViewUtil.render(request, model, Path.Template.NEW_ISSUE);
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
            } catch (Exception e){
                return "Error: " + e.getMessage();
            }
        }

        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route create = (Request request, Response response) -> {

        try {
            QueryParamsMap map = request.queryMap();
            UUID issueUuid = UuidGenerator.getUuid();
            UUID userUuid = userModel.getUserByUsername(request.session().attribute("currentUser")).getUserUuid();
            Integer status = map.get("status").integerValue();
            String title = map.get("title").value();
            String description = map.get("description").value();
            Date startDate = dateFormat.parse(map.get("startDate").value());
            Date deadlineDate = dateFormat.parse(map.get("deadlineDate").value());

            issueModel.create(issueUuid, userUuid, status, title, description, startDate, deadlineDate);
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
            String issueUuid = map.get("issueUuid").value();
            Integer status = map.get("status").integerValue();
            String title = map.get("title").value();
            String description = map.get("description").value();
            Date startDate = dateFormat.parse(map.get("startDate").value());
            Date deadlineDate = dateFormat.parse(map.get("deadlineDate").value());

            issueModel.update(issueUuid, status, title, description, startDate, deadlineDate);

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
            String issueUuid = map.get("issueUuid").value();
            issueModel.delete(issueUuid);
            if (response.status() == 200) {
                return 0;
            }
        }
        catch (Exception e){
            return "Error: " + e.getMessage();
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route updateStatus = (Request request, Response response) -> {

        try {
            QueryParamsMap map = request.queryMap();
            String issueUuid = map.get("issueUuid").value();
            Integer status = map.get("status").integerValue();
            issueModel.updateStatus(issueUuid, status);
            if (response.status() == 200) {
                return status;
            }
        }
        catch (Exception e){
            return "Error: " + e.getMessage();
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

}
