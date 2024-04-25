package hexlet.code.core.dal;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.h2.util.StringUtils;

import java.sql.Connection;
import java.sql.SQLException;

public final class DataSource {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    static {
        String jdbcUrl = System.getenv("JDBC_DATABASE_URL");
        if (!StringUtils.isNullOrEmpty(jdbcUrl)) {
            config.setJdbcUrl(jdbcUrl);
        } else {
            config.setJdbcUrl("jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:/init.sql'");
        }

        dataSource = new HikariDataSource(config);
    }


    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
