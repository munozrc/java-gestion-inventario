package model;

import app.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductModel extends Database {

    private int id;
    private String name;
    private String barcode;
    private float price;
    private int stock;
    private int provider;

    public ProductModel(int id, String name, String barcode, float price, int stock, int provider) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.stock = stock;
        this.provider = provider;
    }

    public ProductModel(String name, String barcode, float price, int stock, int provider) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.stock = stock;
        this.provider = provider;
    }

    public ProductModel() {
    }

    public boolean addProduct(ProductModel product) {
        String query = "INSERT INTO products (name, barcode, price, stock) VALUES (?,?,?,?)";
        Connection con = this.getConnection();

        if (con == null) {
            return false;
        }

        // TODO: Add column for provider in products table
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getBarcode());
            ps.setFloat(3, product.getPrice());
            ps.setInt(4, product.getStock());

            int insertedRows = ps.executeUpdate();
            boolean addedSuccessfully = insertedRows == 1;

            ps.close();
            con.close();

            return addedSuccessfully;
        } catch (SQLException e) {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getProvider() {
        return provider;
    }

}
