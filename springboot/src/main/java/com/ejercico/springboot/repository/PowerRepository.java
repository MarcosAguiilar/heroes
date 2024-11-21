package com.ejercico.springboot.repository;

import com.ejercico.springboot.model.Power;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerRepository extends JpaRepository<Power, Integer> {
}
