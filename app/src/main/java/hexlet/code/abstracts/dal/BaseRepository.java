package hexlet.code.abstracts.dal;

import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.core.dal.DataSource;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Getter
public abstract class BaseRepository<T> {
    private HikariDataSource dataSource;

    protected BaseRepository() {
        dataSource = DataSource.getDataSource();
    }

    protected Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public abstract boolean save(T entity);

    public abstract Optional<T> find(Long id);

    public abstract List<T> getEntities();

    public abstract void update(T entity);

    public abstract void delete(Long id);
}
