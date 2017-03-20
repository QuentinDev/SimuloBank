package fr.instic.cadeaux.service;

import fr.instic.cadeaux.business.City;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Quentin on 10/02/2017.
 */
public interface CityService {

    @Transactional(readOnly = true)
    City getCityById(int id);

    @Transactional(readOnly = true)
    List<City> getCities();

}
