package com.warmingup.inhouseapp.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByNameAndBirthday(String name, LocalDate birthday);
}
