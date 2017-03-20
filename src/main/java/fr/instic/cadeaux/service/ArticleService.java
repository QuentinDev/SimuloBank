package fr.instic.cadeaux.service;

import java.util.List;

import fr.instic.cadeaux.business.Transaction;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleService {

	List<Transaction> recupereArticles();

	Transaction recupereArticleById(int id);

	@Transactional(readOnly = true)
	List<Transaction> recupereArticleParPoints(int minPoints, int maxPoints);
}
