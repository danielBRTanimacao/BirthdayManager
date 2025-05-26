import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import {
    FormGroup,
    FormControl,
    Validators,
    ReactiveFormsModule,
} from '@angular/forms';

@Component({
    selector: 'app-login',
    imports: [ReactiveFormsModule],
    templateUrl: './login.component.html',
    styleUrl: './login.component.css',
})
export class LoginComponent {
    httpClient = inject(HttpClient);

    form = new FormGroup({
        email: new FormControl('', Validators.required),
        password: new FormControl('', [Validators.required]),
    });

    constructor() {}

    submitDataLogin(event: Event) {
        event.preventDefault();

        this.httpClient
            .post('http://127.0.0.1:8080/api/user/login', this.form.value)
            .subscribe((response: any) => {
                console.log(response);

                localStorage.setItem('token', response['token']);
                localStorage.setItem('userId', response['id']);
            });
    }
}
