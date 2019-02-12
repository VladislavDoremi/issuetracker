package com.axmor.comment;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.UUID;

public class CommentModel {

    private Sql2o sql2o;

    public CommentModel(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Comment> fetchAllByIssue(String issueUuid) {
        try (Connection connection = sql2o.open()) {

            String query = "SELECT * FROM Comments WHERE issueUuid=:issueUuid AND deleted=false";

            List<Comment> comments = connection.createQuery(query)
                    .addParameter("issueUuid", issueUuid)
                    .executeAndFetch(Comment.class);
            return comments;
        }
    }

    public void create(UUID commentUuid, String issueUuid, UUID userUuid, String description) {

        try (Connection connection = sql2o.open()) {

            String query = "INSERT INTO Comments (commentUuid, issueUuid, userUuid, description) VALUES (:commentUuid, :issueUuid, :userUuid, :description)";

            connection.createQuery(query)
                    .addParameter("commentUuid", commentUuid)
                    .addParameter("issueUuid", issueUuid)
                    .addParameter("userUuid", userUuid)
                    .addParameter("description", description)
                    .executeUpdate();

            connection.commit();
        }
    }

}
