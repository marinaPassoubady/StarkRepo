import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { tap, delay } from 'rxjs/operators';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    isLoggedIn = false;

    // store the URL so we can redirect after logging in
    redirectUrl: string;

    login(pseudo, mdp): Observable<boolean> {

        const allDresseurs = localStorage.getItem('allDresseurs');


        for (const d of JSON.parse(allDresseurs)) {
            if (d.nom === pseudo && d.motDePasse === mdp) {
                localStorage.setItem('CurrentUser', JSON.stringify(d));
                return of(true).pipe(
                    delay(1000),
                    tap(val => this.isLoggedIn = true)
                );
            }
        }
        return of(false).pipe(
            delay(1000),
            tap(val => this.isLoggedIn = false)
        );    }

    logout(): void {
        this.isLoggedIn = false;
    }
}
