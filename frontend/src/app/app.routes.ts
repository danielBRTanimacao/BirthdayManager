import { Routes } from '@angular/router';
import { MainComponent } from './pages/main/main.component';
import { AuthPageComponent } from './pages/auth-page/auth-page.component';

export const routes: Routes = [
    { path: '', component: MainComponent },
    { path: 'auth', component: AuthPageComponent },
];
