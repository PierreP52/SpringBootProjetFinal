package com.projetF.projetFinal.models;




import jakarta.persistence.Column;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Atelier")
public class Atelier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "BIGINT")
    private Long id;
    
    
    @Column(name = "nom", nullable = false)
    private String nom;

    
    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artisan_id", referencedColumnName = "id", nullable = false)
    private Artisan artisan;
    
    public Atelier() {
        
    }
    
    public Atelier(Long id, String nom, String description, Artisan artisan) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.artisan = artisan;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Artisan getArtisan() {
        return artisan;
    }

    public void setArtisan(Artisan artisan) {
        this.artisan = artisan;
    }

    public Long getArtisanId() {
        return artisan.getId();
    }

    


    
}
