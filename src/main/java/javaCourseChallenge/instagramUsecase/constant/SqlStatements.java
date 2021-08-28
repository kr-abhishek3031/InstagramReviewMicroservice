package javaCourseChallenge.instagramUsecase.constant;

public interface SqlStatements {
        String INSERT = "INSERT INTO InstagramReviews VALUES (?, ?, ?)";
        String DELETE = "DELETE FROM InstagramReviews WHERE userid= ?";
        String SELECT = "SELECT * FROM InstagramReviews WHERE userid= ?";
}
