import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Item } from "./item.model";
import { RestDataSource } from "./rest.datasource";

@Injectable()
export class OrderRepository {
    private items: Item[] = [];
    private loaded: boolean = false;

    constructor(private dataSource: RestDataSource) { }

    deleteItem(id: number) {
        this.dataSource.deleteOrder(id).subscribe(order => {
            this.items.splice(this.items.findIndex(o => id == o.id));
        });
    }

}
