package esd.carlos.learningspring.repositories;

import esd.carlos.learningspring.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
