package javaCourseChallenge.instagramUsecase.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GreetService implements Greet{

    @Override
    public ResponseEntity<String> greet() {
        return new ResponseEntity<String>("Welcome to Instagram feedback.", HttpStatus.OK);
    }
}
