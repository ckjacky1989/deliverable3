/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupproject;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ckjac
 */
public class WarDeck extends GroupOfCard{
    private ArrayList<WarCard> fullDeck;

    public WarDeck() {
        this.fullDeck = new ArrayList<>();
    }

    
    
    public void createFullDeck(){
      for (Suit suit : Suit.values()) {
        for (WarRank rank : WarRank.values()) {
            WarCard card = new WarCard(rank, suit);
            fullDeck.add(card);
        }
      }
    }
    public int getSize(ArrayList<WarCard> deck) {
        return deck.size();
    }

    public ArrayList<WarCard> getFullDeck() {
        return fullDeck;
    }
    
    @Override
    public void shuffleCard() {
        Collections.shuffle(fullDeck);
    }
    
}
