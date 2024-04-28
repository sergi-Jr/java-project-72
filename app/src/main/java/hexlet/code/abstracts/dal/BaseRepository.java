package hexlet.code.abstracts.dal;

import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.core.dal.DataSource;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

@Getter
public class BaseRepository {
    private static HikariDataSource dataSource;

    static  {
        dataSource = DataSource.getDataSource();
    }

    protected static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
