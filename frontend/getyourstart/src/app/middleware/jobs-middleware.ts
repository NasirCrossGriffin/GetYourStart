import { environment } from "../../environments/environment";

//Get Jobs

const BASE_URL : string = environment.BASE_URL;

export async function getAdzunaJobs(jobsRequest : any) {
    const jobsResponse = await fetch(`${BASE_URL}/api/adzuna/job`, {
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

export async function getJSearchJobs(jobsRequest : any) {
    const jobsResponse = await fetch(`${BASE_URL}/api/jsearch/job`, {
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

export async function saveAdzunaJob(adzunaJob : any) {
    const jobsResponse = await fetch(`${BASE_URL}/api/adzuna/job/save`, {
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

export async function deleteAdzunaJob(jobId : any) {
    const jobsResponse = await fetch(`${BASE_URL}/api/adzuna/job/delete/${jobId}`, {
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

export async function getSavedAdzunaJobs(userId : String) {
    const jobsResponse = await fetch(`${BASE_URL}/api/adzuna/job/save/get/${userId}`, {
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


export async function saveJSearchJob(jsearchJob : any) {
    const jobsResponse = await fetch(`${BASE_URL}/api/jsearch/job/save`, {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        credentials: 'include',  
        body : JSON.stringify(jsearchJob)
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

export async function deleteJSearchJob(jobId : any) {
    const jobsResponse = await fetch(`${BASE_URL}/api/jsearch/job/delete/${jobId}`, {
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


export async function getSavedJSearchJobs(userId : String) {
    const jobsResponse = await fetch(`${BASE_URL}/api/jsearch/job/save/get/${userId}`, {
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

