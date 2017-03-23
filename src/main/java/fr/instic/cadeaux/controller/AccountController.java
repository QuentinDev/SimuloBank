package fr.instic.cadeaux.controller;

import fr.instic.cadeaux.business.*;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

        User updatedUser = us.recupereUserById(user.getId());
        hs.removeAttribute("user");
        hs.setAttribute("user", updatedUser);

        ModelAndView mav = new ModelAndView("accounts");
        mav.getModel().put("accounts", as.getAccountsForUser(user.getId()));
        mav.getModel().put("user", updatedUser);
        mav.getModel().put("accountTypes", as.getAccountTypes());
        mav.getModel().put("transactionTypes", ts.getTransactionTypes());

        return mav;
    }

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public ModelAndView createAccount (
            @RequestParam(name = "BALANCE") int balance,
            @RequestParam(name = "NAME") String name,
            @RequestParam(name = "ACCOUNTTYPE") int accountTypeId
    ) {
        System.out.println("Lancement createAccount");
        User user = (User) hs.getAttribute("user");
        AccountType accountType = as.getAccountTypeById(accountTypeId);

        as.addAccount(new Account(user, balance, name, accountType, new Date()));

        hs.removeAttribute("user");
        hs.setAttribute("user", us.recupereUserById(user.getId()));

        return new ModelAndView("redirect:accounts");
    }

    @RequestMapping(value = "/createTransaction", method = RequestMethod.POST)
    public ModelAndView createAccount (
            @RequestParam(name = "ACCOUNT_ID") int accountId,
            @RequestParam(name = "AMOUNT") int amount,
            @RequestParam(name = "NAME") String name,
            @RequestParam(name = "DATE") String dateStr,
            @RequestParam(name = "TRANSACTIONTYPE") int transactionTypeId
    ) {
        System.out.println("Lancement createAccount");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateParsed = null;
        try {
            dateParsed = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = (User) hs.getAttribute("user");

        Account account = as.getAccountById(accountId);

        TransactionType transactionType = ts.getTransactionTypeById(transactionTypeId);

        ts.addTransaction(new Transaction(account, name, dateParsed, amount, transactionType));

        hs.removeAttribute("user");
        hs.setAttribute("user", us.recupereUserById(user.getId()));

        return new ModelAndView("redirect:accounts");
    }

    @RequestMapping(value = "/simulation", method = RequestMethod.POST)
    @Transactional
    public ModelAndView SimulationPost(
            @RequestParam(name = "final_date") Date dateString,
            @RequestParam(name = "idAccount") int idAccount
    )
    { System.out.println("SimulationPost ");
        Account account = as.getAccountById(idAccount);
        List<MontantDate> MontantDateTab;

        MontantDateTab=account.calculBudget(dateString);

        System.out.println("budget calculé  ");


        ModelAndView mav = new ModelAndView("simulation");
        int userId = (int) hs.getAttribute("userId");

        mav.getModel().put("account", account);
        mav.getModel().put("MontantDateTab", MontantDateTab);
        mav.getModel().put("user", hs.getAttribute("user"));


        return mav;
    }

}
