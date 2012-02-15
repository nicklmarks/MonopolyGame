import java.util.*;
public class Board{

public ArrayList<Space> spaceList = new ArrayList<Space>();

public Board(){
for(int i = 0; i<40;i++){
	String s = "";
	s += i;
	spaceList.add(new Property(s,0,0,i*10,i*5,true,"Green"));
	}
}

}