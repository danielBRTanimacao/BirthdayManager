import { Component, EventEmitter, inject, Output } from '@angular/core';
import {
    FormGroup,
    FormControl,
    Validators,
    ReactiveFormsModule,
} from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
    selector: 'app-register',
    imports: [ReactiveFormsModule],
    templateUrl: './register.component.html',
    styleUrl: './register.component.css',
})
export class RegisterComponent {
    @Output() pageChange = new EventEmitter<void>();

    httpClient = inject(HttpClient);
    router = inject(Router);

    form = new FormGroup({
        name: new FormControl('', Validators.required),
        email: new FormControl('', Validators.required),
        password: new FormControl('', [Validators.required]),
    });

    errorSubmit = '';

    changeToLogin() {
        this.pageChange.emit();
    }

    submitDataRegister(event: Event) {
        event.preventDefault();
        this.errorSubmit = '';

        this.httpClient
            .post('http://127.0.0.1:8080/api/user/create', this.form.value)
            .subscribe({
                next: () => {
                    this.errorSubmit = '';
                    this.router.navigate(['/auth']);
                },
                error: (err) => {
                    for (const [key, item] of Object.entries(err.error)) {
                        this.errorSubmit += `<p>${key}: ${item}</p>`;
                    }
                },
            });
    }
}
