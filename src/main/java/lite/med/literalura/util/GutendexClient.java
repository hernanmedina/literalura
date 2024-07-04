package lite.med.literalura.util;

import lite.med.literalura.model.Book;
import lite.med.literalura.model.Author;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GutendexClient {

    private static final String BASE_URL = "https://gutendex.com/books";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Book> getBooksByTitle(String title) {
        String url = BASE_URL + "?search=" + title;
        // Lógica para consumir la API y mapear los resultados a la lista de libros
        return restTemplate.getForObject(url, List.class);
    }

    public List<Book> getAllBooks() {
        String url = BASE_URL;
        // Lógica para consumir la API y mapear los resultados a la lista de libros
        return restTemplate.getForObject(url, List.class);
    }

    public List<Author> getAllAuthors() {
        String url = BASE_URL + "?authors";
        // Lógica para consumir la API y mapear los resultados a la lista de autores
        return restTemplate.getForObject(url, List.class);
    }

    public List<Author> getAuthorsAliveInYear(int year) {
        String url = BASE_URL + "?birthdate=" + year;
        // Lógica para consumir la API y mapear los resultados a la lista de autores vivos en el año especificado
        return restTemplate.getForObject(url, List.class);
    }

    public List<Book> getBooksByLanguage(String language) {
        String url = BASE_URL + "?languages=" + language;
        // Lógica para consumir la API y mapear los resultados a la lista de libros por idioma
        return restTemplate.getForObject(url, List.class);
    }
}
