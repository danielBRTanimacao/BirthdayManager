import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { ModalFormComponent } from '../../components/modal-form/modal-form.component';
import { ModalConfigComponent } from '../../components/modal-config/modal-config.component';
import { PostItComponent } from '../../components/post-it/post-it.component';
import { Router } from '@angular/router';
import { ModalEditableComponent } from '../../components/modal-editable/modal-editable.component';

@Component({
    selector: 'app-main',
    imports: [
        ModalFormComponent,
        ModalConfigComponent,
        PostItComponent,
        ModalEditableComponent,
    ],
    templateUrl: './main.component.html',
    styleUrl: './main.component.css',
})
export class MainComponent {
    httpClient = inject(HttpClient);
    router = inject(Router);
    title = 'Lembrete aniversarios';
    dados: any;

    constructor() {
        const token = localStorage.getItem('token');

        const headers = new HttpHeaders({
            Authorization: `Bearer ${token}`,
        });

        this.httpClient
            .get('http://127.0.0.1:8080/api/birthday', { headers })
            .subscribe({
                next: (res) => {
                    this.dados = res;
                },
                error: () => {
                    localStorage.removeItem('token');
                    this.router.navigate(['/auth']);
                },
            });
    }
}
