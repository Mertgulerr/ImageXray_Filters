package Package3;

public class InvalidInputException extends  RuntimeException
{
    InvalidInputException(String message){super(message);}
    public InvalidInputException(String message, Throwable cause){super(message, cause);}
}
