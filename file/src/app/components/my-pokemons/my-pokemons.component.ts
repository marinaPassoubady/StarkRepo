import { Component } from '@angular/core';

@Component({
  selector: 'app-my-pokemons',
  templateUrl: './my-pokemons.component.html',
  styleUrls: ['./my-pokemons.component.css']
})
export class MyPokemonsComponent {
  public dresseur;

  constructor() {
    this.dresseur = JSON.parse(localStorage.getItem('CurrentUser'));
  }
}
