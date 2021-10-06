package pl.gren.advevethesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gren.advevethesis.model.Author;
import pl.gren.advevethesis.model.Event;


import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    public List<Author> findByName(String authorName);

    @Query(value = "select events from Author a where a.id = ?1", nativeQuery = true)
    List<Event> getEventsByAuthor(Integer id);

}