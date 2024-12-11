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
        
//        Added this section back in case Proff Joe wants to test the program with a smaller test case

//        System.out.println("Running test scenario: Player 1 wins with 5 cards each");
//
//        // Manually create 5 WarCards for each player
//        ArrayList<WarCard> player1Cards = new ArrayList<>();
//        ArrayList<WarCard> player2Cards = new ArrayList<>();
//
//        // Create strongser cards for Player 1
//        player1Cards.add(new WarCard(WarCard.Value.ACE, WarCard.Suit.HEARTS));
//        player1Cards.add(new WarCard(WarCard.Value.KING, WarCard.Suit.SPADES));
//        player1Cards.add(new WarCard(WarCard.Value.QUEEN, WarCard.Suit.CLUBS));
//        player1Cards.add(new WarCard(WarCard.Value.JACK, WarCard.Suit.DIAMONDS));
//        player1Cards.add(new WarCard(WarCard.Value.TEN, WarCard.Suit.HEARTS));
//
//        // Create weaker cards for Player 2
//        player2Cards.add(new WarCard(WarCard.Value.FIVE, WarCard.Suit.HEARTS));
//        player2Cards.add(new WarCard(WarCard.Value.FOUR, WarCard.Suit.CLUBS));
//        player2Cards.add(new WarCard(WarCard.Value.THREE, WarCard.Suit.SPADES));
//        player2Cards.add(new WarCard(WarCard.Value.TWO, WarCard.Suit.DIAMONDS));
//        player2Cards.add(new WarCard(WarCard.Value.SIX, WarCard.Suit.CLUBS));
//        
//        WarHand player1Hand = new WarHand(5, player1Cards);
//        WarHand player2Hand = new WarHand(5, player2Cards);
//        
//        Player p1 = new WarPlayer(this.p1Name, player1Hand.getCards());
//        Player p2 = new WarPlayer(this.p2Name, player2Hand.getCards());
//        
//        ArrayList<Player> players = new ArrayList<>();
//        players.add(p1);
//        players.add(p2);
//        
//        WarGameController warGame = new WarGameController("War Game", players);
//        
//        warGame.play();
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.startGame();
    }
}