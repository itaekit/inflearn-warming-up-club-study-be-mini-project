package com.warmingup.inhouseapp.domain.team;

public class TeamInfo {
    private String name;
    private String mananger;
    private Long memberCount;

    public TeamInfo(String name, String mananger, Long memberCount) {
        this.name = name;
        this.mananger = mananger;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }

    public String getMananger() {
        return mananger;
    }

    public Long getMemberCount() {
        return memberCount;
    }
}
