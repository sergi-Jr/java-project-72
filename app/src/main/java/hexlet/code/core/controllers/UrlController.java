package hexlet.code.core.controllers;

import hexlet.code.abstracts.dto.BasePage;
import hexlet.code.core.dal.UrlRepository;
import hexlet.code.core.dto.BuildUrlPage;
import hexlet.code.core.dto.UrlsPage;
import hexlet.code.core.models.Url;
import hexlet.code.core.utils.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.h2.util.json.JSONItemType;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlController {
    private static UrlRepository repo = new UrlRepository();

    public static void main(Context context) {
        context.render("main.jte", model("page", new BuildUrlPage()));
    }

    public static void create(Context context) {
        try {
            String name = context.formParamAsClass("url", String.class).get();

            URL url = URI.create(name).toURL();
            String urlString = buildUrlString(url);

            Calendar calendar = Calendar.getInstance();
            Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

            Url entity = new Url(urlString, timestamp);
            if (repo.save(entity)) {
                setFlashesInContext(context, "Страница успешно добавлена", "success");
                context.redirect(NamedRoutes.urlsPath());
            } else {
                setFlashesInContext(context, "Страница уже существует", "danger");
                BuildUrlPage page = new BuildUrlPage(name);
                setFlashesInPage(context, page);
                context.render("main.jte", model("page", page));
            }
        } catch (MalformedURLException | IllegalArgumentException exception) {
            String name = context.formParam("url");
            BuildUrlPage page = new BuildUrlPage(name);
            setFlashesInContext(context, "Некорректный URL", "danger");
            setFlashesInPage(context, page);
            context.render("main.jte", model("page", page));
        }
    }

    private static void setFlashesInContext(Context ctx, String msg, String type) {
        ctx.sessionAttribute("flash", msg);
        ctx.sessionAttribute("flashType", type);
    }

    private static void setFlashesInPage(Context ctx, BasePage page) {
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flashType"));
    }

    private static String buildUrlString(URL input) {
        String urlNoPort = String.format("%s://%s", input.getProtocol(), input.getHost());
        int port = input.getPort();
        return port == -1 ?
                urlNoPort :
                String.format("%s:%d", urlNoPort, port);
    }

    public static void index(Context context) {
        List<Url> urls = repo.getEntities();
        UrlsPage page = new UrlsPage(urls);
        setFlashesInPage(context, page);
        context.render("urls/index.jte", model("page", page));
    }

    public static void show(Context context) {
    }
}
