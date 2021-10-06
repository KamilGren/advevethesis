package pl.gren.advevethesis.service;

import org.springframework.stereotype.Service;
import pl.gren.advevethesis.model.Category;
import pl.gren.advevethesis.repository.CategoryRepository;


import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> listAll()
    {
        return repository.findAll();
    }

    public Category save(Category cat)
    {
        return repository.save(cat);
    }

    public void update(Category cat) {
        repository.save(cat);
    }

    public void deleteById(Integer id) { repository.deleteById(id); }

    //public void findAdvertisementByCategoryName(String categoryName) { repository.findAdvertisementByCategoryName(categoryName); }

}
