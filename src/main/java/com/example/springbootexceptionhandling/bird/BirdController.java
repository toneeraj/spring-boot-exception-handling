package com.example.springbootexceptionhandling.bird;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootexceptionhandling.EntityNotFoundException;

@RestController
@RequestMapping("/birds")
public class BirdController {

    @Autowired
    private BirdService birdService;

    @GetMapping(value = "/{birdId}")
    public Bird getBird(@PathVariable("birdId") Long birdId) throws EntityNotFoundException {
        return birdService.getBird(birdId);
    }

    @GetMapping(value = "/collection")
    public List<Bird> getBirdValid(@RequestBody BirdCollection birdCollection) throws EntityNotFoundException {
        return birdService.getBirdCollection(birdCollection);
    }

    @GetMapping(value = "/params")
    public Bird getBirdRequestParam(@RequestParam("birdId") Long birdId) throws EntityNotFoundException {
        return birdService.getBird(birdId);
    }

    @GetMapping(value = "/noexception/{birdId}")
    public Bird getBirdNoException(@PathVariable("birdId") Long birdId) throws EntityNotFoundException {
        return birdService.getBirdNoException(birdId);
    }
    
    @GetMapping(value = "/runtimeexception/{birdId}")
    public Bird getBirdRunTimeException(@PathVariable("birdId") Long birdId) {
        return birdService.getBirdRuntimeException(birdId);
    }


    @PostMapping
    public Bird createBird(@RequestBody @Valid Bird bird) {
        return birdService.createBird(bird);
    }

}
