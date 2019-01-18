import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import {FormControl, FormGroup} from '@angular/forms';
import '../../../../assets/js/loginJS';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

export class LoginComponent {
    // message: string;
    formModel: FormGroup;

    constructor(public authService: AuthService, public router: Router) {
        this.setMessage();
        this.formModel = new FormGroup({
            'form_user' : new FormControl(),
            'form_pass' : new FormControl()
        });
        localStorage.removeItem('CurrentUser');
    }

    setMessage() {
        // this.message = (this.authService.isLoggedIn ? 'Connexion OK' : '');
    }
    login() {
        // this.message = 'Login en cour';
        // this.message += this.formModel.value.form_user;
        // this.message += this.formModel.value.form_pass;
        this.authService.login(this.formModel.value.form_user, this.formModel.value.form_pass).subscribe(() => {
            // this.setMessage();
            if (this.authService.isLoggedIn) {
                // Get the redirect URL from our auth service
                // If no redirect has been set, use the default
                const redirect = this.authService.redirectUrl ? this.authService.redirectUrl : '/home';

                // Redirect the user
                this.router.navigate([redirect]);
            }
        });
    }

    logout() {
        this.authService.logout();
        this.setMessage();
    }
}
