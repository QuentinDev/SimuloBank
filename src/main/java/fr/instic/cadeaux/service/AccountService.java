package fr.instic.cadeaux.service;

import fr.instic.cadeaux.business.Account;
import fr.instic.cadeaux.business.AccountType;

import java.util.List;

/**
 * Created by Quentin on 21/03/2017.
 */
public interface AccountService {
    List<Account> getAccounts();

    Account getAccountById(int id);

    List<Account> getAccountsForUser(int userId);

    List<AccountType> getAccountTypes();

    Account addAccount(Account account);
}
