package com.projetF.projetFinal.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
	@Table(name = "Participant")
	public class Participant {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	    @Column(name = "nom")
	    private String nom;

	    
	    @Column(name = "prenom")
	    private String prenom;
	    
	    public Participant() {
	        
	    }
	    
	    public Participant(Long id, String nom, String prenom) {
	        this.id = id;
	        this.nom = nom;
	        this.prenom = prenom;
	    }

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
