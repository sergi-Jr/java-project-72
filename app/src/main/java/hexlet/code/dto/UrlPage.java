package hexlet.code.dto;

import hexlet.code.urlcheck.UrlCheck;
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
