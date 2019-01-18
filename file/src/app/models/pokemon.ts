export class Pokemon {
    public order?: string; // n° dans le pokedex, id.
    public name?: string;
    public type?: string[];
    public attack?: string[];
    public height?: number;
    public weight?: number;
    public sprite?: string;

    public sexe?: string;
    public price?: number;
    public level?: number;
    public xp: number;


    constructor() {
        this.xp = 0;
    }

    mapResponseToPokemon(pokemon: any) {
        this.order = pokemon.id;
        if ( parseInt(this.order, 10) < 100) {
            this.order =  parseInt(this.order, 10) < 10 ?  '00' + this.order : '0' + this.order;
        }
        this.name = pokemon.name.toUpperCase();
        this.type = [];
        pokemon.types.forEach((type) => {
            this.type.push(type.type.name);
        });
        this.attack = [];
        for (let i = 0; i < 4 ; i++) {
            this.attack.push(pokemon.moves[Math.floor(Math.random() * (pokemon.moves.length - 0))].move.name); // [0 - length[
        }
        this.height = pokemon.height / 10;
        this.weight = pokemon.weight / 10;
        this.sprite = pokemon.sprites.front_default;
        this.sexe = (Math.random() >= 0.5) ? 'Female' : 'Male';
        this.price = Math.floor(Math.random() * (100 - 1 + 1)) + 1; // [0-100]
        this.level = Math.floor(Math.random() * (99 - 1 + 1)) + 1;  // [0-99]
    }

}
