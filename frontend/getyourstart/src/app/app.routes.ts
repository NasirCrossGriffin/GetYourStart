import { Routes } from '@angular/router';
import { ViewJobsComponent } from './view-jobs/view-jobs.component';
import { LoginComponent } from './login/login.component';
import { SavedJobsComponent } from './savedjobs/savedjobs.component';
import { SignupComponent } from './signup/signupcomponent';
import { LandingPageComponent } from './landingpage/landingpage.component';

export const routes: Routes = [
    { path: 'view_jobs', component: ViewJobsComponent },
    { path: 'login', component: LoginComponent },
    { path: 'signup', component: SignupComponent },
    { path: 'savedjobs', component: SavedJobsComponent },
    { path: 'home', component: LandingPageComponent },
    { path: '**', component: ViewJobsComponent }, // Default route
];
