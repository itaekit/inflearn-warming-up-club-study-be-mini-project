package com.warmingup.inhouseapp.dto.member.request;

import java.time.LocalDate;

public class MemberCreateRequest {

    private String name;
    private String teamName;
    private boolean isManager;
    private LocalDate workStartDate;
    private LocalDate birthday;

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
