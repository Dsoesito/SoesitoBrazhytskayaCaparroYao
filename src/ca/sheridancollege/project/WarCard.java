/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.HashMap;
import java.util.Map;

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
    
    private static final Map<Value, Integer> valueRankings;
    
    static {
        valueRankings = new HashMap<>();
        valueRankings.put(Value.ACE, 14); // Assign ACE the highest rank
        valueRankings.put(Value.TWO, 2);
        valueRankings.put(Value.THREE, 3);
        valueRankings.put(Value.FOUR, 4);
        valueRankings.put(Value.FIVE, 5);
        valueRankings.put(Value.SIX, 6);
        valueRankings.put(Value.SEVEN, 7);
        valueRankings.put(Value.EIGHT, 8);
        valueRankings.put(Value.NINE, 9);
        valueRankings.put(Value.TEN, 10);
        valueRankings.put(Value.JACK, 11);
        valueRankings.put(Value.QUEEN, 12);
        valueRankings.put(Value.KING, 13);
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
    
    public int getNumericalValue() {
        return valueRankings.get(value);
    }
}
