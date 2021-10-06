package pl.gren.advevethesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gren.advevethesis.model.User;
import pl.gren.advevethesis.repository.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAll() { return userRepository.findAll(); }

    public Optional<User> findByName(String userName) { return userRepository.findByUsername(userName); }
}
