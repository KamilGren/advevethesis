package pl.gren.advevethesis.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gren.advevethesis.model.Category;
import pl.gren.advevethesis.service.AdvertisementService;
import pl.gren.advevethesis.service.CategoryService;


import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin( origins = "*", maxAge = 3600)
public class CategoryController {

    private final CategoryService categoryService;
    private final AdvertisementService advertisementService;

    public CategoryController(CategoryService categoryService, AdvertisementService advertisementService) {
        this.categoryService = categoryService;
        this.advertisementService = advertisementService;
    }

    private static final Logger logger  = LoggerFactory.getLogger(CategoryController.class);



    @GetMapping("/categories")
    ResponseEntity<List<Category>> readAllCategories(Pageable pageable) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(categoryService.listAll());
    }
//    @GetMapping("/kategorie/ogloszenia/{categoryName}")
//    ResponseEntity<List<Advertisement>> readAllAdvFromCategory(@PathVariable String categoryName) {
//        List <Advertisement> advFromCategory = new ArrayList<>();
//        logger.info(advFromCategory + " wydarzenia");
//        repository.findAdvertisementByCategoryName(categoryName).forEach(advFromCategory::add);
//        System.out.println(advFromCategory);
//        return ResponseEntity.ok(advFromCategory);
//    }

//    @GetMapping("/ogloszenia/{id}")
//    ResponseEntity<Advertisement> readAdvId(@PathVariable Integer id) {
//            return repository.findById(id)
//                    .map(ResponseEntity::ok)
//                    .orElse(ResponseEntity.notFound().build());
//    }


    @PostMapping("/categories")
    ResponseEntity<Category> postCategory(@RequestBody @Valid Category categoryBody) {
        Category result = categoryService.save(categoryBody);
        return ResponseEntity.ok(result);
}



//    @PatchMapping("/events/{id}")
//    public ResponseEntity<?> toggleEvent(@PathVariable long id){
//
//        try {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//    }

//    @PutMapping("/events/{id}")
//    ResponseEntity<Event> updateEvent(@PathVariable long id, @RequestBody @Valid Event toUpdate)
//    {
//
//        repository.findById(id)
//                .ifPresent(event -> {
//                    event.updateFrom(toUpdate);
//                    repository.save(event);
//                });
//        return ResponseEntity.noContent().build();
//    }


    @DeleteMapping("/categories/{id}")
    ResponseEntity<Category> DeleteCategory(@PathVariable Integer id)
    {
        try {
            categoryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}

