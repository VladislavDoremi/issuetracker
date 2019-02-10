package com.axmor.comment;

import com.axmor.issue.Issue;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CommentModel {

    private Sql2o sql2o;

    public CommentModel(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Comment> fetchAllByIssue(String issueUuid) {
        try (Connection connection = sql2o.open()) {

            String query = "SELECT * FROM Comments WHERE issueUuid=:issueUuid";

            System.out.println("SELECT * FROM Comments WHERE issueUuid=" + issueUuid);

            List<Comment> comments = connection.createQuery(query)
                    .addParameter("issueUuid", issueUuid)
                    .executeAndFetch(Comment.class);
            return comments;
        }
    }

    public Comment fetchById(String commentUuid) {
        try (Connection connection = sql2o.open()) {

            String query = "SELECT * FROM Comments WHERE commentUuid=:commentUuid";

            Comment comment = connection.createQuery(query)
                    .addParameter("commentUuid", commentUuid)
                    .executeAndFetchFirst(Comment.class);
            return comment;
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

    public void update(String commentUuid, String description) {
        try (Connection connection = sql2o.open()) {

            String query = "UPDATE Comments SET description=:description WHERE commentUuid=:commentUuid";

            connection.createQuery(query)
                    .addParameter("commentUuid", commentUuid)
                    .addParameter("description", description)
                    .executeUpdate();
            connection.commit();
        }
    }

    public void delete(String commentUuid) {
        try (Connection connection = sql2o.open()) {

            String query = "DELETE FROM Comments WHERE commentUuid=:commentUuid";

            connection.createQuery(query)
                    .addParameter("commentUuid", commentUuid)
                    .executeUpdate();
            connection.commit();
        }
    }

}
