package fr.instic.cadeaux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.instic.cadeaux.service.ArticleService;

@Controller
public class CommandesController {

	@Autowired
	private ArticleService as;

	@RequestMapping(value = { "/index", "/" })
	public ModelAndView accueil() {
		System.out.println("Lancement index");
		ModelAndView mav = new ModelAndView("index");
		mav.getModel().put("articles", as.recupereArticles());

		return mav;
	}

	@RequestMapping(value = "/catalogueFiltre", method = RequestMethod.GET)
	public ModelAndView inscriptionPost(
			@RequestParam(name = "POINT_MIN") int minPoints,
			@RequestParam(name = "POINT_MAX") int maxPoints
	) {
		ModelAndView mav = new ModelAndView("index");

		mav.getModel().put("articles", as.recupereArticleParPoints(minPoints, maxPoints));

		return mav;
	}

	@RequestMapping(value = "/detailArticle", method = RequestMethod.GET)
	public ModelAndView detailArticle(@RequestParam(name = "ID_ARTICLE") int idArticle) {
		System.out.println("Lancement detailArticle");
		ModelAndView mav = new ModelAndView("article");
		mav.getModel().put("article", as.recupereArticleById(idArticle));

		return mav;
	}

}
