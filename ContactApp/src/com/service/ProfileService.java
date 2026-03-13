package com.service;

import com.command.*;
import com.model.*;
import com.session.SessionManager;

// profile services
public class ProfileService {

    public void viewProfile() { // viewing profile of user

        User user = SessionManager.getInstance().getLoggedInUser();

        if (user == null) {
            System.out.println("No user logged in.");
            return;
        }

        String accountType;

        if (user instanceof FreeUser) {
            accountType = "Free User";
        } else if (user instanceof PremiumUser) {
            accountType = "Premium User";
        } else {
            accountType = "Unknown";
        }
        
        System.out.println("\n==== USER PROFILE ====");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Account Type: "+accountType);
        System.out.println("Preference: " + user.getPreference());
    }

    public void updateProfile() { // updating name and email

        ProfileCommand command = new UpdateProfileCommand();
        command.execute();
    }

    public void changePassword() { // update password

        ProfileCommand command = new ChangePasswordCommand();
        command.execute();
    }

    public void updatePreference() { // update preference (dark/light)

        ProfileCommand command = new UpdatePreferenceCommand();
        command.execute();
    }
}