package com.axmor.user;

import org.mindrot.jbcrypt.BCrypt;

import static com.axmor.Application.userModel;

public class UserController {

    public static boolean authenticate(String username, String password) {

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        User user = userModel.getUserByUsername(username);
        if (user == null) {
            return false;
        }
        String hashedPassword = BCrypt.hashpw(password, user.getSalt());
        return hashedPassword.equals(user.getHashedPassword());
    }

}
