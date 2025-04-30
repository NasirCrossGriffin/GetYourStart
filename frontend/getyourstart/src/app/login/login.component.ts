import { ChangeDetectorRef, Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { authenticateUser } from "../middleware/users-middlware";
import { Router } from "@angular/router";

@Component({
    selector : "app-login",
    templateUrl : "./login.component.html",
    imports : [CommonModule],
    standalone : true,
    styleUrls : ["./login.component.css"]
})

export class LoginComponent {
    username : string = "";
    password : string = "";
    authenticationMessage : boolean = false;
    constructor(private router: Router, private cdRef: ChangeDetectorRef) {}

    alterUsername(e : Event) {
        const username = (e.target as HTMLInputElement).value;
        this.username = username;
    }

    alterPassword(e : Event) {
        const password = (e.target as HTMLInputElement).value;
        this.password = password;
    }

    async submit() {
        const userRequest = {
            username : this.username,
            password : this.password
        }

        const foundUser = await authenticateUser(userRequest);

        if (foundUser) {
            this.router.navigateByUrl(`/view_jobs`).then(() => {
                window.location.reload();
              });
              return foundUser;
        } else {
            this.authenticationMessage = true;
            return null;
        }
    }
}