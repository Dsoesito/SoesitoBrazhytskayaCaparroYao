/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Druar
 */
public class WarCard extends Card {
    public enum Suit {
        HEARTS,
        CLUBS,
        SPADES,
        DIAMONDS
    }
    
    public enum Value {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }
    
    private Value value;
    private Suit suit;
    
    WarCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
    
    @Override
    public String toString() {
        return this.value + " OF " + this.suit;
    }
    
    public Value getValue() {
        return this.value;
    }
    
    public Suit getSuit() {
        return this.suit;
    }
}
