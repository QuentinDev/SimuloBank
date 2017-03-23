package fr.instic.cadeaux.dao;

import fr.instic.cadeaux.business.Account;
import fr.instic.cadeaux.business.AccountType;

import java.util.List;

/**
 * Created by Quentin on 21/03/2017.
 */
public interface AccountDao {
    List<Account> findAll();
    Account findById(int id);
    List<Account> findByUserId(int userId);
    List<AccountType> getAccountTypes();
    Account addAccount(Account account);
    AccountType getAccountTypeById(int accountTypeId);
}
