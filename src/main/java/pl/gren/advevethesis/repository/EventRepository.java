package pl.gren.advevethesis.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.gren.advevethesis.model.Event;

import java.util.List;
import java.util.Optional;

@Repository
@Component("EventRepository")
public interface EventRepository {

        List <Event> findAll();

        boolean existsById(Integer id);

        Page<Event> findAll(Pageable page);

        Optional <Event> findById(Integer id);

        Optional <Event> findByName(String name);

        Event save(Event event);

        void deleteById(Integer id);

        List<Event> getEventByAuthorName(String authorName);

        List<Event> findByAuthorId(Integer id);



}
