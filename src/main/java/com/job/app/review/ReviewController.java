package com.job.app.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {
    final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> findAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.findAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/addReview")
    public ResponseEntity<String> createReview(@RequestBody Review review, @PathVariable Long companyId) {
        boolean res=reviewService.createReview(review, companyId);
        if(res){
            return new ResponseEntity<>("Review created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Company not found by this ID "+companyId, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<Review> reviewById(@PathVariable Long companyId, @PathVariable Long id) {
        return new ResponseEntity<>(reviewService.reviewById(companyId, id), HttpStatus.OK);
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<?> editReview(@PathVariable Long companyId, @PathVariable Long id, @RequestBody Review review) {
        boolean res= reviewService.editReview(companyId, id, review);
        if (res){
            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        } return new ResponseEntity<>("Review not found with the given company ID "+companyId+" or Review ID "+id, HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/review/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long id) {
        boolean response = reviewService.deleteReview(id);
        if (response){
            return new ResponseEntity<>("Review deleted with ID "+companyId, HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not found with company ID "+companyId+" or Review ID "+id, HttpStatus.NOT_FOUND);
    }

}
