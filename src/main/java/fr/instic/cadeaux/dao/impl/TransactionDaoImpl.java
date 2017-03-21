package fr.instic.cadeaux.dao.impl;

import fr.instic.cadeaux.business.Transaction;
import fr.instic.cadeaux.dao.TransactionDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Quentin on 21/03/2017.
 */
@Repository
public class TransactionDaoImpl implements TransactionDao {
    @Autowired
    private SessionFactory sf;

    @Override
    public List<Transaction> findAll() {
        return sf.getCurrentSession().createQuery("from Transaction").getResultList();
    }

    @Override
    public Transaction findById(int id) {
        return sf.getCurrentSession().byId(Transaction.class).load(id);
    }

    @Override
    public Transaction findByAccountId(int accountId) {
        return sf.getCurrentSession().byId(Transaction.class).load(accountId);
    }

    @Override
    public Transaction findByAccountIdAndDate(int accountId, Date date) {
        return (Transaction) sf.getCurrentSession().createQuery("from Transaction where date = :date and accountId < :accountId")
                .setParameter("date", date)
                .setParameter("accountId", accountId)
                .getResultList();
    }
}
