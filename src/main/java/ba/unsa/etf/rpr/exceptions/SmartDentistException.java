package ba.unsa.etf.rpr.exceptions;

/**
 * Custom exception for handling errors in this application
 * extends Exception class
 * @author vmujic1
 */

public class SmartDentistException extends Exception{

    public SmartDentistException(String message, Exception reason){
        super(message,reason);
    }

    public SmartDentistException(String message){
        super(message);
    }
}
