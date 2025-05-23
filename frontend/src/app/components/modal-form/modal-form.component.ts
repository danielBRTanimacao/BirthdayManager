import { HttpClient } from '@angular/common/http';
import {
    FormGroup,
    FormControl,
    Validators,
    ReactiveFormsModule,
} from '@angular/forms';
import { Component, inject } from '@angular/core';

@Component({
    selector: 'app-modal-form',
    imports: [ReactiveFormsModule],
    templateUrl: './modal-form.component.html',
    styleUrl: './modal-form.component.css',
})
export class ModalFormComponent {
    httpClient = inject(HttpClient);

    form = new FormGroup({
        userId: new FormControl({ value: 1, disabled: false }), // QUando tiver TOKEN salvar ID do user
        name: new FormControl('', Validators.required),
        birthday: new FormControl('', [Validators.required]),
        notes: new FormControl(''),
    });

    submitBirthadayContent(event: Event) {
        event.preventDefault();

        this.httpClient
            .post('http://127.0.0.1:8080/api/birthday/add', this.form.value)
            .subscribe((res) => {
                console.log('Enviado com sucesso', res);
                window.location.reload();
            });
    }
}
