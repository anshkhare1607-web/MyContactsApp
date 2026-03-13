package com.command;

import java.util.Scanner;

import com.model.User;
import com.session.SessionManager;

// updating preference of user : light or dark theme
public class UpdatePreferenceCommand implements ProfileCommand {

    @Override
    public void execute() {

        Scanner sc = new Scanner(System.in);

        User user = SessionManager.getInstance().getLoggedInUser();

        System.out.print("Enter preference (dark/light) : ");
        String pref = sc.nextLine();

        user.setPreference(pref);

        System.out.println("Preference updated");
    }
}