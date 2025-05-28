import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { MainComponent } from './pages/main/main.component';

export const routes: Routes = [
    { path: '', component: MainComponent },
    { path: 'login', component: LoginComponent },
    { path: 'registro', component: RegisterComponent },
];
