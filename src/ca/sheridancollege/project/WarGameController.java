/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Daniel Soesito
 */
public class WarGameController extends Game {
    private final WarUserView userView;
    private final WarGameView gameView;

    public WarGameController(String name, ArrayList<Player> players) {
        super(name);
        super.setPlayers(players);
        this.userView = new WarUserView();
        this.gameView = new WarGameView();
    }

    @Override
    public void play() {
        WarPlayer p1 = (WarPlayer) super.getPlayers().get(0);
        WarPlayer p2 = (WarPlayer) super.getPlayers().get(1);
        
        int roundNumber = 1;
        while (!p1.getHand().isEmpty() && !p2.getHand().isEmpty()) {
            gameView.displayMessage("Round " + roundNumber + " begins!");
            executeRound(roundNumber);
            gameView.waitForNextRound();
            roundNumber++;
        }
        declareWinner();
    }

    @Override
    public void declareWinner() {
        WarPlayer p1 = (WarPlayer) super.getPlayers().get(0);
        WarPlayer p2 = (WarPlayer) super.getPlayers().get(1);

        String winner = p1.getHand().size() > p2.getHand().size() ? p1.getName() : p2.getName();
        gameView.displayWinner(winner);
    }

    public void executeRound(int roundNumber) {
        WarPlayer p1 = (WarPlayer) super.getPlayers().get(0);
        WarPlayer p2 = (WarPlayer) super.getPlayers().get(1);

        userView.putCardDown(p1.getName());
        WarCard card1 = p1.playCard();

        userView.putCardDown(p2.getName());
        WarCard card2 = p2.playCard();

        gameView.displayMessage(p1.getName() + " plays: " + card1);
        gameView.displayMessage(p2.getName() + " plays: " + card2);

        ArrayList<WarCard> table = new ArrayList<>();
        table.add(card1);
        table.add(card2);

        if (card1.getNumericalValue() == card2.getNumericalValue()) {
            gameView.displayWarStart();
            boolean p1WinsWar = declareWar(table);
            if (p1WinsWar) {
                p1.addToHand(table);
            } else {
                p2.addToHand(table);
            }
        } else if (card1.getNumericalValue() > card2.getNumericalValue()) {
            p1.addToHand(table);
            gameView.displayRoundResult(p1.getName(), roundNumber);
        } else {
            p2.addToHand(table);
            gameView.displayRoundResult(p2.getName(), roundNumber);
        }
    }

    public boolean declareWar(ArrayList<WarCard> table) {
        WarPlayer p1 = (WarPlayer) super.getPlayers().get(0);
        WarPlayer p2 = (WarPlayer) super.getPlayers().get(1);

        if (p1.getHand().size() < 2 || p2.getHand().size() < 2) {
            gameView.displayMessage("One player doesn't have enough cards for war!");
            return p1.getHand().size() > p2.getHand().size();
        }

        WarCard p1FaceDown = p1.playCard();
        WarCard p1FaceUp = p1.playCard();
        WarCard p2FaceDown = p2.playCard();
        WarCard p2FaceUp = p2.playCard();

        table.add(p1FaceDown);
        table.add(p1FaceUp);
        table.add(p2FaceDown);
        table.add(p2FaceUp);

        gameView.displayTable(table);
        gameView.displayMessage(p1.getName() + " plays face-up card: " + p1FaceUp);
        gameView.displayMessage(p2.getName() + " plays face-up card: " + p2FaceUp);

        if (p1FaceUp.getNumericalValue() == p2FaceUp.getNumericalValue()) {
            return declareWar(table);
        } else {
            return p1FaceUp.getNumericalValue() > p2FaceUp.getNumericalValue();
        }
    }
}