package item;

import java.util.Comparator;
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
    private double discount;

    public Index() {
    }

    public Index(String a[]) {
        setBarcode(a[0]);
        setName(a[1]);
        setUnit(a[2]);
        setPrice(Double.parseDouble(a[3]));
        if (a.length == 5) {
            setDiscount(Double.parseDouble(a[4]));
        } else {
            setDiscount(1);
        }
    }

    public Index(List<Index> indexList) {
        System.out.println("输入索引文件:" );
        Scanner in = new Scanner(System.in);
        StringBuilder inputStr = new StringBuilder();
        do {
            inputStr.append(in.nextLine());
        } while (!inputStr.toString().replaceAll(" ", "" ).endsWith("}}" ));
        String a = inputStr.toString();
        String c[] = a.substring(0, a.length() - 2).split("}," );
        for (String d : c) {
            Index index = new Index(d.replaceAll("\\'\\:|\\{|\\'|name|unit|price|discount| |\\'|\\,", "").split(":"));
            indexList.add(index);
        }
        indexList.sort(new SortIndex());
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

class SortIndex implements Comparator {
    public int compare(Object o1, Object o2) {
        Index s1 = (Index) o1;
        Index s2 = (Index) o2;
        return s1.getBarcode().compareTo(s2.getBarcode());
    }
}