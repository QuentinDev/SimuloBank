package fr.instic.cadeaux.dao.impl;

import fr.instic.cadeaux.business.Account;
import fr.instic.cadeaux.dao.AccountDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Quentin on 21/03/2017.
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Account> findAll() {
        return sf.getCurrentSession().createQuery("from Article").getResultList();
    }

    @Override
    public Account findById(int id) {
        return sf.getCurrentSession().byId(Account.class).load(id);
    }

}
