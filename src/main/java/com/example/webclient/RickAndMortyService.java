package com.example.webclient;
import com.example.webclient.model.RickAndMortyCharacterModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.webclient.response.RickAndMortyCharacterResponse;

import java.util.List;
@Service
public class RickAndMortyService {
    private WebClient client = WebClient.create("https://rickandmortyapi.com/api");
//    @Value("${url}")
//    private String url;


    public List<RickAndMortyCharacterModel> getAllCharacters() {

        RickAndMortyCharacterResponse responseFromApi = client.
                get().uri("/character")
                .retrieve()
                .toEntity(RickAndMortyCharacterResponse.class)
                .block()
                .getBody();
        return responseFromApi.getResults();
    }

    public List<RickAndMortyCharacterModel> getAllCharactersAlive(String status) {
        RickAndMortyCharacterResponse responseFromApi = client
                .get().uri("/character/?status="+status)
                .retrieve()
                .toEntity(RickAndMortyCharacterResponse.class)
                .block()
                .getBody();
        return responseFromApi.getResults();
    }
}
