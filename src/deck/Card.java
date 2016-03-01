package deck;


public class Card {

    private int count;
    private String color;
    private String fon;
    private String figure;


    public Card(int count, String color, String fon, String figure) {

        this.count = count;
        this.color = color;
        this.fon = fon;
        this.figure = figure;
    }

    public int getCount() {
        return this.count;
    }

    public String getColor() {
        return this.color;
    }

    public String getFon() {
        return this.fon;
    }

    public String getFigure() {
        return this.figure;
    }


}
