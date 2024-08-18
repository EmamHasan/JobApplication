package com.job.app.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        try{
            jobService.createJob(job);
            return new ResponseEntity<>("Job Created Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Company does not exist", HttpStatus.NOT_IMPLEMENTED);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Job response=jobService.getById(id);
        if (response!=null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Job exist with this ID", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateJob(@PathVariable Long id, @RequestBody Job job){
        boolean response=jobService.updateJob(id, job);
        if (response){
            return new ResponseEntity<>("Job with id: "+id+" updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("No Job found with ID: "+id, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob (@PathVariable Long id){
        boolean response = jobService.deleteJob(id);
        if (response){
            return new ResponseEntity<>("Job deleted with ID: "+id, HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found with ID: "+id, HttpStatus.NOT_FOUND);
    }

}
