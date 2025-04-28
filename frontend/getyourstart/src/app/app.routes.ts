import { Routes } from '@angular/router';
import { ViewJobsComponent } from './view-jobs/view-jobs.component';
import { LoginComponent } from './login/login.component';
import { SavedJobsComponent } from './savedjobs/savedjobs.component';

export const routes: Routes = [
    { path: 'view_jobs', component: ViewJobsComponent },
    { path: 'login', component: LoginComponent },
    { path: 'savedjobs', component: SavedJobsComponent },
    { path: '**', component: ViewJobsComponent }, // Default route
];
