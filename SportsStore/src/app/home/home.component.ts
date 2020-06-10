import { Component, DoCheck, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']

})


export class HomeComponent implements OnInit, DoCheck {

  constructor(private router: Router) { }

  isSignin: boolean;
//ngOnInit-----start--------------
  ngOnInit(): void {
    if (sessionStorage.getItem('token')){
      this.isSignin = true;
      console.log('isSignin true');
    } else {
      this.isSignin = false;
      console.log('isSignin false');
    }
  }
//ngDoCheck-----start--------------
  ngDoCheck(): void {
    console.log('docheck');
    if (sessionStorage.getItem('token')){
      console.log('isSignin true2');
      this.isSignin = true;
    } else {
      this.isSignin = false;
      console.log('isSignin false2');
    }
  }

//signOut-----start--------------  
  signOut() {
    sessionStorage.removeItem('token');
    this.router.navigate(['/signin']);
  }

//signIn-----start--------------  
  signIn(){
    this.router.navigateByUrl("/signin");
  }

//buyerSignUp-----start--------------   
  buyerSignUp(){
    this.router.navigateByUrl("/buyersignup");
  }

//sellerSignUp-----start--------------     
  sellerSignUp(){
    this.router.navigateByUrl("/sellersignup");
  }

 //toAdmin-----start-------------------  
  toAdmin(){
    this.router.navigateByUrl("/admin");
  }


}
