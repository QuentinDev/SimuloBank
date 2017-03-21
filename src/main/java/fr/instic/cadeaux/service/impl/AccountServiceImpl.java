package fr.instic.cadeaux.service.impl;

import fr.instic.cadeaux.business.Account;
import fr.instic.cadeaux.dao.AccountDao;
import fr.instic.cadeaux.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Quentin on 21/03/2017.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(readOnly=true)
    @Override
    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Article getAccountById(int id) {
        return accountDao.findById(id);
    }
}
