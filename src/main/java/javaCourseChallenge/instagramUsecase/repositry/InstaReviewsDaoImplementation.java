package javaCourseChallenge.instagramUsecase.repositry;

import javaCourseChallenge.instagramUsecase.dbConfig.NativeJDBC;
import javaCourseChallenge.instagramUsecase.entity.InstagramReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstaReviewsDaoImplementation implements InstaReviewsDAO{
    @Autowired
    private NativeJDBC nativeJDBC;

    @Override
    public boolean addReview(InstagramReview review) {
        boolean temp = nativeJDBC.addReview(review);
        return temp;
    }

    @Override
    public InstagramReview searchReview(Long userid) {
        InstagramReview temp = nativeJDBC.getReview(userid);
        return temp;
    }

    @Override
    public boolean deleteReview(Long userid) {
        boolean temp = nativeJDBC.deleteReview(userid);
        return temp;
    }
}
