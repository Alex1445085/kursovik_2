package pro.sky.kursovik2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "InvalidNumberException")
public class InvalidNumberException extends RuntimeException{
    public InvalidNumberException(String note) { super("InvalidNumberException = " + note); }
}