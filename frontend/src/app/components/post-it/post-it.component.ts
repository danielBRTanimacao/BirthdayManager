import {
    Component,
    Input,
    ElementRef,
    HostListener,
    AfterViewInit,
} from '@angular/core';

@Component({
    selector: 'app-post-it',
    standalone: true,
    templateUrl: './post-it.component.html',
    styleUrl: './post-it.component.css',
})
export class PostItComponent implements AfterViewInit {
    @Input() name!: string;
    @Input() birthdayDate!: string;
    @Input() anotation!: string;
    @Input() created!: string;

    private dragging = false;
    private offsetX = 0;
    private offsetY = 0;

    constructor(private el: ElementRef) {}

    ngAfterViewInit() {
        const el = this.el.nativeElement.querySelector('.draggable');
        el.addEventListener('mousedown', this.onMouseDown.bind(this));
    }

    onMouseDown(event: MouseEvent) {
        this.dragging = true;
        const element = this.el.nativeElement.querySelector('.draggable');
        element.classList.add('cursor-grabbing');
        const rect = element.getBoundingClientRect();

        this.offsetX = event.clientX - rect.left;
        this.offsetY = event.clientY - rect.top;

        document.addEventListener('mousemove', this.onMouseMove);
        document.addEventListener('mouseup', this.onMouseUp);
    }

    onMouseMove = (event: MouseEvent) => {
        if (!this.dragging) return;

        const main = document.querySelector('main.black-board')!;
        const mainRect = main.getBoundingClientRect();

        const element = this.el.nativeElement.querySelector('.draggable');

        let left = event.clientX - mainRect.left - this.offsetX;
        let top = event.clientY - mainRect.top - this.offsetY;

        left = Math.max(
            0,
            Math.min(left, mainRect.width - element.offsetWidth)
        );
        top = Math.max(
            0,
            Math.min(top, mainRect.height - element.offsetHeight)
        );

        element.style.left = `${left}px`;
        element.style.top = `${top}px`;
    };

    onMouseUp = () => {
        this.dragging = false;
        document.removeEventListener('mousemove', this.onMouseMove);
        document.removeEventListener('mouseup', this.onMouseUp);
    };
}
