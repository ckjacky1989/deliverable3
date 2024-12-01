/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupproject;

import java.util.ArrayList;

/**
 *
 * @author ckjac
 */
public class WarPlayer extends Player{
    private ArrayList<WarCard> playerDeck;
    private String name;
    private String password;
    private int loss;
    private int score;
    private double winRate;
    
    public WarPlayer(String name,String password){
        this.name=name;
        this.password=password;
        this.loss=0;
        this.score=0;
        this.winRate=0;
        this.playerDeck=new ArrayList<>();
    };
    
    public void setPlayerDeck(ArrayList<WarCard> playerDeck) {
        this.playerDeck = playerDeck;
    }
    public ArrayList<WarCard> getPlayerDeck() {
        return playerDeck;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getLoss() {
        return loss;
    }

    public int getScore() {
        return score;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        if(this.score+this.loss==0)
            {this.winRate=0;}else
            {this.winRate = this.score/(this.score+this.loss);}
    }
    public void addScore(){
        this.score++;
    }
    public void addLoss(){
        this.loss++;
    }    

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "WarPlayer " + name;
    }

}