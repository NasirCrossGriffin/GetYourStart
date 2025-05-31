import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { getAdzunaJobs, getJSearchJobs, saveJSearchJob } from "../middleware/jobs-middleware";
import { saveAdzunaJob } from "../middleware/jobs-middleware";
import { getLoggedInUser } from "../middleware/users-middlware";

@Component({
    selector : "app-viewjobs",
    imports : [CommonModule],
    templateUrl : "view-jobs.component.html",
    standalone : true,
    styleUrls : ["view-jobs.component.css"]
})

export class ViewJobsComponent {
    viewingJob : boolean = false;
    adzunaJobs : any;
    loading : boolean = false;
    saveConfirmation : boolean = false;
    chosenJob : any = {
        API : null,
        job : null
    }
    jsearchJobs : any;
    adzunaJobRequest : any  = {
        country : 'us',
        numResults: 20,
        jobTypes: [],
        page: 1,
        where: null,
        distance: null,
        sortBy: null,
        salaryMin: null,
        salaryMax: null,
        fullTime: 1,
        partTime: 1,
        contract: 1,
        permanent: 1 
    };
    jsearchJobRequest : any  = {
         job : null,
         page : 1,
         numPages : 1,
         country : 'us',
         language : 'en',
         datePosted : 'all',
         employmentTypes : 'FULLTIME',
         jobRequirements : 'no_experience',
         radius : null
    };
    jobsQueried : boolean = false;
    saveJobRevealed : boolean = false;
    saveJobStatus : boolean = false;
    user : any = null;
    DrawerVisibility : boolean = true;
    jobValidator : boolean = false;
    jobTypeValidator : boolean = false;

    async ngOnInit() {
        this.user = await getLoggedInUser();
    }

    alterType(e : Event) {
        this.adzunaJobRequest.jobTypes[0] = (e.target as HTMLSelectElement).value;
        this.jsearchJobRequest.job = (e.target as HTMLSelectElement).value;
        this.validateJob()
    }

    alterCountry(e : Event) {
        this.adzunaJobRequest.country = (e.target as HTMLSelectElement).value;
        this.jsearchJobRequest.country = (e.target as HTMLSelectElement).value;
    }

    alterNumResults(e : Event) {
        this.adzunaJobRequest.numResults = (e.target as HTMLInputElement).value;
    }

    alterPage(e : Event) {
        this.adzunaJobRequest.page = (e.target as HTMLInputElement).value;
    }

    alterWhere(e : Event) {
        this.adzunaJobRequest.where = (e.target as HTMLInputElement).value;
    }

    alterDistance(e : Event) {
        this.adzunaJobRequest.distance = (e.target as HTMLInputElement).value;
        this.jsearchJobRequest.radius = (e.target as HTMLInputElement).value;
    }

    alterSortBy(e : Event) {
        this.adzunaJobRequest.sortBy = (e.target as HTMLInputElement).value;
    }

    alterSalaryMin(e : Event) {
        this.adzunaJobRequest.salaryMin = (e.target as HTMLInputElement).value;
    }

    alterSalaryMax(e : Event) {
        this.adzunaJobRequest.salaryMax = (e.target as HTMLInputElement).value;
    }

    alterFullTime(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.adzunaJobRequest.fullTime = 1;
            this.jsearchJobRequest.employmentTypes = 'FULLTIME';
            console.log(this.jsearchJobRequest.employmentTypes);
        } else {
            this.adzunaJobRequest.fullTime = null
        }
        this.validateJobType()
    }

    alterPartTime(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.adzunaJobRequest.partTime = 1
            this.jsearchJobRequest.employmentTypes = 'PARTTIME';
            console.log(this.jsearchJobRequest.employmentTypes);
        } else {
            this.adzunaJobRequest.partTime = null
        }
        this.validateJobType()

    }

    alterContract(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.adzunaJobRequest.contract = 1
            this.jsearchJobRequest.employmentTypes = 'CONTRACTOR';
            console.log(this.jsearchJobRequest.employmentTypes)

        } else {
            this.adzunaJobRequest.contract = null
        }
        this.validateJobType()

    }

    alterPermanent(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.adzunaJobRequest.permanent = 1
            this.jsearchJobRequest.employmentTypes = 'CONTRACTOR';
            console.log(this.jsearchJobRequest.employmentTypes);
        } else {
            this.adzunaJobRequest.permanent = null
        }
        this.validateJobType()

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

    async submit() {
        if (this.jobValidator === false || this.jobTypeValidator === false) {
            return
        }

        if (this.adzunaJobRequest.where === null || this.adzunaJobRequest.where === '') {
            this.adzunaJobRequest.where = this.adzunaJobRequest.country
        }

        if (this.adzunaJobRequest.distance === null || this.adzunaJobRequest.distance === '' || this.jsearchJobRequest.radius === null || this.jsearchJobRequest.radius === '') {
            this.adzunaJobRequest.distance = null
            this.jsearchJobRequest.radius = 100
        }

        this.loading = true;
        this.jsearchJobRequest.job = this.adzunaJobRequest.jobTypes.join(", ") + " in " + this.adzunaJobRequest.where;
        console.log(this.adzunaJobRequest)
        console.log(this.jsearchJobRequest)
        this.adzunaJobs = await getAdzunaJobs(this.adzunaJobRequest);
        this.reformatDates();
        this.jsearchJobs = await getJSearchJobs(this.jsearchJobRequest);
        console.log(this.adzunaJobs);
        console.log(this.jsearchJobs);
        this.jobsQueried = true;
        this.loading = false;
    }

    async saveAdzunaJobHandler() {
        const savedJob = await saveAdzunaJob(this.chosenJob.job);
        if (savedJob !== null) {
            this.saveJobStatus = true;
        } else {
            this.saveJobStatus = false;
        }
        this.saveJobRevealed = true;
        this.saveConfirmation = true;
        setTimeout(() => {
            this.hideSaveConfirmation();
          }, 5000);
        console.log(savedJob);
        
    }

    async saveJSearchJobHandler() {
        const savedJob = await saveJSearchJob(this.chosenJob.job);
        if (savedJob !== null) {
            this.saveJobStatus = true;
        } else {
            this.saveJobStatus = false;
        }
        this.saveJobRevealed = true;
        this.saveConfirmation = true;
        setTimeout(() => {
            this.hideSaveConfirmation();
          }, 5000);
        console.log(savedJob);
    }

    hideSaveConfirmation() {
        this.saveConfirmation = false;
    }

    reformatDates() {
        this.adzunaJobs.forEach((job : any) => {
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

    toggleDrawerVisibiity() {
        this.DrawerVisibility = !this.DrawerVisibility;
    }

    validateJob() {
        console.log("job validator triggered")
        if (this.adzunaJobRequest.jobTypes[0] === null || this.adzunaJobRequest.jobTypes[0] === '' || this.jsearchJobRequest.job === null || this.jsearchJobRequest.job === '') {
            this.jobValidator = false
            return
        }

        this.jobValidator = true;
    }

    validateJobType() {
        const listOfTypes = [this.adzunaJobRequest.fullTime, this.adzunaJobRequest.partTime, this.adzunaJobRequest.contract, this.adzunaJobRequest.permanent]
        var trueCount = 0

        console.log(listOfTypes)

        listOfTypes.forEach((type) => {
            if (type === 1) 
                trueCount++
        })

        console.log("True count is: " + trueCount)

        if (trueCount > 1 || trueCount === 0) {
            this.jobTypeValidator = false
            return
        }

        this.jobTypeValidator = true;
    }


}