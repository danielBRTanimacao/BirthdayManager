import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { ModalFormComponent } from '../../components/modal-form/modal-form.component';
import { ModalConfigComponent } from '../../components/modal-config/modal-config.component';

@Component({
    selector: 'app-main',
    imports: [ModalFormComponent, ModalConfigComponent],
    templateUrl: './main.component.html',
    styleUrl: './main.component.css',
})
export class MainComponent {
    httpClient = inject(HttpClient);
    title = 'Lembrete aniversarios';
    dados: any;

    constructor() {
        this.httpClient
            .get('http://127.0.0.1:8080/api/birthday')
            .subscribe((res) => {
                this.dados = res;
            });
    }
}
