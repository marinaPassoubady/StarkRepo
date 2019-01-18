import { Component, OnInit } from '@angular/core';
import {Pokemon} from '../../models/pokemon';
import {PokedexService} from '../../services/pokedex/pokedex.service';
import {Dresseur} from '../../models/dresseur';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-pokemon-detail',
  templateUrl: './pokemon-detail.component.html',
  styleUrls: ['./pokemon-detail.component.scss']
})
export class PokemonDetailComponent implements OnInit {
    public dresseur: Dresseur;
    id: string;
    pokemon: Pokemon;
    constructor(private route: ActivatedRoute) {
        this.dresseur = JSON.parse(localStorage.getItem('CurrentUser'));
        // Recuperer l'id de l'url
        this.route.params.subscribe(params => {
            this.id = params['id'];
        });
    }

    ngOnInit() {
        this.dresseur.pokemons.forEach(x => {
            console.log(x.order);
            if (x.order === this.id) {
                this.pokemon = x;
            }
        });

    }
}
