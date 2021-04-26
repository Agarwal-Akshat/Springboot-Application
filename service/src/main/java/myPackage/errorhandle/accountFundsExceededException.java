package myPackage.errorhandle;

public class accountFundsExceededException extends RuntimeException {
    public accountFundsExceededException(String message) {
        super(message);
    }
}
