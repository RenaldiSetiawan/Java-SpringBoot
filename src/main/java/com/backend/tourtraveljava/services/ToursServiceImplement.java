package com.backend.tourtraveljava.services;

import java.util.List;
import java.util.Optional;

import com.backend.tourtraveljava.model.Tours;
import com.backend.tourtraveljava.repository.ToursRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToursServiceImplement implements ToursService{

    @Autowired
    private ToursRepository toursRepository;

    @Override
    public List<Tours> findAllTours() {
        
        return toursRepository.findAll();
    }

    @Override
    public Tours addTours(Tours tours) {
       
        return toursRepository.save(tours);
    }

    @Override
    public Tours editTours(Tours tours) {
       
        return toursRepository.save(tours);
    }

    @Override
    public Optional<Tours> findToursById(Long id) {
       
        return toursRepository.findById(id);
    }

    @Override
    public void deleteToursById(Long id) {
       
        toursRepository.deleteById(id);
    }    

}
