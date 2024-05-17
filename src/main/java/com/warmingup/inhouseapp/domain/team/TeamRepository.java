package com.warmingup.inhouseapp.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsByName(String name);
}
