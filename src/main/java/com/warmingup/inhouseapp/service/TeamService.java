package com.warmingup.inhouseapp.service;

import com.warmingup.inhouseapp.domain.team.Team;
import com.warmingup.inhouseapp.domain.team.TeamRepository;
import com.warmingup.inhouseapp.dto.team.request.TeamCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveTeam(TeamCreateRequest request) {
        boolean isExistingTeam = teamRepository.existsByName(request.getName());

        if (isExistingTeam) {
            throw new IllegalArgumentException("Team already exists!");
        }

        teamRepository.save(new Team(request.getName()));
    }
}
