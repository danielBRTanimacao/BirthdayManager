import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { MainComponent } from './pages/main/main.component';
import { NoAuthGuard } from './auth.guard';

export const routes: Routes = [
    { path: '', component: MainComponent },
    { path: 'login', component: LoginComponent, canActivate: [NoAuthGuard] },
    {
        path: 'registro',
        component: RegisterComponent,
        canActivate: [NoAuthGuard],
    },
];
