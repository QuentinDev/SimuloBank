package fr.instic.cadeaux.business;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Quentin on 10/02/2017.
 */
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy="city")
    private List<User> user;

    public City() { super(); }

    public City(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "City{" +
                "name=" + name +
                '}';
    }
}
