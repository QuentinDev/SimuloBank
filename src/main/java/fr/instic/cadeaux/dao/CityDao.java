package fr.instic.cadeaux.dao;

import fr.instic.cadeaux.business.City;

import java.util.List;

/**
 * Created by Quentin on 10/02/2017.
 */
public interface CityDao {
    City findById(int id);

    List<City> findAll();
}
