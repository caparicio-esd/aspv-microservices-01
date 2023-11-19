package esd.carlos.learningspring.controllers;

import esd.carlos.learningspring.domain.Book;
import esd.carlos.learningspring.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // para controllers con rest api
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public Iterable<Book> getAllBooks() {
        return bookService.findAll();
    }
}
