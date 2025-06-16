import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-modal-base',
    imports: [],
    templateUrl: './modal-base.component.html',
    styleUrl: './modal-base.component.css',
})
export class ModalBaseComponent {
    @Input() isOpen!: boolean;
    @Input() close: any = () => {};
}
