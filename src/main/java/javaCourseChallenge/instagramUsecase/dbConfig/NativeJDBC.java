package javaCourseChallenge.instagramUsecase.dbConfig;

import javaCourseChallenge.instagramUsecase.constant.SqlStatements;
import javaCourseChallenge.instagramUsecase.entity.InstagramReview;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class NativeJDBC {
    public boolean addReview(InstagramReview review) {

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(SqlStatements.INSERT);){
            ps.setLong(1, review.getUserid());
            ps.setString(2, review.getUsername());
            ps.setInt(3, review.getRating());
            int i = ps.executeUpdate();

            if(i == 1) {
                System.out.println("Product Record successfully added");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public InstagramReview getReview(Long id){
        InstagramReview review = null;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlStatements.SELECT);) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            review = retrieveReview(rs);
            return review;

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return review;
    }

    public boolean deleteReview(Long id){
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlStatements.DELETE);){
            ps.setLong(1, id);
            int out = ps.executeUpdate();
            if(out ==1){
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    private InstagramReview retrieveReview(ResultSet rs){
        InstagramReview review = new InstagramReview();

        try {
            review.setUserid( rs.getLong("userid")) ;
            review.setUsername(rs.getString("username"));
            review.setRating(rs.getInt("rating"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return review;
    }
}
