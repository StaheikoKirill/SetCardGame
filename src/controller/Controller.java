package controller;


import deck.Card;
import deck.Deck;
import deck.Model;
import view.MainWindow;

import java.util.ArrayList;


public class Controller {
    public MainWindow mainFrame;
    private Deck deck;
    public Model model;
    public boolean gameStarted = false;


    public Controller(MainWindow mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void newGame() {
        deck = new Deck();
        gameStarted = true;
        model = new Model(this, deck.returnDeck());

    }

    public ArrayList<Card> getCards(int count) {
        return model.getCards(count);

    }

    public void setCardToCompare(Card cardToCompare, int add) {
        model.setCardToCompare(cardToCompare, add);
    }

    public int getCardCount() {
        return deck.getDeckSize();

    }

    public int getPanelCount() {
        return model.getPanelCount();
    }

    public int getSetCount() {
        return model.getSetCount();
    }

    public void findSet() {
        model.findSet();
    }


}
