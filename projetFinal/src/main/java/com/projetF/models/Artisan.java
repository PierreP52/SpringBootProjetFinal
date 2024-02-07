package com.projetF.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Artisan")
public class Artisan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "Le nom de l'artisan ne peut pas être vide")
    @Size(max = 255, message = "Le nom de l'artisan ne peut pas dépasser 255 caractères")
    @Column(name = "nom")
    private String nom;

	@NotBlank(message = "Le prénom de l'artisan ne peut pas être vide")
    @Size(max = 255, message = "Le prénom de l'artisan ne peut pas dépasser 255 caractères")
    @Column(name = "prenom")
    private String prenom;

	@NotBlank(message = "L'artisanat de l'artisan ne peut pas être vide")
    @Size(max = 255, message = "L'artisanat de l'artisan ne peut pas dépasser 255 caractères")
    @Column(name = "artisanat")
    private String artisanat;

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

    public String getArtisanat() {
        return artisanat;
    }

    public void setArtisanat(String artisanat) {
        this.artisanat = artisanat;
    }

}
