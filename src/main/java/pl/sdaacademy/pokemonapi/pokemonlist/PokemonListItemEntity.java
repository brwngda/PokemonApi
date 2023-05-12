package pl.sdaacademy.pokemonapi.pokemonlist;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonListItemEntity {
    @Id
    private Long id;

    private String name;
}