package hexlet.code.core.dto;

import hexlet.code.abstracts.dto.BasePage;
import hexlet.code.core.models.UrlCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UrlPage extends BasePage {
    private Long id;
    private String name;
    private List<UrlCheck> checks;
}
