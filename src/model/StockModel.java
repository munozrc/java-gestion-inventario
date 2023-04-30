package model;

import app.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockModel extends Database {

    private int productID;
    private String productName;
    private float productPrice;
    private int productQuantity;

    private int providerID;
    private String providerName;
    private String providerAddress;

    public StockModel(
            int productID,
            String productName,
            float productPrice,
            int productStock,
            int providerID,
            String providerName,
            String providerAddress
    ) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productStock;
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerAddress = providerAddress;
    }

    public StockModel() {
    }

    public boolean addStock() {
        String query = "INSERT INTO stock (product, quantity) VALUES (?,?)";
        Connection con = this.getConnection();

        if (con == null) {
            return false;
        }

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, this.getProductID());
            ps.setInt(2, this.getProductQuantity());

            int insertedRows = ps.executeUpdate();
            boolean addedSuccessfully = insertedRows == 1;
            ps.close();
            con.close();

            return addedSuccessfully;
        } catch (SQLException e) {
            return false;
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

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

}
