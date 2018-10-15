package com.example.server.repository;

import com.example.server.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
}
