import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Injectable({
    providedIn: 'root',
})
export class BirthdayService {
    private headers: HttpHeaders;
    private URL_API: string = 'http://127.0.0.1:8080/api';

    public form = new FormGroup({
        userId: new FormControl({
            value: localStorage.getItem('userId'),
            disabled: false,
        }),
        name: new FormControl('', Validators.required),
        birthday: new FormControl('', [Validators.required]),
        notes: new FormControl(''),
        colors: new FormControl(''),
        textColor: new FormControl(''),
    });

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

    updateBirthday(form: FormGroup) {
        this.client
            .put(`${this.URL_API}/birthday/${1}`, form.value, {
                headers: this.headers,
            })
            .subscribe({
                error: (err) => {
                    console.log(err);
                },
            });
    }

    delBirthday() {}
}
