package lite.med.literalura.menu;


import lite.med.literalura.model.Author;
import lite.med.literalura.model.Book;
import lite.med.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.List;


@Component
public class ConsoleMenu implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.println("Ingrese el título del libro:");
                    String title = scanner.nextLine();
                    List<Book> booksByTitle = bookService.findBooksByTitle(title);
                    booksByTitle.forEach(book -> System.out.println(book.getTitle() + " por " + book.getAuthors().stream().map(Author::getName).toList()));
                    break;
                case 2:
                    List<Book> allBooks = bookService.listAllBooks();
                    allBooks.forEach(book -> System.out.println(book.getTitle() + " por " + book.getAuthors().stream().map(Author::getName).toList()));
                    break;
                case 3:
                    List<Author> allAuthors = bookService.listAllAuthors();
                    allAuthors.forEach(author -> System.out.println(author.getName()));
                    break;
                case 4:
                    System.out.println("Ingrese el año:");
                    int year = scanner.nextInt();
                    List<Author> authorsAliveInYear = bookService.listAuthorsAliveInYear(year);
                    authorsAliveInYear.forEach(author -> System.out.println(author.getName()));
                    break;
                case 5:
                    System.out.println("Ingrese el idioma (ej. 'en' para inglés):");
                    String language = scanner.nextLine();
                    List<Book> booksByLanguage = bookService.findBooksByLanguage(language);
                    booksByLanguage.forEach(book -> System.out.println(book.getTitle() + " por " + book.getAuthors().stream().map(Author::getName).toList()));
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
        }
    }

    private void printMenu() {
        System.out.println("Opciones del programa:");
        System.out.println("1. Buscar libro por título");
        System.out.println("2. Listar libros registrados");
        System.out.println("3. Listar autores registrados");
        System.out.println("4. Listar autores vivos en un determinado año");
        System.out.println("5. Listar libros por idioma");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
