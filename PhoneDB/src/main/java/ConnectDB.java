import java.sql.*;

public class ConnectDB {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest"+
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";
    private static final String NAME = "root";
    private static final String PAS = "root";
    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL, NAME, PAS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void startDriver () throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public Connection getConnection() {
        return connection;
    }
}
