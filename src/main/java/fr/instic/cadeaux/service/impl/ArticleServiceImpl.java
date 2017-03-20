package fr.instic.cadeaux.service.impl;

import java.util.List;

import fr.instic.cadeaux.business.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.instic.cadeaux.dao.ArticleDao;
import fr.instic.cadeaux.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Transaction> recupereArticles() {
		return articleDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Transaction recupereArticleById(int id) {
		return articleDao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Transaction> recupereArticleParPoints(int minPoints, int maxPoints) {
		return articleDao.findByPoint(minPoints, maxPoints);
	}

}
