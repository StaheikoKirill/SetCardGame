package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ScorePanel extends JPanel {
    private Controller controller;
    public JLabel deckLabel;
    private JLabel panelLabel;
    private Font font;
    private Font font1;
    private JLabel timeLabel;
    private JLabel resultLabel;
    public Timer timer;

    private int time;


    public ScorePanel(Controller controller) {
        time = 0;


        this.controller = controller;
        this.setBackground(Color.lightGray);
        this.setSize(400, 300);
        this.setLayout(new GridLayout(4, 1));
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
        this.setVisible(true);

        font = new Font("Verdana", Font.ITALIC, 15);
        font1 = new Font("Verdana", Font.ITALIC, 18);
        deckLabel = new JLabel();
        deckLabel.setFont(font);
        panelLabel = new JLabel();
        panelLabel.setFont(font);
        timeLabel = new JLabel("  Время: 0");
        timeLabel.setFont(font);
        resultLabel = new JLabel("  Выберите сет");
        resultLabel.setFont(font1);
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setCardCount();
        this.add(deckLabel);
        this.add(panelLabel);
        this.add(timeLabel);
        this.add(resultLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setCardCount();
            }
        });
        timer.start();
    }


    public void setCardCount() {
        time++;
        deckLabel.setText("  Карт в колоде: " + Integer.toString(controller.getCardCount()));
        panelLabel.setText("  Сетов убрано: " + Integer.toString(controller.model.getSetCount()));
        timeLabel.setText("  Время: " + time);
    }

    public void setResultText(String result) {
        resultLabel.setText(result);
    }


}
