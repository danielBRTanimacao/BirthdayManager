import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-post-it',
    imports: [],
    templateUrl: './post-it.component.html',
    styleUrl: './post-it.component.css',
})
export class PostItComponent {
    @Input() name!: string;
    @Input() birthdayDate!: string;
    @Input() anotation!: string;
    @Input() created!: string;
}
