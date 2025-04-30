import { ChangeDetectorRef, Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { authenticateUser, createUser } from "../middleware/users-middlware";
import { Router } from "@angular/router";

@Component({
    selector : "app-signup",
    templateUrl : "./signup.component.html",
    imports : [CommonModule],
    standalone : true,
    styleUrls : ["./signup.component.css"]
})

export class SignupComponent {
    username : string = "";
    password : string = "";
    usernameValidator : boolean = false;
    passwordValidator : boolean = false;
    creationMessage : boolean = false;

    constructor(private router: Router, private cdRef: ChangeDetectorRef) {}

    alterUsername(e : Event) {
        const username = (e.target as HTMLInputElement).value;
        this.username = username;
        this.validateUsername();
    }

    alterPassword(e : Event) {
        const password = (e.target as HTMLInputElement).value;
        this.password = password;
        this.validatePassword();
    }

    validateUsername() {
        if (!(this.username.length >= 4)) {
            this.usernameValidator = false;
            return;
        }

        this.usernameValidator = true;
    }

    validatePassword() {
        if (!(this.password.length >= 7)) {
            this.passwordValidator = false;
            return;
        }

        if (this.password.toLocaleLowerCase() === this.password) {
            this.passwordValidator = false;
            return;
        }

        const specialChars = [
            '!', '"', '#', '$', '%', '&', "'", '(', ')', '*', '+', ',', '-', '.', '/',
            ':', ';', '<', '=', '>', '?', '@',
            '[', '\\', ']', '^', '_', '`',
            '{', '|', '}', '~'
          ];

          const numbers = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']

          var index = 0;

          while (index < specialChars.length) {
            if (this.password.includes(specialChars[index])) {
                break;
            }

            if (index === specialChars.length - 1) {
                this.passwordValidator = false;
                return;
            }

            index++;
          }

          index = 0;

          while (index < numbers.length) {
            if (this.password.includes(numbers[index])) {
                break;
            }

            if (index === numbers.length - 1) {
                this.passwordValidator = false;
                return;
            }

            index++;
          }


        this.passwordValidator = true;
    }

    async submit() {
        if (this.usernameValidator === true && this.passwordValidator === true) {
            const userRequest = {
                username : this.username,
                password : this.password
            }

            const newUser = await createUser(userRequest);

            if (newUser) {
                this.router.navigateByUrl(`/view_jobs`).then(() => {
                    window.location.reload();
                });
                return newUser;
            } else {
                this.creationMessage = true;
                return null;
            }
        }
    }
}