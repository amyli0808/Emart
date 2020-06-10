import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Product } from "./product.model";
import { Cart } from "./cart.model";
import { Order } from "./order.model";
import { map } from "rxjs/operators";
import { HttpHeaders } from '@angular/common/http';
import { Order2 } from './order2.model';

const PROTOCOL = "http";
const PORT = 3500;

@Injectable()
export class RestDataSource {
    baseUrl: string;
    productsUrl: string;
    orderUrl: string;
    itemUrl: string;
    auth_token: string;


    constructor(private http: HttpClient) {
     //   this.baseUrl = `${PROTOCOL}://${location.hostname}:${PORT}/`;
     // this.baseUrl = `http://localhost:5555/api/cloud-buyer-service/api/`;
        this.productsUrl = `http://localhost:5555/api/cloud-buyer-service/api/`;
        this.orderUrl = `http://localhost:5555/api/cloud-buyer-service/api/`;
        this.itemUrl  = `http://localhost:5555/api/cloud-seller-service/api/`;
        
    }
    // this is getproduct (cloud-buyer-service)
    getProducts(): Observable<Product[]> {
    //    return this.http.get<Product[]>(this.baseUrl + "products");
          return this.http.get<Product[]>(this.productsUrl + "products");
    }

    //saveOrder(order: Order): Observable<Order> {
     //     return this.http.post<Order>(this.baseUrl + "orders", order);
     //     return this.http.post<Order>(this.orderUrl + "orders", order,httpOptions);
    // this is saveOrder (cloud-buyer-service) 
     saveOrder2(order2: Order2): Observable<Order2> {
            return this.http.post<Order2>(this.orderUrl + "order", order2);
    }

    authenticate(user: string, pass: string): Observable<boolean> {
        return this.http.post<any>(this.baseUrl + "login", {
            name: user, password: pass
        }).pipe(map(response => {
            this.auth_token = response.success ? response.token : null;
            return response.success;
        }));
    }
    // this is saveProduct (cloud-seller-service) 
    saveProduct(product: Product): Observable<Product> {
        return this.http.post<Product>(this.itemUrl + "products",product, this.getOptions());
    }

    updateProduct(product): Observable<Product> {
        return this.http.put<Product>(`${this.baseUrl}products/${product.id}`,
            product, this.getOptions());
    }

    deleteProduct(id: number): Observable<Product> {
        return this.http.delete<Product>(`${this.baseUrl}products/${id}`,
            this.getOptions());
    }

    getOrders(): Observable<Order[]> {
        return this.http.get<Order[]>(this.baseUrl + "orders", this.getOptions());
    }

    deleteOrder(id: number): Observable<Order> {
        return this.http.delete<Order>(`${this.baseUrl}orders/${id}`,
            this.getOptions());
    }

    updateOrder(order: Order): Observable<Order> {
        return this.http.put<Order>(`${this.baseUrl}orders/${order.id}`,
            this.getOptions());
    }

    private getOptions() {
        return {
            headers: new HttpHeaders(
                { "Authorization": `Bearer<${this.auth_token}>`,
                'Content-Type':  'application/json' }
            )
        }
    }

}
