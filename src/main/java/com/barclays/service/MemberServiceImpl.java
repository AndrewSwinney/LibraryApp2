package com.barclays.service;


import com.barclays.model.Member;
import com.barclays.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;
    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        Iterable<Member> memberIts = memberRepository.findAll();
        memberIts.forEach(members::add);
        return members;
    }

    @Override
    public Member findById(int id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.orElseGet(() -> new Member("Default Member: Nothing found"));
    }

    @Override
    public List<Member> findByNameContains(String filter) {
        return memberRepository.findByNameContains(filter);
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
