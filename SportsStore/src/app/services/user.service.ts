import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {User} from '../model/user';



const username = 'cloudsimpleservice';
const password = 'mysecret';


const httpOptions = {
  headers: new HttpHeaders({
    Authorization: 'Basic ' + btoa(username + ':' + password)
  })
};



@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public get currentUserToken(): string {
    return sessionStorage.getItem('token');
  }

  postSignIn(user) {
    //return this.http.post(`${environment.baseUrl}/login`, JSON.stringify(user), httpOptions);
   // return this.http.post(`${environment.baseUrl}/api/cloud-auth-service/auth/oauth/token?grant_type=password&scope=webclient&username=admin&password=admin`,null , httpOptions);
    return this.http.post(`${environment.baseUrl}/api/cloud-auth2-service/auth/oauth/token?grant_type=password&scope=webclient&username=admin&password=admin1`,null , httpOptions);
  
  
  }

  

}
