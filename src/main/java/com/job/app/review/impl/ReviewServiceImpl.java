package com.job.app.review.impl;

import com.job.app.company.Company;
import com.job.app.company.CompanyService;
import com.job.app.review.Review;
import com.job.app.review.ReviewRepository;
import com.job.app.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    final ReviewRepository revRepo;
    final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository revRepo, CompanyService companyService) {
        this.revRepo = revRepo;
        this.companyService = companyService;
    }

    @Override
    public List<Review> findAllReviews(Long companyId) {
        return revRepo.findByCompanyId(companyId);
    }

    @Override
    public boolean createReview(Review review, Long companyId) {
        Company company =  companyService.getById(companyId);
        if (company != null){
            review.setCompany(company);
            revRepo.save(review);
            return true;
        } return false;

    }

    @Override
    public Review reviewById(Long companyId, Long id) {
        List<Review> reviews = revRepo.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public boolean editReview(Long id, Review review) {
        Optional<Review> revSearch = revRepo.findById(id);
        if (revSearch.isPresent()){
            Review newReview= revSearch.get();
            newReview.setTitle(review.getTitle());
            newReview.setDescription(review.getDescription());
            newReview.setRating(review.getRating());
            revRepo.save((newReview));
            return true;
        }
        return false;
    }



    @Override
    public boolean deleteReview(Long id) {
        Optional<Review> res= revRepo.findById(id);
        if (res.isPresent()){
            revRepo.deleteById(id);
            return true;
        } return false;

    }
}
