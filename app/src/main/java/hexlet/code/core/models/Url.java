package hexlet.code.core.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
public final class Url {
    @Setter
    private Long id;

    private String name;
    private Timestamp createdAt;

    public Url(String nameValue, Timestamp createdAtValue) {
        name = nameValue;
        createdAt = createdAtValue;
    }
}
