package pl.gren.advevethesis.service;


import org.springframework.stereotype.Service;
import pl.gren.advevethesis.model.EventCategory;
import pl.gren.advevethesis.repository.EventCategoryRepository;

import java.util.List;

@Service
public class EventCategoryService {

    private EventCategoryRepository repository;

    public EventCategoryService(EventCategoryRepository eventCategoryRepository) {
        this.repository = eventCategoryRepository;
    }

    public List<EventCategory> listAll()
    {
        return repository.findAll();
    }

    public void save(EventCategory eventCategory)
    {
        repository.save(eventCategory);
    }

    public void deleteById(Integer id) { repository.deleteById(id);}

}
