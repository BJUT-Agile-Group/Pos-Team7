package com.PosTeam7;

import item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Item> shoppingCart = new ArrayList<Item>();
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
            shoppingCart.add(new Item(a.split(",|，")));
        }
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
}
