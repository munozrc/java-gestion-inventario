package model;

public class Stock {

    private final int productID;
    private final String productName;
    private final float productPrice;
    private final int productStock;

    private final int providerID;
    private final String providerName;
    private final String providerAddress;

    public Stock(
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
        this.productStock = productStock;
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerAddress = providerAddress;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public int getProviderID() {
        return providerID;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

}
