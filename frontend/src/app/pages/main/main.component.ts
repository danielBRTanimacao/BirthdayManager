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
import { BirthdayEntity } from '../../interfaces/BirthdayInterfaces';
import { ModalService } from '../../services/ModalServices';

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
    modalService = inject(ModalService);
    title = 'Lembrete aniversarios';
    data: BirthdayEntity | any;

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

    showModal(name: string) {
        if (name == 'createNote') {
            this.modalService.modalOpen.create =
                !this.modalService.modalOpen.create;
        } else if (name == 'config') {
            this.modalService.modalOpen.config =
                !this.modalService.modalOpen.config;
        } else if (name == 'editable') {
            this.modalService.modalOpen.editable =
                !this.modalService.modalOpen.editable;
        }
    }

    constructor() {
        this.birthdayService.getBirthdays().subscribe({
            next: (res) => {
                this.data = res;
            },
            error: () => {
                localStorage.removeItem('token');
            },
        });
    }

    submitBirthadayContent(event: Event) {
        event.preventDefault();
        this.birthdayService.postBirthday(this.form);
    }
}
