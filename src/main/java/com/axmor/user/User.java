package com.axmor.user;

import lombok.Value;

@Value
public class User {

    int id;
    String username;
    String salt;
    String hashedPassword;

    public User(int id, String username, String salt, String hashedPassword) {
        this.id = id;
        this.username = username;
        this.salt = salt;
        this.hashedPassword = hashedPassword;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getSalt() {
        return salt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}
