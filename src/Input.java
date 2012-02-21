import java.util.Scanner;
//this class is used to get input from the user.

public class Input{
private Scanner scan = new Scanner(System.in);

//gets input from the user and stores it in a string
public String getInput(){
	String answer = scan.next();
	return answer;
}
//no arg constructor
public Input(){}
}