package hexlet.code.core.dto;

import hexlet.code.abstracts.dto.BasePage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class BuildUrlPage extends BasePage {
    private String name;
}
