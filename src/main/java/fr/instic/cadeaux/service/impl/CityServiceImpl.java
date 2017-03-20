package fr.instic.cadeaux.service.impl;

import fr.instic.cadeaux.business.City;
import fr.instic.cadeaux.dao.CityDao;
import fr.instic.cadeaux.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Quentin on 10/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    @Transactional(readOnly=true)
    @Override
    public List<City> getCities() {
        return cityDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public City getCityById(int id) {
        return cityDao.findById(id);
    }
}
