import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { getJobs } from "../middleware/jobs-middleware";

@Component({
    selector : "app-viewjobs",
    imports : [CommonModule],
    templateUrl : "view-jobs.component.html",
    standalone : true,
    styleUrls : ["view-jobs.component.css"]
})

export class ViewJobsComponent {
    jobs : any;
    jobRequest : any  = {
        country : 'us',
        numResults: null,
        jobTypes: [],
        page: 1,
        where: null,
        distance: null,
        sortBy: null,
        salaryMin: null,
        salaryMax: null,
        fullTime: null,
        partTime: null,
        contract: null,
        permanent: null 
    };
    jobsQueried : boolean = false;


    addType(e : Event) {
        var whatInput = (e.target as HTMLElement).previousElementSibling;
        console.log(whatInput);
        this.jobRequest.jobTypes.push((whatInput as HTMLInputElement).value);
    }

    alterCountry(e : Event) {
        this.jobRequest.country = (e.target as HTMLSelectElement).value;
    }

    alterNumResults(e : Event) {
        this.jobRequest.numResults = (e.target as HTMLInputElement).value;
    }

    alterPage(e : Event) {
        this.jobRequest.page = (e.target as HTMLInputElement).value;
    }

    alterWhere(e : Event) {
        this.jobRequest.where = (e.target as HTMLInputElement).value;
    }

    alterDistance(e : Event) {
        this.jobRequest.distance = (e.target as HTMLInputElement).value;
    }

    alterSortBy(e : Event) {
        this.jobRequest.sortBy = (e.target as HTMLInputElement).value;
    }

    alterSalaryMin(e : Event) {
        this.jobRequest.salaryMin = (e.target as HTMLInputElement).value;
    }

    alterSalaryMax(e : Event) {
        this.jobRequest.salaryMax = (e.target as HTMLInputElement).value;
    }

    alterFullTime(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.jobRequest.fullTime = 1
        } else {
            this.jobRequest.fullTime = null
        }
    }

    alterPartTime(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.jobRequest.partTime = 1
        } else {
            this.jobRequest.partTime = null
        }
    }

    alterContract(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.jobRequest.contract = 1
        } else {
            this.jobRequest.contract = null
        }
    }

    alterPermanent(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.jobRequest.permanent = 1
        } else {
            this.jobRequest.permanent = null
        }
    }

    async submit() {
        console.log(this.jobRequest)
        this.jobs = await getJobs(this.jobRequest);
        console.log(this.jobs);
        this.jobsQueried = true;
    }

}