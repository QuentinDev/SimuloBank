package fr.instic.cadeaux.business;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Article {

	private static final float TAUX_TVA = 0.2f;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idArticle;
	@Size(min=5)
	private String designation;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Lob
	private String description;

	private int nbPoints;
	private int stock;

	@ManyToOne
	@NotNull
	private Categorie categorie;
	
	private float montantHT;
	
	@Transient
	public float getMontantHT() {
		return montantHT * TAUX_TVA;
	}


	@OneToMany(mappedBy = "article")
	private List<Command> commands;

	private String urlImage;

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

    @Override
    public String toString() {
        return "Article{" +
                "idArticle=" + idArticle +
                ", designation='" + designation + '\'' +
                ", description='" + description + '\'' +
                ", nbPoints=" + nbPoints +
                ", stock=" + stock +
                ", categorie=" + categorie +
                ", montantHT=" + montantHT +
                ", commands=" + commands +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
