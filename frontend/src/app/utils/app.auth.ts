import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    constructor() {}

    isLogged(): boolean {
        const token = localStorage.getItem('token');
        return !!token;
    }
}
