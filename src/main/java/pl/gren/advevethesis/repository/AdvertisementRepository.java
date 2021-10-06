package pl.gren.advevethesis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gren.advevethesis.model.Advertisement;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {

    public List <Advertisement> getAdvertisementByUser_Username(String username);
    public List<Advertisement> findAdvertisementByCategory_Name(String categoryName);
    public Advertisement findByTitle(String advName);

}