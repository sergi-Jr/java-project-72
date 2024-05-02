package hexlet.code.core.dal;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

public final class DataSource {
    @Getter
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        String jdbcUrl = System.getenv().getOrDefault("JDBC_DATABASE_URL",
                "jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:/init.sql'");
        config.setJdbcUrl(jdbcUrl);

        dataSource = new HikariDataSource(config);
    }


    private DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
