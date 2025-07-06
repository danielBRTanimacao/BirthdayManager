import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, inject } from '@angular/core';
import { PostItComponent } from '../../components/post-it/post-it.component';
import { Router } from '@angular/router';
import { ModalBaseComponent } from '../../components/modal-base/modal-base.component';
import { BirthdayService } from '../../services/BirthdayServices';
import { ReactiveFormsModule } from '@angular/forms';
import { BirthdayEntity } from '../../interfaces/BirthdayInterfaces';

type ModalType = 'createNote' | 'config' | 'editable';

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
    data: BirthdayEntity | any;

    form = this.birthdayService.form;

    errorCreatePostIt: String = '';

    renderForm = 'Error';

    modalOpen = {
        config: false,
        createNote: false,
        editable: false,
    };

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

    openModal(modalName: ModalType) {
        this.modalOpen[modalName] = !this.modalOpen[modalName];
    }

    renderOpenModal(item: any) {
        this.openModal('editable');
        this.renderForm = item.name;
    }

    submitBirthadayContent(event: Event) {
        this.errorCreatePostIt = '';
        event.preventDefault();
        this.birthdayService.postBirthday(this.form).subscribe({
            next: () => {
                this.errorCreatePostIt =
                    '<p class="text-green-500">Salvando...</p>';
                location.reload();
            },
            error: (err) => {
                for (const [key, item] of Object.entries(err.error)) {
                    this.errorCreatePostIt += `<p>${key}: ${item}</p>`;
                }
            },
        });
    }

    updateBirthadayContent(event: Event) {
        event.preventDefault();
        this.birthdayService.updateBirthday(this.form);
    }
}
