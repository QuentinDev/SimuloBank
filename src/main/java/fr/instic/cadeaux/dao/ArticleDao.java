package fr.instic.cadeaux.dao;

import java.util.List;

import fr.instic.cadeaux.business.Article;

public interface ArticleDao {
	List<Article> findAll();
	Article findById(int id);
	List<Article> findByPoint(int minPoints, int maxPoints);
	}
