package com.job.app.company.impl;

import com.job.app.company.Company;
import com.job.app.company.CompanyRepository;
import com.job.app.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    final CompanyRepository coRepo;

    public CompanyServiceImpl(CompanyRepository coRepo) {
        this.coRepo = coRepo;
    }

    @Override
    public List<Company> findAll() {
        return coRepo.findAll();
    }

    @Override
    public Company getById(Long id) {
        Optional<Company> company = coRepo.findById(id);
        return company.orElse(null);
    }

    @Override
    public Boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> targetCompany = coRepo.findById(id);
        if (targetCompany.isPresent()){
            Company comp=targetCompany.get();
            comp.setName(updatedCompany.getName());
            comp.setDescription(updatedCompany.getDescription());
            comp.setJobs(updatedCompany.getJobs());
            coRepo.save(comp);
            return true;
        }
        return false;
    }

    @Override
    public Void createCompany(Company newCompany) {
        coRepo.save(newCompany);

        return null;
    }

    @Override
    public Boolean deleteCompany(Long id) {
        Optional<Company> delCom = coRepo.findById(id);
        if (delCom.isPresent()){
            coRepo.deleteById(id);
            return true;
        } return false;
    }
}
