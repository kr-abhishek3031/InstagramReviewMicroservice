package javaCourseChallenge.instagramUsecase.controller;

import javaCourseChallenge.instagramUsecase.entity.InstagramReview;
import javaCourseChallenge.instagramUsecase.exceptionHandler.ApplicationException;
import javaCourseChallenge.instagramUsecase.service.FeedbackService;
import javaCourseChallenge.instagramUsecase.service.GreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/instagramFeedback")
public class InstaFeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("")
    public ResponseEntity<String> greetGuest(){
        return new GreetService().greet();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewProduct(@RequestBody InstagramReview review, UriComponentsBuilder ucBuilder){
        boolean out = feedbackService.addReview(review);
        if(out == true) {
            /*
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(review.getUserid().toUri());
            */
            return new ResponseEntity<String>("Review recevied!", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProductbyId(@PathVariable("id") Long id){
        InstagramReview out = feedbackService.searchReview(id);
        if( out !=null){
            return new ResponseEntity<InstagramReview>(out, HttpStatus.OK);
        }
        else{
            ApplicationException aex = new ApplicationException("Review with id " + id
                    + " not found");
            return new ResponseEntity<String>(aex.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        boolean out = feedbackService.deleteReview(id);
        if(out){
            return new ResponseEntity<String>("Review Successfully removed", HttpStatus.OK);
        }
        else{
            ApplicationException aex = new ApplicationException("Review with id " + id
                    + " not found");
            return new ResponseEntity<String>(aex.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
