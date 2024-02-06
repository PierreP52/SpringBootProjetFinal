package com.projetFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetF.models.Reservation;
import com.projetF.repository.ReservationRepository;

public class ReservationService {

	 @Autowired
	    private ReservationRepository reservationRepository;

	    // Méthodes de service pour la logique métier associée à l'entité Réservation
	    public List<Reservation> getAllReservations() {
	        return reservationRepository.findAll();
	    }
	    
	 // Méthode pour réserver un créneau avec vérification des conflits de réservation
	    public Reservation reserverCreneau(Reservation nouvelleReservation) {
	        // Récupérer les réservations existantes pour cet atelier
	        List<Reservation> reservationsExistantes = reservationRepository.findByAtelierId(nouvelleReservation.getAtelier().getId());
	        
	        // Vérifier s'il y a des conflits de réservation
	        for (Reservation reservation : reservationsExistantes) {
	            if (nouvelleReservation.getDateDebut().isBefore(reservation.getDateFin()) &&
	                nouvelleReservation.getDateFin().isAfter(reservation.getDateDebut())) {
	                // Il y a un conflit de réservation
	                throw new IllegalArgumentException("Il y a un conflit de réservation pour cet atelier.");
	            }
	        }

	        // Aucun conflit de réservation, enregistrer la nouvelle réservation
	        return reservationRepository.save(nouvelleReservation);
	    }
	    
	 // Méthode pour annuler une réservation
	    public void annulerReservation(Long reservationId) {
	        // Ajoutez ici votre logique métier pour vérifier les autorisations, etc.
	        reservationRepository.deleteById(reservationId);
	    }
}
