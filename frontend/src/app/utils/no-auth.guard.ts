import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './app.auth';

@Injectable({
    providedIn: 'root',
})
export class NoAuthGuard implements CanActivate {
    constructor(private authService: AuthService, private router: Router) {}

    canActivate(): boolean {
        if (!this.authService.isLogged()) {
            return true;
        } else {
            this.router.navigate(['/']);
            return false;
        }
    }
}
