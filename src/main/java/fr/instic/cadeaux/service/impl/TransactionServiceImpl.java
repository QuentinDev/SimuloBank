package fr.instic.cadeaux.service.impl;

import fr.instic.cadeaux.business.Transaction;
import fr.instic.cadeaux.dao.TransactionDao;
import fr.instic.cadeaux.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Quentin on 21/03/2017.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Transactional(readOnly=true)
    @Override
    public List<Transaction> getTransactions() {
        return transactionDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Transaction getTransactionById(int id) {
        return transactionDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Transaction getTransactionByAccountId(int accountId) {
        return transactionDao.findByAccountId(accountId);
    }

    @Transactional(readOnly = true)
    @Override
    public Transaction getTransactionByAccountIdAndByDate(int accountId, Date date) {
        return transactionDao.findByAccountIdAndDate(accountId, date);
    }
}
