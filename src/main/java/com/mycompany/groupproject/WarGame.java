/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ckjac
 */
public class WarGame extends Game{
    private WarPlayer comp;
    private WarPlayer player;
    private WarDeck deck;
    private boolean isEnd;
    private int round;
    private String roundInput;
    private String goOnInput="1";
    private int maxRound;
    AccountController ac= new AccountController();
    
    public WarGame(WarPlayer comp,WarPlayer player) {
        this.deck = new WarDeck();
        this.comp = comp;
        this.player = player;
        this.isEnd = false;
        this.round=0;
    }

    public void deal(){
        deck.createFullDeck();
        deck.shuffleCard();
        ArrayList<WarCard> fullDeck = deck.getFullDeck();
        comp.setPlayerDeck(new ArrayList<>(fullDeck.subList(0, 26)));
        player.setPlayerDeck(new ArrayList<>(fullDeck.subList(26, 52)));
    }

    public void playARound() {
        // Check if player has at least 1 card for payARound()
        if (player.getPlayerDeck().size() < 1) {
            System.out.println("Player has not enough cards for the game.");
            declareWinner(comp, player);
            //End playARound()
            return;
        // Check if comp has has at least 1 card for payARound()
        } else if (comp.getPlayerDeck().size() < 1){
            System.out.println("Computer has not enough cards for the game.");
            declareWinner(player, comp);
            //End playARound()
            return;
        }
        WarCard playerCard = player.getPlayerDeck().remove(0);
        WarCard compCard = comp.getPlayerDeck().remove(0);

        System.out.println(playerCard + " VS " + compCard);

        if (playerCard.getRank().getRankValue() > compCard.getRank().getRankValue()) {
            System.out.println("Player wins this round.");
            player.getPlayerDeck().add(playerCard);
            player.getPlayerDeck().add(compCard);
            System.out.println("Player's card: " + player.getPlayerDeck().size());
            System.out.println("Comp's card: " + comp.getPlayerDeck().size());            
        } else if (playerCard.getRank().getRankValue() < compCard.getRank().getRankValue()) {
            System.out.println("Computer wins this round.");
            comp.getPlayerDeck().add(playerCard);
            comp.getPlayerDeck().add(compCard);
            System.out.println("Player's card: " + player.getPlayerDeck().size());
            System.out.println("Comp's card: " + comp.getPlayerDeck().size());
        } else {
            // Start a war
            System.out.println("War!");
            ArrayList<WarCard> warPile = new ArrayList<>();
            warPile.add(playerCard);
            warPile.add(compCard);
            war(player, comp, playerCard, compCard, warPile);
    }
}
    public void war(WarPlayer player, WarPlayer comp, WarCard playerFirstCard, WarCard compFirstCard, ArrayList<WarCard> warPile) {

        // Check if player has enough cards for the war
        if (player.getPlayerDeck().size() < 2) {
            System.out.println("Player has not enough cards for war.");
            declareWinner(comp, player);
            //End war()
            return;
        // Check if comp has enough cards for the war
        } else if (comp.getPlayerDeck().size() < 2){
            System.out.println("Computer has not enough cards for war.");
            declareWinner(player, comp);
            //End war()
            return;
        }

   
        // Player's face-down card
        WarCard playerFaceDown = player.getPlayerDeck().remove(0); 
        // Add player's face-down card to the pile
        warPile.add(playerFaceDown);
        // Comp's face-down card
        WarCard compFaceDown = comp.getPlayerDeck().remove(0);
        // Add comp's face-down card to the pile
        warPile.add(compFaceDown);   

        // Player's face-up card
        WarCard playerFaceUp = player.getPlayerDeck().remove(0);
        // Add player's face-up card to the pile
        warPile.add(playerFaceUp);
        // Comp's face-up card
        WarCard compFaceUp = comp.getPlayerDeck().remove(0);
        // Add comp's face-up card to the pile
        warPile.add(compFaceUp);

        System.out.println(playerFaceUp + " VS " + compFaceUp);
        
        // Compare the face-up cards
        if (playerFaceUp.getRank().getRankValue() > compFaceUp.getRank().getRankValue()) {
            System.out.println("Player wins the war!");
            player.getPlayerDeck().addAll(warPile);
            System.out.println("Player's card: " + player.getPlayerDeck().size());
            System.out.println("Comp's card: " + comp.getPlayerDeck().size());            
        } else if (playerFaceUp.getRank().getRankValue() < compFaceUp.getRank().getRankValue()) {
            System.out.println("Comp wins the war!");
            comp.getPlayerDeck().addAll(warPile);
            System.out.println("Player's card: " + player.getPlayerDeck().size());
            System.out.println("Comp's card: " + comp.getPlayerDeck().size());            
        } else {
            System.out.println("It's a tie again, another war starts");
            // Recursive call for another war
            war(player, comp, playerFaceUp, compFaceUp, warPile);
        }
    }

    @Override
    public void playGame() {
        System.out.println("How many rounds do you want to play in maximum?");
        System.out.println("Non integer input implies 50 rounds.");
        Scanner myObj = new Scanner(System.in);
        roundInput=myObj.nextLine();
        
        //If non integer, then maxRound=50, else use it for maxRound
        try {
            maxRound = Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Defaulting to 50 rounds.");
            maxRound = 50;
        }
        //Handle cases if entered maxRound is <=0
        if (maxRound<=0){
            maxRound = 50;}
        while (!isEnd && round < maxRound) {
            round++;
            if (goOnInput.equals("1")){
            System.out.println("1.Go on, 2.Surrender, Others input means auto.");
            goOnInput=myObj.nextLine();}
            switch (goOnInput) {
                // go on
                case "1":
                    playARound();
                    break;
                // surrender
                case "2":
                    declareWinner(comp, player);
                    return;
                // auto
                default:
                    System.out.println("Auto mode");
                    playARound();
                    break;
            }}
        if (round == maxRound) {
            if (player.getPlayerDeck().size() > comp.getPlayerDeck().size()) {
                declareWinner(player, comp);
            } else {
                declareWinner(comp, player);
            }
        }
           
    }

    @Override
    public void declareWinner(WarPlayer winner,WarPlayer loser) {
        System.out.println(winner+" wins.");
        this.isEnd=true;
        if (winner.getName().equals("computerPlayer")){
            ac.updateResultToFile(loser, "loss");
        }else{
            ac.updateResultToFile(winner, "win");
        }
    }
    public WarPlayer getComp() {
        return comp;
    }

    public WarPlayer getPlayer() {
        return player;
    }
}
