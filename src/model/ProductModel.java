package model;

import app.Database;
import app.Observable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductModel extends Observable {

    private int id;
    private String name;
    private String barcode;
    private float price;
    private int supplier;

    public ProductModel() {
        super();
    }

    public boolean save(int quantity) {
        String queryProduct = "INSERT INTO products (name, barcode, price, supplier) VALUES (?,?,?,?)";
        String queryStock = "INSERT INTO stock (product, quantity) VALUES (?,?)";
        Connection con = Database.getConnection();

        if (con == null) {
            return false;
        }

        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            return false;
        }

        try {
            boolean addedProduct;
            int productID = 0;

            try (PreparedStatement pstmtProduct = con.prepareStatement(queryProduct)) {
                pstmtProduct.setString(1, this.getName());
                pstmtProduct.setString(2, this.getBarcode());
                pstmtProduct.setFloat(3, this.getPrice());
                pstmtProduct.setInt(4, this.getSupplier());

                int insertedRowsProduct = pstmtProduct.executeUpdate();
                addedProduct = insertedRowsProduct == 1;

                try (ResultSet generatedKeys = pstmtProduct.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        productID = generatedKeys.getInt(1);
                    }
                    generatedKeys.close();
                }
            }

            boolean addedStock;

            try (PreparedStatement pstmtStock = con.prepareStatement(queryStock)) {
                pstmtStock.setInt(1, productID);
                pstmtStock.setInt(2, quantity);
                int insertedRowsStock = pstmtStock.executeUpdate();
                addedStock = insertedRowsStock == 1;
            }

            con.commit();
            return addedProduct && addedStock;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e2) {
            }
            return false;
        } finally {
            try {
                con.setAutoCommit(true);
                con.close();
                this.notifyObservers();
            } catch (SQLException e) {
            }
        }
    }

    public boolean delete() {
        String query = "DELETE FROM products WHERE id = ?";
        Connection con = Database.getConnection();

        if (con == null) {
            return false;
        }

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, this.getId());
            int deletedRows = pstmt.executeUpdate();
            boolean deletedProduct = deletedRows == 1;

            pstmt.close();
            con.close();
            notifyObservers();

            return deletedProduct;
        } catch (Exception e) {
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
