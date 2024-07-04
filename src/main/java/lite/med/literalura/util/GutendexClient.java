package lite.med.literalura.util;

import lite.med.literalura.model.Book;
import lite.med.literalura.model.GutendexResponse;
import lite.med.literalura.model.Author;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GutendexClient {

    private static final String BASE_URL = "https://gutendex.com/books";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Book> getAllBooks() {
        String url = BASE_URL;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        return response != null ? response.getResults() : List.of();
    }

    public List<Book> getBooksByTitle(String title) {
        String url = BASE_URL + "?search=" + title;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        return response != null ? response.getResults() : List.of();
    }

    public List<Book> getBooksByLanguage(String language) {
        String url = BASE_URL + "?languages=" + language;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        return response != null ? response.getResults() : List.of();
    }

    public List<Author> getAllAuthors() {
        String url = BASE_URL + "?authors";
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        return response != null ? response.getResults().stream().map(Book::getAuthors).flatMap(List::stream).distinct().toList() : List.of();
    }

    public List<Author> getAuthorsAliveInYear(int year) {
        // Aquí asumimos que los autores vivos en el año especificado son aquellos cuyo birthYear <= year y (deathYear == null o deathYear > year)
        return getAllAuthors().stream()
                .filter(author -> author.getBirthYear() != null && author.getBirthYear() <= year
                        && (author.getDeathYear() == null || author.getDeathYear() > year))
                .toList();
    }
}
