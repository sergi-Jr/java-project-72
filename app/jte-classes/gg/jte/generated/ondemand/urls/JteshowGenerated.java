package gg.jte.generated.ondemand.urls;
import hexlet.code.core.dto.UrlPage;
import hexlet.code.core.utils.NamedRoutes;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,8,8,11,11,13,13,13,23,23,23,24,24,24,32,32,32,32,32,32,32,32,32,34,34,34,34,34,34,34,34,34,53,53,55,55,55,56,56,56,57,57,57,58,58,58,59,59,59,60,60,60,62,62,66,66,66,66,66,5,6,6,6,6};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page, DateTimeFormatter formatter) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div>\n        <h1 class=\"display-4\">Сайт: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getName());
				jteOutput.writeContent("</h1>\n        <table class=\"table\">\n            <thead>\n            <tr>\n                <th scope=\"col\">ID</th>\n                <th scope=\"col\">Имя</th>\n            </tr>\n            </thead>\n            <tbody>\n            <tr>\n                <th scope=\"row\">");
				jteOutput.setContext("th", null);
				jteOutput.writeUserContent(page.getId());
				jteOutput.writeContent("</th>\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getName());
				jteOutput.writeContent("</td>\n            </tr>\n            </tbody>\n        </table>\n    </div>\n    <div>\n        <h2 class=\"display-6\">Проверки</h2>\n        <div>\n            <form");
				var __jte_html_attribute_0 = NamedRoutes.urlCheckPath(page.getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n                <div>\n                    <input type=\"text\" name=\"url\"");
				var __jte_html_attribute_1 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" hidden=\"hidden\">\n                </div>\n                <div class=\"col-auto\">\n                    <button type=\"submit\" class=\"btn btn-primary\">Начать проверку</button>\n                </div>\n            </form>\n        </div>\n        <table class=\"table table-striped\">\n            <thead>\n            <tr>\n                <th scope=\"col\">ID</th>\n                <th scope=\"col\">Код ответа</th>\n                <th scope=\"col\">Title</th>\n                <th scope=\"col\">H1</th>\n                <th scope=\"col\">Description</th>\n                <th scope=\"col\">Дата проверки</th>\n            </tr>\n            </thead>\n            <tbody>\n            ");
				for (var check : page.getChecks()) {
					jteOutput.writeContent("\n                <tr>\n                    <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(check.getId());
					jteOutput.writeContent("</th>\n                    <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(check.getStatusCode());
					jteOutput.writeContent("</th>\n                    <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(check.getTitle());
					jteOutput.writeContent("</th>\n                    <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(check.getH1());
					jteOutput.writeContent("</th>\n                    <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(check.getDescription());
					jteOutput.writeContent("</th>\n                    <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(formatter.format(check.getCreatedAt().toLocalDateTime()));
					jteOutput.writeContent("</th>\n                </tr>\n            ");
				}
				jteOutput.writeContent("\n            </tbody>\n        </table>\n    </div>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		DateTimeFormatter formatter = (DateTimeFormatter)params.getOrDefault("formatter", java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		render(jteOutput, jteHtmlInterceptor, page, formatter);
	}
}
