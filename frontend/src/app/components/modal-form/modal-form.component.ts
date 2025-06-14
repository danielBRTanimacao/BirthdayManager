import { HttpClient, HttpHeaders } from '@angular/common/http';
import {
    FormGroup,
    FormControl,
    Validators,
    ReactiveFormsModule,
} from '@angular/forms';
import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-modal-form',
    imports: [ReactiveFormsModule],
    templateUrl: './modal-form.component.html',
    styleUrl: './modal-form.component.css',
})
export class ModalFormComponent {
    httpClient = inject(HttpClient);
    router = inject(Router);

    form = new FormGroup({
        userId: new FormControl({
            value: localStorage.getItem('userId'),
            disabled: false,
        }),
        name: new FormControl('', Validators.required),
        birthday: new FormControl('', [Validators.required]),
        notes: new FormControl(''),
        colors: new FormControl(''),
    });

    headers = new HttpHeaders({
        Authorization: `Bearer ${localStorage.getItem('token')}`,
    });

    submitBirthadayContent(event: Event) {
        event.preventDefault();

        this.httpClient
            .post('http://127.0.0.1:8080/api/birthday/add', this.form.value, {
                headers: this.headers,
            })
            .subscribe((res) => {
                console.log('Enviado com sucesso', res);
                this.router.navigate(['']);
            });
    }
}
