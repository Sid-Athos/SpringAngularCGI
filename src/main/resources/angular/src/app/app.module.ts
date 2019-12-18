<<<<<<< HEAD
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule, MatCardModule, MatIconModule, MatInputModule, MatSnackBarModule, MatToolbarModule} from '@angular/material';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BookComponent} from './components/book/book.component';
import {LibraryComponent} from './components/library/library.component';
import {RegisterComponent} from './components/register/register.component';
import {BookRepository} from './services/book.repository';
import {BookService} from './services/real/book.service';
=======
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidComponent } from './sid/sid.component';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
>>>>>>> d138b552c4317d817bb01daf504b6078a6bc1ae5

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    LibraryComponent,
    BookComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    AppRoutingModule,
    MatCardModule,
    MatIconModule,
    MatInputModule,
    MatSnackBarModule
  ],
  providers: [
    {provide: BookRepository, useFactory: (http: HttpClient) => new BookService(http), 'deps': [HttpClient]}
=======
    SidComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule, 
    RouterModule.forRoot(
      [
      { path: 'users', component: SidComponent },
      { path: 'login', component: LoginComponent },
      ]
    )
>>>>>>> d138b552c4317d817bb01daf504b6078a6bc1ae5
  ],
  bootstrap: [AppComponent]
<<<<<<< HEAD
})
export class AppModule {}
=======
})  
export class AppModule { }
>>>>>>> d138b552c4317d817bb01daf504b6078a6bc1ae5
