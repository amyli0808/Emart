import { Component, OnInit } from '@angular/core';
import { Router }  from '@angular/router';


@Component({
  selector: 'app-sellersignup',
  templateUrl: './sellersignup.component.html',
  styleUrls: ['./sellersignup.component.css']
})
export class SellersignupComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  toSignin(){
    this.router.navigateByUrl("/signin");
  }

}
