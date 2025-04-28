/*
@RestController
public class AdzunaJobController {
    private AdzunaJobService jobService;

    @Autowired
    public AdzunaJobController(AdzunaJobService jobService) {
        this.jobService = jobService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/adzuna/job")
    public ResponseEntity<List<AdzunaJob>> getJobs(@RequestBody AdzunaJobRequest jobRequest) {
        List<AdzunaJob> jobsFound = jobService.getJobs(jobRequest);
        if (jobsFound != null)
            return new ResponseEntity<>(jobsFound, HttpStatus.OK);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/adzuna/job/save")
    public ResponseEntity<AdzunaJobHttpResponse> saveJob(@RequestBody AdzunaJob adzunaJob, HttpSession session) {
        AdzunaJobModel savedJob = jobService.saveJob(adzunaJob, session);
        AdzunaJobHttpResponse savedJobResponse = savedJob.createResponse();
        if (savedJobResponse != null)
            return new ResponseEntity<>(savedJobResponse, HttpStatus.OK);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/adzuna/job/save/get")
    public ResponseEntity<List<AdzunaJobHttpResponse>> getSavedJobs(@RequestBody String userId) {
        List<AdzunaJobHttpResponse> savedAdzunaJobs = jobService.getSavedJobs(userId);
        if (savedAdzunaJobs != null)
            return new ResponseEntity<>(savedAdzunaJobs, HttpStatus.OK);
        else 
            return ResponseEntity.badRequest().body(null);

    }
}
    */



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

export async function saveAdzunaJob(adzunaJob : any) {
    const jobsResponse = await fetch("http://localhost:8080/api/adzuna/job/save", {
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

export async function getSavedAdzunaJobs(userId : String) {
    const jobsResponse = await fetch(`http://localhost:8080/api/adzuna/job/save/get/${userId}`, {
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
    const jobsResponse = await fetch("http://localhost:8080/api/jsearch/job/save", {
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

export async function getSavedJSearchJobs(userId : String) {
    const jobsResponse = await fetch(`http://localhost:8080/api/jsearch/job/save/get/${userId}`, {
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

