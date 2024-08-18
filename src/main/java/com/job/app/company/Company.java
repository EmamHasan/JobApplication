package com.job.app.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.job.app.job.Job;
import com.job.app.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<Review> review;

    public Company(Long id, String name, String description, List<Job> jobs, List<Review> review) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.jobs = jobs;
        this.review = review;
    }

    public Company() {
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
