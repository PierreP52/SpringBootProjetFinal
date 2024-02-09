package com.projetF.controles;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetF.models.Reservation;
import com.projetF.service.ReservationService;



@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

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
