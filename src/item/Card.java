package item;

import java.util.ArrayList;

public class Card {
    private ArrayList<Item> items = new ArrayList<Item>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void CAndG() {
        Card card = new Card();
    }
}
