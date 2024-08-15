package com.job.app.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    Job getById(Long id);
    void createJob(Job job);
    Boolean deleteJob(Long id);
    Boolean updateJob(Long id, Job j);
}
