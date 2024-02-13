package com.projetF.projetFinal.service;

import java.time.LocalDateTime;
import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetF.projetFinal.models.Reservation;
import com.projetF.projetFinal.repository.ReservationRepository;



@Service
public class ReservationService {

	 @Autowired
	    private ReservationRepository reservationRepository;

	    // Méthodes de service pour la logique métier associée à l'entité Réservation
	    public List<Reservation> getAllReservations() {
	        return reservationRepository.findAll();
	    }
	    
	 // Méthode pour réserver un créneau avec vérification des conflits de réservation
	    public Reservation reserverCreneau(String dateDebut, String dateFin, Long participantId, Long atelierId, Long artisanId) {
	        // Récupérer les réservations existantes pour cet atelier
	    	List<Reservation> reservationsExistantes = reservationRepository.findByAtelierId(atelierId);
	        
	        // Vérifier s'il y a des conflits de réservation
	        for (Reservation reservation : reservationsExistantes) {
	            if (isOverlap(dateDebut, dateFin, reservation.getDateDebut(), reservation.getDateFin())) {
	                // Il y a un conflit de réservation
	                throw new IllegalArgumentException("Il y a un conflit de réservation pour cet atelier.");
	            }
	        }
	        
	        
	        Reservation nouvReservation = new Reservation( LocalDateTime.parse(dateDebut), LocalDateTime.parse(dateFin), atelierId, participantId, artisanId);
	        
	       // nouvReservation.setParticipantId(participantId);
	       // nouvReservation.setAtelierId(atelierId);
	       // nouvReservation.setArtisanId(artisanId);

	        // Aucun conflit de réservation, enregistrer la nouvelle réservation
	        return reservationRepository.save(nouvReservation);
	    }
	    
	 // Méthode pour vérifier si deux périodes se chevauchent
	    private boolean isOverlap(String start1, String end1, LocalDateTime localDateTime, LocalDateTime localDateTime2) {
	        LocalDateTime startDate1 = LocalDateTime.parse(start1);
	        LocalDateTime endDate1 = LocalDateTime.parse(end1);
	        LocalDateTime startDate2 = localDateTime;
	        LocalDateTime endDate2 = localDateTime2;

	        return startDate1.isBefore(endDate2) && endDate1.isAfter(startDate2);
	    }
	    
	 // Méthode pour annuler une réservation
	    public void annulerReservation(Long reservationId) {
	        // Ajoutez ici votre logique métier pour vérifier les autorisations, etc.
	        reservationRepository.deleteById(reservationId);
	    }
	    
	    
}
