package pl.sdaacademy.pokemonapi.pokemonlist;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PokemonListService {
    private final FetchPokemonListUseCase pokemonListUseCase;
    private final PokemonListItemRepository pokemonListItemRepository;

    PokemonListService(FetchPokemonListUseCase pokemonListUseCase, PokemonListItemRepository pokemonListItemRepository) {
        this.pokemonListUseCase = pokemonListUseCase;
        this.pokemonListItemRepository = pokemonListItemRepository;
    }

    List<PokemonListItemEntity> getPokemonItemList() {
        if (pokemonListItemRepository.count() != 0) {
            return pokemonListItemRepository.findAll();
        } else {
            return pokemonListUseCase.execute();
        }
    }
}