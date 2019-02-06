package com.axmor;

import com.axmor.about.AboutController;
import com.axmor.comment.CommentController;
import com.axmor.comment.CommentDao;
import com.axmor.dashboard.DashboardController;
import com.axmor.index.IndexController;
import com.axmor.issue.IssueController;
import com.axmor.issue.IssueDao;
import com.axmor.login.LoginController;
import com.axmor.user.UserDao;
import com.axmor.util.Filters;
import com.axmor.util.Path;
import com.axmor.util.ViewUtil;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Application entry point
 */
public class Application {

    public static UserDao userDao;
    public static IssueDao issueDao;
    public static CommentDao commentDao;

    public static void main(String[] args) {

        // Declare dependencies
        userDao = new UserDao();
        issueDao = new IssueDao();
        commentDao = new CommentDao();

        //Application config
        port(80);
        staticFileLocation("/static");
        staticFiles.expireTime(600L);
        enableDebugScreen();

        // Set up before-filters (called before each get/post)
        before("*",            Filters.addTrailingSlashes);
        before("*",            Filters.handleLocaleChange);

        //Routs
        get(Path.Web.INDEX,          IndexController.serveIndexPage);
        get(Path.Web.LOGIN,          LoginController.serveLoginPage);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
        get(Path.Web.DASHBOARD,     DashboardController.serveDashboardPage);
        get(Path.Web.ABOUT_ME,      AboutController.serveAboutPage);

        //get(Path.Web.BOOKS,        BookController.fetchAllBooks);
        //get(Path.Web.ONE_BOOK,     BookController.fetchOneBook);

        get("*",               ViewUtil.notFound);
    }
}
