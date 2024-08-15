package com.job.app.company;

import com.job.app.job.Job;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company getById(Long id);
    Boolean updateCompany(Long id, Company updatedCompany);
    Void createCompany(Company newCompany);
    Boolean deleteCompany(Long id);
}
