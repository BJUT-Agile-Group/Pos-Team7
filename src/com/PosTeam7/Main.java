package com.PosTeam7;

import item.Index;
import item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Index> indexList = new ArrayList<Index>();
        Index index = new Index(indexList);
        List<Item> shoppingCart = getShoppingCart(getLine());
        for (int i = 0; i < shoppingCart.size(); i++) {
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
    }

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
    }
}
