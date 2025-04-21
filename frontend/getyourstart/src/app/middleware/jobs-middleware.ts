//Get Jobs

export async function getAdzunaJobs(jobsRequest : any) {
    const jobsResponse = await fetch("http://localhost:8080/api/adzuna/job", {
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
    const jobsResponse = await fetch("http://localhost:8080/api/jsearch/job", {
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

export default getAdzunaJobs;