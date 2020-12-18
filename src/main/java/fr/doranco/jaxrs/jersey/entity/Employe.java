package fr.doranco.jaxrs.jersey.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employe")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employe {

	private Integer id;
	private String prenom;
	private String nom;

	public Employe() {
	}

	public Employe(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
