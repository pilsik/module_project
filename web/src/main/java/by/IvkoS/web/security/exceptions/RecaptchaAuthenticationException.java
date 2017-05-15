package by.IvkoS.web.security.exceptions;

public class RecaptchaAuthenticationException extends RuntimeException {
    public RecaptchaAuthenticationException(String message) {
        super(message);
    }
}
