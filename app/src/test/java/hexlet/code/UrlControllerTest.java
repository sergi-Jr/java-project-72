package hexlet.code;

import hexlet.code.core.dal.UrlRepository;
import hexlet.code.core.models.Url;
import hexlet.code.core.utils.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;

class UrlControllerTest {
    Javalin app;
    static MockWebServer mockWebServer;
    final String correctTestUrl1 = "https://metanit.com";
    final String correctTestUrl2 = "https://123.org";
    final String correctTestUrl3 = "https://google.com";
    final String invalidUrl = "ht:/hexlet.test";
    static String fixturePath = "src/test/resources/test.html";
    static String testBody;

    @BeforeAll
    public static void setUpMock() throws IOException {
        mockWebServer = new MockWebServer();
        testBody = Files.readString(Paths.get(fixturePath).toAbsolutePath().normalize());
    }

    @AfterAll
    public static void shutdownMock() throws IOException {
        mockWebServer.shutdown();
    }

    @BeforeEach
    public final void setUp() {
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
            try (var response = client.post(NamedRoutes.urlsPath(), "url=" + correctTestUrl1)) {
                var body = response.body().string();
                Assertions.assertEquals(200, response.code());
                Assertions.assertTrue(body.contains(correctTestUrl1));
            }
        });
    }

    @Test
    void testCreateUrlAlreadyExists() {
        JavalinTest.test(app, (server, client) -> {
            try (var response = client.post(NamedRoutes.urlsPath(), "url=" + correctTestUrl1);
                 var same = client.post(NamedRoutes.urlsPath(), "url=" + correctTestUrl1)) {
                var body = same.body().string();
                Assertions.assertEquals(200, same.code());
                Assertions.assertTrue(body.contains("Страница уже существует"));
            }
        });
    }

    @Test
    void testCreateUrlInvalidUrl() {
        JavalinTest.test(app, (server, client) -> {
            try (var response = client.post(NamedRoutes.urlsPath(), "url=" + invalidUrl)) {
                var body = response.body().string();
                Assertions.assertEquals(200, response.code());
                Assertions.assertTrue(body.contains("Некорректный URL"));
            }
        });
    }

    @Test
    void testShowUrlsListWithData() {
        JavalinTest.test(app, (server, client) -> {
            UrlRepository.save(new Url(correctTestUrl1));
            UrlRepository.save(new Url(correctTestUrl2));
            UrlRepository.save(new Url(correctTestUrl3));

            var response = client.get(NamedRoutes.urlsPath());
            var body = response.body().string();
            Assertions.assertEquals(200, response.code());
            Assertions.assertTrue(body.contains(correctTestUrl1));
            Assertions.assertTrue(body.contains(correctTestUrl2));
            Assertions.assertTrue(body.contains(correctTestUrl3));
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
    void testShowUrl() {
        JavalinTest.test(app, (server, client) -> {
            var entity = new Url(correctTestUrl1);
            UrlRepository.save(entity);
            var response = client.get(NamedRoutes.urlPath(entity.getId()));
            var body = response.body().string();
            Assertions.assertEquals(200, response.code());
            Assertions.assertTrue(body.contains(correctTestUrl1));
        });
    }

    @Test
    void testShowUrlNotFound() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.urlPath("42"));
            Assertions.assertEquals(404, response.code());
        });
    }

    @Test
    void testCheckUrlSuccess() throws IOException {
        MockResponse response = new MockResponse()
                .setResponseCode(302)
                .setBody(testBody);
        mockWebServer.enqueue(response);
        mockWebServer.start();
        JavalinTest.test(app, ((server, client) -> {
            var entity = new Url(mockWebServer.url("/").toString(), new Timestamp(System.currentTimeMillis()));
            UrlRepository.save(entity);
            try (var req = client.post(NamedRoutes.urlCheckPath(entity.getId()), "url=" + entity.getName())) {
                var body = req.body().string();
                Assertions.assertTrue(body.contains("test"));
                Assertions.assertTrue(body.contains("302"));
            }
        }));
    }

    @Test
    void testCheckUrlFailure() throws IOException {
        MockResponse response = new MockResponse()
                .setResponseCode(500)
                .setBody(testBody);
        mockWebServer.enqueue(response);
        JavalinTest.test(app, ((server, client) -> {
            var entity = new Url(mockWebServer.url("/").toString(), new Timestamp(System.currentTimeMillis()));
            UrlRepository.save(entity);
            try (var req = client.post(NamedRoutes.urlCheckPath(entity.getId()), "url=" + entity.getName())) {
                var resp = client.get(NamedRoutes.urlPath(entity.getId()));
                var body = resp.body().string();
                Assertions.assertTrue(body.contains("test"));
                Assertions.assertTrue(body.contains("500"));
            }
        }));
    }
}
