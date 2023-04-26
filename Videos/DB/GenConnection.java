package Videos.DB;

import java.sql.Connection;
import java.sql.SQLException;

public interface GenConnection {
    public Connection connection() throws SQLException, ClassNotFoundException;

    public void disconnect(Connection connection) throws SQLException;
}
