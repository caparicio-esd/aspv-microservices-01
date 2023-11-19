package esd.carlos.learningspring.repositories;

import esd.carlos.learningspring.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
