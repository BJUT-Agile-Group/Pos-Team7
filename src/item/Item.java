package item;

/**
 * Created by joe on 14/12/30.
 */
public class Item {
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private int num;
    private double discount;
    private boolean promotion;

    public Item() {
    }

    public Item(Index index) {
        setBarcode(index.getBarcode());
        setPrice(index.getPrice());
        setUnit(index.getUnit());
        setName(index.getName());
        setNum(1);
        if (index.isPromotion()) {
            setPromotion(true);
            setDiscount(1);
        } else {
            setDiscount(index.getDiscount());
            setPromotion(false);
        }
    }

    public Item(String[] a) {
        setBarcode(a[0]);
        setName(a[1]);
        setUnit(a[2]);
        setPrice(Double.parseDouble(a[3]));
        if (a.length == 5) {
            setDiscount(Double.parseDouble(a[4]));
        } else {
            setDiscount(1);
        }
        setNum(1);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getTotal() {
        if (this.isPromotion() && this.getNum() >= 3) {
            return (getNum() - 1) * getPrice() * getDiscount();
        } else
            return getNum() * getPrice() * getDiscount();
    }

    public double getTotalDiscount() {
        if (this.isPromotion())
            return getPrice();
        else
            return getNum() * getPrice() * (1 - getDiscount());
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
}
