package fr.libonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CL_ID")
	private int id;
	
	@Column(name = "CL_NOM", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "CL_PRENOM", length = 50, nullable = false)
	private String prenom;
	
	@Column(name = "CL_ADRESSE", length = 150, nullable = false)
	private String adresse;
	
	@Column(name = "CL_LOGIN", length = 50)
	private String login;
	
	@Column(name = "CL_PASSWORD", length = 300)
	private String password;

	public Client() {

	}

	public Client(int id, String nom, String prenom, String adresse, String login, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.login = login;
		this.password = password;
	}

	public Client(String nom, String prenom, String adresse, String login, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public Client id(int id) {
		this.id = id;
		return this;
	}

	public String getNom() {
		return nom;
	}

	public Client nom(String nom) {
		this.nom = nom;
		return this;
	}

	public String getPrenom() {
		return prenom;
	}

	public Client prenom(String prenom) {
		this.prenom = prenom;
		return this;
	}

	public String getAdresse() {
		return adresse;
	}

	public Client adresse(String adresse) {
		this.adresse = adresse;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public Client login(String login) {
		this.login = login;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Client password(String password) {
		this.password = password;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [id=").append(id).append(", nom=").append(nom).append(", prenom=").append(prenom)
				.append(", adresse=").append(adresse).append(", login=").append(login).append(", password=")
				.append(password).append("]");
		return builder.toString();
	}

}
