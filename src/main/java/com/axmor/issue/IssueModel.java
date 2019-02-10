package com.axmor.issue;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class IssueModel {

    private Sql2o sql2o;

    public IssueModel(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Issue> fetchAll() throws SQLException {
        try (Connection connection = sql2o.open()) {

            String query = "SELECT * FROM Issues";

            List<Issue> issues = connection.createQuery(query)
                    .executeAndFetch(Issue.class);
            return issues;
        }
    }

    public Issue fetchById(String uuid) throws SQLException {
        try (Connection connection = sql2o.open()) {

            String query = "SELECT * FROM Issues WHERE issueUuid=:issueUuid";

            Issue issue = connection.createQuery(query)
                    .addParameter("issueUuid", uuid)
                    .executeAndFetchFirst(Issue.class);
            return issue;
        }
    }

    public void create(UUID issueUuid, String title, String description, int status, UUID userUuid) {

        try (Connection connection = sql2o.open()) {

            String query = "INSERT INTO Issues (issueUuid, title, description, status, userUuid) VALUES (:issueUuid, :title, :description, :status, :userUuid)";

            connection.createQuery(query)
                    .addParameter("issueUuid", issueUuid)
                    .addParameter("title", title)
                    .addParameter("description", description)
                    .addParameter("status", status)
                    .addParameter("userUuid", userUuid)
                    .executeUpdate();

            connection.commit();
        }
    }

    public void update(String uuid, String title, String description, int status) {
        try (Connection connection = sql2o.open()) {

            String query = "UPDATE Issues SET title=:title, description=:description, status=:status WHERE issueUuid=:issueUuid";

            connection.createQuery(query)
                    .addParameter("issueUuid", uuid)
                    .addParameter("title", title)
                    .addParameter("description", description)
                    .addParameter("status", status)
                    .executeUpdate();
            connection.commit();
        }
    }

    public void delete(String uuid) {
        try (Connection connection = sql2o.open()) {

            String query = "DELETE FROM Issues WHERE issueUuid=:issueUuid";

            connection.createQuery(query)
                    .addParameter("issueUuid", uuid)
                    .executeUpdate();
            connection.commit();
        }
    }


}
