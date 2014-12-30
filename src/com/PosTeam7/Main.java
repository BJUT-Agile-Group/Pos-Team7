package com.PosTeam7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String[]> product;
        String[] temp;
        StringBuilder inTemp = new StringBuilder();
        do {
            inTemp.append(in.nextLine());
        } while (!inTemp.toString().endsWith("]"));
        temp = inTemp.toString().replaceAll("\\{|\\[|\\]", "").replaceAll(" ", "").split("},|}");
        ///
        ///ewaogia
        ///
        for (String a : temp) {
            System.out.println(a);
        }
    }
}
