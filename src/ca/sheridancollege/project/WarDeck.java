/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Yao
 */
public final class WarDeck extends GroupOfCards {
    public WarDeck(int size){
        super(size);
        super.setCards(createDeck());
    }
    
    public ArrayList<WarCard> createDeck() {
        ArrayList<WarCard> deck = new ArrayList<>();
        
        // Iterate over all suits
        for (WarCard.Suit suit : WarCard.Suit.values()) {
            // Iterate over all values
            for (WarCard.Value value : WarCard.Value.values()) {
                // Add a new WarCard to the deck
                deck.add(new WarCard(value, suit));
            }
        }

    return deck;
    }
    
    @Override
    public String toString() {
        StringBuilder deckString = new StringBuilder("Deck contains:\n");
        for (Card card : this.getCards()) {
            deckString.append(card).append("\n");
        }
        return deckString.toString();
    }

}
