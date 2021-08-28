package javaCourseChallenge.instagramUsecase.repositry;

import javaCourseChallenge.instagramUsecase.entity.InstagramReview;

public interface InstaReviewsDAO {

    public boolean addReview(InstagramReview review);
    public InstagramReview searchReview(Long userid);
    public boolean deleteReview(Long userid);
}
