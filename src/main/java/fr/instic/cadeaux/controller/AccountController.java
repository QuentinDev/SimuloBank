package fr.instic.cadeaux.controller;

import fr.instic.cadeaux.business.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Quentin on 21/03/2017.
 */
@Controller
public class AccountController {

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ModelAndView inscriptionGet() {
        System.out.println("Lancement accounts");

        List<City> cities = cs.getCities();
        ModelAndView mav = new ModelAndView("accounts");
        mav.getModel().put("cities", cities);

        return mav;
    }

}
