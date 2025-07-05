import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { PostItComponent } from '../../components/post-it/post-it.component';
import { Router } from '@angular/router';
import { ModalBaseComponent } from '../../components/modal-base/modal-base.component';
import { BirthdayService } from '../../services/BirthdayServices';
import { ModalService } from '../../services/ModalService';
import { ReactiveFormsModule } from '@angular/forms';
import { BirthdayEntity } from '../../interfaces/BirthdayInterfaces';

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

    form = this.birthdayService.form;

    renderForm = 'a';

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

    updateBirthadayContent(event: Event) {
        event.preventDefault();
        this.birthdayService.updateBirthday(this.form);
    }
}
