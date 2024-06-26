package hexlet.code;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import hexlet.code.dal.BaseRepository;
import hexlet.code.url.UrlController;
import hexlet.code.dal.DataSource;
import hexlet.code.utils.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public final class App {

    public static void main(String[] args) {
        Javalin app = getApp();

        app.start(getPort());
    }

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.parseInt(port);
    }

    public static Javalin getApp() {
        Javalin app = Javalin.create(cfg -> {
            cfg.fileRenderer(new JavalinJte(createTemplateEngine()));
            cfg.bundledPlugins.enableDevLogging();
        });

        BaseRepository.dataSource = DataSource.getDataSource();

        app.get(NamedRoutes.rootPath(), UrlController::start);

        app.get(NamedRoutes.urlsPath(), UrlController::index);
        app.post(NamedRoutes.urlsPath(), UrlController::create);

        app.get(NamedRoutes.urlPath("{id}"), UrlController::show);
        app.post(NamedRoutes.urlCheckPath("{id}"), UrlController::check);
        return app;
    }

    private static TemplateEngine createTemplateEngine() {
        ClassLoader loader = App.class.getClassLoader();
        ResourceCodeResolver resolver = new ResourceCodeResolver("templates", loader);
        return TemplateEngine.create(resolver, ContentType.Html);
    }
}
