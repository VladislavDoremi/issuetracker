package com.axmor.user;

import java.util.UUID;

public class User {

    private UUID userUuid;
    private String username;
    private String salt;
    private String hashedPassword;

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

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
