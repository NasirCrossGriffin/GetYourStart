import { ChangeDetectorRef, Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { getLoggedInUser, logoutUser } from "../middleware/users-middlware";
import { Router, RouterModule } from "@angular/router";

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
    constructor(private router: Router, private cdRef: ChangeDetectorRef) {}


    async ngOnInit() {
        this.user = await getLoggedInUser();
        console.log(this.user);
    }

    togglevisibility() {
        this.navDrawerVisibility = !this.navDrawerVisibility;
    }

    async logout() {
        const logoutMessage = await logoutUser();
        console.log(logoutMessage);
        this.router.navigateByUrl(`/login`).then(() => {
            window.location.reload();
          });
    }

    navigateHome() {
        this.router.navigateByUrl(`/home`)
    }
}