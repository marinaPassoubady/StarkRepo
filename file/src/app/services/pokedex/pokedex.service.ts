import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class PokedexService {

  constructor(private _httpClient: HttpClient) { }

    getPokemonById(id: number): Observable<any> {
        return this._httpClient.get<any>('https://pokeapi.co/api/v2/pokemon/' + id + '/');
    }

    getAllPokemon(): Observable<any> {
        return this._httpClient.get<any>('https://pokeapi.co/api/v2/pokemon/');
    }
}
