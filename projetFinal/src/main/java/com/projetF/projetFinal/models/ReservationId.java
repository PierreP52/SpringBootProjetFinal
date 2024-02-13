package com.projetF.projetFinal.models;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ReservationId implements Serializable {
	
	@Column(name = "participant_id", insertable = false, updatable = false)
	private long participant_id;
	
	@Column(name = "artisan_id", insertable = false, updatable = false)
	private long artisan_id;
	
	@Column(name = "atelier_id", insertable = false, updatable = false)
    private long atelier_id;
	
	public ReservationId() {
    }

    public ReservationId(long participant_id, long artisan_id, long atelier_id) {
        this.participant_id = participant_id;
        this.artisan_id = artisan_id;
        this.atelier_id = atelier_id;
    }

    // Getters et setters
    public long getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(long participant_id) {
        this.participant_id = participant_id;
    }

    public long getArtisan_id() {
        return artisan_id;
    }

    public void setArtisan_id(long artisan_id) {
        this.artisan_id = artisan_id;
    }
    
    public long getAtelier_id() {
        return atelier_id;
    }

    public void setAtelier_id(long atelier_id) {
        this.atelier_id = atelier_id;
    }

    // Equals et hashCode 

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationId that = (ReservationId) o;
        if (participant_id != that.participant_id) return false;
        if (artisan_id != that.artisan_id) return false;
        return atelier_id == that.atelier_id;
    }

    @Override
    public int hashCode() {
    	long result = participant_id;
        result = 31 * result + artisan_id;
        result = 31 * result + atelier_id;
        return (int) result;
    }

}
