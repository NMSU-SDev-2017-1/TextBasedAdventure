//3/13/2017 - Adjust Nodes to not take input for roomData through their constructor.
//  This will herald the change to only allow room data to be set through modifier methods.
import java.util.Scanner;

public class Maze {
   private Node entrance;
   private Node exit;
private class Node {
   private int[] roomData;
   private int direction;
   private int X_Axis;
   private int Y_Axis;
   private boolean ConstructNorth;
   private boolean ConstructEast;
   private boolean ConstructSouth;
   private boolean ConstructWest;
   private Node north;
   private Node south;
   private Node east;
   private Node west;
   
   public Node(int[] newData, Node newNorth, Node newSouth, Node newEast, Node newWest) {
      roomData = newData;
      north = newNorth;
      south = newSouth;
      east = newEast;
      west = newWest;
      direction = 1;
      X_Axis = 50;
      Y_Axis = 50;
      ConstructNorth = false;
      ConstructEast = false;
      ConstructSouth = false;
      ConstructWest = false;
   }//End Node constructor
   
}//End private class
   public Maze() {
      entrance = null;
      exit = null;
   }
   
   public static Node getStart(Maze M) {
      return M.entrance;
   }//End Method getStart
   
   public static Node getExit(Maze M) {
      return M.exit;
   }//End Method getExit
   
   public static int getDirection(Node C) {
      if(C == null)
         return -1;
      return C.direction;
   }//End Method getDirection
   
   public static boolean getConstructionPointNorth(Node C) {
      return C.ConstructNorth;
   }//End Method getConstructionPointNorth
   
   public static boolean getConstructionPointEast(Node C) {
      return C.ConstructEast;
   }//End Method getConstructionPointEast
   
   public static boolean getConstructionPointSouth(Node C) {
      return C.ConstructSouth;
   }//End Method getConstructionPointSouth
   
   public static boolean getConstructionPointWest(Node C) {
      return C.ConstructSouth;
   }//End Method getConstructionPointWest
   
   public static int getRoomNumber(Node C) {
      if(C == null)
         return -1;
      return C.roomData[0];
   }//End method getRoomNumber
   
   public static int getSpacialCoordinateY(Node C) {
      if(C == null)
         return -1;
      return C.Y_Axis;
   }//End method getSpacialCoordinatesY
   
   public static int getSpacialCoordinateX(Node C) {
      if(C == null)
         return -1;
      return C.X_Axis;
   }//End method getSpacialCoordinatesX
   
   public static int[] getSpacialCoordinates(Node C) {
      if(C == null)
         System.exit(0);
      int SpaceCoordinates [] = new int[2];
      SpaceCoordinates[0] = getSpacialCoordinateX(C);
      SpaceCoordinates[1] = getSpacialCoordinateY(C);
      return SpaceCoordinates;
   }//End Method getSpacialCoordinates
   
   public static void setConstructionPointNorth(Node C, boolean B) {
      C.ConstructNorth = B;
   }//End method setConstructionPointNorth
   
   public static void setConstructionPointEast(Node C, boolean B) {
      C.ConstructEast = B;
   }//End method setConstructionPointEast
   
   public static void setConstructionPointSouth(Node C, boolean B) {
      C.ConstructSouth = B;
   }//End method setConstructionPointSouth
   
   public static void setConstructionPointWest(Node C, boolean B) {
      C.ConstructWest = B;
   }//End method setConstructionPointWest
   
   public static void SpacialCoordinateModifierY(Node C, int y) {
      C.Y_Axis = y;
   }//End method SpacialCoordinateModifierY
   
   public static void SpacialCoordinateModifierX(Node C, int x) {
      C.X_Axis = x;
   }//End method SpacialCoordinateModifierX
   
   //Use this method to change a rooms data.
   //This method is the ONLY WAY ROOM DATA SHOULD BE CHANGED.
   public static int[] setRoomData(int a) {
      final int newRoomData[] = new int[10];
      newRoomData[0] = a;
      return newRoomData;
   }//End method setRoomData
   
   public static boolean isEqual(Node C, Node C2) {
      if(getSpacialCoordinateX(C) == getSpacialCoordinateX(C2) && getSpacialCoordinateY(C) == getSpacialCoordinateY(C2))
         return true;
      else
       return false;
   }//End Method isEqual
   
   public void addEntrance(int[] newData) {
      entrance = new Node(newData, null, null, null, null);
   }
   
   public void addNorthernCorridor(int[] newData, Node C) {
      C.north = new Node(newData, null, C, null, null);
   }
   
   public void addSouthernCorridor(int[] newData, Node C) {
      C.south = new Node(newData, C, null, null, null);
   }
   
   public void addEasternCorridor(int[] newData, Node C) {
      C.east = new Node(newData, null, null, null, C);
   }
   
   public void addWesternCorridor(int[] newData, Node C) {
      C.west = new Node(newData, null, null, C, null);
   }
   
   public static Node moveNorth(Node C) {
      if(C.north != null) {
         return C = C.north;
      }
      else {
         System.out.println("The northern path is a dead end."); 
         return C;
      }
   }//End method move North
   
   public static Node moveEast(Node C) {
      if(C.east != null) {
         return C = C.east;
      }
      else {
         System.out.println("The eastern path is a dead end."); 
         return C;
      }
   }//End method move east
   
   public static Node moveSouth(Node C) {
      if(C.south != null) {
         return C = C.south;
      }
      else {
         System.out.println("The southern path is a dead end."); 
         return C;
      }
   }//End method move south
   
   public static Node moveWest(Node C) {
      if(C.west != null) {
         return C = C.west;
      }
      else {
         System.out.println("The western path is a dead end.");
         return C;
      } 
   }//End method move west
   
   public static void roomChecker(int i, Node C) {
      if(i == 1) {
         if(C.north == null)
            System.out.println("Northern path does not exist.");
         else
            System.out.println("Northern path exists.");
      }//End north check
      
      if(i == 2) {
         if(C.east == null)
            System.out.println("Eastern path does not exist.");
         else
            System.out.println("Eastern path exists.");
      }//End east check
      
      if(i == 3) {
         if(C.south == null)
            System.out.println("Southern path does not exist.");
         else
            System.out.println("Southern path exists.");
      }//End South check
      
      if(i == 4) {
         if(C.west == null)
            System.out.println("Western path does not exist.");
         else
            System.out.println("Western path exists.");
      }
      
   }//End method roomChecker

   public static Maze GenerateBasicMaze() {
      Maze Tutorial = new Maze();
      
      Tutorial.addEntrance(setRoomData(0));
      Tutorial.entrance.direction = 3;      
      Node Position = Tutorial.entrance;
      
      Tutorial.addSouthernCorridor(setRoomData(1), Position);
      Position = moveSouth(Position);
      Tutorial.addSouthernCorridor(setRoomData(2), Position);
      Position = moveSouth(Position);
      Tutorial.addSouthernCorridor(setRoomData(3), Position);
      Position = moveSouth(Position);
      Tutorial.addSouthernCorridor(setRoomData(4), Position);
      Tutorial.addEasternCorridor(setRoomData(5), Position);
      Position = moveEast(Position);
      Tutorial.addEasternCorridor(setRoomData(6), Position);
      Position = moveEast(Position);
      Tutorial.addSouthernCorridor(setRoomData(7), Position);
      Position = moveSouth(Position);
      Tutorial.addSouthernCorridor(setRoomData(8), Position);
      Position = moveNorth(Position);
      Tutorial.addNorthernCorridor(setRoomData(9), Position);
      Position = moveNorth(Position);
      Tutorial.addEasternCorridor(setRoomData(10), Position);
      Position = moveEast(Position);
      Tutorial.addNorthernCorridor(setRoomData(11), Position);
      Position = moveNorth(Position);
      Tutorial.addNorthernCorridor(setRoomData(12), Position);
      Position = moveNorth(Position);
      Tutorial.addWesternCorridor(setRoomData(13), Position);
      Tutorial.addEasternCorridor(setRoomData(14), Position);
      Position = moveEast(Position);
      Tutorial.addEasternCorridor(setRoomData(15), Position);
      Position = moveEast(Position);
      Tutorial.addEasternCorridor(setRoomData(16), Position);
      Position = moveEast(Position);
      Tutorial.addEasternCorridor(setRoomData(17), Position);
      Position = moveWest(Position);
      Position = moveWest(Position);
      Position = moveWest(Position);
      Position = moveSouth(Position);
      Position = moveSouth(Position);
      Tutorial.addEasternCorridor(setRoomData(18), Position);
      Position = moveEast(Position);
      Tutorial.addEasternCorridor(setRoomData(19), Position);
      Position = moveEast(Position);
      Tutorial.addSouthernCorridor(setRoomData(20), Position);
      Position = moveSouth(Position);
      Tutorial.addSouthernCorridor(setRoomData(21), Position);
      Position = moveSouth(Position);
      Tutorial.addWesternCorridor(setRoomData(22), Position);
      Position = moveWest(Position);
      Tutorial.addSouthernCorridor(setRoomData(23), Position);
      Position = moveSouth(Position);
      Tutorial.addSouthernCorridor(setRoomData(24), Position);
      Position = moveSouth(Position);
      Tutorial.addSouthernCorridor(setRoomData(25), Position);
      Position = moveSouth(Position);
      Tutorial.addWesternCorridor(setRoomData(26), Position);
      Position = moveWest(Position);
      Tutorial.addWesternCorridor(setRoomData(27), Position);
      Position = moveWest(Position);
      Tutorial.addWesternCorridor(setRoomData(28), Position);
      Position = moveWest(Position);
      Tutorial.addWesternCorridor(setRoomData(29), Position);
      Position = moveWest(Position);
      Tutorial.addNorthernCorridor(setRoomData(30), Position);
      Position = moveEast(Position);
      Position = moveEast(Position);
      Position = moveEast(Position);
      Position = moveEast(Position);
      Position = moveNorth(Position);
      Position = moveNorth(Position);
      Position = moveNorth(Position);
      Position = moveEast(Position);
      Tutorial.addEasternCorridor(setRoomData(31), Position);
      Position = moveEast(Position);
      Tutorial.addEasternCorridor(setRoomData(32), Position);
      Position = moveEast(Position);
      Tutorial.addNorthernCorridor(setRoomData(33), Position);
      Position = moveNorth(Position);
      Tutorial.addNorthernCorridor(setRoomData(34), Position);
      Position = moveSouth(Position);
      Position = moveWest(Position);
      Tutorial.addSouthernCorridor(setRoomData(35), Position);
      Position = moveSouth(Position);
      Tutorial.addSouthernCorridor(setRoomData(36), Position);
      Position = moveSouth(Position);
      Tutorial.addEasternCorridor(setRoomData(37), Position);
      Position = moveEast(Position);
      Tutorial.addSouthernCorridor(setRoomData(38), Position);
      Position = moveSouth(Position);
    
      Tutorial.exit = Position;
      
      return Tutorial;
   }//End method GenerateBasicMaze
   
   public static Maze TMM(int Level) {
      Maze TM = new Maze();
      TM = GenerateEntrance((int)(Math.random()*(28-1)+1));
      Node Position;
      Node T;
      Position = FindStartRoom(TM);
      Node Start;
      Start = getStart(TM);
      int stop = 0;
      int RoomNumber;
      int RNG;
      int X;
      int Y;
      
      while(stop < Level) {
         RNG = (int)(Math.random()*(5-1)+1);
         X = getSpacialCoordinateX(Position);
         Y = getSpacialCoordinateY(Position);
         RoomNumber = getRoomNumber(Position);
         T = Position;
         if(RNG == 1) {
         if(Position.ConstructNorth == true) {
            GenerateBlock_StraightNorth(T, RoomNumber, X, Y);
            if(ParadoxAvoidance(Start, T) == 0) {
               GenerateBlock_StraightNorth(Position, RoomNumber, X, Y);
               stop++;
               continue; }
            else
               continue;
         }
         }//End northbuild
         if(RNG == 2) {
            if(Position.ConstructEast == true) {
               GenerateBlock_StraightEast(T, RoomNumber, X, Y);
               if(ParadoxAvoidance(Start, T) == 0){
                  GenerateBlock_StraightEast(Position, RoomNumber, X, Y);
                  stop++;
                  continue; }
            }
         }//End eastbuild
         if(RNG == 3) {
            if(Position.ConstructSouth == true) {
               GenerateBlock_StraightSouth(T, RoomNumber, X, Y);
               if(ParadoxAvoidance(Start, T) == 0) {
                  GenerateBlock_StraightSouth(Position, RoomNumber, X, Y);
                  stop++;
                  continue; }
            }
         }//End southbuild
         if(RNG == 4) {
            if(Position.ConstructWest == true) {
               GenerateBlock_StraightWest(T, RoomNumber, X, Y);
               if(ParadoxAvoidance(Start, T) == 0) {
                  GenerateBlock_StraightWest(Position, RoomNumber, X, Y);
                  stop++;
                  continue; }
            }
         }//End westbuild
      }//End While Loope
      return TM;
   }//End Method TMM
   
   public static Maze MazeCreation(int Level) {
      Maze GeneratedMaze = new Maze();
      GeneratedMaze = GenerateEntrance((int)(Math.random()*(28-1)+1));
      Node Position;
      Position = FindStartRoom(GeneratedMaze);
      
      int stop = 0;
      
      while(stop < Level) {
         RandomMazeGenerator(GeneratedMaze, Position, 0, getStart(GeneratedMaze));
         stop++;
      }//End maze generating
      
      return GeneratedMaze;
      
   }//End Method MazeCreation
   
   
   public static int RandomMazeGenerator(Maze M, Node C, int tracker, Node Start) {
      if(tracker > 10) {
         return 0;
      }
      
      Node Position;
      Position = M.entrance;
      int RoomNumber = 10;//TrackHighRoom(Position, getRoomNumber(Position)); 
      
      int x = getRoomNumber(Position);
      if(C.north != null) {
         if(getRoomNumber(Position.north) > x) {
            RandomMazeGenerator(M, Position.north, tracker, Start);
         }
      }
      if(C.east != null) {
         if(getRoomNumber(Position.east) > x) {
            RandomMazeGenerator(M, Position.east, tracker, Start);
         }
      }
      if(C.south != null) {
         if(getRoomNumber(C.south) > x) {
            RandomMazeGenerator(M, C.south, tracker, Start);
         }
      }
      
      if(C.west != null) {
         if(getRoomNumber(C.west) > x) {
            RandomMazeGenerator(M, C.west, tracker, Start);
         }
      }
      tracker++;
      int RNG = (int)(Math.random() * (5-1)+1);
      BlockGenerator(C, RNG, RoomNumber, getSpacialCoordinateX(C), getSpacialCoordinateY(C), Start);
      return 0;
   }//End method RandomMazeGenerator
   
   public static int[] TrackHighRoom(Node C, int N, int i) {
      int array[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
      int x = getRoomNumber(C);
      if(N < x)
         N = x;
      if(C.north != null) {
         if(getRoomNumber(C.north) > x) {
            TrackHighRoom(C.north, N, i); 
         }
      }  
      if(C.east != null) {
         if(getRoomNumber(C.east) > x) {
           TrackHighRoom(C.east, N, i);
         }
      }
      if(C.south != null) {
         if(getRoomNumber(C.south) > x) {
           TrackHighRoom(C.south, N, i);
         }
      }
      if(C.west != null) {
         if(getRoomNumber(C.west) > x) {
            TrackHighRoom(C.west, N, i);
         }
      }
      array[i] = N;
      i++;
      return array;
   }//End method TrackHighRoom
   
   public static int ArrayRoom(int[] a) {
      return a[1];
   }
   
   public static Node BlockGenerator(Node C, int RNG, int RoomNumber, int X, int Y, Node Start) {
      Node T;
      T = C;
      
      if(RNG == 1) {
         if(C.ConstructNorth == true) {
            GenerateBlock_StraightNorth(T, RoomNumber, X, Y);
            if(ParadoxAvoidance(Start, T) == 0) {
               GenerateBlock_StraightNorth(C, RoomNumber, X, Y);
               return C;
            }
         }
      }//End northbuild
      if(RNG == 2) {
         if(C.ConstructEast == true) {
            GenerateBlock_StraightEast(T, RoomNumber, X, Y);
            if(ParadoxAvoidance(Start, T) == 0)
               GenerateBlock_StraightEast(C, RoomNumber, X, Y);
               return C;
         }
      }//End eastbuild
      if(RNG == 3) {
         if(C.ConstructSouth == true) {
            GenerateBlock_StraightSouth(T, RoomNumber, X, Y);
            if(ParadoxAvoidance(Start, T) == 0)
               GenerateBlock_StraightSouth(C, RoomNumber, X, Y);
               return C;
         }
      }//End southbuild
      if(RNG == 4) {
         if(C.ConstructWest == true) {
            GenerateBlock_StraightWest(T, RoomNumber, X, Y);
            if(ParadoxAvoidance(Start, T) == 0)
               GenerateBlock_StraightWest(C, RoomNumber, X, Y);
               return C;
         }
      }//End westbuild
      return C;
   }//End Method BlockGenerator 
   
   //*************************************************************
   //This block of code represents maze generation blocks start.
   //*************************************************************
   
   private static Node GenerateBlock_StraightNorth(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointNorth(C, false);     
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY+2);
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY+3);
      setConstructionPointNorth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_StraightNorth
   
   private static Node GenerateBlock_StraightEast(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointEast(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+2);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+3);
      SpacialCoordinateModifierY(Position, CoordinateY);
      setConstructionPointNorth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointSouth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_StraightEast
   
   private static Node GenerateBlock_StraightSouth(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointSouth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY-2);
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY-3);
      setConstructionPointEast(Position, true);
      setConstructionPointSouth(Position, true);
      setConstructionPointWest(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_StraightSouth
   
   private static Node GenerateBlock_StraightWest(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointWest(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-2);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-3);
      SpacialCoordinateModifierY(Position, CoordinateY);
      setConstructionPointNorth(Position, true);
      setConstructionPointSouth(Position, true);
      setConstructionPointWest(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_StraightWest
   
   //*************************************************************
   //This block of code represents maze generation blocks end.
   //*************************************************************
   
   public static void CheckRoom(Node C) {
      if(C.north != null) {
         if(C.direction == 1)  
            System.out.printf("\nYou can go straight, ");
         if(C.direction == 2)
            System.out.printf("\nYou can go left, ");
         if(C.direction == 3)
            System.out.printf("\nYou can go back, ");
         if(C.direction == 4)
            System.out.printf("\nYou can go right, ");
      }
         
      if(C.east != null) {
         if(C.direction == 1)
            System.out.printf("you can go right, ");
         if(C.direction == 2)
            System.out.printf("you can go straight, ");
         if(C.direction == 3)
            System.out.printf("you can go left, ");
         if(C.direction == 4)
            System.out.printf("you can go back, ");
      }
      
      if(C.south != null) {
         if(C.direction == 1)
            System.out.printf("you can go back, ");
         if(C.direction == 2)
            System.out.printf("you can go right, ");
         if(C.direction == 3)
            System.out.printf("you can go straight, ");
         if(C.direction == 4)
            System.out.printf("you can go left, ");
      }

      if(C.west != null) {
         if(C.direction == 1)
            System.out.printf("you can go left.");
         if(C.direction == 2)
            System.out.printf("you can go back.");
         if(C.direction == 3)
            System.out.printf("you can go right.");
         if(C.direction == 4)
            System.out.printf("you can go straight");
      }
         
      System.out.println();
      System.out.println("The room number is: " + C.roomData[0]);
         
   }//End method CheckRoom
   
   public static int ParadoxAvoidance(Node C, Node Paradox) {
      int x = getRoomNumber(C);
      if(isEqual(C, Paradox) == true)
         return 100;
      if(C.north != null) 
         if(getRoomNumber(C.north) > x)
            return ParadoxAvoidance(C.north, Paradox);
      if(C.east != null)
         if(getRoomNumber(C.east) > x)
            return ParadoxAvoidance(C.east, Paradox);
      if(C.south != null) 
         if(getRoomNumber(C.south) > x) 
            return ParadoxAvoidance(C.south, Paradox);
      if(C.west != null)
         if(getRoomNumber(C.west) > x)
            return ParadoxAvoidance(C.west, Paradox);
       return 0;
   }//End Method ParadoxAvoidance
   
   public void TraverseMaze(Node C) {
      if(C.roomData[0] == this.exit.roomData[0]) {
         System.out.println("You have reached the end!");
         return;
      }
      CheckRoom(C);
      System.out.println();
      System.out.println("Where would you like to go?");
      Scanner Scan = new Scanner(System.in);
      int choice = Scan.nextInt();
      if(C.direction == 1) {
         if(choice == 1) {
            C.north.direction = 1;
            TraverseMaze(C.north);
         }
         if(choice == 2) {
            C.east.direction = 2;
            TraverseMaze(C.east);
         }
         if(choice == 3) {
            C.south.direction = 3;
            TraverseMaze(C.south);
         }
         if(choice == 4) {
            C.west.direction = 4;
            TraverseMaze(C.west);
         }
      }  
      
      if(C.direction == 2) {
         if(choice == 1){
            C.east.direction = 2;
            TraverseMaze(C.east);
         }
         if(choice == 2) {
            C.south.direction = 3;
            TraverseMaze(C.south);
         }
         if(choice == 3) {
            C.west.direction = 4;
            TraverseMaze(C.west);
         }
         if(choice == 4) {
            C.north.direction = 1;
            TraverseMaze(C.north);
         }
      }  
      
      if(C.direction == 3) {
         if(choice == 1) {
            C.south.direction = 3;
            TraverseMaze(C.south);
         }
         if(choice == 2) {
            C.west.direction = 4;
            TraverseMaze(C.west);
         }
         if(choice == 3) {
            C.north.direction = 1;
            TraverseMaze(C.north);
         }
         if(choice == 4) {
            C.east.direction = 2;
            TraverseMaze(C.east);
         }
      }  
      
      if(C.direction == 4) {
         if(choice == 1) {
            C.west.direction = 4;
            TraverseMaze(C.west);
         }
         if(choice == 2) {
            C.north.direction = 1;
            TraverseMaze(C.north);
         }
         if(choice == 3) {
            C.east.direction = 2;
            TraverseMaze(C.east);
         }
         if(choice == 4) {
            C.south.direction = 3;
            TraverseMaze(C.south);
         }
      }         
   }//End method TraverseMaze
   
   public static void mazeDiagnostics(Node C) {
      int x = getRoomNumber(C);
      if(C.north != null) {
         if(getRoomNumber(C.north) > x) {
            System.out.println("Go North to room number: " + getRoomNumber(C.north));
            mazeDiagnostics(C.north);
         }
      }
      
      if(C.east != null) {
         if(getRoomNumber(C.east) > x) {
            System.out.println("Go East to room number: " + getRoomNumber(C.east));
            mazeDiagnostics(C.east);
         }
      }
      
      if(C.south != null) {
         if(getRoomNumber(C.south) > x) {
            System.out.println("Go South to room number: " + getRoomNumber(C.south));
            mazeDiagnostics(C.south);
         }
      }
      
      if(C.west != null) {
         if(getRoomNumber(C.west) > x) {
            System.out.println("Go West to room number: " + getRoomNumber(C.west));
            mazeDiagnostics(C.west);
         }
      }
      System.out.println("Go back from room number: " + x);
      
   }//End method mazeDiagnostics
   
   public static void Interperator(Node C) {
      System.out.println("Room number is: " + getRoomNumber(C));
      System.out.println("The rooms Northern construction point is: " + getConstructionPointNorth(C));
      System.out.println("The rooms Eastern construction point is: " + getConstructionPointEast(C));
      System.out.println("The rooms Southern construction point is: " + getConstructionPointSouth(C));
      System.out.println("The rooms Western construction point is: " + getConstructionPointWest(C));
   }//End Method Interperator
   
   public static Maze GenerateEntrance(int Type) {
      //Direction: North = 1, East = 2, South = 3, West = 4
      Maze MazeStart = new Maze();
      
      MazeStart.addEntrance(setRoomData(0));
      Node Position = MazeStart.entrance;
      SpacialCoordinateModifierX(Position, 0);
      SpacialCoordinateModifierY(Position, 0);
      
      int X = Position.X_Axis;
      int Y = Position.Y_Axis;
      
      //Directions North and South are modified with the Y modifier method.
      //Directions East and West are modified with the X modifier method.
      //When moving North use a positive modification, when moving South use a negative modification.
      //When moving East use a positive modification, when moving West use a negative modification.
      
      if(Type == 1) {//If Type == 1, direction entered into the maze is North with 3 corridors leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);         
         MazeStart.addEasternCorridor(setRoomData(2), Position);
         MazeStart.addWesternCorridor(setRoomData(3), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         SpacialCoordinateModifierX(Position.east, X+1);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.north.ConstructNorth = true;
         Position.east.ConstructEast = true;
         Position.west.ConstructWest = true;
      }
      if(Type == 2) {//If Type == 2, direction entered into the maze is East with 3 corridors leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         MazeStart.addSouthernCorridor(setRoomData(2), Position);
         MazeStart.addNorthernCorridor(setRoomData(3), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         SpacialCoordinateModifierX(Position.east, X+1);
         SpacialCoordinateModifierY(Position.south, Y-1);
         Position.north.ConstructNorth = true;
         Position.east.ConstructEast = true;
         Position.south.ConstructSouth = true;
      }   
      if(Type == 3) {//If Type == 3, direction entered into the maze is South with 3 corridors leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         MazeStart.addWesternCorridor(setRoomData(2), Position);
         MazeStart.addEasternCorridor(setRoomData(3), Position);
         SpacialCoordinateModifierX(Position.east, X+1);
         SpacialCoordinateModifierY(Position.south, Y-1);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.south.ConstructSouth = true;
         Position.east.ConstructEast = true;
         Position.west.ConstructWest = true;
      }
      if(Type == 4) {//If Type == 4, direction entered into the maze is West with 3 corridors leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         MazeStart.addNorthernCorridor(setRoomData(2), Position);
         MazeStart.addSouthernCorridor(setRoomData(3), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         SpacialCoordinateModifierY(Position.south, Y-1);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.north.ConstructNorth = true;
         Position.south.ConstructSouth = true;
         Position.west.ConstructWest = true;
      }
      if(Type == 5) {//If Type == 5, direction entered into the maze is North with East and West corridors leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         MazeStart.addWesternCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierX(Position.east, X+1);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.east.ConstructEast = true;
         Position.west.ConstructWest = true;
      }
      if(Type == 6) {//If Type == 6, direction entered into the maze is North with East and North corridors leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
         MazeStart.addEasternCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         SpacialCoordinateModifierX(Position.east, X+1);
         Position.north.ConstructNorth = true;
         Position.east.ConstructEast = true;
      }  
      if(Type == 7) {//If Type == 7, direction entered into the maze is North with North and West corridors leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
         MazeStart.addWesternCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.north.ConstructNorth = true;
         Position.west.ConstructWest = true;
      }
      if(Type == 8) {//If Type == 8, direction entered into the maze is East with East and South corridors leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         MazeStart.addSouthernCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierX(Position.east, X+1);
         SpacialCoordinateModifierY(Position.south, Y-1);
         Position.south.ConstructSouth = true;
         Position.east.ConstructEast = true;
      }
      if(Type == 9) {//If Type == 9, direction entered into the maze is East with East and North corridors leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         MazeStart.addNorthernCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         SpacialCoordinateModifierX(Position.east, X+1);
         Position.north.ConstructNorth = true;
         Position.east.ConstructEast = true;
      }    
      if(Type == 10) {//If Type == 10, direction entered into the maze is East with South and North corridors leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         MazeStart.addNorthernCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         SpacialCoordinateModifierY(Position.south, Y-1);
         Position.north.ConstructNorth = true;
         Position.south.ConstructSouth = true;
      }  
      if(Type == 11) {//If Type == 11, direction entered into the maze is South with South and West corridors leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         MazeStart.addWesternCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierY(Position.south, Y-1);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.south.ConstructSouth = true;
         Position.west.ConstructWest = true;
      }
      if(Type == 12) {//If Type == 12, direction entered into the maze is South with South and East corridors leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         MazeStart.addEasternCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierX(Position.east, X+1);
         SpacialCoordinateModifierY(Position.south, Y-1);
         Position.south.ConstructSouth = true;
         Position.east.ConstructEast = true;
      }
      if(Type == 13) {//If Type == 13, direction entered into the maze is South with West and East corridors leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         MazeStart.addEasternCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierX(Position.east, X+1);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.east.ConstructEast = true;
         Position.west.ConstructWest = true;
      }
      if(Type == 14) {//If Type == 14, direction entered into the maze is West with West and North corridors leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         MazeStart.addNorthernCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.north.ConstructNorth = true;
         Position.west.ConstructWest = true;
      }
      if(Type == 15) {//If Type == 15, direction entered into the maze is West with West and South corridors leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         MazeStart.addSouthernCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierY(Position.south, Y-1);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.south.ConstructSouth = true;
         Position.west.ConstructWest = true;
      }
      if(Type == 16) {//If Type == 16, direction entered into the maze is West with North and South corridors leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
         MazeStart.addSouthernCorridor(setRoomData(2), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         SpacialCoordinateModifierY(Position.south, Y-1);
         Position.north.ConstructNorth = true;
         Position.south.ConstructSouth = true;
      }
      if(Type == 17) {//If Type == 17, direction entered into the maze is North with a Northern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         Position.north.ConstructNorth = true;
      }
      if(Type == 18) {//If Type == 18, direction entered into the maze is North with an Eastern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierX(Position.east, X+1);
         Position.east.ConstructEast = true;
      }
      if(Type == 19) {//If Type == 19, direction entered into the maze is North with a Western corridor leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.west.ConstructWest = true;
      }
      if(Type == 20) {//If Type == 20, direction entered into the maze is East with an Eastern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierX(Position.east, X+1);
         Position.east.ConstructEast = true;
      }
      if(Type == 21) {//If Type == 21, direction entered into the maze is East with a Southern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierY(Position.south, Y-1);
         Position.south.ConstructSouth = true;
      }
      if(Type == 22) {//If Type == 22, direction entered into the maze is East with a Northern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         Position.north.ConstructNorth = true;
      }
      if(Type == 23) {//If Type == 23, direction entered into the maze is South with a Southern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierY(Position.south, Y-1);
         Position.south.ConstructSouth = true;
      }
      if(Type == 24) {//If Type == 24, direction entered into the maze is South with a Western corridor leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.west.ConstructWest = true;
      }
      if(Type == 25) {//If Type == 25, direction entered into the maze is South with an Eastern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierX(Position.east, X+1);
         Position.east.ConstructEast = true;
      }
      if(Type == 26) {//If Type == 26, direction entered into the maze is West with a Western corridor leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierX(Position.west, X-1);
         Position.west.ConstructWest = true;
      }
      if(Type == 27) {//If Type == 27, direction entered into the maze is West with a Northern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierY(Position.north, Y+1);
         Position.north.ConstructNorth = true;
      }
      if(Type == 28) {//If Type == 28, direction entered into the maze is West with a Southern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         SpacialCoordinateModifierY(Position.south, Y-1);
         Position.south.ConstructSouth = true;
      }
      return MazeStart;  
   }//End Method GenerateEntrance
   
   public static Node FindStartRoom(Maze M) {
      Node Position = M.entrance;
      
      int a, b, c, d;
      a = b = c = d = 0;
      if(Position.north != null)
         a = getRoomNumber(Position.north);
      if(Position.east != null)
         b = getRoomNumber(Position.east);
      if(Position.south != null)
         c = getRoomNumber(Position.south);
      if(Position.west != null)
         d = getRoomNumber(Position.west);
      
      if(a>b) {//a is higher than b
         if(a>c) {//a is higher than c and b
            if(a>d) {//a is the highest room number; 
               return Position.north;
            }//end a>d
            else {//d is the highest room number;
               return Position.west;
            }//end d>a
         }//end a>c
         else {//c is higher than a and b
            if(c>d) {//c is the highest room number
               return Position.south;
            }//end c>d
            else {//d is the highest room number
               return Position.west;
            }//end d>c
         }//end c>a
      }//end a>b
      else {//b is higher than a
         if(b>c) {//b is higher than c and a
            if(b>d) {//b is the highest room number
               return Position.east;
            }//end b>d
            else {//d is the highest room number
               return Position.west;
            }//end d>b
         }//end b>c
         else {//c is higher than b and a
            if(c>d) {//c is the highest room number
               return Position.south;
            }//end c>d
            else {//d is the highest room number
               return Position.west;
            }//end d>c
         }//end c>b
      }//end b>a
   }//End method FindStartRoom
   
}//End class Maze