package com.projetF.projetFinal.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetF.projetFinal.models.Participant;
import com.projetF.projetFinal.repository.ParticipantRepository;


@Service
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
