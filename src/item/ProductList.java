package item;

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

    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
