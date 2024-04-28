package hexlet.code;

import hexlet.code.core.dal.UrlRepository;
import hexlet.code.core.models.Url;
import hexlet.code.core.utils.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

class UrlControllerTest {
    Javalin app;

    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
    }

    @Test
    void testMainPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.rootPath());
            Assertions.assertEquals(200, response.code());
        });
    }

    @Test
    void testCreateUrlSuccess() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=https://123.org";
            var response = client.post(NamedRoutes.urlsPath(), requestBody);
            Assertions.assertEquals(200, response.code());
        });
    }

    @Test
    void testCreateUrlAlreadyExists() {
        UrlRepository.save(new Url("https://123.org", new Timestamp(Calendar.getInstance().getTimeInMillis())));
        JavalinTest.test(app, (server, client) -> {

            var requestBody = "url=https://123.org";
            var response = client.post(NamedRoutes.urlsPath(), requestBody);
            Assertions.assertEquals(200, response.code());
        });
    }

    @Test
    void testCreateUrlInvalidUrl() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=htt://12__3.org12";
            var response = client.post(NamedRoutes.urlsPath(), requestBody);
            Assertions.assertEquals(200, response.code());
        });
    }

    @Test
    void testShowUrlsListEmpty() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.urlsPath());
            Assertions.assertEquals(200, response.code());
        });
    }

    @Test
    void testShowUrlsListWithData() {
        UrlRepository.save(new Url("https://123.org", new Timestamp(Calendar.getInstance().getTimeInMillis())));
        UrlRepository.save(new Url("https://hex.org", new Timestamp(Calendar.getInstance().getTimeInMillis())));
        UrlRepository.save(new Url("https://let.org", new Timestamp(Calendar.getInstance().getTimeInMillis())));
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.urlsPath());
            Assertions.assertEquals(200, response.code());
        });
    }

    @Test
    void testShowUrl() {
        var entity = new Url("https://let.org", new Timestamp(Calendar.getInstance().getTimeInMillis()));
        UrlRepository.save(entity);
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.urlPath(entity.getId()));
            Assertions.assertEquals(200, response.code());
        });
    }

    @Test
    void testShowUrlNotFound() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.urlPath("42"));
            Assertions.assertEquals(404, response.code());
        });
    }
}
