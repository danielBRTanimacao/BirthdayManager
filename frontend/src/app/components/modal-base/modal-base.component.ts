import { Component, Input } from '@angular/core';

type ModalType = 'createNote' | 'config' | 'editable';

@Component({
    selector: 'app-modal-base',
    imports: [],
    templateUrl: './modal-base.component.html',
    styleUrls: ['./modal-base.component.css'],
})
export class ModalBaseComponent {
    @Input() isOpen!: boolean;
    @Input() nameModal!: ModalType;

    public modalOpen: Record<ModalType, boolean> = {
        config: false,
        createNote: false,
        editable: false,
    };

    closeModal() {
        if (this.nameModal && this.modalOpen.hasOwnProperty(this.nameModal)) {
            this.modalOpen[this.nameModal] = false;
        }
    }
}
