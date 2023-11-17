package com.barclays.controller;


import com.barclays.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MemberControllerIntegrationTest {

    @Autowired
    MemberController memberController;

    @Test
    public void testGetAllMembers() {
        List<Member> members = memberController.getAllMembers("");
        assertEquals(3, members.size());
    }

    @Test
    public void testGetAllMemberByNameAndrew() {
        List<Member> members = memberController.getAllMembers("Andrew");
        assertEquals(1, members.size());
    }

    @Test
    public void testGetAllMemberByNameClaire() {
        List<Member> members = memberController.getAllMembers("Claire");
        assertEquals(1, members.size());
    }

    @Test
    public void testGetAllMemberByNameHarry() {
        List<Member> members = memberController.getAllMembers("Harry");
        assertEquals(1, members.size());
    }

    @Test
    public void testGetMember1() {
        Member member = memberController.getMember(1);
        assertEquals("Andrew", member.getName());
    }

    @Test
    public void testGetMember2() {
        Member member = memberController.getMember(2);
        assertEquals("Claire", member.getName());
    }

    @Test
    public void testGetMember3() {
        Member member = memberController.getMember(3);
        assertEquals("Harry", member.getName());
    }
}
