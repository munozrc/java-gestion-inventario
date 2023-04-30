package model;

import app.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProviderRepository {

    public boolean addProvider(Provider provider) {
        String query = "INSERT INTO providers (name, email) VALUES (?,?)";
        Connection con = Database.getConnection();

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

    public ArrayList<Provider> getListOfProviders() {
        String query = "SELECT * FROM providers";
        Connection con = Database.getConnection();
        ArrayList<Provider> list = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
//            list.add(new Provider(0, "Selecciona", ""));

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String email = rs.getString("email");
                list.add(new Provider(id, name, email));
            }

            return list;
        } catch (SQLException e) {
            return list;
        }
    }

}
