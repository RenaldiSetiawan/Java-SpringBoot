package com.backend.tourtraveljava.repository;

import com.backend.tourtraveljava.model.ToursImages;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToursImagesRepository extends JpaRepository<ToursImages, Long>  {
    
}
