package pl.gren.advevethesis.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gren.advevethesis.model.Event;
import pl.gren.advevethesis.model.EventCategory;
import pl.gren.advevethesis.service.EventCategoryService;


import java.util.List;

@RestController
@CrossOrigin( origins = "*", maxAge = 3600)
public class EventCategoryController {

    @Autowired
    private EventCategoryService eventCategoryService;

    public EventCategoryController(EventCategoryService eventService) {
        this.eventCategoryService = eventService;
    }

    private static final Logger logger  = LoggerFactory.getLogger(EventCategoryController.class);


    @GetMapping("/eventCategories")
    ResponseEntity<List<EventCategory>> readAllEventCategories(Pageable pageable) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(eventCategoryService.listAll());

    }

    @PostMapping("/eventCategories")
    ResponseEntity<EventCategory> postEventCategory(@RequestBody EventCategory eventCategoryBody) {

        eventCategoryService.save(eventCategoryBody);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/eventCategory/{id}")
    ResponseEntity<Event> DeleteEvent(@PathVariable int id)
    {
        try {
            eventCategoryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}

