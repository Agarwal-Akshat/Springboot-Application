package bankingdb.errorhandle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class accountFundsExceededAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(accountFundsExceededException.class)
    public @ResponseBody
    ErrorInfo accountFundsExceededHandler(accountFundsExceededException ex) {
        return new ErrorInfo(HttpStatus.BAD_REQUEST,ex.getMessage());
    }
}