import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class ModalService {
    public modalOpen = {
        config: false,
        create: false,
        editable: false,
    };

    constructor() {}

    showModal(name: string) {
        if (name == 'createNote') {
            this.modalOpen.create = !this.modalOpen.create;
        } else if (name == 'config') {
            this.modalOpen.config = !this.modalOpen.config;
        } else if (name == 'editable') {
            this.modalOpen.editable = !this.modalOpen.editable;
        }
    }
}
