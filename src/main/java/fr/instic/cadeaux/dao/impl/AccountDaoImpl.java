package fr.instic.cadeaux.dao.impl;

import fr.instic.cadeaux.business.Account;
import fr.instic.cadeaux.business.AccountType;
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
        return sf.getCurrentSession().createQuery("from Account").getResultList();
    }

    @Override
    public Account findById(int id) {
        return sf.getCurrentSession().byId(Account.class).load(id);
    }

    @Override
    public List<Account> findByUserId(int userId) {
        return sf.getCurrentSession().createQuery("from Account where user_id = :userId")
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<AccountType> getAccountTypes() {
        return sf.getCurrentSession().createQuery("from AccountType", AccountType.class).getResultList();
    }

    @Override
    public Account addAccount(Account account) {
        sf.getCurrentSession().save(account);
        return account;
    }

}
