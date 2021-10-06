package pl.gren.advevethesis.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gren.advevethesis.model.Advertisement;
import pl.gren.advevethesis.service.AdvertisementService;
import pl.gren.advevethesis.service.CategoryService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin( origins = "*", maxAge = 3600)
public class AdvertisementController {


    @Autowired
    private final AdvertisementService advertisementService;

    private final CategoryService categoryService;

    public AdvertisementController(AdvertisementService advertisementService, CategoryService categoryService) {
        this.advertisementService = advertisementService;
        this.categoryService = categoryService;
    }

    private static final Logger logger  = LoggerFactory.getLogger(AdvertisementController.class);



    @GetMapping("/advertisements")
    ResponseEntity<List<Advertisement>> readAllAdvertisements(Pageable pageable) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(advertisementService.listAll());

    }

    @GetMapping("/advertisements/category/{categoryName}")
    ResponseEntity<List<Advertisement>> readAllAdvFromCategory(@PathVariable String categoryName) {
        return ResponseEntity.ok(advertisementService.findAdvertisementsByCategoryName(categoryName));
    }

    @GetMapping("/advertisements/{id}")
    ResponseEntity<Advertisement> readAdvId(@PathVariable Integer id) {

        System.out.println("cat: " + advertisementService.findById(id).get().getCategory().getName());
            return advertisementService.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/advertisement")
    ResponseEntity<Advertisement> postAdv(@RequestBody @Valid Advertisement advBody) {

        Advertisement result = advertisementService.save(advBody);
        return ResponseEntity.ok(result);
}

    @PutMapping("/advertisements/{id}")
    ResponseEntity<Advertisement> updateEvent(@PathVariable Integer id, @RequestBody @Valid Advertisement toUpdate)
    {

        advertisementService.findById(id)
                .ifPresent(advert -> {
                    advert.updateFrom(toUpdate);
                    advertisementService.save(advert);
                });
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/advertisements/{id}")
    ResponseEntity<Advertisement> DeleteEvent(@PathVariable Integer id)
    {
        try {
            advertisementService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}

