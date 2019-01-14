package com.example.springbootexceptionhandling.bird;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootexceptionhandling.BirdNotFoundException;
import com.example.springbootexceptionhandling.EntityNotFoundException;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

    public Bird getBirdNoException(Long birdId) throws EntityNotFoundException {
        
        Optional<Bird> bird = birdRepository.findById(birdId);
        
        if (bird.isPresent()) {
        	return bird.get();
        } else {
        	 throw new EntityNotFoundException(Bird.class, "id", birdId.toString());
        }
    	
    }

    public Bird getBird(Long birdId) throws EntityNotFoundException {
    	
    	 Optional<Bird> bird = birdRepository.findById(birdId);
    	if (!bird.isPresent()) {
            throw new EntityNotFoundException(Bird.class, "id", birdId.toString());
        }
        return bird.get();
    }

    public Bird createBird(Bird bird) {
        return birdRepository.save(bird);
    }

    public List<Bird> getBirdCollection(BirdCollection birdCollection) throws EntityNotFoundException {
        List<Bird> birds = new ArrayList<>();

        for (Long birdId : birdCollection.getBirdsIds()) {
            Optional<Bird> bird = birdRepository.findById(birdId);
            if (!bird.isPresent()) {
                throw new EntityNotFoundException(Bird.class, "id", birdId.toString());
            }
            birds.add(bird.get());
        }
        return birds;
    }

	public Bird getBirdRuntimeException(Long birdId)  {
	     Optional<Bird> bird = birdRepository.findById(birdId);
	        if (!bird.isPresent()) {
	            throw new BirdNotFoundException(Bird.class, "id", birdId.toString());
	        }
	        return bird.get();
	}
}
