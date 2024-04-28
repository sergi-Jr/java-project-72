package gg.jte.generated.ondemand.urls;
import hexlet.code.core.dto.UrlsPage;
import hexlet.code.core.utils.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,8,8,19,19,21,21,21,22,22,22,22,22,22,22,22,22,22,22,22,26,26,29,29,29,29,29,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <table class=\"table table-striped\">\n        <thead>\n        <tr>\n            <th scope=\"col\">#</th>\n            <th scope=\"col\">URL</th>\n            <th scope=\"col\">Последний результат</th>\n            <th scope=\"col\">Код ответа</th>\n        </tr>\n        </thead>\n        <tbody>\n        ");
				for (var p : page.getUrls()) {
					jteOutput.writeContent("\n            <tr>\n                <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(p.getId());
					jteOutput.writeContent("</td>\n                <td><a");
					var __jte_html_attribute_0 = NamedRoutes.urlPath(p.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent("> ");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(p.getName());
					jteOutput.writeContent("</a></td>\n                <td></td>\n                <td></td>\n            </tr>\n        ");
				}
				jteOutput.writeContent("\n        </tbody>\n    </table>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
