import java.util.*;
public class Board{

ArrayList<Space> spaceList = new ArrayList<Space>();

public Board(){

	//space 0 
	spaceList.add(new Space(0, 0, "GO!"));

	//space 1 Property
	spaceList.add(new Property("Purple1", 0, 0, 60, 2, true, "Purple"));

	//space 2 Chance
	spaceList.add(new Space(0, 0, "CHANCE"));

	//space 3 Property
	spaceList.add(new Property("Purple2", 0, 0, 60, 4, true, "Purple"));

	//space 4 Income Tax
	spaceList.add(new Space(0,0,"Income Tax"));

	//space 5 RailodRoad1
	spaceList.add(new Property("RailRoad1", 0, 0, 200, 25, true, null));

	//space 6 Property
	spaceList.add(new Property("LightBlue1", 0, 0, 100, 4, true, "Light Blue"));

	//space 7 Chance
	spaceList.add(new Space(0, 0, "CHANCE"));

	//space 8 Property
	spaceList.add(new Property("LightBlue2", 0, 0, 100, 6, true, "Light Blue"));

	//space 9 Property
	spaceList.add(new Property("LightBlue3", 0, 0, 120, 8, true, "Light Blue"));

	//space 10 Jail
	spaceList.add(new Space(0, 0, "JAIL"));

	//space 11 Property
	spaceList.add(new Property("Pink1", 0, 0, 140, 10, true, "Pink"));

	//space 12 Electric Company
	spaceList.add(new Property("Electric Company", 0, 0, 150, 0, false, null));

	//space 13 Property
	spaceList.add(new Property("Pink2", 0, 0, 140, 10, true, "Pink"));

	//space 14 Property
	spaceList.add(new Property("Pink3", 0, 0, 160, 12, true, "Pink"));

	//space 15 RailRoad2
	spaceList.add(new Property("RailRoad2", 0, 0, 200, 25, false, null));

	//space 16 Property
	spaceList.add(new Property("Orange1", 0, 0, 180, 14, true, "Orange"));

	//space 17 Chance
	spaceList.add(new Space(0, 0, "CHANCE"));

	//space 18 Property
	spaceList.add(new Property("Orange2", 0, 0, 180, 14, true, "Orange"));

	//space 19 Property
	spaceList.add(new Property("Orange3", 0, 0, 200, 16, true, "Orange"));

	//space 20 Free Parking
	spaceList.add(new Space(0, 0, "FREE PARKING"));

	//space 21 Property
	spaceList.add(new Property("Red1", 0, 0, 220, 18, true, "Red"));

	//space 22 Chance
	spaceList.add(new Space(0, 0, "CHANCE"));

	//space 23 Property
	spaceList.add(new Property("Red2", 0, 0, 220, 18, true, "Red"));

	//space 24 Property
	spaceList.add(new Property("Red3", 0, 0, 240, 20, true, "Red"));

	//space 25 RailRoad3
	spaceList.add(new Property("RailRoad3", 0, 0, 200, 25, false, null));

	//space 26 Property
	spaceList.add(new Property("Yellow1", 0, 0, 260, 22, true, "Yellow"));

	//space 27 Property
	spaceList.add(new Property("Yellow2", 0, 0, 260, 22, true, "Yellow"));

	//space 28 Water Works
	spaceList.add(new Property("Water Works", 0, 0, 150, 0, false, null));

	//space 29 Property
	spaceList.add(new Property("Yellow3", 0, 0, 280, 22, true, "Yellow"));

	//space 30 Go To Jail
	spaceList.add(new Space(0, 0, "Go to Jail"));

	//space 31 Property
	spaceList.add(new Property("Green1", 0, 0, 300, 26, true, "Green"));

	//space 32 Property
	spaceList.add(new Property("Green2", 0, 0, 300, 26, true, "Green"));

	//space 33 Chance
	spaceList.add(new Space(0, 0, "CHANCE"));

	//space 34 Property
	spaceList.add(new Property("Green3", 0, 0, 320, 28, true, "Green"));
	
	//space 35 RailRoad4
	spaceList.add(new Property("RailRoad4", 0, 0, 200, 25, false, null));

	//space 36 Chance
	spaceList.add(new Space(0, 0, "CHANCE"));
	
	//space 37 Property
	spaceList.add(new Property("Blue1", 0, 0, 350, 35, true, "Blue"));

	//space 38 Luxury Tax
	spaceList.add(new Space(0,0,"Luxury Tax"));

	//space 39 Property
	spaceList.add(new Property("Blue2", 0, 0, 400, 50, true, "Blue"));
	}
}

