import { Component } from "@angular/core";
import { Product } from "../model/product.model";
import { ProductRepository } from "../model/product.repository";
import { Cart } from "../model/cart.model";
import { Router } from "@angular/router";

@Component({
    selector: "store",
    templateUrl: "store.component.html"
})
export class StoreComponent {
    public selectedCategory = null;
    public productsPerPage = 4;
    public selectedPage = 1;

    showAdditem: boolean = false;
    showName: string;

    constructor(private repository: ProductRepository,
        private cart: Cart,
        private router: Router) { }

    get products(): Product[] {
        let pageIndex = (this.selectedPage - 1) * this.productsPerPage
        return this.repository.getProducts(this.selectedCategory)
            .slice(pageIndex, pageIndex + this.productsPerPage);
    }

    get categories(): string[] {
        return this.repository.getCategories();
    }

    changeCategory(newCategory?: string) {
        this.selectedCategory = newCategory;
    }

    changePage(newPage: number) {
        this.selectedPage = newPage;
    }

    changePageSize(newSize: number) {
        this.productsPerPage = Number(newSize);
        this.changePage(1);
    }

    get pageCount(): number {
        return Math.ceil(this.repository
            .getProducts(this.selectedCategory).length / this.productsPerPage)
    }

    addProductToCart(product: Product) {
        this.cart.addLine(product);
        this.router.navigateByUrl("/cart");
    }

    toAuth() {
        this.router.navigateByUrl("/auth");
    }
    toAdmin() {
        this.router.navigateByUrl("/admin");
    }
    toSeller(){
        // only seller  additem<username:seller>
        this.showName = sessionStorage.getItem('username');
        if(this.showName === 'seller')
           {
               this.router.navigateByUrl("/additem");
               this.showAdditem = true;
           }
        else
            {   this.router.navigateByUrl("/store");
               console.log("you are buyer or admin,you are not additem!!!");
          }

    }


    isSignin: boolean;
    //ngOnInit-----start--------------
      ngOnInit(): void {
        if (sessionStorage.getItem('token')){
          this.isSignin = true;
          console.log('isSignin true1');
        } else {
          this.isSignin = false;
          console.log('isSignin false1');
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
    


}
