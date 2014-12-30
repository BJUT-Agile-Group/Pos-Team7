package info;

/**
 * Created by joe on 14/12/30.
 */
public class Info {
    private String barcode;
    private String name;
    private String unit;
    private String price;
    private int num;
    public Info(){

    }
    public Info(String[] a){
        setBarcode(a[0]);
        setName(a[1]);
        setUnit(a[2]);
        setPrice(a[3]);
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public float getTotal(){
        return num *Float.parseFloat(price);
    }
}
