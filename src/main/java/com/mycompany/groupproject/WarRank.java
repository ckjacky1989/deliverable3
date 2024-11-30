/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.groupproject;

/**
 *
 * @author ckjac
 */
public enum WarRank {
    ACE(14),
    KING(13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    DEUCE(2);
    
    private int rankValue;
    public int getRankValue(){
        return this.rankValue;}
    private WarRank(int rankValue){
        this.rankValue=rankValue;}
    
}
