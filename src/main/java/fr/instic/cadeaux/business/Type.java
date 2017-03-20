package fr.instic.cadeaux.business;

import javax.persistence.*;

/**
 * Created by Quentin on 20/03/2017.
 */
@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
