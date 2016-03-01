package view;

import controller.Controller;
import deck.Card;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.ArrayList;


public class LastSet extends JPanel {
    private DrawCard drawCard;

    Controller controller;

    public LastSet(Controller controller) {
        this.controller = controller;
        this.setSize(300, 150);
        this.setLayout(new GridLayout(1, 3, 5, 5));
        this.setVisible(true);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                        "П о с л е д н и й   с е т: "),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }


    public void drawLastSet(ArrayList<Card> drawLastSet) {
        this.removeAll();
        for (Card card : drawLastSet) {
            drawCard = new DrawCard(card);
            this.add(drawCard);
        }
    }


}
