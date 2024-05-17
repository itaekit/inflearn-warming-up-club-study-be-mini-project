package com.warmingup.inhouseapp.dto.team.response;

public class TeamInfoResponse {
    private String name;
    private String mananger;
    private Long memberCount;

    public TeamInfoResponse(String name, String mananger, Long memberCount) {
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
