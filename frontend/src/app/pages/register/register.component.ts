import { Component, inject } from '@angular/core';
import {
    FormGroup,
    FormControl,
    Validators,
    ReactiveFormsModule,
} from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'app-register',
    imports: [ReactiveFormsModule],
    templateUrl: './register.component.html',
    styleUrl: './register.component.css',
})
export class RegisterComponent {
    httpClient = inject(HttpClient);

    form = new FormGroup({
        name: new FormControl('', Validators.required),
        email: new FormControl('', Validators.required),
        password: new FormControl('', [Validators.required]),
    });

    submitDataRegister(event: Event) {
        event.preventDefault();

        this.httpClient
            .post('http://127.0.0.1:8080/api/user/create', this.form.value)
            .subscribe((res) => {
                window.location.reload();
            });
    }
}
