package lite.med.literalura.controller;

import lite.med.literalura.model.Author;
import lite.med.literalura.model.Book;
import lite.med.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    public class BookController {

        @Autowired
        private BookService bookService;

        @GetMapping("/books/title/{title}")
        public List<Book> getBooksByTitle(@PathVariable String title) {
            return bookService.findBooksByTitle(title);
        }

        @GetMapping("/books")
        public List<Book> listAllBooks() {
            return bookService.listAllBooks();
        }

        @GetMapping("/authors")
        public List<Author> listAllAuthors() {
            return bookService.listAllAuthors();
        }

        @GetMapping("/authors/alive")
        public List<Author> listAuthorsAliveInYear(@RequestParam int year) {
            return bookService.listAuthorsAliveInYear(year);
        }

        @GetMapping("/books/language/{language}")
        public List<Book> getBooksByLanguage(@PathVariable String language) {
            return bookService.findBooksByLanguage(language);
        }
    }


