package hexlet.code.abstracts;

import hexlet.code.core.dal.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseRepository {
    private Connection connection;

    public BaseRepository() throws SQLException {
        connection = DataSource.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }
}
