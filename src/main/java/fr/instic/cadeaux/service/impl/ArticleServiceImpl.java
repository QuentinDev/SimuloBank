package fr.instic.cadeaux.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.instic.cadeaux.business.Article;
import fr.instic.cadeaux.dao.ArticleDao;
import fr.instic.cadeaux.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Article> recupereArticles() {
		return articleDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Article recupereArticleById(int id) {
		return articleDao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Article> recupereArticleParPoints(int minPoints, int maxPoints) {
		return articleDao.findByPoint(minPoints, maxPoints);
	}

}
