package Videos.DB;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements GenConnection {
    String url = "jdbc:mysql://localhost:3306/videosProject";
    String user = "akira";
    String password = "12345678";

    private static DBConnection instancia;

    public static DBConnection getInstancia() {
        if (instancia == null)
            instancia = new DBConnection();
        return instancia;
    }

    @Override
    public java.sql.Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void disconnect(java.sql.Connection connection) throws SQLException {
        connection.close();
    }
}
