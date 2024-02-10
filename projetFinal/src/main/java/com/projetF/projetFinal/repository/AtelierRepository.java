package com.projetF.projetFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetF.projetFinal.models.Atelier;

@Repository
public interface AtelierRepository extends JpaRepository<Atelier, Long> {
}
