package com.warmingup.inhouseapp.controller;

import com.warmingup.inhouseapp.dto.member.request.MemberCreateRequest;
import com.warmingup.inhouseapp.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
