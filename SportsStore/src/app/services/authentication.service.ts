import { Injectable } from '@angular/core';


@Injectable()
export class AuthenticationService {
  getAuthorizationToken():String {
    return sessionStorage.getItem('token');
  }
}
