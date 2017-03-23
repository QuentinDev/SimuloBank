package fr.instic.cadeaux.dao;

import fr.instic.cadeaux.business.Transaction;
import fr.instic.cadeaux.business.TransactionType;

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
    List<TransactionType> getTransactionTypes();
    Transaction addTransaction(Transaction transaction);
    TransactionType getTransactionTypeById(int TransactionTypeId);

}
