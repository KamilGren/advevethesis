package pl.gren.advevethesis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.gren.advevethesis.adapter.SqlEventRepository;
import pl.gren.advevethesis.model.Event;
import pl.gren.advevethesis.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    @Qualifier("EventRepository")
    private EventRepository repository;
    private SqlEventRepository sqlRepository;

    public EventService(EventRepository repository, SqlEventRepository sqlRepository) {
        this.repository = repository;
        this.sqlRepository = sqlRepository;
    }

    public List<Event> listAll()
    {
        return repository.findAll();
    }

    public Event save(Event event)
    {
        return repository.save(event);
    }

    public void update(Event event) {
        repository.save(event);
    }

    public void deleteById(int id) { repository.deleteById(id);}

    public Optional<Event> findByName(String name) { return repository.findByName(name); }

    public List<Event> getEventByAuthorName(String authorName) { return sqlRepository.findEventByAuthor_Name(authorName); }

    public Optional<Event> findById (int id){ return repository.findById(id); }

    public List<Event> findByAuthorId (Integer id) { return repository.findByAuthorId(id); }

    public List <Event> getEventsByEventCategoryName(String eventCategory) {
        return sqlRepository.getEventByEventCategory_Name(eventCategory);
    }

}
