package fr.instic.cadeaux.dao.impl;

import java.util.List;

import fr.instic.cadeaux.business.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.instic.cadeaux.business.Article;
import fr.instic.cadeaux.dao.ArticleDao;

@Repository
public class ArticleDaoImpl implements ArticleDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Article> findAll() {
		return sf.getCurrentSession().createQuery("from Article").getResultList();
	}

	@Override
	public Article findById(int id) {
		return sf.getCurrentSession().byId(Article.class).load(id);
	}

	public List<Article> findByPoint(int minPoints, int maxPoints) {
		return sf.getCurrentSession().createQuery("from Article where nbPoints > :minPoints and nbPoints < :maxPoints")
				.setParameter("minPoints", minPoints)
				.setParameter("maxPoints", maxPoints)
				.getResultList();
	}
}
