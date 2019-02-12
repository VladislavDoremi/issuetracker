package com.axmor;

import com.axmor.comment.CommentController;
import com.axmor.comment.CommentModel;
import com.axmor.dashboard.DashboardController;
import com.axmor.index.IndexController;
import com.axmor.issue.IssueController;
import com.axmor.issue.IssueModel;
import com.axmor.login.LoginController;
import com.axmor.user.UserModel;
import com.axmor.util.DataSource;
import com.axmor.util.Filters;
import com.axmor.util.Path;
import com.axmor.util.ViewUtil;
import org.sql2o.Sql2o;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Application entry point
 */
public class Application {

    private static Sql2o appSql;

    public static UserModel userModel;
    public static IssueModel issueModel;
    public static CommentModel commentModel;

    public static void main(String[] args) {

        appSql = new Sql2o(DataSource.getDataSource());

        // Declare dependencies
        userModel = new UserModel(appSql);
        issueModel = new IssueModel(appSql);
        commentModel = new CommentModel(appSql);

        //Application config
        port(80);
        staticFileLocation("/static");
        staticFiles.expireTime(600L);
        enableDebugScreen();

        // Set up before-filters (called before each get/post)
        before("*",                     Filters.addTrailingSlashes);
        before("*",                     Filters.handleLocaleChange);

        //Routs
        get(Path.Web.INDEX,                   DashboardController.serveDashboardPage);
        get(Path.Web.DASHBOARD,               DashboardController.serveDashboardPage);
        get(Path.Web.LOGIN,                   LoginController.serveLoginPage);
        post(Path.Web.LOGIN,                  LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,                 LoginController.handleLogoutPost);


        get(Path.Web.ISSUE_FORM,              IssueController.form);
        get(Path.Web.ISSUE,                   IssueController.fetchById);
        post(Path.Web.ISSUE,                  IssueController.create);
        put(Path.Web.ISSUE,                   IssueController.update);
        put(Path.Web.ISSUE_UPDATE_STATUS,     IssueController.updateStatus);
        delete(Path.Web.ISSUE,                IssueController.delete);

        get(Path.Web.ALL_COMMENTS,            CommentController.fetchAllByIssue);
        post(Path.Web.COMMENT,                CommentController.create);

        get("*",                         ViewUtil.notFound);
    }
}
