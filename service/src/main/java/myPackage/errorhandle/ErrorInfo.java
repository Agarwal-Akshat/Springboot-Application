package myPackage.errorhandle;

import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ErrorInfo {
    private HttpStatus status;
    private String timeStamp;
    private String message;

    public ErrorInfo() {
    }

    public ErrorInfo(HttpStatus status, String message) {
        this.status = status;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.timeStamp = formatter.format(calendar.getTime());

        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
