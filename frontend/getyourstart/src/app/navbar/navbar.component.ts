import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { getLoggedInUser } from "../middleware/users-middlware";
import { RouterModule } from "@angular/router";

@Component({
    selector : "app-navbar",
    templateUrl : "./navbar.component.html",
    styleUrls : ["./navbar.component.css"],
    imports : [CommonModule, RouterModule],
    standalone : true
})

export class NavbarComponent {
    user : any = null;
    navDrawerVisibility : boolean = false;

    async ngOnInit() {
        this.user = await getLoggedInUser();
        console.log(this.user);
    }

    togglevisibility() {
        this.navDrawerVisibility = !this.navDrawerVisibility;
    }
}