package com.example.pathfinder.infrastructure.citycrud.controller;

import com.example.pathfinder.domain.citycrud.CityCrudFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
class CityCrudRestController {

    private final CityCrudFacade cityCrudFacade;

    @GetMapping("/cities")
    public String getCity() {
        return "Hello world";
    }


}
