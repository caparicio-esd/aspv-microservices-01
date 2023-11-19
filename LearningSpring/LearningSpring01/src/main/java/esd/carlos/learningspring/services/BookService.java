package esd.carlos.learningspring.services;

import esd.carlos.learningspring.domain.Book;
import esd.carlos.learningspring.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IService<Book> {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
