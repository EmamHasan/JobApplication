package com.job.app.review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    Review reviewById(Long id);
    boolean editReview(Long id, Review review);
    void createReview(Review review);
    boolean deleteReview(Long id);
}
