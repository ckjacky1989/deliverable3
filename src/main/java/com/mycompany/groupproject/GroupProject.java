/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.groupproject;

/**
 *
 * @author ckjac
 */
public class GroupProject {

    public static void main(String[] args) {
        WarPlayer comp= new WarPlayer("comp","1234");
        WarPlayer player= new WarPlayer("player","1234");
        WarGame game = new WarGame(comp,player);
        game.deal(); // Deal the cards

        System.out.println("Computer's Deck: " + game.getComp().getPlayerDeck());
        System.out.println("Player's Deck: " + game.getPlayer().getPlayerDeck());
        game.playGame();
    }
}
