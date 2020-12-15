package lab8;

@SuppressWarnings("serial")
public class InvalidZipCodeException extends Exception{
	
	public InvalidZipCodeException() {
		super("Entered an invalid zip code.");
	} 

	public InvalidZipCodeException(String msg){
		super(msg);
	}
}
