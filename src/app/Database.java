package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    final String FILENAME = "inventario.db";
    final String DRIVER = "org.sqlite.JDBC";
    final String URL = "jdbc:sqlite:" + FILENAME;

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL);
            System.out.println("[OK] Connection database is succeded");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.print("[FAIL] Connection database failed " + e);
            return null;
        }
    }
}
