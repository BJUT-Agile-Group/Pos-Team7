package item;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items = new ArrayList<Item>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void AddItem(Item item) {
        items.add(item);
    }
}
