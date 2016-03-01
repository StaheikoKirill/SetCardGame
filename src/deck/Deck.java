package deck;


import java.io.File;
import java.util.ArrayList;


public class Deck {

    private ArrayList<Card> myDeck = new ArrayList<Card>();


    private Card card;

    private String[] files;


    public Deck() {

        File folder = new File("pictures/");
        files = folder.list();
        for (String fileName : files) {
            String figure = fileName.substring(0, fileName.indexOf("_"));
            String color = fileName.substring(5, fileName.indexOf("_", 5));
            String fon = fileName.substring(figure.length() + color.length() + 2, fileName.length() - 4);
            for (int i = 1; i <= 3; i++) {
                card = new Card(i, color, fon, figure);
                myDeck.add(card);

            }

        }
    }

    public ArrayList<Card> returnDeck() {
        return myDeck;
    }

    public int getDeckSize() {
        return myDeck.size();
    }


}
