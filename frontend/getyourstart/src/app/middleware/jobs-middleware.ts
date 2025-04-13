//Get Jobs

export async function getJobs(jobsRequest : any) {
    const jobsResponse = await fetch("http://localhost:8080/api/jobs", {
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

export default getJobs;