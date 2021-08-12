package com.backend.tourtraveljava.services;

import java.util.List;
import java.util.Optional;

import com.backend.tourtraveljava.model.ToursImages;
import com.backend.tourtraveljava.repository.ToursImagesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToursImagesServiceImplement implements ToursImagesService{

    @Autowired
    private ToursImagesRepository toursImagesRepository;

    @Override
    public List<ToursImages> findAllToursImages() {
        
        return toursImagesRepository.findAll();
    }

    @Override
    public ToursImages addToursImages(ToursImages toursImages) {
        
        return toursImagesRepository.save(toursImages);
    }

    @Override
    public Optional<ToursImages> findToursImagesById(Long id) {
        
        return toursImagesRepository.findById(id);
    }

    @Override
    public void deleteToursImagesById(Long id) {
        
        toursImagesRepository.deleteById(id);
        
    }
    

}
