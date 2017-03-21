package fr.instic.cadeaux.dao;

import fr.instic.cadeaux.business.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created by Quentin on 21/03/2017.
 */
public interface TransactionDao {
    List<Transaction> findAll();
    Transaction findById(int id);
    Transaction findByAccountId(int accountId);
    Transaction findByAccountIdAndDate(int accountId, Date date);
}
