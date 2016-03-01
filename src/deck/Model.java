package deck;


import controller.Controller;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    private Controller controller;
    private ArrayList<Card> myDeck;
    public ArrayList<Card> cardsToAdd;
    public ArrayList<Card> cardsToCompare = new ArrayList<Card>();
    private ArrayList<Card> cardsOnPanel;
    private ArrayList<Card> cardsToFind;
    public int setCount;

    public Model(Controller controller, ArrayList<Card> myDeck) {
        this.controller = controller;
        this.myDeck = myDeck;
        setCount = 0;
    }

    public ArrayList<Card> getCards(int count) {
        cardsToAdd = new ArrayList<Card>();
        for (int i = 0; i < count; i++) {
            Random rand = new Random();
            int index = rand.nextInt(myDeck.size());
            cardsToAdd.add(myDeck.get(index));
            myDeck.remove(index);

        }
        return cardsToAdd;
    }

    public void setCardsOnPanel(ArrayList<Card> cardsOnPanel) {
        this.cardsOnPanel = cardsOnPanel;

    }

    public int getPanelCount() {
        return this.cardsOnPanel.size();
    }

    public int getSetCount() {
        return this.setCount;
    }

    public void setCardToCompare(Card cardToCompare, int add) {
        switch (add) {
            case 0:
                cardsToCompare.remove(cardToCompare);
                break;

            case 1: {
                cardsToCompare.add(cardToCompare);
                if (cardsToCompare.size() == 3) {
                    if (compareCards(cardsToCompare)) {


                        deleteCards(cardsToCompare);

                    }
                    cardsToCompare.clear();

                }
            }
        }
    }

    private boolean compareCards(ArrayList<Card> cardsToCompare) {
        if (compareCount(cardsToCompare.get(0).getCount(), cardsToCompare.get(1).getCount(),
                cardsToCompare.get(2).getCount())
                && compareColor(cardsToCompare.get(0).getColor(), cardsToCompare.get(1).getColor(),
                cardsToCompare.get(2).getColor())
                && compareFon(cardsToCompare.get(0).getFon(), cardsToCompare.get(1).getFon(),
                cardsToCompare.get(2).getFon())
                && compareFigure(cardsToCompare.get(0).getFigure(), cardsToCompare.get(1).getFigure(),
                cardsToCompare.get(2).getFigure())) {

            return true;
        } else {


            return false;

        }
    }

    private void deleteCards(ArrayList<Card> cardsToDelete) {
        controller.mainFrame.cardPanel.deleteCardsFromPanel(cardsToDelete);
        controller.mainFrame.lastSetPanel.drawLastSet(cardsToDelete);
        setCount++;

    }


    private boolean compareCount(int count1, int count2, int count3) {
        if (count1 == count2 && count2 == count3) {
            return true;

        } else if (count1 != count2 && count2 != count3 && count1 != count3) {
            return true;
        } else return false;


    }

    private boolean compareColor(String color1, String color2, String color3) {
        if (color1.equals(color2) && color2.equals(color3)) {
            return true;
        } else if (!(color1.equals(color2)) && !(color2.equals(color3)) && !(color1.equals(color3))) {
            return true;
        } else return false;

    }

    private boolean compareFon(String fon1, String fon2, String fon3) {
        if (fon1.equals(fon2) && fon2.equals(fon3)) {
            return true;
        } else if (!(fon1.equals(fon2)) && !(fon2.equals(fon3)) && !(fon1.equals(fon3))) {
            return true;
        } else return false;


    }

    private boolean compareFigure(String figure1, String figure2, String figure3) {
        if (figure1.equals(figure2) && figure2.equals(figure3)) {
            return true;
        } else if (!(figure1.equals(figure2)) && !(figure2.equals(figure3)) && !(figure1.equals(figure3))) {
            return true;
        } else return false;


    }

    public void findSet() {


        for (int x = 0; x < cardsOnPanel.size() - 2; x++) {
            for (int y = x + 1; y < cardsOnPanel.size() - 1; y++) {
                for (int z = y + 1; z < cardsOnPanel.size(); z++) {

                    cardsToFind = new ArrayList<Card>();

                    cardsToFind.add(cardsOnPanel.get(x));
                    cardsToFind.add(cardsOnPanel.get(y));
                    cardsToFind.add(cardsOnPanel.get(z));
                    if (compareCards(cardsToFind)) {
                        controller.mainFrame.cardPanel.showSet(x, y, z);
                        return;
                    }
                }
            }
        }
        controller.mainFrame.scorePanel.setResultText("  СЕТ НЕ НАЙДЕН!");
    }


}
