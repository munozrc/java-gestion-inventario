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
    private float productPrice;
    private int productQuantity;

    public ArrayList<StockModel> getAllProductsByName() {
        ArrayList<StockModel> list = new ArrayList<>();
        String query = "SELECT products.*, stock.quantity FROM products JOIN stock ON products.id = stock.product WHERE products.name LIKE '%" + this.getProductName() + "%'";
        Connection con = Database.getConnection();

        if (this.getProductName().trim().equals("")) {
            query = "SELECT products.*, stock.quantity FROM products JOIN stock ON products.id = stock.product";
        }

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StockModel product = new StockModel();

                product.setProductID(Integer.parseInt(rs.getString("id")));
                product.setProductName(rs.getString("name"));
                product.setProductPrice(Float.parseFloat(rs.getString("price")));
                product.setProductQuantity(Integer.parseInt(rs.getString("quantity")));

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

}
