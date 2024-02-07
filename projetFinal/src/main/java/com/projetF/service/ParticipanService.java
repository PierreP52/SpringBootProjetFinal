package com.projetF.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.projetF.models.Participant;
import com.projetF.repository.ParticipantRepository;



public class ParticipanService {

	@Autowired
    private ParticipantRepository participantRepository;

    // Méthodes de service pour la logique métier associée à l'entité Participant
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }
    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

}
