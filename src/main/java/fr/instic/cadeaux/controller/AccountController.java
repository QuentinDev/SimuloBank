package fr.instic.cadeaux.controller;

import fr.instic.cadeaux.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Quentin on 21/03/2017.
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService as;

    @Autowired
    private HttpSession hs;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @Transactional
    public ModelAndView accountsGet() {
        System.out.println("Lancement de la liste des comptes");
        ModelAndView mav = new ModelAndView("accounts");
        int userId = (int) hs.getAttribute("userId");

        mav.getModel().put("accounts", as.getAccountsForUser(userId));

        return mav;
    }

    @RequestMapping(value = "/simulation", method = RequestMethod.POST)
    @Transactional
    public ModelAndView SimulationPost(
            @RequestParam(name = "final_date") Date dateString,
            @RequestParam(name = "idAccount") int idAccount

    ) {

        System.out.println("la date au format String est    "+dateString);

        System.out.println(idAccount);
        ModelAndView mav = new ModelAndView("motDePasse");
        int userId = (int) hs.getAttribute("userId");

        mav.getModel().put("accounts", as.getAccountsForUser(userId));

        return mav;
    }


}
