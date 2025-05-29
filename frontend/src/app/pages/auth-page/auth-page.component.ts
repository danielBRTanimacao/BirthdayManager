import { Component } from '@angular/core';
import { RegisterComponent } from '../register/register.component';
import { LoginComponent } from '../login/login.component';
import { PaperAnimComponent } from '../../components/paper-anim/paper-anim.component';

@Component({
    selector: 'app-auth-page',
    imports: [RegisterComponent, LoginComponent, PaperAnimComponent],
    templateUrl: './auth-page.component.html',
    styleUrl: './auth-page.component.css',
})
export class AuthPageComponent {
    showLogin = true;
    showAnim = true;

    onPaperAnimDone() {
        this.showAnim = false;
    }

    toggleMode() {
        this.showLogin = !this.showLogin;
        this.showAnim = true;
    }
}
