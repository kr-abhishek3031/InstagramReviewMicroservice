package javaCourseChallenge.instagramUsecase.service;

import javaCourseChallenge.instagramUsecase.entity.InstagramReview;
import javaCourseChallenge.instagramUsecase.repositry.InstaReviewsDaoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    InstaReviewsDaoImplementation feedbackFunctions;


    public boolean addReview(InstagramReview review) {
        boolean temp = feedbackFunctions.addReview(review);
        return temp;
    }


    public InstagramReview searchReview(Long userid) {
        return feedbackFunctions.searchReview(userid);

    }


    public boolean deleteReview(Long userid) {
        return feedbackFunctions.deleteReview(userid);
    }
}
