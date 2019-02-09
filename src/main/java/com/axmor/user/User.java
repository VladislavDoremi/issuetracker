package com.axmor.user;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    UUID userUuid;
    String username;
    String salt;
    String hashedPassword;

    public User() {}

    public User(UUID userUuid, String username, String salt, String hashedPassword) {
        this.userUuid = userUuid;
        this.username = username;
        this.salt = salt;
        this.hashedPassword = hashedPassword;
    }

    public UUID getUserUuid() {
        return userUuid;
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
