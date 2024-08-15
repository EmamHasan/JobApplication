package com.job.app.review.impl;

import com.job.app.review.Review;
import com.job.app.review.ReviewRepository;
import com.job.app.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    final ReviewRepository revRepo;

    public ReviewServiceImpl(ReviewRepository revRepo) {
        this.revRepo = revRepo;
    }

    @Override
    public List<Review> findAll() {
        return revRepo.findAll();
    }

    @Override
    public Review reviewById(Long id) {
        return revRepo.findById(id).orElse(null);
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
    public void createReview(Review review) {
        revRepo.save(review);
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
