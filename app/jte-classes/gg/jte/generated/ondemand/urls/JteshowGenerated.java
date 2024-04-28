package gg.jte.generated.ondemand.urls;
import hexlet.code.core.dto.UrlPage;
import hexlet.code.core.utils.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,8,8,20,20,20,24,24,24,24,24,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <table class=\"table table-striped\">\n        <thead>\n        <tr>\n            <th scope=\"col\">URL</th>\n            <th scope=\"col\">Результат</th>\n            <th scope=\"col\">Код ответа</th>\n            <th scope=\"col\">Время проверки</th>\n        </tr>\n        </thead>\n        <tbody>\n        <tr>\n            <th scope=\"col\">");
				jteOutput.setContext("th", null);
				jteOutput.writeUserContent(page.getName());
				jteOutput.writeContent("</th>\n        </tr>\n        </tbody>\n    </table>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
