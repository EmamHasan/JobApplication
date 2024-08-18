package com.job.app.job.impl;

import com.job.app.job.Job;
import com.job.app.job.JobRepository;
import com.job.app.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    final JobRepository jobs;

    public JobServiceImpl(JobRepository jobs) {
        this.jobs = jobs;
    }

    @Override
    public List<Job> findAll() {
        return jobs.findAll();
    }

    @Override
    public Job getById(Long id) {
        for (Job job:jobs.findAll()){
            if (job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public void createJob(Job job) {
        jobs.save(job);
    }

    @Override
    public Boolean deleteJob(Long id) {
        try{
            jobs.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Boolean updateJob(Long id, Job j) {
        for (Job job:jobs.findAll()){
            if (job.getId().equals(id)){
                job.setTitle(j.getTitle());
                job.setDescription(j.getDescription());
                job.setMaxSalary(j.getMaxSalary());
                job.setMinSalary(j.getMinSalary());
                job.setLocation(j.getLocation());
                jobs.save(job);
                return true;
            }
        }
        return false;
    }

}
