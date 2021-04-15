package bankingdb.errorhandle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class customerNotFoundAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(customerNotFoundException.class)
    public @ResponseBody ErrorInfo employeeNotFoundHandler(customerNotFoundException ex) {
        return new ErrorInfo(HttpStatus.BAD_REQUEST,ex.getMessage());
    }
}
