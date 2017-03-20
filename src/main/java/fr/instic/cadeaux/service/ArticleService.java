package fr.instic.cadeaux.service;

import java.util.List;

import fr.instic.cadeaux.business.Article;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleService {

	List<Article> recupereArticles();

	Article recupereArticleById(int id);

	@Transactional(readOnly = true)
	List<Article> recupereArticleParPoints(int minPoints, int maxPoints);
}
