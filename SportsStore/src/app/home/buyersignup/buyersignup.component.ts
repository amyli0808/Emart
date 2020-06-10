import { Component, OnInit } from '@angular/core';
import { Router }  from '@angular/router';


@Component({
  selector: 'app-buyersignup',
  templateUrl: './buyersignup.component.html',
  styleUrls: ['./buyersignup.component.css']
})
export class BuyersignupComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  toSignin(){
    this.router.navigateByUrl("/signin");
  }

}
