import {Component, Input} from '@angular/core';
import {NgbModalConfig, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Pokemon} from '../../models/pokemon';
import {TrainingService} from '../../services/training.service';

@Component({
    selector: 'app-training',
    templateUrl: './training.component.html',
    styleUrls: ['./training.component.scss'],
    providers: [NgbModalConfig, NgbModal, TrainingService]
})
export class TrainingComponent {
    // Pokemon à entrainer reçu en input
    @Input() pokemonSelected: Pokemon;
    // pokemon à retourner après entrainement
    pokemonFinal: Pokemon;
    pokemonTrained: Pokemon;
    private evolution_chain: string;
    hasEvolved: boolean;


    constructor(private trainingService: TrainingService, config: NgbModalConfig, private modalService: NgbModal) {
        // configuration de la modale
        config.backdrop = 'static';
        config.keyboard = false;

        this.hasEvolved = false;
    }

    launchTraining(modal) {
        // Affichage de la modale

        this.pokemonTrained = this.trainingService.trainPokemon(this.pokemonSelected);
        // si level augmenté alors vérif évolution
        // test - deux lignes à supp
        //this.pokemonTrained.level = 16;
        //this.pokemonSelected.level = 15;
        if (this.pokemonSelected.level < this.pokemonTrained.level) {
            this.evolvePokemon(this.pokemonTrained);

            // pokemonFinal = localstorage pok evol
            let pokemonTmp = localStorage.getItem('pokemon_evolved');

            if (pokemonTmp === 'not_evolved') {
                // modal pas evol
                this.hasEvolved = false;
            }
            else {
                this.hasEvolved = true;
                let pokemonDatas = JSON.parse(pokemonTmp);
                this.pokemonTrained = pokemonDatas;
                console.log('pokemon recu');
                console.log(this.pokemonTrained);
                //mettre à jour la liste
            }
        }
        this.modalService.open(modal, {size: 'lg'});
    }

    finishTraining(modal) {
        this.modalService.dismissAll();
        this.pokemonSelected = this.pokemonTrained;
    }


    /********************************* EVOLUTION ******************************/

    evolvePokemon(pokemonTrained: Pokemon) {
        let orderInt = parseInt(pokemonTrained.order);

        //recuperer la chaine d'evol
        this.getEvolutionChain(orderInt, pokemonTrained);
        this.evolution_chain = localStorage.getItem('evolution_string');
        console.log('level avant evolved ' + this.pokemonTrained.level);
        //recuperer le pokemon si evolution
        this.checkEvolvedPokemon(this.evolution_chain, this.pokemonTrained);
        console.log('level apres evolved ' + this.pokemonTrained.level);

    }

    getEvolutionChain(id: number, pokemonTrained: Pokemon) {
        this.trainingService.getPokemonEvolutionSpecies(id).subscribe(
            result => {
                localStorage.setItem('evolution_string', result.evolution_chain.url);
            }
        );
    }

    checkEvolvedPokemon(url: string, pokemonTrained: Pokemon) {
        this.trainingService.getPokemonEvolutionName(url).subscribe(
            result => {
                if (!result.chain.evolves_to.isEmpty) {
                    //bulba 18 (16)
                    // si le pokémon est plus fort que la premiere evol
                    if (result.chain.evolves_to[0].evolution_details[0].min_level < pokemonTrained.level) {
                        if (!result.chain.evolves_to[0].evolves_to.isEmpty) {
                            //si encore plus fort que le prochain level
                            if (result.chain.evolves_to[0].evolves_to[0].evolution_details[0].min_level < pokemonTrained.level) {
                                if (pokemonTrained.name != result.chain.evolves_to[0].species.name) {
                                    this.getEvolvedPokemon(result.chain.evolves_to[0].evolves_to[0].species.name, pokemonTrained);
                                }
                                else {
                                    localStorage.setItem('pokemon_evolved', 'not_evolved');
                                }
                            }
                            // le level pokemon egale level deuxieme evol
                            else if (result.chain.evolves_to[0].evolves_to[0].evolution_details[0].min_level === pokemonTrained.level) {
                                this.getEvolvedPokemon(result.chain.evolves_to[0].evolves_to[0].species.name, pokemonTrained);
                            }
                            else {
                                // cas anormal bulba 28
                                if (pokemonTrained.name != result.chain.evolves_to[0].species.name) {
                                    this.getEvolvedPokemon(result.chain.evolves_to[0].species.name, pokemonTrained);
                                }
                                else {
                                    localStorage.setItem('pokemon_evolved', 'not_evolved');
                                }
                            }

                        }
                        else {
                            if (pokemonTrained.name != result.chain.evolves_to[0].species.name) {
                                this.getEvolvedPokemon(result.chain.evolves_to[0].species.name, pokemonTrained);
                            }
                            else {
                                localStorage.setItem('pokemon_evolved', 'not_evolved');
                            }
                        }
                    }
                    // j'ai atteint le level requis de la premiere evol
                    else if (result.chain.evolves_to[0].evolution_details[0].min_level === pokemonTrained.level) {
                        //on récupère le pokemon évolué
                        console.log('j ai atteint le level requis');
                        this.getEvolvedPokemon(result.chain.evolves_to[0].species.name, pokemonTrained);
                    }
                    else {
                        localStorage.setItem('pokemon_evolved', 'not_evolved');
                    }
                }
                else {
                    localStorage.setItem('pokemon_evolved', 'not_evolved');
                }
            }
        );
    }

    getEvolvedPokemon(name: string, pokemonTrained: Pokemon) {
        this.trainingService.getPokemonByName(name).subscribe(
            result => {
                console.log('je suis entré dans getEvolvedPoke');
                let pokeEvolved = new Pokemon();
                pokeEvolved.mapResponseToPokemon(result);
                pokeEvolved.xp = pokemonTrained.xp;
                pokeEvolved.level = pokemonTrained.level;
                pokeEvolved.price = pokemonTrained.price;
                localStorage.setItem('pokemon_evolved', JSON.stringify(pokeEvolved));
                console.log('pokemon envoye');
                console.log(pokeEvolved);
                console.log('j ai ajoute le poke en localStorage');
            }
        );
    }

    /*finishTraining(modal) {
        if (this.trainingService.evolution(this.pokemonTrained))
        {
            this.hasEvolved = true;
        }
        else {
            this.modalService.dismissAll();
            this.pokemonSelected = this.pokemonTrained;
        }
    }*/

    finishEvolution(modal) {
        this.modalService.dismissAll();
        this.hasEvolved = false;
        this.pokemonSelected = this.pokemonTrained;
    }


}
