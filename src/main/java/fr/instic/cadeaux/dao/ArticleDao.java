package fr.instic.cadeaux.dao;

import java.util.List;

import fr.instic.cadeaux.business.Transaction;

public interface ArticleDao {
	List<Transaction> findAll();
	Transaction findById(int id);
	List<Transaction> findByPoint(int minPoints, int maxPoints);
	}
