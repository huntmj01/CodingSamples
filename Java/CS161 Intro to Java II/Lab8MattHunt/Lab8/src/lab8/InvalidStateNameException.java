package lab8;

@SuppressWarnings("serial")
public class InvalidStateNameException extends Exception{
	
	public InvalidStateNameException() {
		super("Entered an invalid state name.");
	} 

	public InvalidStateNameException(String msg){
		super(msg);
	}
}
