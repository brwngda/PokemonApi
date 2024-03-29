package pl.sdaacademy.pokemonapi.pokemonlist;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
class PokemonListLoaderService {

    private final PokeApiListNetworkRepository pokeApiListNetworkRepository;
    private final PokemonListItemRepository pokemonListItemRepository;

    private final FetchPokemonListUseCase fetchPokemonListUseCase;

    public PokemonListLoaderService(PokeApiListNetworkRepository pokeApiListNetworkRepository,
                                    PokemonListItemRepository pokemonListItemRepository,
                                    FetchPokemonListUseCase fetchPokemonListUseCase) {
        this.pokeApiListNetworkRepository = pokeApiListNetworkRepository;
        this.pokemonListItemRepository = pokemonListItemRepository;
        this.fetchPokemonListUseCase = fetchPokemonListUseCase;
    }

    @PostConstruct
    void loadPokemonList() {
        long repoCount = pokemonListItemRepository.count();
        if (repoCount == 0) {
            fetchPokemonListUseCase.execute();
        } else {
            PokeApiListResult countResult = pokeApiListNetworkRepository.fetchPokemonListResult(1, 0);
            int apiResponseCount = countResult.getCount();
            if (repoCount != apiResponseCount) {
                pokemonListItemRepository.deleteAll();
                fetchPokemonListUseCase.execute();
            }
        }
    }
}