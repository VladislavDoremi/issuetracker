package com.axmor.issue;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class IssueModel {

    private Sql2o sql2o;

    public IssueModel(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Issue> fetchAll() {
        try (Connection connection = sql2o.open()) {

            String query = "SELECT * FROM Issues WHERE deleted=false";

            List<Issue> issues = connection.createQuery(query)
                    .executeAndFetch(Issue.class);
            return issues;
        }
    }

    public Issue fetchById(String issueUuid) {
        try (Connection connection = sql2o.open()) {

            String query = "SELECT * FROM Issues WHERE issueUuid=:issueUuid";

            Issue issue = connection.createQuery(query)
                    .addParameter("issueUuid", issueUuid)
                    .executeAndFetchFirst(Issue.class);
            return issue;
        }
    }

    public void create(UUID issueUuid, UUID userUuid, int status,  String title, String description,  Date startDate, Date deadlineDate) {

        try (Connection connection = sql2o.open()) {

            String query = "INSERT INTO Issues (issueUuid, userUuid, status, title, description, startDate, deadlineDate) " +
                    "VALUES (:issueUuid, :userUuid, :status, :title, :description, :startDate, :deadlineDate )";

            connection.createQuery(query)
                    .addParameter("issueUuid", issueUuid)
                    .addParameter("userUuid", userUuid)
                    .addParameter("status", status)
                    .addParameter("title", title)
                    .addParameter("description", description)
                    .addParameter("startDate", startDate)
                    .addParameter("deadlineDate", deadlineDate)
                    .executeUpdate();

            connection.commit();
        }
    }

    public void update(String issueUuid, int status, String title, String description, Date startDate, Date deadlineDate) {
        try (Connection connection = sql2o.open()) {

            String query = "UPDATE Issues SET status=:status, title=:title, description=:description, " +
                    "startDate=:startDate, deadlineDate=:deadlineDate  WHERE issueUuid=:issueUuid";

            connection.createQuery(query)
                    .addParameter("issueUuid", issueUuid)
                    .addParameter("status", status)
                    .addParameter("title", title)
                    .addParameter("description", description)
                    .addParameter("startDate", startDate)
                    .addParameter("deadlineDate", deadlineDate)
                    .executeUpdate();
            connection.commit();
        }
    }

    public void delete(String issueUuid) {
        try (Connection connection = sql2o.open()) {

            //String query = "DELETE FROM Issues WHERE issueUuid=:issueUuid";
            String query = "UPDATE Issues SET deleted=true WHERE issueUuid=:issueUuid";

            connection.createQuery(query)
                    .addParameter("issueUuid", issueUuid)
                    .executeUpdate();
            connection.commit();
        }
    }

    public void updateStatus(String issueUuid, int status) {
        try (Connection connection = sql2o.open()) {

            String query = "UPDATE Issues SET status=:status WHERE issueUuid=:issueUuid";

            connection.createQuery(query)
                    .addParameter("issueUuid", issueUuid)
                    .addParameter("status", status)
                    .executeUpdate();
            connection.commit();
        }
    }


}
