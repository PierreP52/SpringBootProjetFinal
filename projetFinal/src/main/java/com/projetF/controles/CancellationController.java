package com.projetF.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.projetF.service.ReservationService;

@Controller
public class CancellationController {

	@Autowired
    private ReservationService reservationService;

    @GetMapping("/annulerReservation")
    public String showAnnulerReservationPage() {
        return "annulerReservation"; 
    }

    @DeleteMapping("/annulerReservation/{reservationId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long reservationId, Model model) {
        try {
            reservationService.annulerReservation(reservationId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
