import { Routes } from '@angular/router';
import { ViewJobsComponent } from './view-jobs/view-jobs.component';

export const routes: Routes = [
    { path: 'view_jobs', component: ViewJobsComponent },
    { path: '**', component: ViewJobsComponent }, // Default route
];
