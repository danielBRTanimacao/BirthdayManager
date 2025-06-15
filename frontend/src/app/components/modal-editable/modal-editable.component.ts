import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-modal-editable',
    imports: [],
    templateUrl: './modal-editable.component.html',
    styleUrl: './modal-editable.component.css',
})
export class ModalEditableComponent {
    @Input() data!: any;
}
