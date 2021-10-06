package pl.gren.advevethesis.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gren.advevethesis.model.Event;
import pl.gren.advevethesis.service.EventService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin( origins = "*", maxAge = 3600)
public class EventController {


    @Autowired
    private EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    private static final Logger logger  = LoggerFactory.getLogger(EventController.class);


    @GetMapping("/events/text")
    public String giveTextHello() {
        return String.format("Hello!");
    }

    @GetMapping("/events")
    ResponseEntity<List<Event>> readAllEvents(Pageable pageable) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(eventService.listAll());

    }
    // za pomoca imienia autora znajdz jego eventy
    @GetMapping("/events/author/{authorName}")
    ResponseEntity<List<Event>> readAllAuthorEventsByAuthorName(@PathVariable String authorName) {
        List <Event> authorEvents = new ArrayList<>();
        logger.info(authorName + " events");
        eventService.getEventByAuthorName(authorName).forEach(authorEvents::add);
        System.out.println(authorEvents);
        return ResponseEntity.ok(authorEvents);
    }

    @GetMapping("/events/authors/{authorId}")
    public List <Event> readAuthor(@PathVariable Integer authorId)
    {
        return eventService.findByAuthorId(authorId);
    }

    @GetMapping("/events/{id}")
    ResponseEntity<Event> readEventId(@PathVariable int id) {

        if(id > 2)  {
            System.out.println("taki tescik");
        }
        else
            System.out.println("a taki tez");

            return eventService.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/events")
    ResponseEntity<Event> postEvent(@RequestBody @Valid Event eventBody) {



        eventService.save(eventBody);

        //trying gson, but... its still json
//        eventService.findByName(eventBody.getName()).ifPresent(event -> {
//            String serializedEvent = new Gson().toJson(event);
//            System.out.println(serializedEvent);
//        });

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{eventCategory}/events")
    ResponseEntity<List<Event>> readAllEventFromEventCategory(Pageable pageable, @PathVariable String eventCategory) {
        return ResponseEntity.ok(eventService.getEventsByEventCategoryName(eventCategory));
    }



    @PatchMapping("/events/{id}")
    public ResponseEntity<?> toggleEvent(@PathVariable long id){

        try {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/events/{id}")
    ResponseEntity<Event> updateEvent(@PathVariable int id, @RequestBody @Valid Event toUpdate)
    {

        eventService.findById(id)
                .ifPresent(event -> {
                    event.updateFrom(toUpdate);
                    eventService.save(event);
                });
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/events/{id}")
    ResponseEntity<Event> DeleteEvent(@PathVariable int id)
    {
        try {
            eventService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}

