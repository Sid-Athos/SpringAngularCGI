import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { SidComponent } from './sid/sid.component';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS, HttpRequest } from '@angular/common/http';
import { UsersListComponent } from './users-list/users-list.component';
 // import { ConfigComponent } from './config/config.component';

@NgModule({
  declarations: [
    AppComponent,
    SidComponent,
    LoginComponent,
    UsersListComponent
    // ConfigComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    HttpRequest,
    RouterModule.forRoot(
      [
      { path: 'users', component: SidComponent },
      { path: 'login', component: LoginComponent },
      { path: 'list', component: UsersListComponent },
      ]
    )
  ],
  providers: [
    AppComponent,
    { provide  : HTTP_INTERCEPTORS, useClass: UsersListComponent, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
