package com.projetF.models;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
	@Table(name = "Participant")
	public class Participant {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Le nom ne peut pas être vide")
	    @Size(max = 255, message = "Le nom ne peut pas dépasser 255 caractères")
	    @Column(name = "nom")
	    private String nom;

	    @NotBlank(message = "Le prénom ne peut pas être vide")
	    @Size(max = 255, message = "Le prénom ne peut pas dépasser 255 caractères")
	    @Column(name = "prenom")
	    private String prenom;

	    // Getters and Setters
	    
	 // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
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
