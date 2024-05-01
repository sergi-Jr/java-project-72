package gg.jte.generated.ondemand;
import hexlet.code.core.utils.NamedRoutes;
import hexlet.code.core.dto.BuildUrlPage;
public final class JtemainGenerated {
	public static final String JTE_NAME = "main.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,8,8,9,9,9,9,9,9,9,9,9,13,13,13,13,13,13,13,13,13,22,22,22,22,22,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUrlPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <form");
				var __jte_html_attribute_0 = NamedRoutes.urlsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n        <div class=\"form-row\">\n            <div class=\"col\">\n                <label>Type some url below\n                    <input type=\"url\" class=\"form-control\" required name=\"url\"");
				var __jte_html_attribute_1 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" pattern=\"https?://(www\\.)?\\S+\\.\\S+\">\n                </label>\n                <small class=\"form-text text-muted\">Only http[s]://example.com[:port] is allowed</small>\n            </div>\n            <div class=\"col-auto\">\n                <button type=\"submit\" class=\"btn btn-primary\" name=\"inspect-btn\">Inspect</button>\n            </div>\n        </div>\n    </form>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUrlPage page = (BuildUrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
