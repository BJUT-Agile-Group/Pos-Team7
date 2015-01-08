package com.PosTeam7;

import item.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        List<Index> indexList = new ArrayList<Index>();
        List<Item> promotion = new ArrayList<Item>();
        List<Users> user = new ArrayList<Users>();
        ShoppingCart shoppingCart = new ShoppingCart();
        Index index = new Index();
        ProductList product = new ProductList();
        Users users = new Users();
        index.read(indexList);
        product.read();
        users.read(user);

        int i = 0;
        for (Users username : user) {
            if (username.getName().equals(product.getUserName())) {
                shoppingCart.vip = username.getVip();
                shoppingCart.score = username.getScore();
                break;
            }
            i++;
        }
        if (i == user.size()) {
            System.out.println("没有这个用户!");
            exit(0);
        }

        i = 0;
        for (String barcode : product.getBarcode()) {
            if (barcode.equals(indexList.get(i).getBarcode())) {
                Item item = new Item(indexList.get(i));
                shoppingCart.add(item);
            } else {
                while (++i < indexList.size()) {
                    if (barcode.equals(indexList.get(i).getBarcode())) {
                        Item item = new Item(indexList.get(i));
                        shoppingCart.add(item);
                        break;
                    }
                }
                if (i >= indexList.size()) {
                    System.out.println("Barcode not found.");
                    exit(0);
                }
            }
        }
        double sum = 0;
        double discount = 0;
        //计算购物积分
        for (Item a : shoppingCart.shoppingCart) {
            if (!shoppingCart.vip.equals("true")) {
                sum += a.getTotal();
                discount += a.getTotalDiscount();
            } else {
                sum += a.getVipTotal();
                discount += a.getVipTotalDiscount();
            }
        }


        System.out.println("***商店购物清单***\n");
        System.out.println("************\n");
        if (shoppingCart.score <= 200) {
            shoppingCart.score += (int) (sum / 5);
        } else if (shoppingCart.score > 200 && shoppingCart.score <= 500) {
            shoppingCart.score += (int) (sum / 5) * 3;
        } else if (shoppingCart.score > 500) {
            shoppingCart.score += (int) (sum / 5) * 5;
        }
        System.out.println("会员编号:" + product.getUserName() + "\t会员积分:" + shoppingCart.score);
        users.setScore(product.getUserName(), shoppingCart.score);
        System.out.println("************\n");
        sum = 0;
        discount = 0;
        for (Item a : shoppingCart.shoppingCart) {
            if (!shoppingCart.vip.equals("true")) {
                System.out.println(a.getName() + "," + a.getNum() + a.getUnit() + "," + a.getPrice() + "," + "￥" + a.getTotal());

                if (a.isPromotion() && a.getNum() >= 2) {
                    promotion.add(a);
                }
                sum += a.getTotal();
                discount += a.getTotalDiscount();
            } else {
                System.out.println(a.getName() + "," + a.getNum() + a.getUnit() + "," + a.getPrice() + "," + "￥" + a.getVipTotal());
                sum += a.getVipTotal();
                discount += a.getVipTotalDiscount();
            }
        }
        if (!promotion.isEmpty()) {
            System.out.println("爺送你的");
            for (Item a : promotion) {
                System.out.println(a.getName() + "\t1" + a.getUnit());
            }
        }
        System.out.println("************\n");
        System.out.println("总计：￥" + sum);
        System.out.println("节省:" + "￥" + (float) discount);
    }
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