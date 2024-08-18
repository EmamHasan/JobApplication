package com.job.app.review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews(Long companyId);
    Review reviewById(Long companyId, Long id);
    boolean editReview(Long id, Review review);
    boolean createReview(Review review, Long companyId);
    boolean deleteReview(Long id);
}
