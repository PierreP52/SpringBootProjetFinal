package com.projetF.models;

import java.time.LocalDateTime;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation {

	@EmbeddedId
    private ReservationId id;

    // Autres champs de la réservation
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    
    @ManyToOne
    @JoinColumn(name = "atelier_id", referencedColumnName = "id")
    private Atelier atelier;

    // Getters and setters
   
    public ReservationId getId() {
        return id;
    }

    public void setId(ReservationId id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }
    
    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }
    
    
}
