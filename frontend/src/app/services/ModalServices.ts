import { Injectable } from '@angular/core';

type ModalType = 'createNote' | 'config' | 'editable';

@Injectable({
    providedIn: 'root',
})
export class ModalService {
    public modalOpen: Record<ModalType, boolean> = {
        config: false,
        createNote: false,
        editable: false,
    };

    constructor() {}

    showModal(name: string) {
        if (name == 'createNote') {
            this.modalOpen.createNote = !this.modalOpen.createNote;
        } else if (name == 'config') {
            this.modalOpen.config = !this.modalOpen.config;
        } else if (name == 'editable') {
            this.modalOpen.editable = !this.modalOpen.editable;
        }
    }

    renderForm(data: any) {
        return data;
    }
}
