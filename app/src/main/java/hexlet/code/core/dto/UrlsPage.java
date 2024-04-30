package hexlet.code.core.dto;

import hexlet.code.abstracts.dto.BasePage;
import hexlet.code.core.models.Url;
import hexlet.code.core.models.UrlCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.javatuples.Pair;

import java.util.List;

@Getter
@AllArgsConstructor
public class UrlsPage extends BasePage {
    private List<Pair<Url, UrlCheck>> urlTuples;
}
