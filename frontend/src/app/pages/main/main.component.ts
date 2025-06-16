import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { PostItComponent } from '../../components/post-it/post-it.component';
import { Router } from '@angular/router';
import { ModalBaseComponent } from '../../components/modal-base/modal-base.component';
import { BirthdayService } from '../../services/BirthdayServices';
import {
    FormControl,
    FormGroup,
    ReactiveFormsModule,
    Validators,
} from '@angular/forms';

@Component({
    selector: 'app-main',
    imports: [ModalBaseComponent, PostItComponent, ReactiveFormsModule],
    templateUrl: './main.component.html',
    styleUrl: './main.component.css',
})
export class MainComponent {
    httpClient = inject(HttpClient);
    router = inject(Router);
    birthdayService = inject(BirthdayService);
    title = 'Lembrete aniversarios';
    data: any;

    form = new FormGroup({
        userId: new FormControl({
            value: localStorage.getItem('userId'),
            disabled: false,
        }),
        name: new FormControl('', Validators.required),
        birthday: new FormControl('', [Validators.required]),
        notes: new FormControl(''),
        colors: new FormControl(''),
        textColor: new FormControl(''),
    });

    constructor() {
        this.birthdayService.getBirthdays().subscribe({
            next: (res) => {
                this.data = res;
                console.log('Aniversários:', res);
            },
            error: (err) => {
                localStorage.removeItem('token');
                console.error(err);
            },
        });
    }

    submitBirthadayContent(event: Event) {
        event.preventDefault();
        this.birthdayService.postBirthday(this.form);
    }
}
