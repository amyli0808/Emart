import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";
import { StoreModule } from "./store/store.module";
import { StoreComponent } from "./store/store.component";
import { CheckoutComponent } from "./store/checkout.component";
import { CartDetailComponent } from "./store/cartDetail.component";
import { RouterModule } from "@angular/router";
import { StoreFirstGuard } from "./storeFirst.guard";
import { HomeComponent } from "./home/home.component";
import { SigninComponent} from "./home/signin/signin.Component";
import { BuyersignupComponent } from "./home/buyersignup/buyersignup.component";
import { SellersignupComponent } from "./home/sellersignup/sellersignup.component";
import { HistoryComponent } from "./store/history.component";
import { AdditemComponent } from "./store/additem.component";
import { MoneyPipe } from './money.pipe';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';
import { AdminModule }  from  './admin/admin.module';
import {JwtInterceptor} from './model/jwt.interceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import {AuthenticationService} from './services/authentication.service';


@NgModule({
    imports: [BrowserModule, StoreModule,FormsModule,ReactiveFormsModule,NgbAlertModule,
        RouterModule.forRoot([
            {
                path: "home", component: HomeComponent               
             },
            //  {
            //     path: "admin", component: AdminComponent               
            //  },
             {
                path: "signin", component: SigninComponent               
             },
             {
                path: "buyersignup", component: BuyersignupComponent               
             },
             {
                path: "sellersignup", component: SellersignupComponent               
             },
            {
                path: "store", component: StoreComponent,
                canActivate: [StoreFirstGuard]
            },
            {
                path: "cart", component: CartDetailComponent,
                canActivate: [StoreFirstGuard]
            },
            {
                path: "history", component: HistoryComponent,
                canActivate: [StoreFirstGuard]
            },
            {
                path: "additem", component: AdditemComponent,
                canActivate: [StoreFirstGuard]
            },
            {
                path: "checkout", component: CheckoutComponent,
                canActivate: [StoreFirstGuard]
            },
            {
                path: "admin",
                loadChildren: "./admin/admin.module#AdminModule",
                canActivate: [StoreFirstGuard]
            },

           { path: "**", redirectTo: "/home" }

        ])],
    providers: [
        StoreFirstGuard,
        AuthenticationService,
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
     ],
    declarations: [AppComponent, MoneyPipe,SigninComponent],
    bootstrap: [AppComponent]
})
export class AppModule { }
