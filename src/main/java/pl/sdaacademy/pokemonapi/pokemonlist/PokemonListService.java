package pl.sdaacademy.pokemonapi.pokemonlist;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PokemonListService {
    private final FetchPokemonListUseCase pokemonListUseCase;

    PokemonListService(FetchPokemonListUseCase pokemonListUseCase) {
        this.pokemonListUseCase = pokemonListUseCase;
    }

    List<PokemonListItemEntity> getPokemonItemList() {
        return pokemonListUseCase.execute();
    }
}