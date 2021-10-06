package pl.gren.advevethesis.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.gren.advevethesis.model.EventCategory;

import java.util.List;
import java.util.Optional;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {

        List <EventCategory> findAll();

        boolean existsById(Integer id);

        Page<EventCategory> findAll(Pageable page);

        Optional <EventCategory> findById(Integer id);

        Optional <EventCategory> findByName(String name);

        EventCategory save(EventCategory event);

        void deleteById(Integer id);



        //List<EventCategory> getEventByAuthorName(String authorName);

}
