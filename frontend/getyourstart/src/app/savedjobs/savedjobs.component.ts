import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { getLoggedInUser } from "../middleware/users-middlware";
import { getAdzunaJobs, getJSearchJobs, getSavedJSearchJobs } from "../middleware/jobs-middleware";
import { getSavedAdzunaJobs } from "../middleware/jobs-middleware";

@Component({
    selector : "app-savedjobs",
    imports : [CommonModule],
    templateUrl : "savedjobs.component.html",
    standalone : true,
    styleUrls : ["savedjobs.component.css"]
})

export class SavedJobsComponent {
    viewingJob : boolean = false;
    adzunaJobs : any = [];
    chosenJob : any = {
        API : null,
        job : null
    }
    jsearchJobs : any = [];
    user : any = null;
    loading : boolean = true;

    async ngOnInit() {
        this.loading = true;
        this.user = await getLoggedInUser();
        this.adzunaJobs = await getSavedAdzunaJobs(this.user.id);
        this.jsearchJobs = await getSavedJSearchJobs(this.user.id);
        this.loading = false;
    }


    setAdzunaJob(index : number) {
        this.chosenJob.API = "Adzuna";
        this.chosenJob.job = this.adzunaJobs[index];
        console.log(index);
        console.log(this.chosenJob);
        this.toggleJobView();
    }

    setJsearchJob(index : number) {
        this.chosenJob.API = "JSearch";
        this.chosenJob.job = this.jsearchJobs[index];
        console.log(index);
        console.log(this.chosenJob);
        this.toggleJobView();
    }

    toggleJobView() {
        this.viewingJob = !(this.viewingJob);
    }
}