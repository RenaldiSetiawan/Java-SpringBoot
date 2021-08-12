package com.backend.tourtraveljava.repository;

import com.backend.tourtraveljava.model.Tours;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToursRepository extends JpaRepository<Tours,Long> {
    
}
