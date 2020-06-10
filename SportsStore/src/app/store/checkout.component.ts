import { Component } from "@angular/core";
import { NgForm } from "@angular/forms";
import { OrderRepository } from "../model/order.repository";
import { Order } from "../model/order.model";
import { Order2 } from "../model/order2.model";

@Component({
    templateUrl: "checkout.component.html",
    styleUrls: ["checkout.component.css"]
})
export class CheckoutComponent {
    orderSent: boolean = false;
    submitted: boolean = false;

    //constructor(public repository: OrderRepository,
    //            public order: Order) {}
    constructor(public repository: OrderRepository,
                public order2: Order2) {}


    submitOrder(form: NgForm) {
        this.submitted = true;
        // if (form.valid) {
        //     this.repository.saveOrder(this.order).subscribe(order => {
        //         this.order.clear();
        //         this.orderSent = true;
        //         this.submitted = false;
        //     });

           if (form.valid) {
                this.repository.saveOrder2(this.order2).subscribe(order2 => {
                    this.orderSent = true;
                    this.submitted = false;
                });
        }
    }
}
