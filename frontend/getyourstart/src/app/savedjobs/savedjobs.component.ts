import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { getLoggedInUser } from "../middleware/users-middlware";
import { deleteGYSJob, getGYSJobs, getGYSSavedJobs } from "../middleware/jobs-middleware";

@Component({
    selector : "app-savedjobs",
    imports : [CommonModule],
    templateUrl : "savedjobs.component.html",
    standalone : true,
    styleUrls : ["savedjobs.component.css"]
})

export class SavedJobsComponent {
    viewingJob : boolean = false;
    jobs : any = [];
    chosenJob : any = null
    user : any = null;
    loading : boolean = true;

    async ngOnInit() {
        this.loading = true;
        this.user = await getLoggedInUser();
        this.jobs = await getGYSSavedJobs(this.user.id);
        this.reformatDates();
        this.loading = false;
    }


    setSelectedJob(index : number) {
        this.chosenJob = this.jobs[index];
        console.log(index);
        console.log(this.chosenJob);
        this.toggleJobView();
    }


    deleteJobHandler() {
        deleteGYSJob(this.chosenJob.id);
        window.location.reload();
    }

    toggleJobView() {
        this.viewingJob = !(this.viewingJob);
    }

    reformatDates() {
        this.jobs.forEach((job : any) => {
            if (job.created !== null) {
                var datetime = new Date(job.created);
                
                const month = (datetime.getMonth() + 1).toString().padStart(2, '0'); // months are 0-indexed
                const day = datetime.getDate().toString().padStart(2, '0');
                const year = datetime.getFullYear();

                const formattedDate = `${month}/${day}/${year}`;

                job.date = formattedDate;
            }
        });
    }
}