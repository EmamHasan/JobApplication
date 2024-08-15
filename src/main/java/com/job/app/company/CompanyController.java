package com.job.app.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/createCompany")
    public ResponseEntity<?> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created successfully", HttpStatus.OK);
    }
    @GetMapping("/companies/{id}")
    public ResponseEntity<?> getCompanyById(@PathVariable Long id){
        Company company = companyService.getById(id);
        if (company!=null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        } return new ResponseEntity<>("No Company found with the ID "+id, HttpStatus.NOT_FOUND);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        companyService.updateCompany(id, company);
        return new ResponseEntity<>("Company with ID "+id+" updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
    }
}
