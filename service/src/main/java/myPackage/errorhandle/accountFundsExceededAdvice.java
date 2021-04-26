package myPackage.errorhandle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class accountFundsExceededAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(accountFundsExceededException.class)
    public @ResponseBody String accountFundsExceededHandler(accountFundsExceededException ex) {
        return ex.getMessage();
    }
}