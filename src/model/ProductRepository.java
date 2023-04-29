package model;

import app.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepository {

    public boolean addProduct(Product product) {

        String query = "INSERT INTO products (name, barcode, price, stock) VALUES (?,?,?,?)";
        Connection con = Database.getConnection();

        if (con == null) {
            return false;
        }

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
}
