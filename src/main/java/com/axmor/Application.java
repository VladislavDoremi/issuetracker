package com.axmor;

import com.axmor.controller.*;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.*;

/**
 * Application entry point
 */
public class Application {
    public static void main(String[] args) {


        //FreeMarker
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freemarkerConfiguration = new Configuration();
        freemarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Application.class, "/templates/"));
        freeMarkerEngine.setConfiguration(freemarkerConfiguration);
        staticFileLocation("/static");

        //Application config
        port(80);

        //Routs
        //get("/", (Request req, Response res) -> IndexController.init(freeMarkerEngine));

        //TODO: Авторизация пользователя
        //get("/login", (Request req, Response res) -> LoginController.authorization());

        //TODO: Доска задач
        get("/", (Request req, Response res) -> DashboardController.get(freeMarkerEngine));
        //get("/dashboard", (Request req, Response res) -> DashboardController.get());

        //TODO: CRUD задач
        path("/issue", () -> {
            //post("/create", (Request req, Response res) -> IssueController.create());
            //get("/read", (Request req, Response res) -> IssueController.getById(0));
            //post("/update", (Request req, Response res) -> IssueController.update());
            //post("/delete", (Request req, Response res) -> IssueController.delete());

            //TODO: CRUD комментариев
            path("/comment", () -> {
                //post("/create", (Request req, Response res) -> CommentController.create());
                //get("/read", (Request req, Response res) -> CommentController.getById(0));
                //post("/update", (Request req, Response res) -> CommentController.update());
                //post("/delete", (Request req, Response res) -> CommentController.delete());
            });
        });

    }
}
