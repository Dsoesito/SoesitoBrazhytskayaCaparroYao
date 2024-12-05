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
        int roundNumber = 1;
        while (super.getPlayers().get(0).getHand().size() > 0 && super.getPlayers().get(1).getHand().size() > 0) {
            gameView.displayMessage("Round " + roundNumber + " begins!");
            executeRound(roundNumber);
            gameView.waitForNextRound();
            roundNumber++;
        }
        declareWinner();
    }

    @Override
    public void declareWinner() {
        Player p1 = super.getPlayers().get(0);
        Player p2 = super.getPlayers().get(1);

        String winner = p1.getHand().size() > p2.getHand().size() ? p1.getName() : p2.getName();
        gameView.displayWinner(winner);
    }

    public void executeRound(int roundNumber) {
        Player p1 = super.getPlayers().get(0);
        Player p2 = super.getPlayers().get(1);

        userView.putCardDown(p1.getName());
        Card card1 = p1.playCard();

        userView.putCardDown(p2.getName());
        Card card2 = p2.playCard();

        gameView.displayMessage(p1.getName() + " plays: " + card1);
        gameView.displayMessage(p2.getName() + " plays: " + card2);

        ArrayList<Card> table = new ArrayList<>();
        table.add(card1);
        table.add(card2);

        if (card1.getValue() == card2.getValue()) {
            gameView.displayWarStart();
            boolean p1WinsWar = declareWar(table);
            if (p1WinsWar) {
                p1.addToHand(table);
            } else {
                p2.addToHand(table);
            }
        } else if (card1.getValue() > card2.getValue()) {
            p1.addToHand(table);
            gameView.displayRoundResult(p1.getName(), card1, roundNumber);
        } else {
            p2.addToHand(table);
            gameView.displayRoundResult(p2.getName(), card2, roundNumber);
        }
    }

    public boolean declareWar(ArrayList<Card> table) {
        Player p1 = super.getPlayers().get(0);
        Player p2 = super.getPlayers().get(1);

        if (p1.getHand().size() < 2 || p2.getHand().size() < 2) {
            gameView.displayMessage("One player doesn't have enough cards for war!");
            return p1.getHand().size() > p2.getHand().size();
        }

        Card p1FaceDown = p1.playCard();
        Card p1FaceUp = p1.playCard();
        Card p2FaceDown = p2.playCard();
        Card p2FaceUp = p2.playCard();

        table.add(p1FaceDown);
        table.add(p1FaceUp);
        table.add(p2FaceDown);
        table.add(p2FaceUp);

        gameView.displayTable(table);
        gameView.displayMessage(p1.getName() + " plays face-up card: " + p1FaceUp);
        gameView.displayMessage(p2.getName() + " plays face-up card: " + p2FaceUp);

        if (p1FaceUp.getValue() == p2FaceUp.getValue()) {
            return declareWar(table);
        } else {
            return p1FaceUp.getValue() > p2FaceUp.getValue();
        }
    }
}