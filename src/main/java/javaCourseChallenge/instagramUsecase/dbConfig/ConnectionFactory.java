package javaCourseChallenge.instagramUsecase.dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static String JDBC_DRIVER = "org.postgresql.Driver";
    private static String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    private static String jdbcUsername = "postgres";
    private static String jdbcPassword = "123456";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
