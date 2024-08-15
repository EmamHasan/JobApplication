package com.job.app.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Review>> findAll() {
        return new ResponseEntity<>(reviewService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Review> reviewById(Long id) {
        return new ResponseEntity<>(reviewService.reviewById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editReview(Long id, Review review) {
        boolean res= reviewService.editReview(id, review);
        if (res){
            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        } return new ResponseEntity<>("Review not found with the given ID "+id, HttpStatus.NOT_FOUND);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createReview(Review review) {
        reviewService.createReview(review);
        return new ResponseEntity<>("Review Created Successfully", HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReview(Long id) {
        boolean response = reviewService.deleteReview(id);
        if (response){
            return new ResponseEntity<>("Review deleted with ID"+id, HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not found with ID"+id, HttpStatus.NOT_FOUND);
    }

}
