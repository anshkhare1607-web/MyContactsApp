package com.command;

import java.util.Scanner;

import com.model.User;
import com.session.SessionManager;
import com.util.*;

// updating user name and email of user
public class UpdateProfileCommand implements ProfileCommand {

    //Override
    public void execute() {

        Scanner sc = new Scanner(System.in);

        User user = SessionManager.getInstance().getLoggedInUser();

        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        System.out.print("Enter new email: ");
        String email = sc.nextLine();

        EmailValidationUtil.validateEmail(email);

        user.setName(name);
        user.setEmail(email);

        System.out.println("Profile updated successfully");
    }
}