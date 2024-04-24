package hexlet.code;

import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public final class App {

    public static void main(String[] args) {
        Javalin app = getApp();

        app.start(getPort());
    }

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }

    public static Javalin getApp() {
        Javalin app = Javalin.create(cfg -> {
            cfg.bundledPlugins.enableDevLogging();
        });

        app.get("/", ctx -> ctx.result("Hello"));

        return app;
    }
}
