package view;

import controller.Controller;
import deck.Card;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;


public class CardPanel extends JPanel {

    private ArrayList<Card> cardsOnPannel;
    public ArrayList<DrawCard> drawCardsonPanel;
    public Controller controller;

    private DrawCard drawCard;


    public CardPanel(Controller controller) {

        this.controller = controller;
        this.setSize(600, 500);
        this.setLayout(new GridLayout(3, 5, 10, 10));
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.lightGray));
        this.setVisible(true);
        this.setBackground(Color.lightGray);
        cardsOnPannel = new ArrayList<Card>();
        drawCardsonPanel = new ArrayList<DrawCard>();


    }

    public void addCardsOnPanel(ArrayList<Card> cardsToAdd) {
        cardsOnPannel.addAll(cardsToAdd);
        for (int i = 0; i < cardsToAdd.size(); i++) {
            drawCard = new DrawCard(cardsToAdd.get(i));
            drawCard.addMouseListener(new ListenerForCard(drawCard, controller, cardsToAdd.get(i)));
            drawCardsonPanel.add(drawCard);
            this.add(drawCard);

        }
        controller.model.setCardsOnPanel(cardsOnPannel);
        this.updateUI();


    }

    public void clearPanel() {
        cardsOnPannel.clear();
        drawCardsonPanel.clear();
        controller.model.setCardsOnPanel(cardsOnPannel);
        this.removeAll();
    }

    public void deleteCardsFromPanel(ArrayList<Card> deleteCards) {
        cardsOnPannel.removeAll(deleteCards);
        drawCardsonPanel.clear();
        this.removeAll();
        for (int i = 0; i < cardsOnPannel.size(); i++) {
            drawCard = new DrawCard(cardsOnPannel.get(i));
            drawCard.addMouseListener(new ListenerForCard(drawCard, controller, cardsOnPannel.get(i)));
            drawCardsonPanel.add(drawCard);
            this.add(drawCard);
        }
        controller.model.setCardsOnPanel(cardsOnPannel);
        this.updateUI();

    }


    public void reDrawPanel() {
        drawCardsonPanel.clear();
        this.removeAll();
        for (int i = 0; i < cardsOnPannel.size(); i++) {
            drawCard = new DrawCard(cardsOnPannel.get(i));
            drawCard.addMouseListener(new ListenerForCard(drawCard, controller, cardsOnPannel.get(i)));
            drawCardsonPanel.add(drawCard);
            this.add(drawCard);
        }

        this.updateUI();


    }

    public void showSet(int index1, int index2, int index3) {
        drawCardsonPanel.get(index1).setBorder(new LineBorder(Color.orange, 3, true));
        drawCardsonPanel.get(index2).setBorder(new LineBorder(Color.orange, 3, true));
        drawCardsonPanel.get(index3).setBorder(new LineBorder(Color.orange, 3, true));
        controller.mainFrame.scorePanel.setResultText(" СЕТ НАЙДЕН!");
        this.updateUI();
    }

}


