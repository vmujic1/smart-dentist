package ba.unsa.etf.rpr.exceptions;

public class SmartDentinstException extends Exception{

    public SmartDentinstException(String message, Exception reason){
        super(message,reason);
    }

    public SmartDentinstException(String message){
        super(message);
    }
}
