package model;

import app.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
