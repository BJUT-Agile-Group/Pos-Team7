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
        } while (!inTemp.toString().endsWith("]"));
        temp = inTemp
                .toString()
                .replaceAll("\\{|\\[|\\]| |\t|'|barcode:|name:|unit:|price:", "")
                .split("},|}");
        for (String a : temp) {
            product.add(new Info(a.split(",")));
        }
        for (int i = 0; i < product.size(); i++) {
            for (int j = product.size() - 1; j > i; j--) {
                if (product.get(i).getBarcode().equals(product.get(j).getBarcode())) {
                    product.get(i).setNum(product.get(i).getNum() + 1);
                    product.remove(j);
                }
            }
        }
        int sum = 0;
        for (Info a : product) {
            System.out.println(a.getName() + "," + a.getNum() + a.getUnit() + "," + "￥" + a.getTotal());
            sum += a.getTotal();
        }
        System.out.println("￥" + sum);
    }
}
