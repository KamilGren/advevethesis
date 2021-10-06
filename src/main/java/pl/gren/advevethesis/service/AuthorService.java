package pl.gren.advevethesis.service;


import org.springframework.stereotype.Service;
import pl.gren.advevethesis.model.Author;
import pl.gren.advevethesis.model.Event;
import pl.gren.advevethesis.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorService {


    private AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> listAll()
    {
        return repository.findAll();
    }

    public Optional<Author> findById(Integer authorId) { return repository.findById(authorId); }

    public void save(Author author)
    {
        repository.save(author);
    }

    public void update(Author author) {
        repository.save(author);
    }

    public List<Event> getEventsByAuthor(Integer authorId)
    {
        return repository.getEventsByAuthor(authorId);
    }

    public void deleteById(Integer authorId) { repository.deleteById(authorId); }

    public boolean existsById(Integer authorId) { return repository.existsById(authorId); }

    public List<Author> findByName (String authorName) { return repository.findByName(authorName); }
}
