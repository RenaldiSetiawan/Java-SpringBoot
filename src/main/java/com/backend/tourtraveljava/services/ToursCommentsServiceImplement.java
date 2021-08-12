package com.backend.tourtraveljava.services;

import java.util.List;
import java.util.Optional;

import com.backend.tourtraveljava.model.ToursComments;
import com.backend.tourtraveljava.repository.ToursCommentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToursCommentsServiceImplement implements ToursCommentsService {

    @Autowired
    private ToursCommentsRepository toursCommentsRepository;

    @Override
    public List<ToursComments> findAllToursComments() {
        
        return toursCommentsRepository.findAll();
    }

    @Override
    public ToursComments addToursComments(ToursComments toursComments) {
        
        return toursCommentsRepository.save(toursComments);
    }

    @Override
    public Optional<ToursComments> findToursCommentsById(Long id) {
        
        return toursCommentsRepository.findById(id);
    }

    @Override
    public void deleteToursCommentsById(Long id) {
        
        toursCommentsRepository.deleteById(id);
        
    }
    
}
