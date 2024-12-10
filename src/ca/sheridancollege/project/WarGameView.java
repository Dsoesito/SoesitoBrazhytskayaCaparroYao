/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel Soesito
 */
public class WarGameView {
    
    private final Scanner scanner;
    
    public WarGameView() {
        this.scanner = new Scanner(System.in);
    }

    // General message to CLI
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Display round results
    public void displayRoundResult(String winnerName, int roundNumber) {
        System.out.println("Round " + roundNumber + " Winner: " + winnerName);
    }

    // Ask users to start next round
    public void waitForNextRound() {
        System.out.println("Press Enter to proceed to the next round...");
        scanner.nextLine(); // Waits for the user to press Enter
    }

    // Displaying winner of game
    public void displayWinner(String playerName) {
        System.out.println("Congratulations " + playerName + "! You are the winner!");
    }

    // Displaying start of war
    public void displayWarStart() {
        System.out.println("WAR! Both players have drawn cards of equal value!");
    }

    // Displaying table
    public void displayTable(ArrayList<WarCard> table) {
        System.out.println("Cards on the table: " + table);
    }
}