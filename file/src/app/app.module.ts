import {PokemonDetailComponent} from './components/pokemon-detail/pokemon-detail.component';

import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './components/app.component';
import { BrowserModule } from '@angular/platform-browser';

import {AuthModule} from './services/authentification/auth.module';
import {LoginComponent} from './services/authentification/login/login.component';
import {AuthGuard} from './services/authentification/auth.guard';
import {NavbarComponent} from './shared/components/navbar/navbar.component';
import {TrainingComponent} from './components/training/training.component';
import {InscriptionFormComponent} from './services/authentification/inscription/inscription-form.component';
import {HttpClientModule} from '@angular/common/http';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { MyPokemonsComponent } from './components/my-pokemons/my-pokemons.component';
import { MySoldComponent } from './components/my-sold/my-sold.component';

const routes: Routes = [
    { path: 'home', canActivate: [AuthGuard], component: AppComponent },
    { path: 'detail/:id', canActivate: [AuthGuard], component: PokemonDetailComponent },
    { path : 'login', component: LoginComponent},
    { path : 'inscription', component: InscriptionFormComponent},
    { path: '',   redirectTo: '/login', pathMatch: 'full'},
    { path: '**', redirectTo: 'not-found' }
];

@NgModule({
  declarations: [
      NavbarComponent,
      MyPokemonsComponent,
      PokemonDetailComponent,
      TrainingComponent,
      MySoldComponent,
      AppComponent
  ],
  imports: [
    BrowserModule,
      HttpClientModule,
      RouterModule.forRoot(
          routes
      ),
      AuthModule,
      NgbModule
  ],
  providers: [],
  bootstrap: [NavbarComponent]
})
export class AppModule {

}
