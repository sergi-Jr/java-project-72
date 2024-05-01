package hexlet.code.abstracts.dal;

import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.core.dal.DataSource;
import lombok.Getter;

@Getter
public class BaseRepository {
    protected static HikariDataSource dataSource = DataSource.getDataSource();
}
