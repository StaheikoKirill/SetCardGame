package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame {

    Controller controller;
    private JLabel imageLabel;
    private JLabel newGame;
    private JLabel addCards;
    private JLabel findSet;
    public CardPanel cardPanel;
    public ScorePanel scorePanel;
    public int cardsOnPanel;
    public LastSet lastSetPanel;


    public MainWindow() {

        controller = new Controller(this);
        this.setTitle("SET Game");
        this.setSize(1000, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        imageLabel = new JLabel(new ImageIcon("menuItems/fon.jpg"));
        this.add(imageLabel);
        imageLabel.setBounds(0, 0, 1000, 700);
        newGame = new JLabel(new ImageIcon("menuItems/NewGame.png"));
        imageLabel.add(newGame);
        newGame.setBounds(0, 10, 250, 70);
        addCards = new JLabel(new ImageIcon("menuItems/AddCards.png"));
        imageLabel.add(addCards);
        cardsOnPanel = 10;
        addCards.setBounds(20, 70, 250, 70);
        findSet = new JLabel(new ImageIcon("menuItems/FindSet.png"));
        imageLabel.add(findSet);
        findSet.setBounds(5, 120, 170, 100);
        cardPanel = new CardPanel(controller);
        imageLabel.add(cardPanel);
        cardPanel.setBounds(350, 50, 600, 500);
        lastSetPanel = new LastSet(controller);
        imageLabel.add(lastSetPanel);
        lastSetPanel.setBounds(25, 450, 300, 150);


        newGame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (controller.gameStarted) {

                    cardPanel.clearPanel();
                    scorePanel.timer.stop();
                }
                controller.newGame();
                cardPanel.addCardsOnPanel(controller.getCards(15));
                scorePanel = new ScorePanel(controller);
                imageLabel.add(scorePanel);
                scorePanel.setBounds(30, 220, 200, 200);
                scorePanel.deckLabel.setText(" Карт в колоде: 66");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                newGame.setIcon(new ImageIcon("menuItems/NewGame1.png"));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                newGame.setIcon(new ImageIcon("menuItems/NewGame.png"));

            }
        });
        addCards.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (cardsOnPanel < 18) {

                        cardPanel.addCardsOnPanel(controller.getCards(3));



                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                addCards.setIcon(new ImageIcon("menuItems/AddCards1.png"));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                addCards.setIcon(new ImageIcon("menuItems/AddCards.png"));

            }
        });
        findSet.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    controller.findSet();

                } catch (Exception ex) {
                }
                System.out.println("Начните игру!");

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                findSet.setIcon(new ImageIcon("menuItems/FindSet1.png"));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                findSet.setIcon(new ImageIcon("menuItems/FindSet.png"));

            }
        });
    }

}
