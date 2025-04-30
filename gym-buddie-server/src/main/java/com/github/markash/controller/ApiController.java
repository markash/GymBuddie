package com.github.markash.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.markash.model.Workout;

@RestController
@CrossOrigin
public class ApiController {
    
    @GetMapping(path = "/workouts")
    public List<Workout> getWorkouts() {

        return HomeController.workouts;
    }
}
