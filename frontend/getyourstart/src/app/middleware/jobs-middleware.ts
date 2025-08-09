import { environment } from "../../environments/environment";

//Get Jobs

/*
    @PostMapping("/api/gys/job")
    @PostMapping("/api/gys/job/save")
    @PostMapping("/api/gys/job/save/get/{userId}")
    @PostMapping("/api/gys/job/delete/{jobId}")
*/

const BASE_URL : string = environment.BASE_URL;

export async function getGYSJobs(jobsRequest : any) {
    const jobsResponse = await fetch(`${BASE_URL}/api/gys/job`, {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(jobsRequest)
    });
    if (jobsResponse.ok) {
        try {
            const jobs = jobsResponse.json();

            return jobs;
        } catch (err) {
            console.log(err)
            return null;
        }
    } else {
        console.log(jobsResponse.text());
    }
}

export async function saveGYSJob(adzunaJob : any) {
    const jobsResponse = await fetch(`${BASE_URL}/api/gys/job/save`, {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        credentials: 'include',  
        body : JSON.stringify(adzunaJob)
    });
    if (jobsResponse.ok) {
        try {
            const savedJob = await jobsResponse.json();
            console.log(savedJob);
            return savedJob;
        } catch (err) {
            console.log(err)
            return null;
        }
    } else {
        return null;
    }
}

export async function deleteGYSJob(jobId : any) {
    const jobsResponse = await fetch(`${BASE_URL}/api/gys/job/delete/${jobId}`, {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
    });
    if (jobsResponse.ok) {
        try {
            return true;
        } catch (err) {
            console.log(err)
            return false;
        }
    } else {
        return false;
    }
}

export async function getGYSSavedJobs(userId : String) {
    const jobsResponse = await fetch(`${BASE_URL}/api/gys/job/save/get/${userId}`, {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
    });
    if (jobsResponse.ok) {
        try {
            const savedJobs = await jobsResponse.json();
            console.log(savedJobs);
            return savedJobs;
        } catch (err) {
            console.log(err)
            return null;
        }
    } else {
        return null;
    }
}

//Save Jobs

