package com.warmingup.inhouseapp.controller;

import com.warmingup.inhouseapp.dto.member.response.MemberInfoResponse;
import com.warmingup.inhouseapp.dto.member.request.MemberCreateRequest;
import com.warmingup.inhouseapp.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public void saveMember(@RequestBody MemberCreateRequest request) {
        memberService.saveMember(request);
    }

    @GetMapping
    public List<MemberInfoResponse> getAllMemberInfo() {
        return memberService.getAllMemberInfo();
    }
}
