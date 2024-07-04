# literalura
catalogo de libros (gutendex api)
Al iniciar la aplicación, verás el siguiente menú en la consola:  

Opciones del programa:  

1. Buscar libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año
5. Listar libros por idioma
6. Salir
Seleccione una opción:


Selecciona una opción ingresando el número correspondiente y sigue las instrucciones en pantalla.  

Además del menú de consola, la aplicación expone varios endpoints REST:  


Buscar libro por título  

GET /books/title/{title}  

Ejemplo:  

GET /books/title/Moby Dick

Listar todos los libros  

GET /books  


Listar todos los autores  

GET /authors  


Listar autores vivos en un determinado año  

GET /authors/alive?year={year}  

Ejemplo:  

GET /authors/alive?year=1900  


Listar libros por idioma  

GET /books/language/{language}  

Ejemplo:  

GET /books/language/en  


Estructura del Proyecto  

El proyecto está organizado de la siguiente manera:  

src/main/java/lite/med/literalura/  

    LiteraluraApplication.java
    controller/
        BookController.java
    service/
        BookService.java
    model/
        Book.java
        Author.java
        GutendexResponse.java
    util/
        GutendexClient.java
    menu/
        ConsoleMenu.java  
        

Descripción de Clases  

LiteraluraApplication: Clase principal para iniciar la aplicación Spring Boot.  

BookController:  
Controlador REST que maneja las solicitudes HTTP.  

BookService:  
Servicio que contiene la lógica de negocio.  

GutendexClient:  
Cliente que se comunica con la API de Gutendex.  

Book:  
Modelo que representa un libro.  

Author:  
Modelo que representa un autor.  

GutendexResponse:  
Modelo para mapear la respuesta de la API de Gutendex.  

ConsoleMenu:  
Clase que imprime el menú en consola y maneja la interacción del usuario.        

