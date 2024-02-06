package com.projetF.models;

import java.io.Serializable;

import jakarta.persistence.Column;

public class ReservationId implements Serializable {
	
	@Column(name = "participant_id")
	private int participant_id;
	
	@Column(name = "artisan_id")
	private int artisan_id;
	
	public ReservationId() {
    }

    public ReservationId(int participant_id, int artisan_id) {
        this.participant_id = participant_id;
        this.artisan_id = artisan_id;
    }

    // Getters et setters
    public int getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(int participant_id) {
        this.participant_id = participant_id;
    }

    public int getArtisan_id() {
        return artisan_id;
    }

    public void setArtisan_id(int artisan_id) {
        this.artisan_id = artisan_id;
    }

    // Equals et hashCode 

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationId that = (ReservationId) o;
        if (participant_id != that.participant_id) return false;
        return artisan_id == that.artisan_id;
    }

    @Override
    public int hashCode() {
        int result = participant_id;
        result = 31 * result + artisan_id;
        return result;
    }

}
