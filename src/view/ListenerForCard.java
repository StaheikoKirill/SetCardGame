package view;

import controller.Controller;
import deck.Card;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerForCard implements MouseListener {

    private DrawCard drawCard;
    public Controller controller;
    private Card card;
    public boolean clicked;

    public ListenerForCard(DrawCard drawCard, Controller controller, Card card) {
        this.drawCard = drawCard;
        this.controller = controller;
        this.card = card;
        clicked = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!clicked) {
            clicked = true;
            controller.setCardToCompare(card, 1);

            drawCard.setBackground(Color.PINK);
        } else {
            clicked = false;
            controller.setCardToCompare(card, 0);
            drawCard.setBackground(Color.WHITE);
        }


    }

    @Override
    public void mouseEntered(MouseEvent e) {
        drawCard.setBackground(Color.PINK);


    }
   @Override
    public void mouseExited(MouseEvent e) {
        if (!clicked) {
            drawCard.setBackground(Color.WHITE);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
