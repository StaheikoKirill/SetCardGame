package view;


import deck.Card;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DrawCard extends JPanel {
    private Card card;
    private ImageIcon imageIcon;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;


    public DrawCard(Card card) {
        this.card = card;


        this.setBackground(Color.WHITE);
        this.setSize(70, 120);
        this.setLayout(new GridLayout(3, 1));
        this.setBorder(new LineBorder(Color.GRAY, 3, true));

        imageIcon = new ImageIcon("pictures/" + card.getFigure() + "_" + card.getColor() + "_" +
                card.getFon() + ".png");
        label1 = new JLabel(imageIcon);
        switch (card.getCount()) {
            case 1:
                this.add(label1);
                break;
            case 2:
                this.add(label1);
                label2 = new JLabel(imageIcon);
                this.add(label2);
                break;
            case 3:
                this.add(label1);
                label2 = new JLabel(imageIcon);
                label3 = new JLabel(imageIcon);
                this.add(label2);
                this.add(label3);
                break;
        }
    }
}
