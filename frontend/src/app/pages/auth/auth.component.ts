import { Component } from '@angular/core';
import { RegisterComponent } from '../register/register.component';
import { LoginComponent } from '../login/login.component';
import { PaperAnimComponent } from '../../components/paper-anim/paper-anim.component';

@Component({
    selector: 'app-auth',
    imports: [RegisterComponent, LoginComponent, PaperAnimComponent],
    templateUrl: './auth.component.html',
    styleUrl: './auth.component.css',
})
export class AuthComponent {
    showLogin = true;
    playAnim = true;

    onPaperAnimDone() {
        this.playAnim = !this.playAnim;
    }

    toggleMode() {
        this.showLogin = !this.showLogin;
        this.playAnim = !this.playAnim;
    }
}
