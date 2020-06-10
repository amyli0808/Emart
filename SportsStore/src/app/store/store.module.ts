import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms";
import { ModelModule } from "../model/model.module";
import { StoreComponent } from "./store.component";
import { CounterDirective } from "./counter.directive";
import { CartSummaryComponent } from "./cartSummary.component";
import { CartDetailComponent } from "./cartDetail.component";
import { CheckoutComponent } from "./checkout.component";
import { RouterModule } from "@angular/router";
import { HistoryComponent } from './history.component';
import { AdditemComponent } from './additem.component';

@NgModule({
    imports: [ModelModule, BrowserModule, FormsModule, RouterModule],
    
    declarations: [StoreComponent, CounterDirective, CartSummaryComponent,

        CartDetailComponent, CheckoutComponent, HistoryComponent, AdditemComponent],
    exports: [StoreComponent, CartDetailComponent, CheckoutComponent]
})
export class StoreModule { }
