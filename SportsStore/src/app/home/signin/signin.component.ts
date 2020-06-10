import { Component, OnInit } from '@angular/core';
import { Router }  from '@angular/router';
import {UserService} from '../../services/user.service';
import { User } from 'src/app/model/user';

interface Alert {
  type: string;
  message: string;
}

const ALERTS: Alert[] = [];

@Component({
  selector: 'signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  
  alerts: Alert[];
  
  constructor(private userService: UserService, private router: Router) {
    //this.reset();
  }

  ngOnInit(): void {
    if (sessionStorage.getItem('token')) {
      this.router.navigateByUrl("/store");}
    }
   /* signin  operate*/
   onSubmit(value: any) {
    if (this.validInput(value)) {
      this.userService.postSignIn(value).subscribe(
        data => {
          console.log(JSON.stringify(data));
          const info: any = data;
          // if (200 === info.code) { 
             if (info.code === info.code) { 
              console.log('signin ok，this is you store home');
          //    sessionStorage.setItem('token',  info.result.token)
                sessionStorage.setItem('token', info.access_token )
                sessionStorage.setItem('username',value.name )
                this.router.navigateByUrl("/store");
              } 
          //   else {
          //   console.log('登录失败，弹出MSG');
          //   this.alerts.push({type : 'danger', message: 'username or password error!'});

          // } 
        }
      );
    }
  }

  /* 验证输入项 */
  validInput(value: any): boolean {
    this.reset();
    let result = true
    if (!value.name) {
      this.alerts.push({type : 'danger', message: 'username required!'});
      result = false;
    }

    if (!value.password) {
      this.alerts.push({type : 'danger', message: 'password required!'});
      result =  false;
    }

    if (value.password.length < 6) {
      this.alerts.push({type : 'danger', message: 'password length must be greater than 6!'});
      result =  false;
    }
    return result;
  }

  close(alert: Alert) {
    this.alerts.splice(this.alerts.indexOf(alert), 1);
  }

  reset() {
    this.alerts = Array.from(ALERTS);
  }

  //gotoStore
  toStore(){
    this.router.navigateByUrl("/store");
  }

  

}
