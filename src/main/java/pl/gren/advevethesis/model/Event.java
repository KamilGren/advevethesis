package pl.gren.advevethesis.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @NotBlank(message = "Event's description must not be empty")
    private String descriptionOfEvent;
    @NotBlank(message = "Event's link must not be empty")
    private String link;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAndTimeOfEvent;
    private String posterLink;

    private LocalDateTime timeOfEventEnd;

    @ManyToOne
    private Author author;

    @ManyToOne
    @JoinColumn(name = "event_category_id")
    private EventCategory eventCategory;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Event() {

    }

    public Event(int id, String name, @NotBlank(message = "Event's description must not be empty") String descriptionOfEvent, @NotBlank(message = "Event's link must not be empty") String link, String posterLink) {
        this.id = id;
        this.name = name;
        this.descriptionOfEvent = descriptionOfEvent;
        this.link = link;
        this.posterLink = posterLink;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }





    public LocalDateTime getDateAndTimeOfEvent() {
        return dateAndTimeOfEvent;
    }

    public void setDateAndTimeOfEvent(LocalDateTime dateAndTimeOfEvent) {
        this.dateAndTimeOfEvent = dateAndTimeOfEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionOfEvent() {
        return descriptionOfEvent;
    }

    public void setDescriptionOfEvent(String descriptionOfEvent) {
        this.descriptionOfEvent = descriptionOfEvent;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public String getPosterLink() {
        return posterLink;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public LocalDateTime getTimeOfEventEnd() {
        return timeOfEventEnd;
    }

    public void setTimeOfEventEnd(LocalDateTime timeOfEventEnd) {
        this.timeOfEventEnd = timeOfEventEnd;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void updateFrom(final Event source)
    {
        name = source.name;
        descriptionOfEvent = source.descriptionOfEvent;
        dateAndTimeOfEvent = source.dateAndTimeOfEvent;
        posterLink = source.posterLink;
        link = source.link;
        author = source.author;
        eventCategory = source.eventCategory;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }
}
