import { HttpClient, HttpRequest, HttpInterceptor, HttpHandler, HttpEvent } from '@angular/common/http';
import { Component, OnInit, Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';
import { ServerConfiguration } from '../../services/ServerConfiguration.service';
import { UserRegistration } from '../../models';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

class Customer {
  id: string;
  name: string;
  mail: string;
  pw: string;
}
@Component({
    selector: 'app-users',
    templateUrl: 'users-list.component.html'
})

@Injectable()
export class UsersListComponent implements OnInit {
    customerObservable: Observable<Customer[]>;
    // tslint:disable-next-line: no-shadowed-variable
    constructor(private HttpClient: HttpClient) {

    }

    ngOnInit(): void {
      this.HttpClient.get('http://localhost:8080/api/users').subscribe(data => {
        console.log(data);
      });
    }
}

