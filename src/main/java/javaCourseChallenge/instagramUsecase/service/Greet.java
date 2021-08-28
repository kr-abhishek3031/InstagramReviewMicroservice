package javaCourseChallenge.instagramUsecase.service;

import org.springframework.http.ResponseEntity;

public interface Greet {
    public ResponseEntity<String> greet();
}
