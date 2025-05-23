import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BirthdayNote } from './BirthdayNote';

@Component({
    selector: 'app-root',
    imports: [HttpClientModule, FormsModule],
    templateUrl: './app.component.html',
})
export class AppComponent {
    httpClient = inject(HttpClient);
    title = 'frontend';
    dados: any;

    name = '';
    birthday = '';
    notes = '';

    constructor() {
        this.httpClient
            .get('http://127.0.0.1:8080/api/birthday')
            .subscribe((res) => {
                this.dados = res;
            });
    }

    submitBirthadayContent(event: Event) {
        event.preventDefault();

        const data: BirthdayNote = {
            name: this.name,
            birthday: this.birthday,
            notes: this.notes,
        };

        this.httpClient
            .post('http://127.0.0.1:8080/api/birthday/add', data)
            .subscribe((res) => {
                console.log('Enviado com sucesso', res);
            });
    }
}
