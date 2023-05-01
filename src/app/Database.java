package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static final String FILENAME = "inventario.db";
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:" + FILENAME;

    public static Connection getConnection() {
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
