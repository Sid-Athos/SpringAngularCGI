export class UserLogin {
  username: string;
  password: string;
}

export class UserRegistration {
  username: string;
  password: string;
  email?: string;
  pictureUrl?: string;
}

export class User {
  id: string;
  name: string;
  pwd: string;
  mail: string;
}

