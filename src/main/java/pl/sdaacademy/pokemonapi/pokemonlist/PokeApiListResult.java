package pl.sdaacademy.pokemonapi.pokemonlist;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokeApiListResult {

    private Integer count;
    private String next;
    private String previous;
    private List<PokeApiListItemResult> results;

}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class PokeApiListItemResult {
    private String name;
    private String url;

}
