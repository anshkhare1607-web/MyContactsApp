package com.session;

import com.model.User;

// for having only one instance running at a time, only one user access at a time
public class SessionManager {

    private static SessionManager instance;
    private User loggedInUser;

    private SessionManager() {}

    public static SessionManager getInstance() {

    	// if instance is null, create a new one
    	// other wise return the one that is already running
        if (instance == null) {
            instance = new SessionManager();
        }

        return instance;
    }

    public void login(User user) {
        this.loggedInUser = user;
    }

    public void logout() {
        this.loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}