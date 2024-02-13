package com.projetF.projetFinal.models;

import java.sql.Date;

import java.time.LocalDateTime;
import java.util.Objects;


import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.projetF.projetFinal.models.ReservationId;
import com.projetF.projetFinal.models.Participant;
import com.projetF.projetFinal.models.Artisan;
import com.projetF.projetFinal.models.Atelier;


@Entity
@Table(name = "Reservation")
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_debut")
    private LocalDateTime dateDebut;
    
    @Column(name = "date_fin")
    private LocalDateTime dateFin;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "artisan_id")
    private Artisan artisan;
    
    @ManyToOne
    @JoinColumn(name = "atelier_id")
    private Atelier atelier;
    
    
    private Long atelierId;
    
    private Long participantId;
    
    private Long artisanId;
	
    public Reservation() {
    }

    public Reservation(LocalDateTime dateDebut, LocalDateTime dateFin, Long atelierId, Long participantId, Long artisanId) {
        
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.atelierId = atelierId;
        this.participantId = participantId;
        this.artisanId = artisanId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    
    public Long getArtisanId() {
        return artisanId;
    }
    
    public void setArtisanId(Long artisanId) {
        this.artisanId = artisanId;
    }

    public Long getParticipantId() {
        return participantId;
    }
    
    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }
    
    public Long getAtelierId() {
        return atelierId;
    }

    public void setAtelierId(Long atelierId) {
        this.atelierId = atelierId;
    }
    
    public Atelier getAtelier() {
        return atelier;
    }
    
    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }
    
    public Artisan getArtisan() {
        return artisan;
    }

    public void setArtisan(Artisan artisan) {
        this.artisan = artisan;
    }
    
    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(dateDebut, that.dateDebut) &&
               Objects.equals(dateFin, that.dateFin) &&
               Objects.equals(participant, that.participant) &&
               Objects.equals(artisan, that.artisan) &&
               Objects.equals(atelier, that.atelier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateDebut, dateFin, participant, artisan, atelier);
    }

    @Override
    public String toString() {
        return "Reservation{" +
               "id=" + id +
               ", dateDebut=" + dateDebut +
               ", dateFin=" + dateFin +
               ", participant=" + participant +
               ", artisan=" + artisan +
               ", atelier=" + atelier +
               '}';
    }
}