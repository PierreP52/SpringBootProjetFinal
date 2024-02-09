package com.projetF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetF.models.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}