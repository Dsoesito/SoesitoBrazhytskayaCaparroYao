/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Main {
    private final WarUserView userView;
    private final String p1Name;
    private final String p2Name;
    
    public Main() {
        this.userView = new WarUserView();
        this.p1Name = userView.getUserName(1);
        this.p2Name = userView.getUserName(2);
    }
    
    public void startGame() {
        System.out.println("Starting War Game!");
        
        // Create players with the user input names
        Player p1 = new WarPlayer(this.p1Name);
        Player p2 = new WarPlayer(this.p2Name);

        // Add players to a list and start the game
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        
        // Instantiate the WarGameController with players
        WarGameController warGame = new WarGameController("War Game", players);
        
        // Start the game
        warGame.play();
    }

    public static void main(String[] args) {
        // Create an instance of the Main class and start the game
        Main game = new Main();
        game.startGame();
    }
}