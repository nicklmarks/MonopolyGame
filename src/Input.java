import java.util.Scanner;
//this class is used to get input from the user.

public class Input{
//instance variables
private Scanner scan = new Scanner(System.in);

//methods
public String getInput(){
	String answer = scan.next();
	return answer;
}

public Input(){}
}