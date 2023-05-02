package model;

import app.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockModel {

    private int productID;
    private String productName;
    private String productBarcode;
    private float productPrice;
    private int productQuantity;
    private int productSupplier;

    public ArrayList<StockModel> getProductsByName(String name) {
        ArrayList<StockModel> list = new ArrayList<>();
        String query = "SELECT products.*, stock.quantity FROM products JOIN stock ON products.id = stock.product WHERE products.name LIKE '%" + name + "%' LIMIT 8";
        Connection con = Database.getConnection();

        if (name.trim().equals("")) {
            query = "SELECT products.*, stock.quantity FROM products JOIN stock ON products.id = stock.product LIMIT 8";
        }

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StockModel product = new StockModel();

                product.setProductID(Integer.parseInt(rs.getString("id")));
                product.setProductName(rs.getString("name"));
                product.setProductBarcode("barcode");
                product.setProductPrice(Float.parseFloat(rs.getString("price")));
                product.setProductQuantity(Integer.parseInt(rs.getString("quantity")));
                product.setProductSupplier(Integer.parseInt(rs.getString("supplier")));

                list.add(product);
            }

            return list;
        } catch (SQLException e) {
            return list;
        }
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductSupplier() {
        return productSupplier;
    }

    public void setProductSupplier(int productSupplier) {
        this.productSupplier = productSupplier;
    }

}
