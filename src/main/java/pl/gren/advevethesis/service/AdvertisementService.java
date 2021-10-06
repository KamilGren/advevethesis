package pl.gren.advevethesis.service;

import org.springframework.stereotype.Service;
import pl.gren.advevethesis.model.Advertisement;
import pl.gren.advevethesis.repository.AdvertisementRepository;


import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementService {

    private AdvertisementRepository repository;

    public AdvertisementService(AdvertisementRepository repository) {
        this.repository = repository;
    }

    public List<Advertisement> listAll() { return repository.findAll(); }

    public Advertisement save(Advertisement adv)
    {
        return repository.save(adv);
    }

    public void update(Advertisement adv) {
        repository.save(adv);
    }

    public Optional<Advertisement> findById (int id){ return repository.findById(id); }

    public void delete(Integer id) { repository.deleteById(id);}

    public List <Advertisement> getAdvertisementByUserUsername(String userName) { return repository.getAdvertisementByUser_Username(userName); }

    public List <Advertisement> findAdvertisementsByCategoryName(String categoryName) { return repository.findAdvertisementByCategory_Name(categoryName); }

}
