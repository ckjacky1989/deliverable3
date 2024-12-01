/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupproject;
import java.util.Scanner;
/**
 *
 * @author ckjac
 */
public class Viewer {
    public String displayStartMenu(){
        System.out.println("-----------------------------");
        System.out.println("Start Menu");
        System.out.println("1.Create account");
        System.out.println("2.Login");
        System.out.println("3.Game instruction");
        System.out.println("4.Exit game");
        System.out.println("Please input 1, 2, 3, or 4");        
        System.out.println("-----------------------------");
        Scanner myObj = new Scanner(System.in);
        String inputValue = myObj.nextLine();
        return inputValue;
    }
     public String displayPlayerMenu(){
        System.out.println("-----------------------------");
        System.out.println("Player Menu");
        System.out.println("1.Start game");
        System.out.println("2.View players scores");
        System.out.println("3.Logout");
        System.out.println("Please input 1, 2, or 3");
        System.out.println("-----------------------------");
        Scanner myObj = new Scanner(System.in);
        String inputValue = myObj.nextLine();
        return inputValue;
    }
     public String readInstruction(){
        System.out.println("Game Instruction");
        System.out.println();
        System.out.println("After the game starts, the player will get 26 random cards. ");
        System.out.println("Before each round, the player can choose to press 1 for starting a round ");
        System.out.println("or 2 for surrendering. After a new round starts, the rank of the first card");
        System.out.println("of each player will be compared, the winner of that round can get both cards.");
        System.out.println("If the ranks are the same, compare the rank of the third card of each player,");
        System.out.println("the winner of that round can get 6 cards. If the ranks are the same again,");
        System.out.println("compare the 2n+1 cards until the ranks are different or no more cards can be ");
        System.out.println("compared, where n is the number of times having the same rank. Repeat the rounds");
        System.out.println("until there is a player having all 52 cards. It will declare the winner");
        System.out.println("");
        System.out.println("Input any key to go back to Start menu");
        Scanner myObj = new Scanner(System.in);
        myObj.nextLine();
        return "";
    }
}
