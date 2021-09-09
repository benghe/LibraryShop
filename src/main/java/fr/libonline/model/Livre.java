package fr.libonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIV_ID")
	private int id;
	
	@Column(name = "LIV_TITRE", length = 50, nullable = false)
	private String titre;
	@Column(name = "LIV_AUTEUR", length = 50, nullable = false)
	private String auteur;
	@Column(name = "LIV_PRIX", precision = 10, scale = 2, nullable = false)
	private Double prix;
	@Column(name = "LIV_PHOTO", length = 250, nullable = true)
	private String photo;
	@Column(name = "LIV_RESUME", length = 500, nullable = true)
	private String resume;

public Livre() {

	}

	public Livre(int id, String titre, String auteur, Double prix, String photo, String resume) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.prix = prix;
		this.photo = photo;
		this.resume = resume;
	}

	public Livre(String titre, String auteur, double prix, String photo, String resume) {
		this.titre = titre;
		this.auteur = auteur;
		this.prix = prix;
		this.photo = photo;
		this.resume = resume;
	}

	public int getId() {
		return id;
	}

	public Livre id(int id) {
		this.id = id;
		return this;
	}

	public String getTitre() {
		return titre;
	}

	public Livre titre(String titre) {
		this.titre = titre;
		return this;
	}

	public String getAuteur() {
		return auteur;
	}

	public Livre auteur(String auteur) {
		this.auteur = auteur;
		return this;
	}

	public Double getPrix() {
		return prix;
	}

	public Livre prix(Double prix) {
		this.prix = prix;
		return this;
	}

	public String getPhoto() {
		return photo;
	}

	public Livre photo(String photo) {
		this.photo = photo;
		return this;
	}

	public String getResume() {
		return resume;
	}

	public Livre resume(String resume) {
		this.resume = resume;
		return this;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livre [id=").append(id).append(", titre=").append(titre).append(", auteur=").append(auteur)
				.append(", prix=").append(prix).append(", photo=").append(photo).append(", resume=")
				.append(resume).append("]");
		return builder.toString();
	}
}
