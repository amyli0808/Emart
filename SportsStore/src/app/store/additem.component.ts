import { Component } from '@angular/core';
import { NgForm } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { Product } from "../model/product.model";
import { ProductRepository } from "../model/product.repository";

@Component({
  selector: 'app-additem',
  templateUrl: './additem.component.html',
  styleUrls: ['./additem.component.css']
})
export class AdditemComponent  {

  itemSent: boolean = false;
  submitted: boolean = false;
  product: Product = new Product();

  constructor(public repository: ProductRepository,
    private router: Router,
    activeRoute: ActivatedRoute
              ) {}

  submitProduct(form: NgForm) {

      this.submitted = true;
      if (form.valid) {
        this.repository.saveProduct(this.product); 
        this.itemSent = true;   
        this.submitted = false;

        }
  }


}
