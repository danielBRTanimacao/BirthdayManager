import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, inject, Output } from '@angular/core';
import {
    FormGroup,
    FormControl,
    Validators,
    ReactiveFormsModule,
} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector: 'app-login',
    imports: [ReactiveFormsModule],
    templateUrl: './login.component.html',
    styleUrl: './login.component.css',
})
export class LoginComponent {
    @Output() pageChange = new EventEmitter<void>();

    httpClient = inject(HttpClient);
    router = inject(Router);
    errorSubmit: string = '';

    form = new FormGroup({
        email: new FormControl('', Validators.required),
        password: new FormControl('', [Validators.required]),
    });

    changeToRegister() {
        this.pageChange.emit();
    }

    submitDataLogin(event: Event) {
        event.preventDefault();

        this.httpClient
            .post('http://127.0.0.1:8080/api/user/login', this.form.value)
            .subscribe({
                next: (response: any) => {
                    localStorage.setItem('token', response.token);
                    localStorage.setItem('userId', response.id);
                    localStorage.setItem('mail', response.email);
                    this.router.navigate(['']);
                },
                error: (err) => {
                    this.errorSubmit = err.error.error;
                },
            });
    }
}
