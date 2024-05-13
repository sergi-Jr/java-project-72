package hexlet.code.core.dto;

import hexlet.code.abstracts.dto.BasePage;
import hexlet.code.core.models.Url;
import hexlet.code.core.models.UrlCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class UrlsPage extends BasePage {
    private List<Url> urls;
    private Map<Long, UrlCheck> latestChecks;
}
