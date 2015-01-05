package item;

import java.util.List;
import java.util.Scanner;

/**
 * Created by joe on 15/1/5.
 */
public class Index {
    private String barcode;
    private String name;
    private String unit;
    private double price;

    public Index() {
    }

    public Index(String a[]) {
        setBarcode(a[0]);
        setName(a[1]);
        setUnit(a[2]);
        setPrice(Double.parseDouble(a[3]));
    }

    public Index(List<Index> indexList) {
        Scanner in = new Scanner(System.in);
        StringBuilder inputStr = new StringBuilder();
        do {
            inputStr.append(in.nextLine());
        } while (!inputStr.toString().replaceAll(" ", "" ).endsWith("}}" ));
        String a = inputStr.toString();
        String c[] = a.substring(0, a.length() - 2).split("}," );
        for (String d : c) {
            Index index = new Index(d.replaceAll("\\'\\:|\\{|\\'|name|unit|price| |\\'|\\,", "" ).split(":" ));
            indexList.add(index);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
