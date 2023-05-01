package model;

import app.Database;
import app.Observable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierModel extends Observable {

    private int id;
    private String name;
    private String email;

    public SupplierModel(int id, String name, String email) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public SupplierModel() {
        super();
    }

    public boolean addProvider() {
        String query = "INSERT INTO suppliers (name, email) VALUES (?,?)";
        Connection con = Database.getConnection();

        if (con == null) {
            return false;
        }

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, this.getName());
            ps.setString(2, this.getEmail());

            int insertedRows = ps.executeUpdate();
            boolean addedSuccessfully = insertedRows == 1;

            ps.close();
            con.close();

            return addedSuccessfully;
        } catch (SQLException e) {
            return false;
        }

    }

    public ArrayList<SupplierModel> getListOfProviders() {
        String query = "SELECT * FROM suppliers";
        Connection con = Database.getConnection();
        ArrayList<SupplierModel> list = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SupplierModel supplier = new SupplierModel();

                supplier.setId(Integer.parseInt(rs.getString("id")));
                supplier.setName(rs.getString("name"));
                supplier.setEmail(rs.getString("email"));

                list.add(supplier);
            }

            return list;
        } catch (SQLException e) {
            return list;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
