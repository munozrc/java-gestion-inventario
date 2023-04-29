package model;

public class Product {

    private int id;
    private String name;
    private String barcode;
    private float price;
    private int stock;

    public Product(int id, String name, String barcode, float price, int stock) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, String barcode, float price, int stock) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
