package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.SQLiteConfig;

public class Database {

    public static final String FILENAME = "inventario.db";
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:" + FILENAME;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);

            // It appears that SQLite does not enforce foreign keys by default.
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);

            Connection con = DriverManager.getConnection(URL, config.toProperties());
            System.out.println("[OK] Connection database is succeded");

            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.print("[FAIL] Connection database failed " + e);
            return null;
        }
    }
}
