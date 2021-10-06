package pl.gren.advevethesis.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotBlank
    @Size(max = 25)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category" )
    private Set<Advertisement> advertisements = new HashSet<Advertisement>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Advertisement> getAdvertisements() {
        return advertisements;
    }

    @JsonManagedReference
    public void setAdvertisements(Set<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }
}
