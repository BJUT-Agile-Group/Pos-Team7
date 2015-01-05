package com.PosTeam7;

import item.Index;
import item.Item;
import item.ProductList;
import item.ShoppongCart;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Index> indexList = new ArrayList<Index>();
        List<ProductList> productList = new ArrayList<ProductList>();
        List<Item> shoppongCart = new ArrayList<Item>();
        Index index = new Index(indexList);
        ProductList product = new ProductList(productList);

        int i = 0;
        for (ProductList barcode : productList)
        {
            if(barcode.getBarcode() == indexList.get(i).getBarcode()) {
                Item item = new Item(indexList.get(i));
                shoppongCart.add(item);
            }
        }

        //  List<Item> shoppingCart = getShoppingCart(getLine());
/*        for (int i = 0; i < shoppingCart.size(); i++) {
            for (int j = shoppingCart.size() - 1; j > i; j--) {
                if (shoppingCart.get(i).getBarcode().equals(shoppingCart.get(j).getBarcode())) {
                    shoppingCart.get(i).setNum(shoppingCart.get(i).getNum() + 1);
                    shoppingCart.remove(j);
                }
            }
        }
        double sum = 0;
        double discount = 0;
        for (Item a : shoppingCart) {
            System.out.println(a.getName() + "," + a.getNum() + a.getUnit() + "," + "￥" + a.getTotal());
            sum += a.getTotal();
            discount += a.getTotalDiscount();
        }
        System.out.println("￥" + sum);
        System.out.println("save:" + "￥" + (float) discount);
    }*/
/*
    public static String getLine() {
        Scanner in = new Scanner(System.in);
        StringBuilder inputStr = new StringBuilder();
        do {
            inputStr.append(in.nextLine());
        } while (!inputStr.toString().replaceAll(" |　", "").endsWith("]"));
        return inputStr.toString();
    }

    public static List<Item> getShoppingCart(String inputStr) {
        List<Item> shoppingCart = new ArrayList<Item>();
        for (String a : inputStr.replaceAll("\\{|\\[|\\]| |　|\t|\n|'|barcode|name|unit|price|discount|:|：", "").split("]，|},|}")) {
            shoppingCart.add(new Item(a.split(",|，")));
        }
        return shoppingCart;
    }*/
    }
}
