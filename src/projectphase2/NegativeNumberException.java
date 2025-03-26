
package projectphase2;

public class NegativeNumberException extends Exception{
    
    
	public NegativeNumberException(){
		super("Negative Number !");
	}
	
	public NegativeNumberException(String str){
		super(str);
	}
	
}//end class
