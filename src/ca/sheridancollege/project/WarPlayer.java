/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Sofya Dec10, 2024
 */
public class WarPlayer extends Player {
    
    /**
     * The player's hand of cards.
     */
    private final ArrayList<WarCard> hand;
    
    /**
     * Creating a WarPlayer with a given name and initial hand.
     *
     * @param name  The player's name.
     * @param hand  The initial hand of cards for the player.
     */
    public WarPlayer(String name, ArrayList<WarCard> hand) {
        super(name);
        this.hand = hand;
    }
    
    /**
     * Returns the player's current hand of cards.
     * @return 
     */
    public ArrayList<WarCard> getHand() {
        return hand;
    }
    
    /**
     * Plays the top card from the player's hand.
     *
     * @return The played card.
     * @throws IllegalStateException if the player's hand is empty.
     */
    public WarCard playCard() {
        if (hand.isEmpty()) {
            throw new IllegalStateException( super.getName() + " has no cards left!");
        }
        return hand.remove(0);
    }

    /**
     * Adds a list of cards to the player's hand.
     *
     * @param cards The cards to add to the hand.
     */
    public void addToHand(ArrayList<WarCard> cards) {
    if (cards != null) {
        hand.addAll(cards);
    } else {
        // Handle null input
        System.out.println("Warning: Received null card list in addToHand()");
    }
   }

    @Override
    public void play() {
        System.out.println("Play.");
    }
    
    /**
     * Plays a card in the War game.
     *
     * This method interacts with the WarGameController to draw a card and play it.
     */
//    @Override
//    public void play() {
//       // Get a card from the WarGameController
//    WarCard cardToPlay = WarGameController.drawCard();
//    hand.remove(cardToPlay); // Remove the played card from the player's hand
//    // Send the played card to the WarGameController
//    WarGameController.playCard(this, cardToPlay);
//    }

}

