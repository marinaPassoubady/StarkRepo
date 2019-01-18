import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Pokemon} from '../models/pokemon';

@Injectable()
export class TrainingService {

    /**
     * Constructeur
     * @param {HttpClient} http
     */


    constructor(private http: HttpClient) {
    }

    getPokemonByName(name: string): Observable<any> {
        return this.http.get('https://pokeapi.co/api/v2/pokemon/' + name + '/');
    }

    getPokemonEvolutionSpecies(id: number): Observable<any> {
        return this.http.get('https://pokeapi.co/api/v2/pokemon-species/' + id + '/');
    }

    getPokemonEvolutionName(url: string): Observable<any> {
        return this.http.get(url);
    }

    trainPokemon(pokemonSelected: Pokemon) {
        // création d'une nouvelle version du pokemon reçu
        let pokemonTrained = this.clonePokemon(pokemonSelected);

        // On ajoute un nombre aléatoire au xp du pokemon
        this.updateXpAndLevel(pokemonTrained);

        return pokemonTrained;
    }

    getNewXp(oldXp: number): number {
        let randomXp = Math.floor(Math.random() * (100 - 1 + 1)) + 1; // [0-100]

        return oldXp + randomXp;
    }

    clonePokemon(pokemonSelected: Pokemon): Pokemon {

        let clone = new Pokemon();

        clone.order = pokemonSelected.order;
        clone.name = pokemonSelected.name;
        clone.type = pokemonSelected.type;
        clone.attack = pokemonSelected.attack;
        clone.height = pokemonSelected.height;
        clone.weight = pokemonSelected.weight;
        clone.sprite = pokemonSelected.sprite;
        clone.sexe = pokemonSelected.sexe;
        clone.price = pokemonSelected.price;
        clone.level = pokemonSelected.level;
        clone.xp = pokemonSelected.xp;

        return clone;
    }

    updateXpAndLevel(pokemon: Pokemon) {
        let newXp = this.getNewXp(pokemon.xp);

        let newLevel = pokemon.level;
        if (newXp > 100) {
            newLevel++;
            newXp = newXp - 100;
            // check evolution
        }

        pokemon.xp = newXp;
        pokemon.level = newLevel;
    }

}
