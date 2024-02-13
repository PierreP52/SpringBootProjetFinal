package com.projetF.projetFinal.models;



import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "artisan", fetch = FetchType.EAGER)
    private List<Atelier> ateliers;
    
    public Artisan () {
    	
    }
    
    public Artisan(Long id, String nom, String prenom, String artisanat) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.artisanat = artisanat;
        
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artisan artisan = (Artisan) o;
        return Objects.equals(id, artisan.id) &&
               Objects.equals(nom, artisan.nom) &&
               Objects.equals(prenom, artisan.prenom) &&
               Objects.equals(artisanat, artisan.artisanat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, artisanat);
    }

}
