package hello.repository;

import hello.services.Words;
import org.springframework.data.repository.CrudRepository;

public interface WordsRepository extends CrudRepository<Words, Long> {

}
