package lite.med.literalura.service;


import lite.med.literalura.model.Book;
import lite.med.literalura.model.Author;
import lite.med.literalura.util.GutendexClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class BookService {

        @Autowired
        private GutendexClient gutendexClient;

        public List<Book> findBooksByTitle(String title) {
            return gutendexClient.getBooksByTitle(title);
        }

        public List<Book> listAllBooks() {
            return gutendexClient.getAllBooks();
        }

        public List<Author> listAllAuthors() {
            return gutendexClient.getAllAuthors();
        }

        public List<Author> listAuthorsAliveInYear(int year) {
            return gutendexClient.getAuthorsAliveInYear(year);
        }

        public List<Book> findBooksByLanguage(String language) {
            return gutendexClient.getBooksByLanguage(language);
        }
    }


