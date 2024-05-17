package com.warmingup.inhouseapp.service;

import com.warmingup.inhouseapp.domain.member.Member;
import com.warmingup.inhouseapp.domain.member.MemberInfo;
import com.warmingup.inhouseapp.domain.member.MemberRepository;
import com.warmingup.inhouseapp.domain.team.TeamRepository;
import com.warmingup.inhouseapp.dto.member.request.MemberCreateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    public void saveMember(MemberCreateRequest request) {
        boolean isExistingTeam = teamRepository.existsByName(request.getTeamName());
        if (!isExistingTeam) {
            throw new IllegalArgumentException("Team does not exist");
        }

        boolean isExistingMember = memberRepository.existsByNameAndBirthday(request.getName(), request.getBirthday());
        if (isExistingMember) {
            throw new IllegalArgumentException("Member already exists");
        }

        memberRepository.save(new Member(request));
    }

    public List<MemberInfo> getAllMemberInfo() {
        List<Member> memberList = memberRepository.findAll();
        List<MemberInfo> memberInfoList = new ArrayList<>();

        for (Member member : memberList) {
            memberInfoList.add(new MemberInfo(member));
        }

        return memberInfoList;
    }
}
