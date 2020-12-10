package ukrkosenko;

public class MyException extends Exception {

	@Override
	public String getMessage(){
	return "Максимально колличество студентов 10";
	
	}
}