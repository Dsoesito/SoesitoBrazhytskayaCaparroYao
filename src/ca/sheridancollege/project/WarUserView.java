/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Daniel Soesito
 */
public class WarUserView {

    private final Scanner scanner;

    public WarUserView() {
        this.scanner = new Scanner(System.in);
    }
    
    public String getUserName(int num) {
        System.out.println("Player " + num + " please enter your name: ");
        String name = scanner.next();
        return name;
    }

    public void putCardDown(String playerName) {
        System.out.println(playerName + ", press Enter to play your card...");
        scanner.nextLine(); // Waits for the user to press Enter
    }
}
