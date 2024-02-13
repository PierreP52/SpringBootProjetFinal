package com.projetF.projetFinal.models;

public class NouvelleReservation {
    private String dateDebut;
    private String dateFin;
    private Long participantId;
    private Long atelierId;

    // Constructeur
    public NouvelleReservation(String dateDebut, String dateFin, Long participantId, Long atelierId) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.participantId = participantId;
        this.atelierId = atelierId;
    }

    // Getters et setters
    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
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
}
