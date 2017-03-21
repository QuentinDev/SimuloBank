package fr.instic.cadeaux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Quentin on 21/03/2017.
 */
@Controller
public class AccountController {

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public boolean inscriptionGet() {

        return true;
    }

}
