package hexlet.code.core.dal;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class DataSource {
    @Getter
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        String jdbcUrl = System.getenv().getOrDefault("JDBC_DATABASE_URL",
                "jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;");
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(System.getenv("USERNAME"));
        config.setPassword(System.getenv("PASSWORD"));

        dataSource = new HikariDataSource(config);

        try (Connection conn = getConnection();
             InputStream stream = DataSource.class.getResourceAsStream("/init.sql");
             BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }

            String query = builder.toString();
            PreparedStatement prep = conn.prepareStatement(query);
            prep.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
