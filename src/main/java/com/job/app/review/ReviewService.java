package com.job.app.review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews(Long companyId);
    Review reviewById(Long companyId, Long id);
    boolean editReview(Long companyId, Long id, Review updatedReview);
    boolean createReview(Review review, Long companyId);
    boolean deleteReview(Long id);
}
