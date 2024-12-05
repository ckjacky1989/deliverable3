/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupproject;

/**
 *
 * @author ckjac
 */
public class MainController {
    Viewer v = new Viewer();
    AccountViewer av = new AccountViewer();
    AccountController ac = new AccountController();
    String startMenuAns = "";
    boolean isFinished = false;
    public void menu(){
        AccountController ac = new AccountController();
        //Viewer v = new Viewer();
        //AccountViewer av = new AccountViewer();
        //String startMenuAns = "";
        //boolean isFinished = false;

        while (!isFinished) {
            // Display the start menu and get the user's choice
            startMenuAns = v.displayStartMenu();

            switch (startMenuAns) {
                // Create account
                case "1":
//                    String name = av.displayPrompt("Enter name: ");
//                    String password = av.displayPrompt("Enter password: ");
//                    String confirmedPw = av.displayPrompt("Enter password again: ");
//                    if (password.equals(confirmedPw)) {
//                        WarPlayer newPlayer = ac.registerWarPlayer(name, password);
//                        if (newPlayer != null) {
//                            System.out.println("Account created successfully.");
//                        } else {
//                            System.out.println("Account creation failed. Player may already exist.");
//                        }
//                    } else {
//                        System.out.println("Passwords do not match.");
//                    }
                    createAccount();
                    break;

                // Login
                case "2":
                    name = av.displayPrompt("Enter name: ");
                    password = av.displayPrompt("Enter password: ");
                    WarPlayer player = ac.authenticateWarPlayer(name, password);
                    if (player != null) {
                        System.out.println("Login successful. Welcome, " + player.getName());
                        boolean isPlayerMenuActive = true;
                        while (isPlayerMenuActive) {
                            String playerMenuAns = v.displayPlayerMenu();
                            switch (playerMenuAns) {
                                // Start game
                                case "1":
                                    WarPlayer comp = new WarPlayer("computerPlayer", "1234");
                                    WarGame game = new WarGame(comp, player);
                                    game.deal();
                                    game.playGame();
                                    break;

                                // View scores
                                case "2":
                                    av.viewPlayerScores();
                                    break;

                                // Log out
                                case "3":
                                    player = ac.logout();
                                    isPlayerMenuActive = false;
                                    
                                    break;

                                // Invalid option in player menu
                                default:
                                    System.out.println("Invalid option. Please try again.");
                            }
                        }
                    }
                    break;

                // Read instructions
                case "3":
//                    v.readInstruction();
                    gameInstruction();
                    break;

                // Exit program
                case "4":
//                    System.out.println("Thank you for using the War Game application. Goodbye!");
//                    isFinished = true;
                    exitGame();
                    break;

                // Invalid option in start menu
                default:
                    System.out.println("Invalid option. Please enter a valid choice.");
            
        }
    }
    
    }
    
    public void createAccount() {
        String name = av.displayPrompt("Enter name: ");
        String password = av.displayPrompt("Enter password: ");
        String confirmedPw = av.displayPrompt("Enter password again: ");
            if (password.equals(confirmedPw)) {
                WarPlayer newPlayer = ac.registerWarPlayer(name, password);
                if (newPlayer != null) {
                    System.out.println("Account created successfully.");
                } else {
                    System.out.println("Account creation failed. Player may already exist.");
                }
            } else {
                System.out.println("Passwords do not match.");
            }
    }
    
    public void login() {}
    
    public void gameInstruction() {
        v.readInstruction();
    }
    
    public void exitGame() {
        System.out.println("Thank you for using the War Game application. Goodbye!");
        isFinished = true;}
    
}
