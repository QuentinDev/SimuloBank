package fr.instic.cadeaux.dao.impl;

import fr.instic.cadeaux.business.City;
import fr.instic.cadeaux.dao.CityDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Quentin on 10/02/2017.
 */
@Repository
public class CityDaoImpl implements CityDao {
    @Autowired
    private SessionFactory sf;

    @Override
    public List<City> findAll() {
        return sf.getCurrentSession().createQuery("from City", City.class).getResultList();
    }

    @Override
    public City findById(int id) {
        return sf.getCurrentSession().byId(City.class).load(id);
    }
}
