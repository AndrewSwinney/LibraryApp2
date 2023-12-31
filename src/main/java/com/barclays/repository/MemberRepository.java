package com.barclays.repository;

import com.barclays.model.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Integer> {

    List<Member> findByNameContains(String filter);
}
