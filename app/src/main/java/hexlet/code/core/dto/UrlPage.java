package hexlet.code.core.dto;

import hexlet.code.abstracts.dto.BasePage;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UrlPage extends BasePage {
    private String name;
}
