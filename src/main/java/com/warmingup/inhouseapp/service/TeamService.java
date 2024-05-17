package com.warmingup.inhouseapp.service;

import com.warmingup.inhouseapp.domain.member.Member;
import com.warmingup.inhouseapp.domain.member.MemberRepository;
import com.warmingup.inhouseapp.domain.team.Team;
import com.warmingup.inhouseapp.domain.team.TeamInfo;
import com.warmingup.inhouseapp.domain.team.TeamRepository;
import com.warmingup.inhouseapp.dto.team.request.TeamCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    public TeamService(TeamRepository teamRepository, MemberRepository memberRepository) {
        this.teamRepository = teamRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void saveTeam(TeamCreateRequest request) {
        boolean isExistingTeam = teamRepository.existsByName(request.getName());

        if (isExistingTeam) {
            throw new IllegalArgumentException("Team already exists!");
        }

        teamRepository.save(new Team(request.getName()));
    }

    @Transactional(readOnly = true)
    public List<TeamInfo> getAllTeamInfo() {
        List<Team> teamList = teamRepository.findAll();
        List<TeamInfo> teamInfoList = new ArrayList<>();

        for (Team team : teamList) {
            String teamName = team.getName();
            String managerName;
            List<Member> memberList = memberRepository.findByTeamName(teamName);

            Member manager = memberList
                    .stream()
                    .filter(m->m.getIsManager())
                    .findFirst()
                    .orElse(null);

            if (manager == null) {
                managerName = null;
            } else {
                managerName = manager.getName();
            }

            Long memberCount = memberList.stream().count();
            teamInfoList.add(new TeamInfo(teamName, managerName, memberCount));
        }

        return teamInfoList;
    }
}
