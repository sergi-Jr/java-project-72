package hexlet.code.urlcheck;

import hexlet.code.dal.BaseRepository;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class UrlCheckRepository extends BaseRepository {
    public static boolean save(UrlCheck entity) {
        String query = "Insert into url_checks "
                + "(title, url_id, status_code, h1, description, created_at) values (?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            prep.setString(1, entity.getTitle());
            prep.setLong(2, entity.getUrlId());
            prep.setInt(3, entity.getStatusCode());
            prep.setString(4, entity.getH1());
            prep.setString(5, entity.getDescription());
            prep.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            prep.executeUpdate();
            ResultSet keys = prep.getGeneratedKeys();
            if (keys.next()) {
                entity.setId(keys.getLong(1));
                return true;
            } else {
                log.error("",
                        new SQLException("DB have not returned an id after save"));
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    public static Optional<UrlCheck> find(Long id) {
        String query = "Select * from url_checks where id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setLong(1, id);
            ResultSet resultSet = prep.executeQuery();
            if (resultSet.next()) {
                UrlCheck check = new UrlCheck(
                        resultSet.getInt("status_code"),
                        resultSet.getString("title"),
                        resultSet.getString("h1"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("created_at")
                );
                check.setId(resultSet.getLong("id"));
                check.setUrlId(id);
                return Optional.of(check);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<Long, UrlCheck> findLasts() {
        String query = "Select distinct on (url_id) * from url_checks order by url_id desc, id desc";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            Map<Long, UrlCheck> resultMap = new LinkedHashMap<>();
            ResultSet resultSet = prep.executeQuery();
            while (resultSet.next()) {
                UrlCheck check = new UrlCheck(
                        resultSet.getInt("status_code"),
                        resultSet.getString("title"),
                        resultSet.getString("h1"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("created_at")
                );
                check.setId(resultSet.getLong("id"));
                check.setUrlId(resultSet.getLong("url_id"));
                resultMap.put(check.getUrlId(), check);
            }
            return resultMap;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Long id) {
        String query = "Delete from url_checks where id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setLong(1, id);
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<UrlCheck> getChecks(Long id) {
        String query = "Select * from url_checks where url_id = ? order by created_at desc";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setLong(1, id);
            ResultSet set = prep.executeQuery();
            LinkedList<UrlCheck> list = new LinkedList<>();
            while (set.next()) {
                UrlCheck check = new UrlCheck(
                        set.getInt("status_code"),
                        set.getString("title"),
                        set.getString("h1"),
                        set.getString("description"),
                        set.getTimestamp("created_at")
                );
                check.setId(set.getLong("id"));
                check.setUrlId(id);
                list.add(check);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
