package pl.gren.advevethesis.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gren.advevethesis.model.Advertisement;
import pl.gren.advevethesis.model.Post;
import pl.gren.advevethesis.model.User;
import pl.gren.advevethesis.service.AdvertisementService;
import pl.gren.advevethesis.service.PostService;
import pl.gren.advevethesis.service.UserService;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@CrossOrigin( origins = "*", maxAge = 3600)
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final AdvertisementService advertisementService;

    public UserController(UserService userService, AdvertisementService advertisementService, PostService postService) {
        this.userService = userService;
        this.advertisementService = advertisementService;
        this.postService = postService;
    }

    @GetMapping("user/{Username}")
    ResponseEntity<User> readUsername(@PathVariable String Username) {

        return userService.findByName(Username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("user/{Username}/roles")
    ResponseEntity<String> readUsernameRole(@PathVariable String Username) {

        return ResponseEntity.ok(userService.findByName(Username).get().getRoles());
    }

    @GetMapping("/users")
    ResponseEntity<List<User>> readAllUsers(Pageable pageable) {

        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("/users/{username}/advertisements")
    ResponseEntity<List<Advertisement>> readAllUsers(Pageable pageable, @PathVariable String username) {

        List<Advertisement> lista = advertisementService.getAdvertisementByUserUsername(username);
        //System.out.println(lista.get(0).getTitle());
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/users/{username}/posts")
    ResponseEntity<List<Post>> readAllUserPosts(Pageable pageable, @PathVariable String username) {

        List<Post> lista = postService.getPostByUserUsername(username);
        //System.out.println(lista.get(0).getTitle());
        return ResponseEntity.ok(lista);

    }

    // rada: zalogowany user do podpiecia do tworzonego adverta na stronie, automatycznie pod formularzem dodawany do adverta



//    @RequestMapping(value = "/users/{username}/adverts/{advertId}", method = POST, produces = "application/json")
//    ResponseEntity<List<Advertisement>> addAdvert(@PathVariable("username") String username, @PathVariable("advertId") Integer advertId) {
//        Optional<Advertisement> advertOptional = advertisementService.findById(advertId);
//        Advertisement advert = advertOptional.get();
//
//        List<Advertisement> advertList = new ArrayList<>();
//        advertList.add(advert);
//
//
//        // optional to class user
//        Optional<User> userOptional = userService.findByName(username);
//        User user = userOptional.get();
//
//        advert.setUser(user);
//        System.out.println(advert.getUser().getUsername());
//        //System.out.println(advert.getUser());
//
//        //user.setAdvert(advertList);
//        return ResponseEntity.ok(advertList);
//    }
}

