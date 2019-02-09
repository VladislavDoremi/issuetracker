package com.axmor.user;

import com.axmor.issue.Issue;
import com.google.common.collect.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.*;
import java.util.stream.*;

public class UserModel {

    private Sql2o sql2o;

    public UserModel(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public User getUserByUsername(String username) {
        try (Connection connection = sql2o.open()) {

            String query = "SELECT * FROM User WHERE username=:username";

            User user = connection.createQuery(query)
                    .addParameter("username", username)
                    .executeAndFetchFirst(User.class);
            return user;
        }
    }

}
