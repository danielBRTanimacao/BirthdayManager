import { Component, EventEmitter, Output } from '@angular/core';

@Component({
    selector: 'app-paper-anim',
    imports: [],
    templateUrl: './paper-anim.component.html',
    styleUrl: './paper-anim.component.css',
})
export class PaperAnimComponent {
    @Output() animationDone = new EventEmitter<void>();

    onAnimationEnd() {
        this.animationDone.emit();
    }
}
