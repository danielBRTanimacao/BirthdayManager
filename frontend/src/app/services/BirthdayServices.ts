import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable({
    providedIn: 'root',
})
export class BirthdayService {
    private headers: HttpHeaders;
    private URL_API: string = 'http://127.0.0.1:8080/api';

    constructor(private client: HttpClient) {
        const token = localStorage.getItem('token');
        this.headers = new HttpHeaders({
            Authorization: `Bearer ${token}`,
        });
    }

    getBirthdays() {
        return this.client.get(`${this.URL_API}/birthday`, {
            headers: this.headers,
        });
    }

    postBirthday(form: FormGroup) {
        this.client
            .post(`${this.URL_API}/birthday/add`, form.value, {
                headers: this.headers,
            })
            .subscribe({
                error: (err) => {
                    console.log(err);
                },
            });
    }

    updateBirthday() {
        console.log('update');
    }

    delBirthday() {
        console.log('destruido');
    }
}
