package hexlet.code.core.dto;

import hexlet.code.abstracts.dto.BasePage;
import hexlet.code.core.models.Url;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UrlsPage extends BasePage {
    private List<Url> urls;
}
