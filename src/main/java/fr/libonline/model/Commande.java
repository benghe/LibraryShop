package fr.libonline.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CMD_ID")
	private int id;
	
	@Column(name = "CMD_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "CMD_CLIENT_ID", nullable = false)
	private int clientId;
	
	@Column(name = "CMD_MONTANT", nullable = false)
	private Double montant;
	
	public Commande() {
	
	}
	
	public Commande(int id, Date date, int clientId, Double montant) {
		this.id = id;
		this.date = date;
		this.clientId = clientId;
		this.montant = montant;
	}

	public Commande(Date date, int clientId, Double montant) {
		this.date = date;
		this.clientId = clientId;
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public Commande id(int id) {
		this.id = id;
		return this;
	}
	
	public Date getDate() {
		return date;
	}

	public Commande date(Date date) {
		this.date = date;
		return this;
	}
	
	public int getClientId() {
		return clientId;
	}
	
	public Commande clientId(int clientId) {
		this.clientId = clientId;
		return this;
	}
	
	public Double getMontant() {
		return montant;
	}
	
	public Commande montant(Double montant) {
		this.montant = montant;
		return this;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + ", clientId=" + clientId + ", montant=" + montant + "]";
	}
	
	

}
