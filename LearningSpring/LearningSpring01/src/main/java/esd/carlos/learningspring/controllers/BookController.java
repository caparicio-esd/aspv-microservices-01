package esd.carlos.learningspring.controllers;


import esd.carlos.learningspring.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // para controllers con thymeleaf
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public String generalData(Model model) {
        model.addAttribute("name", "my first spa app"); // interpolamos la info que queramos en la plantilla
        return "index"; // retornamos el nombre de la plantilla
    }

    @RequestMapping("/books")
    public String renderAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll()); // en colecciones tb valoe
        return "books";
    }
}
