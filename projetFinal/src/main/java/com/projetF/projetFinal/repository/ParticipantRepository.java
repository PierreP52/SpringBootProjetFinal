package com.projetF.projetFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetF.projetFinal.models.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}