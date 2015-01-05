package item;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by joe on 15/1/5.
 */
public class ProductList {
    private String barcode;

    public ProductList() {
    }

    public ProductList(List<ProductList> productList) {
        System.out.println("输入商品列表文件:" );
        Scanner in = new Scanner(System.in);
        StringBuilder inputStr = new StringBuilder();
        do {
            inputStr.append(in.nextLine());
        } while (!inputStr.toString().replaceAll(" ", "" ).endsWith("]" ));
        String input = inputStr.toString();
        String c[] = input.replaceAll("\\[|\\]|\\'|\n| ", "" ).split("," );
        for (String d : c) {
            ProductList product = new ProductList();
            product.setBarcode(d);
            productList.add(product);
        }
        productList.sort(new SortProduct());
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}

class SortProduct implements Comparator {
    public int compare(Object s1, Object s2) {
        return s1.toString().compareTo(s2.toString());
    }
}