package com.example.webclient.response;

import lombok.Data;
import com.example.webclient.model.RickAndMortyCharacterModel;

import java.util.List;

@Data
public class RickAndMortyCharacterResponse {
    List<RickAndMortyCharacterModel> results;
}
