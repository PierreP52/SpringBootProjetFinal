package com.projetF.projetFinal.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;


import jakarta.persistence.FetchType;

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

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Participant participant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artisan_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Artisan artisan;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atelier_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Atelier atelier;
	
    public Reservation() {
    }

    public Reservation(ReservationId id, LocalDateTime dateDebut, LocalDateTime dateFin, Atelier atelier) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.atelier = atelier;
    }

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