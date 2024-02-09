package com.projetF.controles;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projetF.models.Atelier;
import com.projetF.models.Reservation;
import com.projetF.service.AtelierService;
import com.projetF.service.ReservationService;

@Controller
public class GestionReservation {

    @GetMapping("/")
    public String showIndexPage() {
        return "listAteliers"; 
    }
    
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/annulerReservation")
    public String annulerReservation() {
        return "annulerReservation"; 
    }

    /*@DeleteMapping("/annulerReservation/{reservationId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long reservationId, Model model) {
        try {
            reservationService.annulerReservation(reservationId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
   }*/
    
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
    

    @GetMapping("/reservationAtelier")
    public String showreservationAtelierPage() {
        return "reservationAtelier"; 
    }

    @PostMapping("/reservationAtelier/creneau")
    public ResponseEntity<Reservation> reserverCreneau(@RequestBody Reservation nouvelleReservation) {
        try {
            Reservation reservation = reservationService.reserverCreneau(nouvelleReservation);
            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
  
    


