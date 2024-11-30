/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupproject;

/**
 *
 * @author ckjac
 */
public class WarCard extends Card {
    private WarRank rank;
    private Suit suit;
    public WarCard(WarRank rank, Suit suit){
        this.rank=rank;
        this.suit=suit;
    };
    @Override
    public String toString(){
    return this.rank+" "+this.suit;}
    
    public WarRank getRank() {
        return rank;
    }
    public Suit getSuit() {
        return suit;
    }
}
