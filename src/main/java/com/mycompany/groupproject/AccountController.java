/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupproject;
import java.io.*;
import java.util.*;
/**
 *
 * @author ckjac
 */
public class AccountController {
    private static final String FILE_PATH = "player.txt";

    public WarPlayer registerWarPlayer(String name, String password) {
        // Create file if it doesn't exist
        createFileIfNotExist();

        // Load all players' data using Scanner
        List<String> playersData = loadPlayersData();

        // Check if the name already exists
        for (String playerLine : playersData) {
            // Data is split by "," 
            String[] playerDetails = playerLine.split(",");
            if (playerDetails[0].toUpperCase().equals(name.toUpperCase())) {
            System.out.println("Player " + name + " already exists.");
            // Return null if name already exists
            return null; 
            }
        }

        // If name does not exist, instantiate new WarPlayer
        WarPlayer newPlayer = new WarPlayer(name, password);
        System.out.println("Player " + name + " is successfully registered.");
        // Store the player's data in the form of name,password,score,loss
        String playerRecord = name + "," + password + ",0,0"; 

        // Add the new player to the list of players
        playersData.add(playerRecord);

        // Write the updated players' data to the file
        writeToFile(playersData);  

        // Return the new WarPlayer
        return newPlayer;
    }

    public WarPlayer authenticateWarPlayer(String name, String password) {
        // Load all players' data using Scanner
        List<String> playersData = loadPlayersData();

        // Check if the player exists and if the password matches
        for (String playerLine : playersData) {
            String[] playerDetails = playerLine.split(",");
            String storedName = playerDetails[0];
            String storedPassword = playerDetails[1];
            int storedScore = Integer.parseInt(playerDetails[2]);
            int storedLoss = Integer.parseInt(playerDetails[3]);

            // Check if name and password match
            if (storedName.equals(name) && storedPassword.equals(password)) {
                // If they match, instantiate the WarPlayer
                WarPlayer warPlayer = new WarPlayer(storedName, storedPassword);
                warPlayer.setScore(storedScore);
                warPlayer.setLoss(storedLoss);
                return warPlayer; // Return the authenticated WarPlayer
            }
        }

        // If not match, return null
        System.out.println("Incorrect name or password.");
        return null;
    }
    // Add score or loss and update the file
    public void updateResultToFile(WarPlayer player, String result) {
        // Load the player data from file
        List<String> playersData = loadPlayersData();

        // Loop through the players data, find the correct row and update the score or loss
        for (int i = 0; i < playersData.size(); i++) {
            String[] playerDetails = playersData.get(i).split(",");
            String storedName = playerDetails[0];
            String storedPassword = playerDetails[1];
            int storedScore = Integer.parseInt(playerDetails[2]);
            int storedLoss = Integer.parseInt(playerDetails[3]);
            
            // Check if the player's name matches
            if (storedName.equals(player.getName())) {
                // Update the player's score if win, otherwise update loss 
                if (result.equals("win")){player.addScore();}
                else {player.addLoss();}
                System.out.println("Updated score and loss is " + player.getScore()+" and "+ player.getLoss());
                // Create the updated record for the player
                String updatedRecord = storedName + "," + storedPassword + "," + player.getScore() + "," + player.getLoss();
                // Update the list with updated record
                playersData.set(i, updatedRecord);
                System.out.println("Updated successfully for " + player.getName());
                // Exit the loop after update
                break; 
            }
        }
        // Write the updated data to the file
        writeToFile(playersData); 
    }
    public WarPlayer logout() {
        System.out.println("Player has been logged out.");
        // Logout the current player by setting the reference to null
        return null; 
    }
    
    public void createFileIfNotExist() {        
        // Check if the file exists. If not, create it
        // Ref:https://www.w3schools.com/java/java_files_create.asp
        try {
            File myObj = new File(FILE_PATH);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public List<String> loadPlayersData() {
        List<String> playersData = new ArrayList<>();
        File file = new File(FILE_PATH);

        // Check if the file exists
        if (!file.exists()) {
            //Return empty list if file does not exist
            return playersData; 
        }

        // Using Scanner to read the file line by line
        // Ref:https://www.w3schools.com/java/java_files_read.asp
        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                // Add the line to the list
                playersData.add(line); 
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return playersData;
    }

    public void writeToFile(List<String> playersData) {
        // Using FileWriter to write the list of player data to the file
        // Ref:https://www.w3schools.com/java/java_files_create.asp
        try {
            // (FILE_PATH,false)or(FILE_PATH)=overwrite the file with the updated data
            // (FILE_PATH,ture)=appending
            FileWriter myWriter = new FileWriter(FILE_PATH);
            for (String data : playersData) {
                myWriter.write(data + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote all player data to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
    }
}
}