package model;

import app.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductModel extends Database {

    private int id;
    private String name;
    private String barcode;
    private float price;
    private int supplier;

    public ProductModel(int id, String name, String barcode, float price, int supplier) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.supplier = supplier;
    }

    public ProductModel() {
    }

    public boolean addProduct() {
        String query = "INSERT INTO products (name, barcode, price, supplier) VALUES (?,?,?,?)";
        Connection con = this.getConnection();

        if (con == null) {
            return false;
        }

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, this.getName());
            ps.setString(2, this.getBarcode());
            ps.setFloat(3, this.getPrice());
            ps.setInt(4, this.getSupplier());

            int insertedRows = ps.executeUpdate();
            boolean addedSuccessfully = insertedRows == 1;

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    this.setId(generatedKeys.getInt(1));
                }
                generatedKeys.close();
            }

            ps.close();

            return addedSuccessfully;
        } catch (SQLException e) {
            return false;
        }
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

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }
}
