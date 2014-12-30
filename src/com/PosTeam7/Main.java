package com.PosTeam7;

import info.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Info> product = new ArrayList<Info>();
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
            product.add(new Info(a.split(",|，")));
        }
        for (int i = 0; i < product.size(); i++) {
            for (int j = product.size() - 1; j > i; j--) {
                if (product.get(i).getBarcode().equals(product.get(j).getBarcode())) {
                    product.get(i).setNum(product.get(i).getNum() + 1);
                    product.remove(j);
                }
            }
        }
        double sum = 0;
        double discount = 0;
        for (Info a : product) {
            System.out.println(a.getName() + "," + a.getNum() + a.getUnit() + "," + "￥" + a.getTotal());
            sum += a.getTotal();
            discount += a.getTotalDiscount();
        }
        System.out.println("￥" + sum);
        System.out.println("save:" + "￥" + (float) discount);
    }
}
