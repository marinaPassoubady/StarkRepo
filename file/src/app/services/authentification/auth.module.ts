import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LoginComponent } from './login/login.component';
import {InscriptionFormComponent} from './inscription/inscription-form.component';


@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule
    ],
    declarations: [
        LoginComponent,
        InscriptionFormComponent
    ],
    exports: [
        InscriptionFormComponent,
        LoginComponent,
    ]
})
export class AuthModule {}
