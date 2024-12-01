/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupproject;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 *
 * @author ckjac
 */

public class AccountViewer {
    AccountController ac= new AccountController();
    public String displayNamePrompt(){
        System.out.println("Enter name: ");
        Scanner myObj = new Scanner(System.in);
        String inputValue = myObj.nextLine();
        return inputValue;
    }
    public String displayPasswordPrompt(){
        System.out.println("Enter password: ");
        Scanner myObj = new Scanner(System.in);
        String inputValue = myObj.nextLine();
        return inputValue;
    }
    public String displayPasswordConfirm(){
        System.out.println("Enter password: ");
        Scanner myObj = new Scanner(System.in);
        String inputValue = myObj.nextLine();
        return inputValue;
    }

    // Display sorted results
    public String viewPlayerScores() {
        // Load the existing player data from file
        List<String> playersData = ac.loadPlayersData();

        //Sort score in descending, then sort loss in ascending
        //Ref: https://www.baeldung.com/java-8-comparator-comparing
        playersData = playersData.stream()
                    // Sort score in descending
                    // p is a string, but it cannot use split(",") without clarifying it is a string
                    .sorted(Comparator.comparingInt((String p) -> Integer.valueOf(p.split(",")[2])).reversed() 
                     // Then sort loss in ascending
                    .thenComparingInt(p -> Integer.valueOf(p.split(",")[3]))) 
                    .collect(Collectors.toList());

        // Display sorted results
        System.out.println("Players Scores:");
        for (String line : playersData) {
            String[] details = line.split(",");
            String name = details[0];
            int score = Integer.parseInt(details[2]);
            int loss = Integer.parseInt(details[3]);
            double winRate;
            //Handle denominator=0 
            if (score+loss==0){
                winRate=0;}
            else {
                winRate=(double)score/(score+loss);
            }            
            
            System.out.println(
                "Name: " + name + ", Score: " + score + ", Loss: " + loss +
                ", Win Rate: " + String.format("%.2f", winRate*100)+"%"
            );
        }
        System.out.println("Input any key to go back to Player menu");
        Scanner myObj = new Scanner(System.in);
        myObj.nextLine();
        return "";
    }

}
