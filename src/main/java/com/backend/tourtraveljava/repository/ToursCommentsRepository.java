package com.backend.tourtraveljava.repository;

import com.backend.tourtraveljava.model.ToursComments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToursCommentsRepository extends JpaRepository<ToursComments, Long>{
    
}
