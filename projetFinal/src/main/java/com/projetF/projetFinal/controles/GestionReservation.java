package com.projetF.projetFinal.controles;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetF.projetFinal.models.Artisan;
import com.projetF.projetFinal.models.Atelier;
import com.projetF.projetFinal.models.NouvelleReservation;
import com.projetF.projetFinal.models.Participant;
import com.projetF.projetFinal.models.Reservation;
import com.projetF.projetFinal.service.ArtisanService;
import com.projetF.projetFinal.service.AtelierService;
import com.projetF.projetFinal.service.ParticipanService;
import com.projetF.projetFinal.service.ReservationService;

@Controller
public class GestionReservation {

    @GetMapping("/")
    public String showIndexPage() {
        return "index"; 
    }
    
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/annulerReservation")
    public String annulerReservation(Model model) {
    	
    	List<Reservation> reservations = reservationService.getAllReservations();
        
        // Ajouter la liste d'ateliers au modèle pour l'affichage dans la vue
        model.addAttribute("reservations", reservations);
    	
        return "annulerReservation"; 
    }

    @DeleteMapping("/annulerReservation/{reservationId}")
    public String cancelReservation(@PathVariable Long reservationId, RedirectAttributes redirectAttributes) {
        try {
            reservationService.annulerReservation(reservationId);
            redirectAttributes.addFlashAttribute("successMessage", "La réservation a été annulée avec succès.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "La réservation avec l'ID " + reservationId + " n'existe pas.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Une erreur s'est produite lors de l'annulation de la réservation.");
        }
        return "redirect:/index"; // Redirection vers la page d'index
    }
    
    @Autowired
    private AtelierService atelierService;

    @GetMapping("/listAteliers")
    public String showlistAteliersPage(Model model) {
        // Récupérer la liste de tous les ateliers
        List<Atelier> ateliers = atelierService.getAllAteliers();
        
        // Ajouter la liste d'ateliers au modèle pour l'affichage dans la vue
        model.addAttribute("ateliers", ateliers);
        
        // Retourner le nom de la vue correspondante
        return "listAteliers";
    }
    
    @Autowired
    private ParticipanService participanService;
    
    @Autowired
    private ArtisanService artisanService;
    
    

    @GetMapping("/reservationAtelier")
    public String showreservationAtelierPage(Model model) {
        
        NouvelleReservation nouvelleReservation = new NouvelleReservation(null, null, null, null);
        model.addAttribute("nouvelleReservation", nouvelleReservation);
        
        List<Participant> participants = participanService.getAllParticipants();
        model.addAttribute("participants", participants);
        
        List<Atelier> ateliers = atelierService.getAllAteliers();
        model.addAttribute("ateliers", ateliers);
        
        return "reservationAtelier";
    }

    @PostMapping("/reservationAtelier/creneau")
    public String reserverCreneau(NouvelleReservation nouvelleReservation,
            RedirectAttributes redirectAttributes) {
        try {
        	// Utilisation du service pour récupérer l'atelier correspondant à l'atelierId
        	
            Atelier atelier = atelierService.getAtelierById(nouvelleReservation.getAtelierId());
            // Récupération de l'artisanId de cet atelier
            Long artisanId = atelier.getArtisanId();
            reservationService.reserverCreneau(nouvelleReservation.getDateDebut(), nouvelleReservation.getDateFin(), nouvelleReservation.getParticipantId(), nouvelleReservation.getAtelierId(), artisanId);
            redirectAttributes.addFlashAttribute("successMessage", "La réservation a été effectuée avec succès.");
            return "redirect:/index"; // Redirection vers la page d'index
        } catch (IllegalArgumentException e) {
            // Gérer l'exception
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de la réservation.");
            return "redirect:/error"; // Redirection vers une page d'erreur
        } catch (Exception e) {
            // Gérer l'exception
            redirectAttributes.addFlashAttribute("errorMessage", "Une erreur interne s'est produite.");
            return "redirect:/error"; // Redirection vers une page d'erreur
        }
    }
}
