import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { getGYSJobs, saveGYSJob } from "../middleware/jobs-middleware";
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
    loading : boolean = false;
    saveConfirmation : boolean = false;
    chosenJob : any = {
        job : null
    }
    jobRequest: any = {
        jobTitle: '',
        country: '',
        where: '',
        distance: null,
        sortBy: '',
        salaryMin: null,
        salaryMax: null,
        fullTime: null,
        partTime: null,
        contract: null,
        permanent: null
    };
    jobs : any = [];
    jobsQueried : boolean = false;
    saveJobRevealed : boolean = false;
    saveJobStatus : boolean = false;
    user : any = null;
    DrawerVisibility : boolean = true;
    jobValidator : boolean = false;
    jobTypeValidator : boolean = false;
    salaryValidator : boolean = false;
    distanceValidator : boolean = false;

    async ngOnInit() {
        this.user = await getLoggedInUser();
    }

    alterType(e : Event) {
        this.jobRequest.jobTitle = (e.target as HTMLSelectElement).value;
        this.validateJob()
    }

    alterCountry(e : Event) {
        this.jobRequest.country = (e.target as HTMLSelectElement).value;
    }

    alterWhere(e : Event) {
        this.jobRequest.where = (e.target as HTMLInputElement).value;
    }

    alterDistance(e : Event) {
        this.jobRequest.distance = (e.target as HTMLInputElement).value;
        this.validateDistance()
    }

    alterSortBy(e : Event) {
        this.jobRequest.sortBy = (e.target as HTMLInputElement).value;
    }

    alterSalaryMin(e : Event) {
        this.jobRequest.salaryMin = (e.target as HTMLInputElement).value;
        this.validateSalary()
    }

    alterSalaryMax(e : Event) {
        this.jobRequest.salaryMax = (e.target as HTMLInputElement).value;
        this.validateSalary()
    }

    alterFullTime(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.jobRequest.fullTime = 1;
        } else {
            this.jobRequest.fullTime = 0;
        }
        this.validateJobType()
    }

    alterPartTime(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.jobRequest.partTime = 1
        } else {
            this.jobRequest.partTime = 0
        }
        this.validateJobType()

    }

    alterContract(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.jobRequest.contract = 1
        } else {
            this.jobRequest.contract = 0
        }
        this.validateJobType()

    }

    alterPermanent(e : Event) {
        if ((e.target as HTMLInputElement).value === 'true') {
            this.jobRequest.permanent = 1
        } else {
            this.jobRequest.permanent = 0
        }
        this.validateJobType()

    }

    setSelectedJob(index : number) {
        this.chosenJob = this.jobs[index];
        console.log(index);
        console.log(this.chosenJob);
        this.toggleJobView();
    }

    toggleJobView() {
        this.viewingJob = !(this.viewingJob);
    }

    async submit() {
        this.validateJob()
        this.validateJobType()
        this.validateDistance()
        this.validateSalary()

        if (this.jobValidator === false || this.jobTypeValidator === false || this.distanceValidator === false || this.salaryValidator === false) {
            return
        }

        if (this.jobRequest.where === null || this.jobRequest.where === '') {
            this.jobRequest.where = this.jobRequest.country
        }

        if (this.jobRequest.distance === null || this.jobRequest.distance === '') {
            this.jobRequest.distance = 25
        }

         if (this.jobRequest.sortBy === 'default') {
            this.jobRequest.sortBy = null
         }

        this.loading = true;
        this.jobs = await getGYSJobs(this.jobRequest)
        console.log(this.jobs);
        this.jobsQueried = true;
        this.loading = false;
    }

    async saveJobHandler() {
        const savedJob = await saveGYSJob(this.chosenJob);
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

    toggleDrawerVisibiity() {
        this.DrawerVisibility = !this.DrawerVisibility;
    }

    validateJob() {
        console.log("job validator triggered")
        if (this.jobRequest.jobTitle === null || this.jobRequest.jobTitle === '' || this.jobRequest.jobTitle === null || this.jobRequest.jobTitle === '') {
            this.jobValidator = false
            return
        }

        this.jobValidator = true;
    }

    validateJobType() {
        const listOfTypes = [this.jobRequest.fullTime, this.jobRequest.partTime, this.jobRequest.contract, this.jobRequest.permanent]
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

    validateSalary() {
        if ((this.jobRequest.salaryMin !== null && this.jobRequest.salaryMin !== '')) {
            this.salaryValidator = !isNaN(parseFloat(this.jobRequest.salaryMin)) && isFinite(this.jobRequest.salaryMin) && !isNaN(parseFloat(this.jobRequest.salaryMax)) && isFinite(this.jobRequest.salaryMax) && !this.jobRequest.salaryMin.includes(" ") && !this.jobRequest.salaryMax.includes(" ");
        } else {
            this.salaryValidator = true
        }
    }

    validateDistance() {
        if ((this.jobRequest.distance !== null && this.jobRequest.distance !== '')) {
            this.distanceValidator = !isNaN(parseFloat(this.jobRequest.distance)) && isFinite(this.jobRequest.distance) && !this.jobRequest.distance.includes(" ");
        } else {
            this.distanceValidator = true
        }
    }
}