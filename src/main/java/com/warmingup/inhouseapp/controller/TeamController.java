package com.warmingup.inhouseapp.controller;

import com.warmingup.inhouseapp.dto.team.response.TeamInfoResponse;
import com.warmingup.inhouseapp.dto.team.request.TeamCreateRequest;
import com.warmingup.inhouseapp.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public void saveTeam(@RequestBody TeamCreateRequest request) {
        teamService.saveTeam(request);
    }

    @GetMapping
    public List<TeamInfoResponse> getAllTeamInfo() {
        return teamService.getAllTeamInfo();
    }
}
