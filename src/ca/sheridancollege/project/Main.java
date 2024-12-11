/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Daniel
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
        
        WarDeck deck = new WarDeck(52);
        deck.shuffle();
        
        // Get all cards from the deck
        ArrayList<WarCard> cards = deck.getCards(); 

        // Split the deck into two halves and convert to ArrayList
        ArrayList<WarCard> player1Cards = new ArrayList<>(cards.subList(0, 26));
        ArrayList<WarCard> player2Cards = new ArrayList<>(cards.subList(26, 52));

        // Create WarHand instances for each player
        WarHand player1Hand = new WarHand(26, player1Cards);
        WarHand player2Hand = new WarHand(26, player2Cards);

        // Create players with the user input names
        Player p1 = new WarPlayer(this.p1Name, player1Hand.getCards());
        Player p2 = new WarPlayer(this.p2Name, player2Hand.getCards());

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
        Main game = new Main();
        game.startGame();
    }
}