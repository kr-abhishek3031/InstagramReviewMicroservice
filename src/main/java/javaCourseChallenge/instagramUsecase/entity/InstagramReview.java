package javaCourseChallenge.instagramUsecase.entity;

/*
3- Develop GET,POST & DELETE methods of an Instagram review microservie.
Review contains an userid, username and rating. Use springboot for developing your solution.

4- Use DAO Pattern in the above microservice to store your review data into H2/Postgres database.

Assumptions: One user can post at max one rating. So userid is our primary key.
 */
public class InstagramReview {
    private Long userid;
    private String username;
    private Integer rating;

    public InstagramReview(){}

    public InstagramReview(Long userid, String username, Integer rating) {
        this.userid = userid;
        this.username = username;
        this.rating = rating;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
