package fr.instic.cadeaux.controller;

import fr.instic.cadeaux.business.Account;
import fr.instic.cadeaux.business.AccountType;
import fr.instic.cadeaux.business.City;
import fr.instic.cadeaux.business.User;
import fr.instic.cadeaux.service.AccountService;
import fr.instic.cadeaux.service.TransactionService;
import fr.instic.cadeaux.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Quentin on 21/03/2017.
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService as;

    @Autowired
    private UtilisateurService us;

    @Autowired
    private TransactionService ts;

    @Autowired
    private HttpSession hs;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @Transactional
    public ModelAndView accountsGet() {
        System.out.println("Lancement de la liste des comptes");

        User user = (User) hs.getAttribute("user");

        ModelAndView mav = new ModelAndView("accounts");
        mav.getModel().put("accounts", user.getAccounts());
        mav.getModel().put("user", user);
        mav.getModel().put("accountTypes", as.getAccountTypes());
        mav.getModel().put("transactionTypes", ts.getTransactionTypes());

        return mav;
    }

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public ModelAndView createAccount (
            @RequestParam(name = "USER_ID") int userId,
            @RequestParam(name = "BALANCE") int balance,
            @RequestParam(name = "NAME") String name,
            @RequestParam(name = "ACCOUNTTYPE") int accountTypeId
    ) {
        System.out.println("Lancement inscriptionPost");
        User user = us.getUserById(userId);
        AccountType accountType = as.getAccountTypeById(accountTypeId);

        Account account = as.addAccount(new Account(user, balance, name, accountType));

        return mav;
    }

}
