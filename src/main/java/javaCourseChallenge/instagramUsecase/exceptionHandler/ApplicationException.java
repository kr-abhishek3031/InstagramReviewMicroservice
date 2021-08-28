package javaCourseChallenge.instagramUsecase.exceptionHandler;

public class ApplicationException {

    private String errorMessage;

    public ApplicationException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {

        return errorMessage;
    }
}
