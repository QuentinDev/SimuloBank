package fr.instic.cadeaux.service.impl;

import fr.instic.cadeaux.business.Account;
import fr.instic.cadeaux.business.AccountType;
import fr.instic.cadeaux.business.Article;
import fr.instic.cadeaux.dao.AccountDao;
import fr.instic.cadeaux.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Quentin on 21/03/2017.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(readOnly = true)
    @Override
    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Account getAccountById(int id) {
        return accountDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Account> getAccountsForUser(int userId) {
        return accountDao.findByUserId(userId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountType> getAccountTypes() {
        return accountDao.getAccountTypes();
    }

    @Transactional
    @Override
    public Account addAccount(Account account) {
        return accountDao.addAccount(account);
    }

    @Transactional
    @Override
    public AccountType getAccountTypeById(int accountTypeId) {
        return accountDao.getAccountTypeById(accountTypeId);
    }

}
