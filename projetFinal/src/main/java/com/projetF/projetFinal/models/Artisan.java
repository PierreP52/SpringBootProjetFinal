package com.projetF.projetFinal.models;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Artisan")
public class Artisan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
    @Column(name = "nom")
    private String nom;

	
    @Column(name = "prenom")
    private String prenom;

	
    @Column(name = "artisanat")
    private String artisanat;

    @OneToMany(mappedBy = "artisan", fetch = FetchType.LAZY)
    private List<Atelier> ateliers;
    
    public Artisan () {
    	
    }
    
    public Artisan(Long id, String nom, String prenom, String artisanat, List<Atelier> ateliers) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.artisanat = artisanat;
        this.ateliers = ateliers;
    }
	
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
    
    public void setAteliers(List<Atelier> ateliers) {
        this.ateliers = ateliers;
    }

}
