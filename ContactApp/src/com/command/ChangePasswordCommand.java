package com.command;

import java.util.Scanner;

import com.model.User;
import com.session.SessionManager;
import com.util.PasswordUtil;


// for changing password
public class ChangePasswordCommand implements ProfileCommand {

    //Override
    public void execute() {

        Scanner sc = new Scanner(System.in);

        User user = SessionManager.getInstance().getLoggedInUser(); // session manager

        System.out.print("Enter new password: ");
        String password = sc.nextLine();

        String hashed = PasswordUtil.hashPassword(password);

        user.setPasswordHash(hashed);

        System.out.println("Password updated successfully");
    }
}