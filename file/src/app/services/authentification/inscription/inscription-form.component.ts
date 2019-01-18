import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PokedexService} from '../../pokedex/pokedex.service';
import {Pokemon} from '../../../models/pokemon';
import {Dresseur} from '../../../models/dresseur';
import {Router} from '@angular/router';

@Component({
    selector: 'app-inscription-form',
    templateUrl: './inscription-form.component.html',
    styleUrls: ['./inscription-form.component.css']
})
export class InscriptionFormComponent {
    public pokeForm: FormGroup;
    public nom: string;
    public prenom: string;
    public mail: string;
    public motDePasse: string;
    public starter: number;
    public starterIds = [25, 1, 4];
    public starters: Pokemon[];
    public dresseur;
    public allDresseurs = [];

    constructor(
        private _formBuilder: FormBuilder,
        private pokedexService: PokedexService,
        public router: Router
    ) {
        this.pokeForm = _formBuilder.group({
            nom: ['', Validators.required],
            prenom: ['', Validators.required],
            mail: ['', Validators.required],
            motDePasse: ['', Validators.required],
            starter: ['', Validators.required]
        });
        this.fetchStarters();
    }


    public validate() {
        this.nom = this.pokeForm.get('nom').value;
        this.prenom = this.pokeForm.get('prenom').value;
        this.mail = this.pokeForm.get('mail').value;
        this.motDePasse = this.pokeForm.get('motDePasse').value;
        this.starter = this.pokeForm.get('starter').value;

        const pokeStarter = this.starterIdToPokemon(this.starter);
        const dresseur = new Dresseur(this.nom, this.prenom, this.mail, this.motDePasse, this.starter, [pokeStarter]);
        this.dresseur = dresseur;
        this.allDresseurs.push(dresseur);

        const key = 'allDresseurs';
        const value = this.allDresseurs;
        localStorage.setItem(key, JSON.stringify(value));

        this.router.navigate(['/login']);
    }

    private fetchStarters() {
        this.starters = [];

        this.starterIds.forEach(id => {
             this.pokedexService.getPokemonById(id).subscribe(
             (response) => {
                    const p = new Pokemon();
                    p.mapResponseToPokemon(response);
                    this.starters.push(p);
                }, (error) => {
                    console.log('Erreur dans getListeVente', error);
             });
        });

    }

    private starterIdToPokemon(starterId) {
        return this.starters.find(pokemon => pokemon.order === starterId);
    }

}
