package lite.med.literalura.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private String language;

    // Getters y setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

