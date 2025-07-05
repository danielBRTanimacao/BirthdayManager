import { Injectable } from '@angular/core';

type ModalType = 'createNote' | 'config' | 'editable';

@Injectable({ providedIn: 'root' })
export class ModalService {
    public modalOpen: Record<ModalType, boolean> = {
        config: false,
        createNote: false,
        editable: false,
    };

    showModal(modalName: ModalType) {
        Object.keys(this.modalOpen).forEach((key) => {
            this.modalOpen[key as ModalType] = false;
        });
        this.modalOpen[modalName] = true;
    }

    closeModal(modalName: ModalType) {
        this.modalOpen[modalName] = false;
    }
}
