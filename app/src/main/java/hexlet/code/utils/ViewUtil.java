package hexlet.code.utils;

import hexlet.code.dto.BasePage;
import io.javalin.http.Context;

public class ViewUtil {
    public static void setFlashes(BasePage page, Context ctx, String msg, String type) {
        setFlashesInContext(ctx, msg, type);
        setFlashesInPage(ctx, page);
    }

    public static void setFlashesInContext(Context ctx, String msg, String type) {
        ctx.sessionAttribute("flash", msg);
        ctx.sessionAttribute("flashType", type);
    }

    public static void setFlashesInPage(Context ctx, BasePage page) {
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flashType"));
    }
}
