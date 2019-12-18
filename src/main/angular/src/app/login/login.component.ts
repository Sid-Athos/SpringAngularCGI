import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  checkoutForm;

  constructor(
    private formBuilder: FormBuilder,
  ) {
    this.checkoutForm = this.formBuilder.group({
      name: '',
      pwd: ''
    });
  }
  onSubmit(datas) {
    // Process checkout data here
    console.warn('Your order has been submitted');
    this.checkoutForm.reset();
  }

}
