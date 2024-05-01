package gg.jte.generated.ondemand.urls;
import hexlet.code.core.dto.UrlPage;
import hexlet.code.core.utils.NamedRoutes;
import java.util.Date;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,6,6,9,9,11,11,11,11,11,11,11,11,11,13,13,13,13,13,13,13,13,13,32,32,34,34,34,35,35,35,36,36,36,37,37,37,38,38,38,39,39,39,41,41,44,44,44,44,44,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div>\n        <form");
				var __jte_html_attribute_0 = NamedRoutes.urlCheckPath(page.getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n            <div>\n                <input type=\"text\" name=\"url\"");
				var __jte_html_attribute_1 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" hidden=\"hidden\">\n            </div>\n            <div class=\"col-auto\">\n                <button type=\"submit\" class=\"btn btn-primary\">Inspect</button>\n            </div>\n        </form>\n    </div>\n    <table class=\"table table-striped\">\n        <thead>\n        <tr>\n            <th scope=\"col\">ID</th>\n            <th scope=\"col\">Код ответа</th>\n            <th scope=\"col\">Title</th>\n            <th scope=\"col\">H1</th>\n            <th scope=\"col\">Description</th>\n            <th scope=\"col\">Дата проверки</th>\n        </tr>\n        </thead>\n        <tbody>\n        ");
				for (var check : page.getChecks()) {
					jteOutput.writeContent("\n            <tr>\n                <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(check.getId());
					jteOutput.writeContent("</th>\n                <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(check.getStatusCode());
					jteOutput.writeContent("</th>\n                <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(check.getTitle());
					jteOutput.writeContent("</th>\n                <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(check.getH1());
					jteOutput.writeContent("</th>\n                <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(check.getDescription());
					jteOutput.writeContent("</th>\n                <th scope=\"col\">");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(new Date(check.getCreatedAt().getTime()).toString());
					jteOutput.writeContent("</th>\n            </tr>\n        ");
				}
				jteOutput.writeContent("\n        </tbody>\n    </table>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
