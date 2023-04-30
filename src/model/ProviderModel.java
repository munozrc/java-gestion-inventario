package model;

import app.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProviderModel extends Database {

    private int id;
    private String name;
    private String email;

    public ProviderModel(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public ProviderModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ProviderModel() {
    }

    public boolean addProvider(ProviderModel provider) {
        String query = "INSERT INTO providers (name, email) VALUES (?,?)";
        Connection con = this.getConnection();

        if (con == null) {
            return false;
        }

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, provider.getName());
            ps.setString(2, provider.getEmail());

            int insertedRows = ps.executeUpdate();
            boolean addedSuccessfully = insertedRows == 1;

            ps.close();
            con.close();

            return addedSuccessfully;
        } catch (SQLException e) {
            return false;
        }

    }

    public ArrayList<ProviderModel> getListOfProviders() {
        String query = "SELECT * FROM providers";
        Connection con = this.getConnection();
        ArrayList<ProviderModel> list = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProviderModel provider = new ProviderModel();
                provider.setId(Integer.parseInt(rs.getString("id")));
                provider.setName(rs.getString("name"));
                provider.setEmail(rs.getString("email"));
                list.add(provider);
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
