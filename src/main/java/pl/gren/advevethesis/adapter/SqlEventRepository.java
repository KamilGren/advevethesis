package pl.gren.advevethesis.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.gren.advevethesis.model.Event;
import pl.gren.advevethesis.repository.EventRepository;

import java.util.List;


@Repository
public interface SqlEventRepository extends EventRepository, JpaRepository<Event, Integer> {

    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from EVENT where id=:id")
    boolean existsById(@Param("id") Integer id);


    public List<Event> findEventByAuthor_Name(String authorName);
    List<Event> getEventByEventCategory_Name(String eventCategory);
    //boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);


}

