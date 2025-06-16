import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './pages/main/main.component';
import { AuthGuard } from './utils/app.guard';
import { NgModule } from '@angular/core';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { NoAuthGuard } from './utils/no-auth.guard';
import { AuthComponent } from './pages/auth/auth.component';

export const routes: Routes = [
    { path: '', component: MainComponent, canActivate: [AuthGuard] },
    { path: 'auth', component: AuthComponent, canActivate: [NoAuthGuard] },
    { path: '**', component: PageNotFoundComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
