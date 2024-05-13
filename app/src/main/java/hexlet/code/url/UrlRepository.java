package hexlet.code.url;

import hexlet.code.dal.BaseRepository;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public final class UrlRepository extends BaseRepository {

    public static boolean save(Url entity) {
        String query = "Insert into urls (name) values (?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            prep.setString(1, entity.getName());
            prep.executeUpdate();
            ResultSet keys = prep.getGeneratedKeys();
            if (keys.next()) {
                entity.setId(keys.getLong(1));
                return true;
            } else {
                log.error("",
                        new SQLException("DB have not returned an id after save"));
            }
        } catch (SQLException exception) {
            return false;
        }
        return false;
    }

    public static Optional<Url> findById(Long id) {
        String query = "Select * from urls where id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setLong(1, id);
            ResultSet resultSet = prep.executeQuery();
            if (resultSet.next()) {
                Url entity = new Url(
                        resultSet.getString("name"),
                        resultSet.getTimestamp("created_at")
                );
                entity.setId(id);
                return Optional.of(entity);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<Url> findByName(String name) {
        String query = "Select * from urls where name = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setString(1, name.toLowerCase().trim());
            ResultSet resultSet = prep.executeQuery();
            if (resultSet.next()) {
                Url entity = new Url(
                        resultSet.getString("name"),
                        resultSet.getTimestamp("created_at")
                );
                entity.setId(resultSet.getLong("id"));
                return Optional.of(entity);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Url> getEntities() {
        String query = "Select * from urls order by id desc";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            ResultSet resultSet = prep.executeQuery();
            ArrayList<Url> list = new ArrayList<>();
            while (resultSet.next()) {
                Url entity = new Url(
                        resultSet.getString("name"),
                        resultSet.getTimestamp("created_at")
                );
                entity.setId(resultSet.getLong("id"));
                list.add(entity);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Url entity) {
        String query = "Update urls set name = ? where id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setString(1, entity.getName());
            prep.setLong(2, entity.getId());
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Long id) {
        String query = "Delete from urls where id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setLong(1, id);
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
