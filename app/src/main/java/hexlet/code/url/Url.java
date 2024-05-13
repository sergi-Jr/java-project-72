package hexlet.code.url;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
public final class Url {
    @Setter
    private Long id;

    private String name;
    private Timestamp createdAt;

    public Url(String nameValue) {
        name = nameValue;
    }

    public Url(String nameValue, Timestamp created) {
        name = nameValue;
        createdAt = created;
    }
}
