import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BirthdayNote } from '../../BirthdayNote';

@Component({
    selector: 'app-modal-form',
    imports: [HttpClientModule, FormsModule],
    templateUrl: './modal-form.component.html',
    styleUrl: './modal-form.component.css',
})
export class ModalFormComponent {
    httpClient = inject(HttpClient);
    name = '';
    birthday = '';
    notes = '';

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
