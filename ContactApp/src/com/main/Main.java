/*
 * UC-03: User Profile Management
 * 
 * author : Developer
 * version : 3.0
 */


package com.main;
import com.controller.MenuController;

// main class 
public class Main {

	public static void main(String[] args) {

		MenuController menuController = new MenuController(); // calling menu function
		menuController.start();

	}
}
