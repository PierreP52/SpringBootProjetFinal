package com.projetF.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetF.models.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}