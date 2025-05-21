import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, inject } from '@angular/core';

@Component({
    selector: 'app-root',
    imports: [HttpClientModule],
    templateUrl: './app.component.html',
})
export class AppComponent {
    httpClient = inject(HttpClient);
    title = 'frontend';
    dados: any;

    constructor() {
        this.httpClient
            .get('http://127.0.0.1:8080/api/birthday')
            .subscribe((res) => {
                this.dados = res;
            });
    }
}
