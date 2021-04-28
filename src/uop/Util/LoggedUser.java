/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uop.Util;

import uop.Model.User;

/**
 *
 * @author caplj
 */
public class LoggedUser {
    private static User currentUser = null;

    private LoggedUser() {
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

}
