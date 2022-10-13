package com.example.webclient.controller;

import com.example.webclient.RickAndMortyService;
import com.example.webclient.model.RickAndMortyCharacterModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController
@RequestMapping("/api")
public class RickAndMortyController {

    RickAndMortyService apiService = new RickAndMortyService();

    @GetMapping("/character")
    public List<RickAndMortyCharacterModel> getAllCharacters() {

        return apiService.getAllCharacters();
    }

    @GetMapping("/character/")
    public List<RickAndMortyCharacterModel> getAllCharactersAlive(@RequestParam String status) {

        return apiService.getAllCharactersAlive(status);
    }

}
