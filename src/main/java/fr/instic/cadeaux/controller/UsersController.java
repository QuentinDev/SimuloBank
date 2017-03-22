package fr.instic.cadeaux.controller;

import fr.instic.cadeaux.business.City;
import fr.instic.cadeaux.business.User;
import fr.instic.cadeaux.service.CityService;
import fr.instic.cadeaux.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UtilisateurService us;

    @Autowired
    private CityService cs;

    @Autowired
    private HttpSession hs;

    @RequestMapping(value = "/inscription", method = RequestMethod.GET)
    public ModelAndView inscriptionGet() {
        System.out.println("Lancement inscriptionGet");

        List<City> cities = cs.getCities();
        ModelAndView mav = new ModelAndView("inscription");
        mav.getModel().put("cities", cities);

        return mav;
    }

    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public ModelAndView inscriptionPost(
            @RequestParam(name = "NOM") String nom,
            @RequestParam(name = "PRENOM") String prenom,
            @RequestParam(name = "EMAIL") String email,
            @RequestParam(name = "MOT_DE_PASSE") String motDePasse,
            @RequestParam(name = "CITY") int cityId
    ) {
        System.out.println("Lancement inscriptionPost");
        City city = cs.getCityById(cityId);
        User user = us.ajouterUtilisateur(new User(prenom, nom, email, motDePasse, city));
        ModelAndView mav = new ModelAndView("inscriptionPost");
        mav.getModel().put("user", user);

        return mav;
    }

    @RequestMapping(value = "/connexion", method = RequestMethod.GET)
    public ModelAndView connexionGet() {
        System.out.println("Lancement connexionGet");

        ModelAndView mav = new ModelAndView("connexion");

        return mav;
    }

    @RequestMapping(value = "/connexion", method = RequestMethod.POST)
    public ModelAndView connexionPOST(String email, String password) {
        System.out.println("Lancement connexionPOST");

        User user = us.verrifierUtilisateur(email, password);
        ModelAndView mav = new ModelAndView();
        if (user != null) {
            hs.setAttribute("user", user);
            hs.setAttribute("userId", user.getId());
            mav.setViewName("connexionPost");
            mav.getModel().put("user", user);
            return mav;
        } else {
            return new ModelAndView("redirect:connexion");
        }
    }

    @RequestMapping(value = "/passwordReset", method = RequestMethod.GET)
    public ModelAndView changePasswordPost() {
        System.out.println("Lancement passwordResetGet");

        ModelAndView mav = new ModelAndView("motDePasse");

        return mav;
    }

    @RequestMapping(value = "/passwordReset", method = RequestMethod.POST)
    public ModelAndView changePasswordPost(String email, String password) {
        System.out.println("Lancement passwordResetPost");

        us.changePasswordForUser(email, password);

        return new ModelAndView("redirect:connexion");
    }
}
