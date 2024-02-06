package com.projetF.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.projetF.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findByAtelierId(Long atelierId);
}
