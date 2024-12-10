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
public class WarHand extends GroupOfCards{
    
    public WarHand(int size, ArrayList<WarCard> hand) {
        super(size);
        super.setCards(hand);
    }
    
    public ArrayList<WarCard> getWarHand() {
        return super.getCards();
    }
}
