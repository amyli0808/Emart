import { Injectable } from "@angular/core";

@Injectable()
export class Item {
    public id: number;
    public category: string;
    public subcategory: string;
    public itemname: string;
    public price?: number;
    public itemtype: string;
    public country: string;
    public shipped: boolean = false;
}
