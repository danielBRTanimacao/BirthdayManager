import {
    Component,
    Input,
    ElementRef,
    AfterViewInit,
    OnDestroy,
    inject,
    Renderer2,
} from '@angular/core';
import { ModalService } from '../../services/ModalService';

@Component({
    selector: 'app-post-it',
    standalone: true,
    templateUrl: './post-it.component.html',
    styleUrls: ['./post-it.component.css'],
})
export class PostItComponent implements AfterViewInit, OnDestroy {
    modalService = inject(ModalService);
    private renderer = inject(Renderer2);

    @Input() name!: string;
    @Input() birthdayDate!: string;
    @Input() colors!: string;
    @Input() textColor!: string;
    @Input() anotation!: string;
    @Input() created!: string;

    private dragging = false;
    private offsetX = 0;
    private offsetY = 0;
    private dragElement!: HTMLElement;
    private unlistenMove!: () => void;
    private unlistenUp!: () => void;

    constructor(private el: ElementRef) {}

    openEditable() {
        const data = {
            name: this.name,
            birthdayDate: this.birthdayDate,
            colors: this.colors,
            textColor: this.textColor,
            anotation: this.anotation,
            created: this.created,
        };
        this.modalService.showModal('editable');
    }

    birthdayFormat() {
        if (!this.birthdayDate) return '';
        const [month, day] = this.birthdayDate.split('-');
        return `${day}/${month}`;
    }

    formatCreatedDate() {
        try {
            const date = new Date(this.created);
            return date.toLocaleString('pt-BR');
        } catch (error) {
            return this.created;
        }
    }

    ngAfterViewInit() {
        this.dragElement = this.el.nativeElement.querySelector('.draggable');

        if (this.dragElement) {
            this.renderer.listen(
                this.dragElement,
                'mousedown',
                this.onMouseDown.bind(this)
            );
            this.renderer.listen(
                this.dragElement,
                'touchstart',
                this.onTouchStart.bind(this)
            );

            // Melhoria de acessibilidade
            this.renderer.setAttribute(this.dragElement, 'tabindex', '0');
            this.renderer.setAttribute(this.dragElement, 'role', 'application');
            this.renderer.setAttribute(
                this.dragElement,
                'aria-label',
                'Post-it arrastável'
            );
        }
    }

    ngOnDestroy() {
        this.removeDocumentListeners();
    }

    private removeDocumentListeners() {
        if (this.unlistenMove) this.unlistenMove();
        if (this.unlistenUp) this.unlistenUp();
    }

    onMouseDown(event: MouseEvent) {
        this.startDrag(event.clientX, event.clientY);
    }

    onTouchStart(event: TouchEvent) {
        if (event.touches.length > 0) {
            this.startDrag(event.touches[0].clientX, event.touches[0].clientY);
            event.preventDefault();
        }
    }

    private startDrag(clientX: number, clientY: number) {
        if (!this.dragElement) return;

        this.dragging = true;
        this.renderer.addClass(this.dragElement, 'cursor-grabbing');
        const rect = this.dragElement.getBoundingClientRect();

        this.offsetX = clientX - rect.left;
        this.offsetY = clientY - rect.top;

        // Usa Renderer2 para melhor compatibilidade
        this.unlistenMove = this.renderer.listen(
            document,
            'mousemove',
            this.onMove.bind(this)
        );
        this.unlistenUp = this.renderer.listen(
            document,
            'mouseup',
            this.onEndDrag.bind(this)
        );

        this.renderer.listen(
            document,
            'touchmove',
            this.onTouchMove.bind(this)
        );
        this.renderer.listen(document, 'touchend', this.onEndDrag.bind(this));
    }

    private onMove(event: MouseEvent) {
        this.updatePosition(event.clientX, event.clientY);
    }

    private onTouchMove(event: TouchEvent) {
        if (event.touches.length > 0) {
            this.updatePosition(
                event.touches[0].clientX,
                event.touches[0].clientY
            );
            event.preventDefault();
        }
    }

    private updatePosition(clientX: number, clientY: number) {
        if (!this.dragging || !this.dragElement) return;

        const main = document.querySelector('main.black-board');
        if (!main) return;

        const mainRect = main.getBoundingClientRect();

        let left = clientX - mainRect.left - this.offsetX;
        let top = clientY - mainRect.top - this.offsetY;

        left = Math.max(
            0,
            Math.min(left, mainRect.width - this.dragElement.offsetWidth)
        );
        top = Math.max(
            0,
            Math.min(top, mainRect.height - this.dragElement.offsetHeight)
        );

        this.renderer.setStyle(this.dragElement, 'left', `${left}px`);
        this.renderer.setStyle(this.dragElement, 'top', `${top}px`);
    }

    private onEndDrag() {
        if (!this.dragging) return;

        this.dragging = false;
        this.renderer.removeClass(this.dragElement, 'cursor-grabbing');
        this.removeDocumentListeners();

        this.savePosition();
    }

    private savePosition() {
        const position = {
            left: this.dragElement.style.left,
            top: this.dragElement.style.top,
        };
        console.log('Posição salva:', position);
    }
}
