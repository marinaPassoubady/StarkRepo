import {Pokemon} from './pokemon';

export class Dresseur {
    public nom?: string;
    public prenom?: string;
    public mail?: string;
    public motDePasse?: string;
    public starter?: number;
    public pokemons?: Pokemon[];
    public solde?: number;

    constructor(nom: string, prenom: string, mail: string, motDePasse: string, starter: number, pokemons: Pokemon[]) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.starter = starter;
        this.pokemons = pokemons;
        this.solde = 300;
    }
}
