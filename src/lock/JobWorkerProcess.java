package lock;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JobWorkerProcess {
    private Map<Long, Job> jobs;

    public Job getJob(long jobId) {
        return jobs.get(jobId);
    }

    public Status getJobState(long obId) {
        return getJob(obId).status;
    }

    public void updateJobStatus(long jobId, Status status, long epochTimeOfUpdate) {
        Job job = getJob(jobId);
        LocalDate date = Instant
                .ofEpochMilli(epochTimeOfUpdate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        if(LocalDate.now().isBefore(date) &&
                job.status != Status.COMPLETE &&
                job.status != Status.ERROR){
            job.status = status;
        }
    }

    public List<Job> getJobs(int K) {
        List<Job> result = new ArrayList<>();
        for (Job job : jobs.values()) {
            if (job.status != Status.COMPLETE && job.status != Status.ERROR) {
                result.add(job);
            }
        }
        Collections.sort(result, (a, b) -> Long.compare(b.epochTimeOfUpdate, a.epochTimeOfUpdate));
        return result.subList(0, K);
    }

}
