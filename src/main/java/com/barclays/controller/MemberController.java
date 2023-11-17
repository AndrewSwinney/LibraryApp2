package com.barclays.controller;


import com.barclays.model.Member;
import com.barclays.service.MemberService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;

    }

    @GetMapping("/members")
    public List<Member> getAllMembers(@PathParam("filter") String filter) {
        log.debug("In the getAll Members method");
        List<Member> members = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)) {
            log.debug("In the getAll Members method: " + filter);
            members = memberService.findByNameContains(filter);
        }
        else {
            members = memberService.findAll();
        }
        return members;
    }

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable int id) {
        log.debug("In the getMember method: " + id);
        return memberService.findById(id);
    }
}
