package item;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private ArrayList<Item> items = new ArrayList<Item>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void AddItem() {
        Scanner in = new Scanner(System.in);
        String[] temp;
        StringBuilder inTemp = new StringBuilder();
        do {
            inTemp.append(in.nextLine());
        } while (!inTemp.toString().replaceAll(" |　", "").endsWith("]"));
        temp = inTemp
                .toString()
                .replaceAll("\\{|\\[|\\]| |　|\t|'|barcode|name|unit|price|discount|:|：", "")
                .split("]，|},|}");
        for (String a : temp) {
            items.add(new Item(a.split(",|，")));
        }
    }
}
