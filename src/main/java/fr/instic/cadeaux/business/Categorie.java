package fr.instic.cadeaux.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategorie;
	
	private String nom;

	@OneToMany(mappedBy="categorie")
	private List<Article> articles;


	public Categorie() {
		super();
	}

	public Categorie(String nom) {
		setNom(nom);
	}

	public int getIdCategorie() {
		return idCategorie;
	}
	
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nom=" + nom + "]";
	}
}
