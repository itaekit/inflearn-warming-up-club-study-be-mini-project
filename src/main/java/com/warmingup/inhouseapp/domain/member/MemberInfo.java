package com.warmingup.inhouseapp.domain.member;

import java.time.LocalDate;

public class MemberInfo {
    private String name;
    private String teamName;
    private String role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public MemberInfo(Member member) {
        this.name = member.getName();
        this.teamName = member.getTeamName();
        this.role = member.getIsManager() ? "MANAGER" : "MEMBER";
        this.birthday = member.getBirthday();
        this.workStartDate = member.getWorkStartDate();
    }

    public String getName() {
        return name;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getRole() {
        return role;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }
}
