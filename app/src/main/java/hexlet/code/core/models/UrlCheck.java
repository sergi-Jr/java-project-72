package hexlet.code.core.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@Getter
public class UrlCheck {
    @Setter
    private Long id;
    private int statusCode;
    private String title;
    private String h1;
    private String description;
    @Setter
    private Long urlId;
    private Timestamp createdAt;


    public UrlCheck(int statusCode, String title, String h1, String description) {
        this.statusCode = statusCode;
        this.title = title;
        this.h1 = h1;
        this.description = description;
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    public UrlCheck(int statusCode, String title, String h1, String description, Timestamp created) {
        this.statusCode = statusCode;
        this.title = title;
        this.h1 = h1;
        this.description = description;
        createdAt = created;
    }
}
