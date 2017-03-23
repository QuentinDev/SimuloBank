package fr.instic.cadeaux.service;

import fr.instic.cadeaux.business.Transaction;
import fr.instic.cadeaux.business.TransactionType;

import java.util.Date;
import java.util.List;

/**
 * Created by Quentin on 21/03/2017.
 */
public interface TransactionService {
    List<Transaction> getTransactions();

    Transaction getTransactionById(int id);

    Transaction getTransactionByAccountId(int accountId);

    Transaction getTransactionByAccountIdAndByDate(int accountId, Date date);

    List<TransactionType> getTransactionTypes();

    TransactionType getTransactionTypeById(int transactionTypeId);

    Transaction addTransaction(Transaction transaction);
}
