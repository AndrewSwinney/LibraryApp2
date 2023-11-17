package com.barclays.service;


import com.barclays.model.Member;
import org.aspectj.bridge.Message;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findById(int id);

    List<Member> findByNameContains(String filter);
}
