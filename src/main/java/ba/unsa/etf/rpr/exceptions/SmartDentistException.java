package ba.unsa.etf.rpr.exceptions;

public class SmartDentistException extends Exception{

    public SmartDentistException(String message, Exception reason){
        super(message,reason);
    }

    public SmartDentistException(String message){
        super(message);
    }
}
