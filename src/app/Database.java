package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    static final String FILENAME = "inventario.db";

    public static Connection getConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:" + FILENAME);
            System.out.println("[OK] Connection database is succeded");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.print("[FAIL] Connection database failed " + e);
            return null;
        }

    }
}
