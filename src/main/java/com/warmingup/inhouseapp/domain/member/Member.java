package com.warmingup.inhouseapp.domain.member;

import com.warmingup.inhouseapp.dto.member.request.MemberCreateRequest;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String teamName;
    private boolean isManager;
    private LocalDate workStartDate;
    private LocalDate birthday;

    protected Member() {
    }

    public Member(MemberCreateRequest request) {
        this.name = request.getName();
        this.teamName = request.getTeamName();
        this.isManager = request.getIsManager();
        this.workStartDate = request.getWorkStartDate();
        this.birthday = request.getBirthday();

        System.out.println("2 > > > > " + isManager + " / " + request.getIsManager());
    }

    public String getName() {
        return name;
    }

    public String getTeamName() {
        return teamName;
    }

    public boolean getIsManager() {
        return isManager;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
