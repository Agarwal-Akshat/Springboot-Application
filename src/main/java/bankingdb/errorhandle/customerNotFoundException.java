package bankingdb.errorhandle;

import org.springframework.http.HttpStatus;

public class customerNotFoundException extends RuntimeException {
    public customerNotFoundException(String message) {
        super(message);
    }
}