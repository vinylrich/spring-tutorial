package com.example.springtutorial.repository;

import com.example.springtutorial.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);//시퀀스를 1 더해주고(id값을 넣어줌)
        store.put(member.getId(),member);//스토어에 id값과 member 객체를 넣어줌
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(s`tore.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }
}
