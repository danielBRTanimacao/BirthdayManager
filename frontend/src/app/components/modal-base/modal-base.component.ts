import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-modal-base',
    templateUrl: './modal-base.component.html',
    styleUrls: ['./modal-base.component.css'],
})
export class ModalBaseComponent {
    @Input() isOpen!: boolean;

    closeModal() {
        this.isOpen = !this.isOpen;
    }
}
