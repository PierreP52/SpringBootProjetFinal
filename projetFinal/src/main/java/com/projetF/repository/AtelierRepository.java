package com.projetF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetF.models.Atelier;

@Repository
public interface AtelierRepository extends JpaRepository<Atelier, Long> {
}
