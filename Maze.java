//3/13/2017 - Adjust Nodes to not take input for roomData through their constructor.
//  This will herald the change to only allow room data to be set through modifier methods.
import java.util.Scanner;

public class Maze extends Character {
   private Node entrance;
   public Node exit;
   private Node grabPoint;
   private MazeVar MazeVariables;
   private int[] EventTrackerArray;
   public boolean FoundExit;
public class Node extends Event {
   private int[] roomData;
   public int direction;
   private int X_Axis;
   private int Y_Axis;
   private int BeenInRoom;
   private boolean ConstructNorth;
   private boolean ConstructEast;
   private boolean ConstructSouth;
   private boolean ConstructWest;
   private boolean ConstructionExists;
   public boolean CurrentRoom;
   public Node north;
   public Node south;
   public Node east;
   public Node west;
   private Event RoomEvent;
   public Monster monster;
   
   public Node(int[] newData, Node newNorth, Node newSouth, Node newEast, Node newWest) {
      roomData = newData;
      north = newNorth;
      south = newSouth;
      east = newEast;
      west = newWest;
      direction = 1;
      X_Axis = 0;
      Y_Axis = 0;
      ConstructNorth = false;
      ConstructEast = false;
      ConstructSouth = false;
      ConstructWest = false;
      BeenInRoom = 0;
      RoomEvent = new Event();
      monster = null;
   }//End Node constructor
   
}//End private class

private class MazeVar extends Item {
   private boolean Paradox;
   private int MaxMazeRoom;
   private int MazeEnvironment;
   
   public MazeVar() {
      Paradox = false;
      MaxMazeRoom = 0;
      MazeEnvironment = 0;
   }//End MazeVar Constructor   
}//End private class MazeVar

   //Maze Constructor
   public Maze() {
      entrance = null;
      exit = null;
      grabPoint = null;
      MazeVariables = new MazeVar();
      EventTrackerArray = new int[]{0,0,0,0,0,0,0,0,0,0};
   }
   
   public static void AssignEventNumber(Event E, int Enumber) {
      E.setEventNumber(Enumber);
   }//End Method AssigneEventNumber
   
   public static Event getRoomEvent(Node C) {
      return C.RoomEvent;
   }//End Method getRoomEvent
   
   public static int getRoomEventNumber(Event E) {
      return E.getEventNumber();
   }//End Method GetRoomEventNumber
   
   public static int[] getEventTrackerArray(Maze M) {
      return M.EventTrackerArray;
   }//End Method getEventTrackerArray
   
   public static boolean MonsterInRoom(Node C) {
      if(C.monster == null)
         return false;
      else
         return true;
   }//End Method MonsterInRoom
   
   public static int getMazeEnvironment(MazeVar MV) {
      return MV.MazeEnvironment;
   }//End Method getMazeEnvironment
   
   public static MazeVar getMazeVar(Maze M) {
      return M.MazeVariables;
   }//End Method getMazeVar
   
   public static boolean getParadox(MazeVar MV) {
      return MV.Paradox;
   }//End Method getParadox
   
   public static int getMaxMazeRoom(MazeVar MV) {
      return MV.MaxMazeRoom;
   }//End Method getParadox
   
   public static Node getStart(Maze M) {
      return M.entrance;
   }//End Method getStart
   
   public static Node getExit(Maze M) {
      return M.exit;
   }//End Method getExit
   
   public static boolean getFoundExit(Maze M) {
      return M.FoundExit;
   }
   
   public static void setFoundExit(boolean newFE, Maze M) {
      M.FoundExit = newFE;
   }
   
   public static boolean getCurrentRoom(Node C) {
      return C.CurrentRoom;
   }
   
   public static void setCurrentRoom(boolean newCR, Node C) {
      C.CurrentRoom = newCR;
   }
   
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
   }//End Method getRoomNumber
   
   public static Node getGrabPoint(Maze M) {
     if(M.grabPoint != null) {
        return M.grabPoint;
     }
     else {
        System.out.println("ERROR: NULL POINTER EXCEPTION IN METHOD getGrabPoint.");
         return M.entrance;  
     }
   }//End Method
   
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
   
   public static void setParadox(MazeVar MV, boolean b) {
      MV.Paradox = b; 
   }//End Method setParadox
   
   public static void setMaxMazeRoom(MazeVar MV, int i) {
      MV.MaxMazeRoom = i;
   }//End Method setMaxMazeRoom
   
   public static void setMazeEnvironment(MazeVar MV, int i) {
      MV.MazeEnvironment = i;
   }//End Method setMazeEnvironment
   
   public static void setGrabPoint(Maze M, Node C) {
      M.grabPoint = C;
   }//End Method setGrabPoint
   
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
   
   public static void setExit(Maze M, Node C) {
      M.exit = C;
   }//End Method getExit
   
   public static boolean isConstructionPoint(Node C) {
      if(C.ConstructNorth == true || C.ConstructEast == true || C.ConstructSouth == true || C.ConstructWest == true)
         return true;
      else
         return false;
   }//End Method checkConstructionPoint
   
   public static boolean isEqual(Node C, Node C2) {
      if(getSpacialCoordinateX(C) == getSpacialCoordinateX(C2) && getSpacialCoordinateY(C) == getSpacialCoordinateY(C2))
         return true;
      else
       return false;
   }//End Method isEqual
   
   public static boolean isExit(Node C, Maze M) {
      if(getRoomNumber(C) == getRoomNumber(getExit(M)))
         return true;
      return false;
   }//End Method isExit
   
   public boolean ExitExists() {
      if(this.exit != null)
         return true;
      else
         return false;
   }//End Method ExitExists
   
   public void addEntrance(int[] newData) {
      entrance = new Node(newData, null, null, null, null);
   }
   
   public static void addMonster(Monster m, Node C) {
      C.monster = m;
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
      Node StartPoint = Tutorial.entrance;      
      Node Position = Tutorial.entrance;
      SpacialCoordinateModifierX(Position, 0);
      SpacialCoordinateModifierY(Position, 0);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 1
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 0);
      SpacialCoordinateModifierY(Position, -1);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 2
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 0);
      SpacialCoordinateModifierY(Position, -2);
      
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 3
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 0);
      SpacialCoordinateModifierY(Position, -3);
      Skeleton MrBones = new Skeleton();
      addMonster(MrBones, Position);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 4
      SpacialCoordinateModifierX(Position.south, 0);
      SpacialCoordinateModifierY(Position.south, -4);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 5
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 1);
      SpacialCoordinateModifierY(Position, -3);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 6 
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 2);
      SpacialCoordinateModifierY(Position, -3);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 7
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 2);
      SpacialCoordinateModifierY(Position, -4);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 8
      SpacialCoordinateModifierX(Position.south, 2);
      SpacialCoordinateModifierY(Position.south, -5);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Position = moveNorth(Position);
      Tutorial.addNorthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 9
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, 2);
      SpacialCoordinateModifierY(Position, -2);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 10
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 3);
      SpacialCoordinateModifierY(Position, -2);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addNorthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 11
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, 3);
      SpacialCoordinateModifierY(Position, -1);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addNorthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 12
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, 3);
      SpacialCoordinateModifierY(Position, 0);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addWesternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 13
      SpacialCoordinateModifierX(Position.west, 2);
      SpacialCoordinateModifierY(Position.west, 0);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 14
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 4);
      SpacialCoordinateModifierY(Position, 0);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 15
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 5);
      SpacialCoordinateModifierY(Position, 0);
      
      //GenerateBlock_StraightNorth(Position, getRoomNumber(Position), getSpacialCoordinateX(Position), getSpacialCoordinateY(Position));
      GenerateBlock_North_TBlock(Position, getRoomNumber(Position), getSpacialCoordinateX(Position), getSpacialCoordinateY(Position));
      //ParadoxAvoidance_4Block(Tutorial, getStart(Tutorial), Position.north, Position.north.north, Position.north.north.east, Position.north.north.west);
      //System.out.println(getParadox(Tutorial.MazeVariables));
      
      TrackMaxRoom(StartPoint, Tutorial);   
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 16
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 6);
      SpacialCoordinateModifierY(Position, 0);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 17
      SpacialCoordinateModifierX(Position.east, 7);
      SpacialCoordinateModifierY(Position.east, 0);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Position = moveWest(Position);
      Position = moveWest(Position);
      Position = moveWest(Position);
      Position = moveSouth(Position);
      Position = moveSouth(Position);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 18
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 4);
      SpacialCoordinateModifierY(Position, -2);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 19
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 5);
      SpacialCoordinateModifierY(Position, -2);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 20
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 5);
      SpacialCoordinateModifierY(Position, -3);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 21
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 5);
      SpacialCoordinateModifierY(Position, -4);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addWesternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 22
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, 4);
      SpacialCoordinateModifierY(Position, -4);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 23
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 4);
      SpacialCoordinateModifierY(Position, -5);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 24
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 4);
      SpacialCoordinateModifierY(Position, -6);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 25
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 4);
      SpacialCoordinateModifierY(Position, -7);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addWesternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 26
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, 3);
      SpacialCoordinateModifierY(Position, -7);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addWesternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 27
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, 2);
      SpacialCoordinateModifierY(Position, -7);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addWesternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 28
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, 1);
      SpacialCoordinateModifierY(Position, -7);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addWesternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 29
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, 0);
      SpacialCoordinateModifierY(Position, -7);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addNorthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 30
      SpacialCoordinateModifierX(Position.north, 0);
      SpacialCoordinateModifierY(Position.north, -6);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Position = moveEast(Position);
      Position = moveEast(Position);
      Position = moveEast(Position);
      Position = moveEast(Position);
      Position = moveNorth(Position);
      Position = moveNorth(Position);
      Position = moveNorth(Position);
      Position = moveEast(Position);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 31
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 6);
      SpacialCoordinateModifierY(Position, -4);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 32
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 7);
      SpacialCoordinateModifierY(Position, -4);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addNorthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 33
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, 7);
      SpacialCoordinateModifierY(Position, -3);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addNorthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 34
      SpacialCoordinateModifierX(Position.north, 7);
      SpacialCoordinateModifierY(Position.north, -2);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Position = moveSouth(Position);
      Position = moveWest(Position);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 35
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 6);
      SpacialCoordinateModifierY(Position, -5);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 36
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 6);
      SpacialCoordinateModifierY(Position, -6);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addEasternCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 37
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, 7);
      SpacialCoordinateModifierY(Position, -6);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.addSouthernCorridor(setRoomData(getMaxMazeRoom(getMazeVar(Tutorial))+1), Position);//Added room 38
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, 7);
      SpacialCoordinateModifierY(Position, -7);
      
      TrackMaxRoom(StartPoint, Tutorial);
      Tutorial.exit = Position;
      
      return Tutorial;
   }//End method GenerateBasicMaze
   
   public static Maze CreateMaze() {
      Maze Dungeon = new Maze();
      boolean EE;
      EE = false;
      while(EE == false) {
         Dungeon = RandomMazeGeneration();
         if(Dungeon.ExitExists() == true)
            EE = true;
      }
      FillMaze(getStart(Dungeon), Dungeon);
      return Dungeon;
   }//End Method CreateMaze
   
   public static Maze RandomMazeGeneration() {
      Maze M = new Maze();
      Node Position, Insert;
      Node NodeTracker[] = new Node[15];
      M = GenerateEntrance((int)(Math.random()*(29-1)+1));
      Position = FindStartRoom(M);
      for(int x = 0; x < NodeTracker.length; x++) {
         NodeTracker[x] = Position;
      }
      int RNG, MaxRoomNumber, VerifyAddition, i;
      i = 0;
      
      while(i < 10) {
         RNG = (int)(Math.random()*(5-1)+1);   
         if(isConstructionPoint(Position) == true) {
            TrackMaxRoom (getStart(M), M);
            MaxRoomNumber = getMaxMazeRoom(getMazeVar(M));
            Insert = BlockGenerator(Position, RNG, MaxRoomNumber, getSpacialCoordinateX(Position), getSpacialCoordinateY(Position), M);
            NodeTracker[i] = Insert;
            TrackMaxRoom(getStart(M), M);
            VerifyAddition = getMaxMazeRoom(getMazeVar(M));
            if(VerifyAddition > MaxRoomNumber)
               i++;
         }
         if(RNG == 1) {
            if(Position.north != null) {
               Position = Position.north;
               continue;
            }
            else
               continue;
         }//End North if
         if(RNG == 2) {
            if(Position.east != null) {
               Position = Position.east;
               continue;
            }
            else
               continue;
         }//End East if
         if(RNG == 3) {
            if(Position.south != null) {
               Position = Position.south;
               continue;
            }
            else
               continue;
         }//End South if
         if(RNG == 4) {
            if(Position.west != null) {
               Position = Position.west;
               continue;
            }
            else
               continue;
         }//End West if
         Position = RandomNodeSelection(NodeTracker);
      }//End Loop
      
      M.setMazeExit(getStart(M), 0, 15);
      return M;
   }//End Method RandomMazeGeneration
   
   public static Node RandomNodeSelection(Node[] A) {
   Node NValue;
   NValue = A[0];
   int RNG;
   boolean FoundNode;
   FoundNode = false;
   
   while(FoundNode == false) {
      RNG = (int)(Math.random()*(A.length-1));
      if(A[RNG] != null) {
         NValue = A[RNG];
         FoundNode = true;
      }
      else
         continue;
   }//End loop
   return NValue;
   }//End Method RandomNodeSelection
   
   public static Maze GenerateMazeStartPoint(Maze M) {
      M = GenerateEntrance((int)(Math.random() *(29-1)+1));
      return M;
   }//End Method GenerateMazeStartPoint
   
   public static void TrackMaxRoom (Node C, Maze M) {
      int x;
      x = getRoomNumber(C);
      if(C.north != null) {
         if(x < getRoomNumber(C.north)) {
            TrackMaxRoom(C.north, M);
         }
      }
      if(C.east != null) {
         if(x < getRoomNumber(C.east)) {
            TrackMaxRoom(C.east, M);
         }
      }
      if(C.south != null) {
         if(x < getRoomNumber(C.south)) {
            TrackMaxRoom(C.south, M);
         }
      }
      if(C.west != null) {
         if(x < getRoomNumber(C.west)) {
            TrackMaxRoom(C.west, M);
         }
      }
      if(x >= getMaxMazeRoom(M.MazeVariables))
         setMaxMazeRoom(M.MazeVariables, x);
   }//End Method TrackMaxRoom
   
   public static Node FindCurrentRoom (Node C, Maze M) {
      int x;
      x = getRoomNumber(C);
      
      if(getCurrentRoom(C) == true)
         return C;
      
      if(C.north != null) {
         if(x < getRoomNumber(C.north)) {
            FindCurrentRoom(C.north, M);
         }
      }
      if(C.east != null) {
         if(x < getRoomNumber(C.east)) {
            FindCurrentRoom(C.east, M);
         }
      }
      if(C.south != null) {
         if(x < getRoomNumber(C.south)) {
            FindCurrentRoom(C.south, M);
         }
      }
      if(C.west != null) {
         if(x < getRoomNumber(C.west)) {
            FindCurrentRoom(C.west, M);
         }
      }
      return C;
      
   }//End Method FindCurrentRoom
   
   public static void MatchRoom(Node MatchNode, int MatchNumber, Maze M) {
      
      if(getRoomNumber(MatchNode) == MatchNumber) {
          setGrabPoint(M, MatchNode);
          return;
      }
      if(MatchNode.north != null) {
         if(getRoomNumber(MatchNode) < getRoomNumber(MatchNode.north)) {
            MatchRoom(MatchNode.north, MatchNumber, M);
         }
      }//End North check
      
      if(MatchNode.east != null) {
         if(getRoomNumber(MatchNode) < getRoomNumber(MatchNode.east)) {
            MatchRoom(MatchNode.east, MatchNumber, M);
         }
      }//End East check
      
      if(MatchNode.south != null) {
         if(getRoomNumber(MatchNode) < getRoomNumber(MatchNode.south)) {
            MatchRoom(MatchNode.south, MatchNumber, M);
         }
      }//End South check
      
      if(MatchNode.west != null) {
         if(getRoomNumber(MatchNode) < getRoomNumber(MatchNode.west)) {
            MatchRoom(MatchNode.west, MatchNumber, M);
         }
      }//End West check
      
   }//End Method MatchRoom
   
   public static void TestVarious() {
      Maze Test = new Maze();
   
      Character Player = new Character();
      
      boolean EE;
      EE = false;
      while(EE == false) {
         Test = RandomMazeGeneration();
         if(Test.ExitExists() == true)
            EE = true;
      }
      FillMaze(getStart(Test), Test);
      mazeDiagnostics(Maze.getStart(Test), Test);
      
   }//End Method TestVarious
   
   
   public static Node BlockGenerator(Node C, int RNG, int RoomNumber, int X, int Y, Maze M) {
      Maze clone = new Maze();
      clone = Clone(M);
      setParadox(clone.MazeVariables, false);
      Node T, S, Match;
      S = getStart(clone);
      Match = getStart(clone);      
      MatchRoom(Match, RoomNumber, clone);
      T = getGrabPoint(clone);
      int Path;
      
      if(RNG == 1) {//Start NorthBuild
         if(C.ConstructNorth == true) {
            Path = (int)(Math.random()*(12-1)+1);
            if(Path == 1) {
               GenerateBlock_StraightNorth(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.north, T.north.north, T.north.north.north); 
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_StraightNorth(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 2) {
               GenerateBlock_NorthEast_Elbow_NorthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.north, T.north.north, T.north.north.east);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_NorthEast_Elbow_NorthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 3) {
               GenerateBlock_NorthWest_Elbow_NorthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.north, T.north.north, T.north.north.west);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_NorthWest_Elbow_NorthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 4) {
               GenerateBlock_EastNorth_Elbow_NorthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.north, T.north.east, T.north.east.north);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_EastNorth_Elbow_NorthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 5) {
               GenerateBlock_EastSouth_Elbow_NorthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.north, T.north.east, T.north.east.south);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_EastSouth_Elbow_NorthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 6) {
               GenerateBlock_WestNorth_Elbow_NorthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.north, T.north.west, T.north.west.north);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_WestNorth_Elbow_NorthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 7) {
               GenerateBlock_WestSouth_Elbow_NorthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.north, T.north.west, T.north.west.south);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_WestSouth_Elbow_NorthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 8) {
               if(getConstructionPointEast(C) == true && getConstructionPointWest(C) == true) {//Start multiBuildCheck
                  GenerateBlock_North_TriBlock(T, RoomNumber, X, Y);
                  ParadoxAvoidance_3Block(clone, S, T.north, T.east, T.west);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_North_TriBlock(C, RoomNumber, X, Y);
                     return C;
                  }
               }//End multiBuildCheck
               else {
                  GenerateBlock_MultiConnector_Specialty_NorthBuilt(T, RoomNumber, X, Y);
                  ParadoxAvoidance_1Block(clone, S, T.north);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_MultiConnector_Specialty_NorthBuilt(C, RoomNumber, X, Y);
                     return C;
                  }
               }
            }
            if(Path == 9) {
               GenerateBlock_North_TBlock(T, RoomNumber, X, Y);
               ParadoxAvoidance_4Block(clone, S, T.north, T.north.north, T.north.north.east, T.north.north.west);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_North_TBlock(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 10) {
               if(getConstructionPointSouth(C) == true) {//Start multiBuildCheck
                  GenerateBlock_NorthSouth_Split(T, RoomNumber, X, Y);
                  ParadoxAvoidance_4Block(clone, S, T.north, T.north.north, T.south, T.south.south);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_NorthSouth_Split(C, RoomNumber, X, Y);
                     return C;
                  }
               }//End multiBuildCheck
               else {
                  GenerateBlock_MultiConnector_Specialty_NorthBuilt(T, RoomNumber, X, Y);
                  ParadoxAvoidance_1Block(clone, S, T.north);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_MultiConnector_Specialty_NorthBuilt(C, RoomNumber, X, Y);
                     return C;
                  }
               }
            }
            if(Path == 11) {
               GenerateBlock_MultiConnector_Specialty_NorthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_1Block(clone, S, T.north);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_MultiConnector_Specialty_NorthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
         }//End ConstructNorth
      }//End northbuild
      if(RNG == 2) {//Start EastBuild
         if(C.ConstructEast == true) {
            Path = (int)(Math.random()*(12-1)+1);
            if(Path == 1) {
               GenerateBlock_StraightEast(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.east, T.east.east, T.east.east.east);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_StraightEast(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 2) {
               GenerateBlock_NorthEast_Elbow_EastBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.east, T.east.north, T.east.north.east);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_NorthEast_Elbow_EastBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 3) {
               GenerateBlock_NorthWest_Elbow_EastBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.east, T.east.north, T.east.north.west);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_NorthWest_Elbow_EastBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 4) {
               GenerateBlock_EastNorth_Elbow_EastBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.east, T.east.east, T.east.east.north);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_EastNorth_Elbow_EastBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 5) {
               GenerateBlock_EastSouth_Elbow_EastBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.east, T.east.east, T.east.east.south);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_EastSouth_Elbow_EastBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 6) {
               GenerateBlock_SouthEast_Elbow_EastBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.east, T.east.south, T.east.south.east);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_SouthEast_Elbow_EastBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 7) {
               GenerateBlock_SouthWest_Elbow_EastBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.east, T.east.south, T.east.south.west);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_SouthWest_Elbow_EastBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 8) {
               if(getConstructionPointNorth(C) == true && getConstructionPointSouth(C) == true) {//Start multiBuildCheck
                  GenerateBlock_East_TriBlock(T, RoomNumber, X, Y);
                  ParadoxAvoidance_3Block(clone, S, T.north, T.east, T.south);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_East_TriBlock(C, RoomNumber, X, Y);
                     return C;
                  }
               }//End multiBuildCheck
               else {
                  GenerateBlock_MultiConnector_Specialty_EastBuilt(T, RoomNumber, X, Y);
                  ParadoxAvoidance_1Block(clone, S, T.east);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_MultiConnector_Specialty_EastBuilt(C, RoomNumber, X, Y);
                     return C;
                  }
               }
            }
            if(Path == 9) {
               GenerateBlock_East_TBlock(T, RoomNumber, X, Y);
               ParadoxAvoidance_4Block(clone, S, T.east, T.east.east, T.east.east.north, T.east.east.south);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_East_TBlock(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 10) {
               if(getConstructionPointWest(C) == true) {//Start multiBuildCheck
                  GenerateBlock_EastWest_Split(T, RoomNumber, X, Y);
                  ParadoxAvoidance_4Block(clone, S, T.east, T.east.east, T.west, T.west.west);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_EastWest_Split(C, RoomNumber, X, Y);
                     return C;
                  }
               }//End multiBuildCheck
               else {
                  GenerateBlock_MultiConnector_Specialty_EastBuilt(T, RoomNumber, X, Y);
                  ParadoxAvoidance_1Block(clone, S, T.east);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_MultiConnector_Specialty_EastBuilt(C, RoomNumber, X, Y);
                     return C;
                  }
               }
            }
            if(Path == 11) {
               GenerateBlock_MultiConnector_Specialty_EastBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_1Block(clone, S, T.east);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_MultiConnector_Specialty_EastBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
         }//End ConstructEast
      }//End eastbuild
      if(RNG == 3) {//Start SouthBuild
         if(C.ConstructSouth == true) {
            Path = (int)(Math.random()*(12-1)+1);
            if(Path == 1) {   
               GenerateBlock_StraightSouth(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.south, T.south.south, T.south.south.south);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_StraightSouth(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 2) {   
               GenerateBlock_EastNorth_Elbow_SouthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.south, T.south.east, T.south.east.north);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_EastNorth_Elbow_SouthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 3) {   
               GenerateBlock_EastSouth_Elbow_SouthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.south, T.south.east, T.south.east.south);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_EastSouth_Elbow_SouthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 4) {   
               GenerateBlock_SouthEast_Elbow_SouthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.south, T.south.south, T.south.south.east);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_SouthEast_Elbow_SouthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 5) {   
               GenerateBlock_SouthWest_Elbow_SouthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.south, T.south.south, T.south.south.west);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_SouthWest_Elbow_SouthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 6) {   
               GenerateBlock_WestNorth_Elbow_SouthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.south, T.south.west, T.south.west.north);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_WestNorth_Elbow_SouthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 7) {   
               GenerateBlock_WestSouth_Elbow_SouthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.south, T.south.west, T.south.west.south);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_WestSouth_Elbow_SouthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 8) {
               if(getConstructionPointEast(C) == true && getConstructionPointWest(C) == true) {//Start multiBuildCheck
                  GenerateBlock_South_TriBlock(T, RoomNumber, X, Y);
                  ParadoxAvoidance_3Block(clone, S, T.south, T.east, T.west);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_South_TriBlock(C, RoomNumber, X, Y);
                     return C;
                  }
               }//End multiBuildCheck
               else {
                  GenerateBlock_MultiConnector_Specialty_SouthBuilt(T, RoomNumber, X, Y);
                  ParadoxAvoidance_1Block(clone, S, T.south);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_MultiConnector_Specialty_SouthBuilt(C, RoomNumber, X, Y);
                     return C;
                  }
               }
            }
            if(Path == 9) {
               GenerateBlock_South_TBlock(T, RoomNumber, X, Y);
               ParadoxAvoidance_4Block(clone, S, T.south, T.south.south, T.south.south.east, T.south.south.west);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_South_TBlock(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 10) {
               if(getConstructionPointNorth(C) == true) {//Start multiBuildCheck
                  GenerateBlock_NorthSouth_Split(T, RoomNumber, X, Y);
                  ParadoxAvoidance_4Block(clone, S, T.north, T.north.north, T.south, T.south.south);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_NorthSouth_Split(C, RoomNumber, X, Y);
                     return C;
                  }
               }//End multiBuildCheck
               else {
                  GenerateBlock_MultiConnector_Specialty_SouthBuilt(T, RoomNumber, X, Y);
                  ParadoxAvoidance_1Block(clone, S, T.south);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_MultiConnector_Specialty_SouthBuilt(C, RoomNumber, X, Y);
                     return C;
                  }
               }
            }
            if(Path == 11) {
               GenerateBlock_MultiConnector_Specialty_SouthBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_1Block(clone, S, T.south);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_MultiConnector_Specialty_SouthBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
         }//End ConstructSouth
      }//End southbuild
      if(RNG == 4) {//Start WestBuild
         if(C.ConstructWest == true) {
            Path = (int)(Math.random()*(12-1)+1);
            if(Path == 1) {
               GenerateBlock_StraightWest(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.west, T.west.west, T.west.west.west);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_StraightWest(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 2) {
               GenerateBlock_NorthEast_Elbow_WestBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.west, T.west.north, T.west.north.east);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_NorthEast_Elbow_WestBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 3) {
               GenerateBlock_NorthWest_Elbow_WestBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.west, T.west.north, T.west.north.west);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_NorthWest_Elbow_WestBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 4) {
               GenerateBlock_SouthEast_Elbow_WestBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.west, T.west.south, T.west.south.east);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_SouthEast_Elbow_WestBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 5) {
               GenerateBlock_SouthWest_Elbow_WestBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.west, T.west.south, T.west.south.west);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_SouthWest_Elbow_WestBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 6) {
               GenerateBlock_WestNorth_Elbow_WestBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.west, T.west.west, T.west.west.north);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_WestNorth_Elbow_WestBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 7) {
               GenerateBlock_WestSouth_Elbow_WestBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_3Block(clone, S, T.west, T.west.west, T.west.west.south);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_WestSouth_Elbow_WestBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 8) {
               if(getConstructionPointNorth(C) == true && getConstructionPointSouth(C) == true) {//Start multiBuildCheck
                  GenerateBlock_West_TriBlock(T, RoomNumber, X, Y);
                  ParadoxAvoidance_3Block(clone, S, T.north, T.west, T.south);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_West_TriBlock(C, RoomNumber, X, Y);
                     return C;
                  }
               }//End multiBuildCheck
               else {
                  GenerateBlock_MultiConnector_Specialty_WestBuilt(T, RoomNumber, X, Y);
                  ParadoxAvoidance_1Block(clone, S, T.west);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_MultiConnector_Specialty_WestBuilt(C, RoomNumber, X, Y);
                     return C;
                  }
               }
            }
            if(Path == 9) {
               GenerateBlock_West_TBlock(T, RoomNumber, X, Y);
               ParadoxAvoidance_4Block(clone, S, T.west, T.west.west, T.west.west.north, T.west.west.south);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_West_TBlock(C, RoomNumber, X, Y);
                  return C;
               }
            }
            if(Path == 10) {
               if(getConstructionPointEast(C) == true) {//Start multiBuildCheck
                  GenerateBlock_EastWest_Split(T, RoomNumber, X, Y);
                  ParadoxAvoidance_4Block(clone, S, T.east, T.east.east, T.west, T.west.west);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_EastWest_Split(C, RoomNumber, X, Y);
                     return C;
                  }
               }//End multiBuildCheck
               else {
                  GenerateBlock_MultiConnector_Specialty_WestBuilt(T, RoomNumber, X, Y);
                  ParadoxAvoidance_1Block(clone, S, T.west);
                  if(getParadox(clone.MazeVariables)==false) {
                     C = GenerateBlock_MultiConnector_Specialty_WestBuilt(C, RoomNumber, X, Y);
                     return C;
                  }
               }
            }
            if(Path == 11) {
               GenerateBlock_MultiConnector_Specialty_WestBuilt(T, RoomNumber, X, Y);
               ParadoxAvoidance_1Block(clone, S, T.west);
               if(getParadox(clone.MazeVariables)==false) {
                  C = GenerateBlock_MultiConnector_Specialty_WestBuilt(C, RoomNumber, X, Y);
                  return C;
               }
            }
         }//End ConstructWest
      }//End westbuild
      return C;
   }//End Method BlockGenerator 
   
   //*************************************************************
   //This block of code represents maze generation blocks start.
   //*************************************************************
   
   //*************************************************************
   //Start straight block code.
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
   
   //************************************************************
   //End straight block code.
   //************************************************************
   
   //************************************************************
   //Start elbow block code.
   //************************************************************
   
   private static Node GenerateBlock_EastNorth_Elbow_EastBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+2);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      setConstructionPointNorth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_EastNorth_Elbow_EastBuilt
   
   private static Node GenerateBlock_EastNorth_Elbow_NorthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointNorth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY+2);
      setConstructionPointNorth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_EastNorth_Elbow_NorthBuilt
   
   private static Node GenerateBlock_EastNorth_Elbow_SouthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointSouth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      setConstructionPointNorth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_EastNorth_Elbow_SouthBuilt
   
   private static Node GenerateBlock_EastSouth_Elbow_EastBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+2);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      setConstructionPointSouth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_EastSouth_Elbow_EastBuilt
   
   private static Node GenerateBlock_EastSouth_Elbow_NorthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointNorth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      setConstructionPointSouth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_EastSouth_Elbow_NorthBuilt
   
   private static Node GenerateBlock_EastSouth_Elbow_SouthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointSouth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY-2);
      setConstructionPointSouth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_EastSouth_Elbow_SouthBuilt
   
   private static Node GenerateBlock_NorthEast_Elbow_NorthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY+2);
      setConstructionPointSouth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_NorthEast_Elbow_NorthBuilt
   
   private static Node GenerateBlock_NorthEast_Elbow_EastBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointEast(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+2);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      setConstructionPointSouth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_NorthEast_Elbow_EastBuilt
   
   private static Node GenerateBlock_NorthEast_Elbow_WestBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointWest(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      setConstructionPointSouth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_NorthEast_Elbow_WestBuilt
   
   private static Node GenerateBlock_NorthWest_Elbow_NorthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY+2);
      setConstructionPointSouth(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_NorthWest_Elbow_NorthBuilt
   
   private static Node GenerateBlock_NorthWest_Elbow_EastBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointEast(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      setConstructionPointSouth(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_NorthWest_Elbow_EastBuilt
   
   private static Node GenerateBlock_NorthWest_Elbow_WestBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointWest(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-2);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      setConstructionPointSouth(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_NorthWest_Elbow_WestBuilt
   
   private static Node GenerateBlock_SouthEast_Elbow(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointSouth(C, false);
      setConstructionPointEast(C, false);
      setConstructionPointWest(C, false);
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
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY-2);
      setConstructionPointSouth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_SouthEast_Elbow
   
   private static Node GenerateBlock_SouthEast_Elbow_SouthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY-2);
      setConstructionPointSouth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_SouthEast_Elbow_SouthBuilt
   
   private static Node GenerateBlock_SouthEast_Elbow_WestBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointWest(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      setConstructionPointSouth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_SouthEast_Elbow_WestBuilt
   
   private static Node GenerateBlock_SouthEast_Elbow_EastBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointEast(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+2);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      setConstructionPointSouth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_SouthEast_Elbow_EastBuilt
   
   private static Node GenerateBlock_SouthWest_Elbow_SouthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY-2);
      setConstructionPointSouth(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_SouthWest_Elbow_SouthBuilt
   
   private static Node GenerateBlock_SouthWest_Elbow_WestBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointWest(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-2);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      setConstructionPointSouth(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_SouthWest_Elbow_WestBuilt
   
   private static Node GenerateBlock_SouthWest_Elbow_EastBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointEast(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      setConstructionPointSouth(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_SouthWest_Elbow_EastBuilt
   
   private static Node GenerateBlock_WestNorth_Elbow_WestBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-2);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_WestNorth_Elbow_WestBuilt
   
   private static Node GenerateBlock_WestNorth_Elbow_NorthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointNorth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY+2);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_WestNorth_Elbow_NorthBuilt
   
   private static Node GenerateBlock_WestNorth_Elbow_SouthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointSouth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointNorth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_WestNorth_Elbow_SouthBuilt
   
   private static Node GenerateBlock_WestSouth_Elbow_WestBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-2);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointSouth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_WestSouth_Elbow_WestBuilt
   
   private static Node GenerateBlock_WestSouth_Elbow_NorthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointNorth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointSouth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_WestSouth_Elbow_NorthBuilt
   
   private static Node GenerateBlock_WestSouth_Elbow_SouthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointSouth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+2), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY-2);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointSouth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_WestSouth_Elbow_SouthBuilt
   
   //************************************************************
   //End elbow block code.
   //************************************************************
   
   //************************************************************
   //Start TriBlock block code.
   //************************************************************
   
   private static Node GenerateBlock_North_TriBlock(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointNorth(C, false);
      setConstructionPointEast(C, false);
      setConstructionPointWest(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+1), Position);
      SpacialCoordinateModifierX(Position.north, CoordinateX);
      SpacialCoordinateModifierY(Position.north, CoordinateY+1);
      setConstructionPointNorth(Position.north, true);
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+2), Position);
      SpacialCoordinateModifierX(Position.east, CoordinateX+1);
      SpacialCoordinateModifierY(Position.east, CoordinateY);
      setConstructionPointEast(Position.east, true);
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+3), Position);
      SpacialCoordinateModifierX(Position.west, CoordinateX-1);
      SpacialCoordinateModifierY(Position.west, CoordinateY);
      setConstructionPointWest(Position.west, true);
      
      return Position;
      
   }//End Method GenerateBlock_North_TriBlock
   
   private static Node GenerateBlock_East_TriBlock(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointNorth(C, false);
      setConstructionPointEast(C, false);
      setConstructionPointSouth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+1), Position);
      SpacialCoordinateModifierX(Position.north, CoordinateX);
      SpacialCoordinateModifierY(Position.north, CoordinateY+1);
      setConstructionPointNorth(Position.north, true);
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+2), Position);
      SpacialCoordinateModifierX(Position.east, CoordinateX+1);
      SpacialCoordinateModifierY(Position.east, CoordinateY);
      setConstructionPointEast(Position.east, true);
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      SpacialCoordinateModifierX(Position.south, CoordinateX);
      SpacialCoordinateModifierY(Position.south, CoordinateY-1);
      setConstructionPointSouth(Position.south, true);
      
      return Position;
      
   }//End Method GenerateBlock_East_TriBlock
   
   private static Node GenerateBlock_South_TriBlock(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointSouth(C, false);
      setConstructionPointEast(C, false);
      setConstructionPointWest(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+1), Position);
      SpacialCoordinateModifierX(Position.west, CoordinateX-1);
      SpacialCoordinateModifierY(Position.west, CoordinateY);
      setConstructionPointWest(Position.west, true);
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+2), Position);
      SpacialCoordinateModifierX(Position.east, CoordinateX+1);
      SpacialCoordinateModifierY(Position.east, CoordinateY);
      setConstructionPointEast(Position.east, true);
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      SpacialCoordinateModifierX(Position.south, CoordinateX);
      SpacialCoordinateModifierY(Position.south, CoordinateY-1);
      setConstructionPointSouth(Position.south, true);
      
      return Position;
      
   }//End Method GenerateBlock_South_TriBlock
   
   private static Node GenerateBlock_West_TriBlock(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointNorth(C, false);
      setConstructionPointWest(C, false);
      setConstructionPointSouth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+1), Position);
      SpacialCoordinateModifierX(Position.north, CoordinateX);
      SpacialCoordinateModifierY(Position.north, CoordinateY+1);
      setConstructionPointNorth(Position.north, true);
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+2), Position);
      SpacialCoordinateModifierX(Position.west, CoordinateX-1);
      SpacialCoordinateModifierY(Position.west, CoordinateY);
      setConstructionPointWest(Position.west, true);
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      SpacialCoordinateModifierX(Position.south, CoordinateX);
      SpacialCoordinateModifierY(Position.south, CoordinateY-1);
      setConstructionPointSouth(Position.south, true);
      
      return Position;
      
   }//End Method GenerateBlock_West_TriBlock
   
   //************************************************************
   //End TriBlock block code.
   //************************************************************
   
   //************************************************************
   //Start TBlock block code.
   //************************************************************
   
   private static Node GenerateBlock_North_TBlock(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      SpacialCoordinateModifierX(Position.east, CoordinateX+1);
      SpacialCoordinateModifierY(Position.east, CoordinateY+2);
      setConstructionPointNorth(Position.east, true);
      setConstructionPointEast(Position.east, true);
      setConstructionPointSouth(Position.east, true);
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+4), Position);
      SpacialCoordinateModifierX(Position.west, CoordinateX-1);
      SpacialCoordinateModifierY(Position.west, CoordinateY+2);
      setConstructionPointNorth(Position.west, true);
      setConstructionPointWest(Position.west, true);
      setConstructionPointSouth(Position.west, true);
      
      return Position;
      
   }//End Method GenerateBlock_North_TBlock
   
   private static Node GenerateBlock_East_TBlock(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+3), Position);
      SpacialCoordinateModifierX(Position.north, CoordinateX+2);
      SpacialCoordinateModifierY(Position.north, CoordinateY+1);
      setConstructionPointNorth(Position.north, true);
      setConstructionPointEast(Position.north, true);
      setConstructionPointWest(Position.north, true);
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+4), Position);
      SpacialCoordinateModifierX(Position.south, CoordinateX+2);
      SpacialCoordinateModifierY(Position.south, CoordinateY-1);
      setConstructionPointEast(Position.south, true);
      setConstructionPointWest(Position.south, true);
      setConstructionPointSouth(Position.south, true);
      
      return Position;
      
   }//End Method GenerateBlock_East_TBlock
   
   private static Node GenerateBlock_South_TBlock(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      SpacialCoordinateModifierX(Position.east, CoordinateX+1);
      SpacialCoordinateModifierY(Position.east, CoordinateY-2);
      setConstructionPointNorth(Position.east, true);
      setConstructionPointEast(Position.east, true);
      setConstructionPointSouth(Position.east, true);
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+4), Position);
      SpacialCoordinateModifierX(Position.west, CoordinateX-1);
      SpacialCoordinateModifierY(Position.west, CoordinateY-2);
      setConstructionPointNorth(Position.west, true);
      setConstructionPointWest(Position.west, true);
      setConstructionPointSouth(Position.west, true);
      
      return Position;
      
   }//End Method GenerateBlock_South_TBlock
   
   private static Node GenerateBlock_West_TBlock(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
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
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+3), Position);
      SpacialCoordinateModifierX(Position.north, CoordinateX-2);
      SpacialCoordinateModifierY(Position.north, CoordinateY+1);
      setConstructionPointNorth(Position.north, true);
      setConstructionPointEast(Position.north, true);
      setConstructionPointWest(Position.north, true);
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+4), Position);
      SpacialCoordinateModifierX(Position.south, CoordinateX-2);
      SpacialCoordinateModifierY(Position.south, CoordinateY-1);
      setConstructionPointEast(Position.south, true);
      setConstructionPointWest(Position.south, true);
      setConstructionPointSouth(Position.south, true);
      
      return Position;
      
   }//End Method GenerateBlock_West_TBlock
   
   //************************************************************
   //End TBlock block code.
   //************************************************************
   
   //************************************************************
   //Start specialty block code.
   //************************************************************
   
   private static Node GenerateBlock_MultiConnector_Specialty_NorthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointNorth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveNorth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY+1);
      setConstructionPointNorth(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointEast(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_MultiConnector_Specialty_NorthBuilt
   
   private static Node GenerateBlock_MultiConnector_Specialty_EastBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointEast(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveEast(Position);
      SpacialCoordinateModifierX(Position, CoordinateX+1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      setConstructionPointNorth(Position, true);
      setConstructionPointEast(Position, true);
      setConstructionPointSouth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_MultiConnector_Specialty_EastBuilt
   
   private static Node GenerateBlock_MultiConnector_Specialty_SouthBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointSouth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveSouth(Position);
      SpacialCoordinateModifierX(Position, CoordinateX);
      SpacialCoordinateModifierY(Position, CoordinateY-1);
      setConstructionPointEast(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointSouth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_MultiConnector_Specialty_SouthBuilt
   
   private static Node GenerateBlock_MultiConnector_Specialty_WestBuilt(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointWest(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+1), Position);
      Position = moveWest(Position);
      SpacialCoordinateModifierX(Position, CoordinateX-1);
      SpacialCoordinateModifierY(Position, CoordinateY);
      setConstructionPointNorth(Position, true);
      setConstructionPointWest(Position, true);
      setConstructionPointSouth(Position, true);
      
      return Position;
      
   }//End Method GenerateBlock_MultiConnector_Specialty_WestBuilt
   
   private static Node GenerateBlock_EastWest_Split(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointWest(C, false);
      setConstructionPointEast(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+1), Position);
      SpacialCoordinateModifierX(Position.west, CoordinateX-1);
      SpacialCoordinateModifierY(Position.west, CoordinateY);
      
      AttachPoint.addWesternCorridor(setRoomData(RoomNumber+2), Position.west);
      SpacialCoordinateModifierX(Position.west.west, CoordinateX-2);
      SpacialCoordinateModifierY(Position.west.west, CoordinateY);
      setConstructionPointNorth(Position.west.west, true);
      setConstructionPointSouth(Position.west.west, true);
      setConstructionPointWest(Position.west.west, true);
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+3), Position);
      SpacialCoordinateModifierX(Position.east, CoordinateX+1);
      SpacialCoordinateModifierY(Position.east, CoordinateY);
      
      AttachPoint.addEasternCorridor(setRoomData(RoomNumber+4), Position.east);
      SpacialCoordinateModifierX(Position.east.east, CoordinateX+2);
      SpacialCoordinateModifierY(Position.east.east, CoordinateY);
      setConstructionPointNorth(Position.east.east, true);
      setConstructionPointEast(Position.east.east, true);
      setConstructionPointSouth(Position.east.east, true);
      
      return Position;
      
   }//End Method GenerateBlock_EastWest_Split
   
   private static Node GenerateBlock_NorthSouth_Split(Node C, int RoomNumber, int CoordinateX, int CoordinateY) {
      setConstructionPointNorth(C, false);
      setConstructionPointSouth(C, false);
      Maze AttachPoint = new Maze();
      
      AttachPoint.entrance = C;      
      Node Position = AttachPoint.entrance;
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+1), Position);
      SpacialCoordinateModifierX(Position.north, CoordinateX);
      SpacialCoordinateModifierY(Position.north, CoordinateY+1);
      
      AttachPoint.addNorthernCorridor(setRoomData(RoomNumber+2), Position.north);
      SpacialCoordinateModifierX(Position.north.north, CoordinateX);
      SpacialCoordinateModifierY(Position.north.north, CoordinateY+2);
      setConstructionPointNorth(Position.north.north, true);
      setConstructionPointEast(Position.north.north, true);
      setConstructionPointWest(Position.north.north, true);
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+3), Position);
      SpacialCoordinateModifierX(Position.south, CoordinateX);
      SpacialCoordinateModifierY(Position.south, CoordinateY-1);
      
      AttachPoint.addSouthernCorridor(setRoomData(RoomNumber+4), Position.south);
      SpacialCoordinateModifierX(Position.south.south, CoordinateX);
      SpacialCoordinateModifierY(Position.south.south, CoordinateY-2);
      setConstructionPointSouth(Position.south.south, true);
      setConstructionPointEast(Position.south.south, true);
      setConstructionPointWest(Position.south.south, true);
      
      return Position;
      
   }//End Method GenerateBlock_NorthSouth_Split
   
   //************************************************************
   //End specialty block code.
   //************************************************************
   
   //*************************************************************
   //This block of code represents maze generation blocks end.
   //*************************************************************
   
   public static void DisplayRoom(Node C, Character Player) throws InterruptedException {
      //*****************************************
      //Call code for displaying room description
      //*****************************************
      
      getRoomEvent(C).EventInterpreter(getRoomEventNumber(getRoomEvent(C)), Player, C);
      
      System.out.println("");
      System.out.println("What will you do?");
      
      if(C.north != null) {
         if(C.direction == 1)  
            System.out.printf("\n(1)You can go straight, ");
         if(C.direction == 2)
            System.out.printf("\n(4)You can go left, ");
         if(C.direction == 3)
            System.out.printf("\n(3)You can go back, ");
         if(C.direction == 4)
            System.out.printf("\n(2)You can go right, ");
      }
         
      if(C.east != null) {
         if(C.direction == 1)
            System.out.printf("(2)you can go right, ");
         if(C.direction == 2)
            System.out.printf("(1)you can go straight, ");
         if(C.direction == 3)
            System.out.printf("(4)you can go left, ");
         if(C.direction == 4)
            System.out.printf("(3)you can go back, ");
      }
      
      if(C.south != null) {
         if(C.direction == 1)
            System.out.printf("(3)you can go back, ");
         if(C.direction == 2)
            System.out.printf("(2)you can go right, ");
         if(C.direction == 3)
            System.out.printf("(1)you can go straight, ");
         if(C.direction == 4)
            System.out.printf("(4)you can go left, ");
      }

      if(C.west != null) {
         if(C.direction == 1)
            System.out.printf("(4)you can go left,");
         if(C.direction == 2)
            System.out.printf("(3)you can go back, ");
         if(C.direction == 3)
            System.out.printf("(2)you can go right, ");
         if(C.direction == 4)
            System.out.printf("(1)you can go straight, ");
      }
      
      if(getRoomEvent(C).getEventOn() == true) {
        System.out.printf("(5)turn back?");
      }
         
   }//End method DisplayRoom
   
   public static void BackupDisplayRoom(Node C, Character Player) throws InterruptedException {
      System.out.println();
      System.out.println("What will you do?");
      
      if(C.north != null) {
         if(C.direction == 1)  
            System.out.printf("\n(1)You can go straight, ");
         if(C.direction == 2)
            System.out.printf("\n(4)You can go left, ");
         if(C.direction == 3)
            System.out.printf("\n(3)You can go back, ");
         if(C.direction == 4)
            System.out.printf("\n(2)You can go right, ");
      }
         
      if(C.east != null) {
         if(C.direction == 1)
            System.out.printf("(2)you can go right, ");
         if(C.direction == 2)
            System.out.printf("(1)you can go straight, ");
         if(C.direction == 3)
            System.out.printf("(4)you can go left, ");
         if(C.direction == 4)
            System.out.printf("(3)you can go back, ");
      }
      
      if(C.south != null) {
         if(C.direction == 1)
            System.out.printf("(3)you can go back, ");
         if(C.direction == 2)
            System.out.printf("(2)you can go right, ");
         if(C.direction == 3)
            System.out.printf("(1)you can go straight, ");
         if(C.direction == 4)
            System.out.printf("(4)you can go left, ");
      }

      if(C.west != null) {
         if(C.direction == 1)
            System.out.printf("(4)you can go left,");
         if(C.direction == 2)
            System.out.printf("(3)you can go back, ");
         if(C.direction == 3)
            System.out.printf("(2)you can go right, ");
         if(C.direction == 4)
            System.out.printf("(1)you can go straight, ");
      }
      
      if(getRoomEvent(C).getEventOn() == true) {
        System.out.printf("(5)turn back?");
      }
         
   }//End method BackupDisplayRoom

   
   public static void CheckRoom(Node C, Character Player) throws InterruptedException {
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
      
      getRoomEvent(C).EventInterpreter(getRoomEventNumber(getRoomEvent(C)), Player, C);
         
      System.out.println();
      System.out.println("The room number is: " + C.roomData[0]);
         
   }//End method CheckRoom
   
   public static void ParadoxAvoidance_1Block(Maze M, Node C, Node ParadoxOne) {
      int x = getRoomNumber(C);
      if(x != getRoomNumber(ParadoxOne)) { 
         if(isEqual(C, ParadoxOne) == true) {
            //System.out.println("PARADOX ONE COLLISON IN ROOM: " + x + " WITH ROOM: " + getRoomNumber(ParadoxOne));
            setParadox(M.MazeVariables, true);
         }
      }
      if(C.north != null) 
         if(getRoomNumber(C.north) > x)
            ParadoxAvoidance_1Block(M, C.north, ParadoxOne);
      if(C.east != null)
         if(getRoomNumber(C.east) > x)
            ParadoxAvoidance_1Block(M, C.east, ParadoxOne);
      if(C.south != null) 
         if(getRoomNumber(C.south) > x) 
            ParadoxAvoidance_1Block(M, C.south, ParadoxOne);
      if(C.west != null)
         if(getRoomNumber(C.west) > x)
            ParadoxAvoidance_1Block(M, C.west, ParadoxOne);
   }//End Method ParadoxAvoidance_1Block
   
   public static void ParadoxAvoidance_3Block(Maze M, Node C, Node ParadoxOne, Node ParadoxTwo, Node ParadoxThree) {
      int x = getRoomNumber(C);
      if(x != getRoomNumber(ParadoxOne) && x != getRoomNumber(ParadoxTwo) && x != getRoomNumber(ParadoxThree)) { 
         if(isEqual(C, ParadoxOne) == true) {
            //System.out.println("PARADOX ONE COLLISON IN ROOM: " + x + " WITH ROOM: " + getRoomNumber(ParadoxOne));
            setParadox(M.MazeVariables, true);
         }
         if(isEqual(C, ParadoxTwo) == true) {
            //System.out.println("PARADOX TWO COLLISON IN ROOM: " + x + " WITH ROOM: " + getRoomNumber(ParadoxOne));
            setParadox(M.MazeVariables, true);
         }
         if(isEqual(C, ParadoxThree) == true) {
            //System.out.println("PARADOX THREE COLLISON IN ROOM: " + x + " WITH ROOM: " + getRoomNumber(ParadoxThree));
            setParadox(M.MazeVariables, true);
         }
      }
      if(C.north != null) 
         if(getRoomNumber(C.north) > x)
            ParadoxAvoidance_3Block(M, C.north, ParadoxOne, ParadoxTwo, ParadoxThree);
      if(C.east != null)
         if(getRoomNumber(C.east) > x)
            ParadoxAvoidance_3Block(M, C.east, ParadoxOne, ParadoxTwo, ParadoxThree);
      if(C.south != null) 
         if(getRoomNumber(C.south) > x) 
            ParadoxAvoidance_3Block(M, C.south, ParadoxOne, ParadoxTwo, ParadoxThree);
      if(C.west != null)
         if(getRoomNumber(C.west) > x)
            ParadoxAvoidance_3Block(M, C.west, ParadoxOne, ParadoxTwo, ParadoxThree);
   }//End Method ParadoxAvoidance_3Block

   public static void ParadoxAvoidance_4Block(Maze M, Node C, Node ParadoxOne, Node ParadoxTwo, Node ParadoxThree, Node ParadoxFour) {
      int x = getRoomNumber(C);
      if(x != getRoomNumber(ParadoxOne) && x != getRoomNumber(ParadoxTwo) && x != getRoomNumber(ParadoxThree) && x != getRoomNumber(ParadoxFour)) { 
         if(isEqual(C, ParadoxOne) == true) {
            //System.out.println("PARADOX ONE COLLISON IN ROOM: " + x + " WITH ROOM: " + getRoomNumber(ParadoxOne));
            setParadox(M.MazeVariables, true);
         }
         if(isEqual(C, ParadoxTwo) == true) {
            //System.out.println("PARADOX TWO COLLISON IN ROOM: " + x + " WITH ROOM: " + getRoomNumber(ParadoxOne));
            setParadox(M.MazeVariables, true);
         }
         if(isEqual(C, ParadoxThree) == true) {
            //System.out.println("PARADOX THREE COLLISON IN ROOM: " + x + " WITH ROOM: " + getRoomNumber(ParadoxThree));
            setParadox(M.MazeVariables, true);
         }
         if(isEqual(C, ParadoxFour) == true) {
            //System.out.println("PARADOX ONE COLLISON IN ROOM: " + x + " WITH ROOM: " + getRoomNumber(ParadoxOne));
            setParadox(M.MazeVariables, true);
         }
      }
      if(C.north != null) 
         if(getRoomNumber(C.north) > x)
            ParadoxAvoidance_4Block(M, C.north, ParadoxOne, ParadoxTwo, ParadoxThree, ParadoxFour);
      if(C.east != null)
         if(getRoomNumber(C.east) > x)
            ParadoxAvoidance_4Block(M, C.east, ParadoxOne, ParadoxTwo, ParadoxThree, ParadoxFour);
      if(C.south != null) 
         if(getRoomNumber(C.south) > x) 
            ParadoxAvoidance_4Block(M, C.south, ParadoxOne, ParadoxTwo, ParadoxThree, ParadoxFour);
      if(C.west != null)
         if(getRoomNumber(C.west) > x)
            ParadoxAvoidance_4Block(M, C.west, ParadoxOne, ParadoxTwo, ParadoxThree, ParadoxFour);
   }//End Method ParadoxAvoidance_4Block
   
   public void TraverseMaze(Node C, Character Player) throws InterruptedException {
      if(getRoomNumber(C) == getRoomNumber(this.exit)) {
         System.out.println("You have reached the end!");
         //return;
      }
      DisplayRoom(C, Player);
      System.out.println();
      
      Scanner Scan = new Scanner(System.in);
      int choice = Scan.nextInt();
      if(C.direction == 1) {
         if(choice == 1) {
            if(C.north == null) {
               BackupTraverseMaze(C, Player);
               return;
            }
            C.north.direction = 1;
            TraverseMaze(C.north, Player);
         }
         if(choice == 2) {
            if(C.east == null) {
               BackupTraverseMaze(C, Player);
               return;
            }
            C.east.direction = 2;
            TraverseMaze(C.east, Player);
         }
         if(choice == 3) {
            if(C.south == null) {
               BackupTraverseMaze(C, Player);
               return;
            }
            C.south.direction = 3;
            TraverseMaze(C.south, Player);
         }
         if(choice == 4) {
            if(C.west == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.west.direction = 4;
            TraverseMaze(C.west, Player);
         }
      }  
      
      if(C.direction == 2) {
         if(choice == 1){
            if(C.east == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.east.direction = 2;
            TraverseMaze(C.east, Player);
         }
         if(choice == 2) {
            if(C.south == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.south.direction = 3;
            TraverseMaze(C.south, Player);
         }
         if(choice == 3) {
            if(C.west == null) {
               BackupTraverseMaze(C, Player);
               return;
            }
            C.west.direction = 4;
            TraverseMaze(C.west, Player);
         }
         if(choice == 4) {
            if(C.north == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.north.direction = 1;
            TraverseMaze(C.north, Player);
         }
      }  
      
      if(C.direction == 3) {
         if(choice == 1) {
            if(C.south == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.south.direction = 3;
            TraverseMaze(C.south, Player);
         }
         if(choice == 2) {
            if(C.west == null) {
               BackupTraverseMaze(C, Player);
               return;
            }
            C.west.direction = 4;
            TraverseMaze(C.west, Player);
         }
         if(choice == 3) {
            if(C.north == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.north.direction = 1;
            TraverseMaze(C.north, Player);
         }
         if(choice == 4) {
            if(C.east == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.east.direction = 2;
            TraverseMaze(C.east, Player);
         }
      }  
      
      if(C.direction == 4) {
         if(choice == 1) {
            if(C.west == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.west.direction = 4;
            TraverseMaze(C.west, Player);
         }
         if(choice == 2) {
            if(C.north == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.north.direction = 1;
            TraverseMaze(C.north, Player);
         }
         if(choice == 3) {
            if(C.east == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.east.direction = 2;
            TraverseMaze(C.east, Player);
         }
         if(choice == 4) {
            if(C.south == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.south.direction = 3;
            TraverseMaze(C.south, Player);
         }
      }
      if(choice == 5) {
         TraverseMaze(C, Player);
      }         
      if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
         BackupTraverseMaze(C, Player);
      }
   }//End method TraverseMaze
   
   public void BackupTraverseMaze(Node C, Character Player) throws InterruptedException {
      BackupDisplayRoom(C, Player);
      System.out.println();
      
      Scanner Scan = new Scanner(System.in);
      int choice = Scan.nextInt();
      if(C.direction == 1) {
         if(choice == 1) {
            if(C.north == null) {
               BackupTraverseMaze(C, Player);
               return;
            }
            C.north.direction = 1;
            TraverseMaze(C.north, Player);
         }
         if(choice == 2) {
            if(C.east == null) {
               BackupTraverseMaze(C, Player);
               return;
            }
            C.east.direction = 2;
            TraverseMaze(C.east, Player);
         }
         if(choice == 3) {
            if(C.south == null) {
               BackupTraverseMaze(C, Player);
               return;
            }
            C.south.direction = 3;
            TraverseMaze(C.south, Player);
         }
         if(choice == 4) {
            if(C.west == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.west.direction = 4;
            TraverseMaze(C.west, Player);
         }
      }  
      
      if(C.direction == 2) {
         if(choice == 1){
            if(C.east == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.east.direction = 2;
            TraverseMaze(C.east, Player);
         }
         if(choice == 2) {
            if(C.south == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.south.direction = 3;
            TraverseMaze(C.south, Player);
         }
         if(choice == 3) {
            if(C.west == null) {
               BackupTraverseMaze(C, Player);
               return;
            }
            C.west.direction = 4;
            TraverseMaze(C.west, Player);
         }
         if(choice == 4) {
            if(C.north == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.north.direction = 1;
            TraverseMaze(C.north, Player);
         }
      }  
      
      if(C.direction == 3) {
         if(choice == 1) {
            if(C.south == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.south.direction = 3;
            TraverseMaze(C.south, Player);
         }
         if(choice == 2) {
            if(C.west == null) {
               BackupTraverseMaze(C, Player);
               return;
            }
            C.west.direction = 4;
            TraverseMaze(C.west, Player);
         }
         if(choice == 3) {
            if(C.north == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.north.direction = 1;
            TraverseMaze(C.north, Player);
         }
         if(choice == 4) {
            if(C.east == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.east.direction = 2;
            TraverseMaze(C.east, Player);
         }
      }  
      
      if(C.direction == 4) {
         if(choice == 1) {
            if(C.west == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.west.direction = 4;
            TraverseMaze(C.west, Player);
         }
         if(choice == 2) {
            if(C.north == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.north.direction = 1;
            TraverseMaze(C.north, Player);
         }
         if(choice == 3) {
            if(C.east == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.east.direction = 2;
            TraverseMaze(C.east, Player);
         }
         if(choice == 4) {
            if(C.south == null) { 
               BackupTraverseMaze(C, Player);
               return;
            }
            C.south.direction = 3;
            TraverseMaze(C.south, Player);
         }
      }
      if(choice == 5) {
         TraverseMaze(C, Player);
      }         
      if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
         BackupTraverseMaze(C, Player);
      }
   }//End method BackupTraverseMaze
   
   public static void mazeDiagnostics(Node C, Maze M) {
      int x = getRoomNumber(C);
      //System.out.println("Event Number: " + getRoomEventNumber(getRoomEvent(C)) + " Is in room: " + x);
      if(isExit(C, M) == true) {
         System.out.println("Exit is in room number: " + getRoomNumber(C));
      }
      if(C.north != null) {
         if(getRoomNumber(C.north) > x) {
            System.out.println("Go North to room number: " + getRoomNumber(C.north));
            mazeDiagnostics(C.north, M);
         }
      }
      
      if(C.east != null) {
         if(getRoomNumber(C.east) > x) {
            System.out.println("Go East to room number: " + getRoomNumber(C.east));
            mazeDiagnostics(C.east, M);
         }
      }
      
      if(C.south != null) {
         if(getRoomNumber(C.south) > x) {
            System.out.println("Go South to room number: " + getRoomNumber(C.south));
            mazeDiagnostics(C.south, M);
         }
      }
      
      if(C.west != null) {
         if(getRoomNumber(C.west) > x) {
            System.out.println("Go West to room number: " + getRoomNumber(C.west));
            mazeDiagnostics(C.west, M);
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
   
   public static Maze Clone(Maze Target) {
      Maze M;
      M = new Maze();
      M.addEntrance(setRoomData(0));
      CloneMaze(getStart(Target), getStart(M), M);
      return M;
   }
   
   public static void CloneMaze(Node CloneTarget, Node Clone, Maze CloneMaze) {
      Clone.roomData = setRoomData(getRoomNumber(CloneTarget));
      Clone.X_Axis = getSpacialCoordinateX(CloneTarget);
      Clone.Y_Axis = getSpacialCoordinateY(CloneTarget);
      Clone.ConstructNorth = getConstructionPointNorth(CloneTarget);
      Clone.ConstructEast = getConstructionPointNorth(CloneTarget);
      Clone.ConstructSouth = getConstructionPointNorth(CloneTarget);
      Clone.ConstructWest = getConstructionPointNorth(CloneTarget);
      Clone.direction = getDirection(CloneTarget);
      
      if(CloneTarget.north != null) {
         if(getRoomNumber(CloneTarget) < getRoomNumber(CloneTarget.north)) { 
            CloneMaze.addNorthernCorridor(setRoomData(getRoomNumber(CloneTarget.north)), Clone);
            CloneMaze(CloneTarget.north, Clone.north, CloneMaze);
         }
      }//End North check
      
      if(CloneTarget.east != null) {
         if(getRoomNumber(CloneTarget) < getRoomNumber(CloneTarget.east)) {   
            CloneMaze.addEasternCorridor(setRoomData(getRoomNumber(CloneTarget.east)), Clone);
            CloneMaze(CloneTarget.east, Clone.east, CloneMaze);
         }
      }//End east check
      
      if(CloneTarget.south != null) {
         if(getRoomNumber(CloneTarget) < getRoomNumber(CloneTarget.south)) {
            CloneMaze.addSouthernCorridor(setRoomData(getRoomNumber(CloneTarget.south)), Clone);
            CloneMaze(CloneTarget.south, Clone.south, CloneMaze);
         }
      }//End South check
      
      if(CloneTarget.west != null) {
         if(getRoomNumber(CloneTarget) < getRoomNumber(CloneTarget.west)) {
            CloneMaze.addWesternCorridor(setRoomData(getRoomNumber(CloneTarget.west)), Clone);
            CloneMaze(CloneTarget.west, Clone.west, CloneMaze);
         }
      }//End west check
   }//End Method CloneMaze
   
   public static void FillMaze(Node Start, Maze M) {
      int RandomEvent;
      int addEvent;
      RandomEvent = (int)(Math.random() * (6-1) + 1);
      //RandomEvent = 1;
      addEvent = (int)(Math.random() * (4-1) + 1);
      if(addEvent == 1) {
         if(getRoomNumber(Start) != 0) {   
            if(EventExists(M, RandomEvent) != true) {
               AssignEventNumber(getRoomEvent(Start), RandomEvent);
               AddRoomEvent(RandomEvent, getEventTrackerArray(M));
               getRoomEvent(Start).setEventOn(true);
            }
         }   
      } 
      if(Start.north != null) {
         if(getRoomNumber(Start) < getRoomNumber(Start.north)) { 
            FillMaze(Start.north, M);
         }
      }//End North check
      
      if(Start.east != null) {
         if(getRoomNumber(Start) < getRoomNumber(Start.east)) {   
            FillMaze(Start.east, M);
         }
      }//End east check
      
      if(Start.south != null) {
         if(getRoomNumber(Start) < getRoomNumber(Start.south)) {
            FillMaze(Start.south, M);
         }
      }//End South check
      
      if(Start.west != null) {
         if(getRoomNumber(Start) < getRoomNumber(Start.west)) {
            FillMaze(Start.west, M);
         }
      }//End west check
   }//End Method FillMaze
   
   public static boolean EventExists(Maze M, int Enumber) {
      for(int i = 0; i < getEventTrackerArray(M).length; i++) {
         if(Enumber == getEventTrackerArray(M)[i])
            return true;
      }
      return false;
   }//End Method EventExists
   
   public static void AddRoomEvent(int Enumber, int[] InnitEvents) {
      for(int i = 0; i < InnitEvents.length; i++) {
         if(InnitEvents[i] == 0)
            InnitEvents[i] = Enumber;
      }
   }//End Method AddRoomEvent
   
   public void setMazeExit(Node C, int current, int target) {
      Node Position;
      Position = C;
      int x;
      x = getRoomNumber(C);
      
      if(C.north != null) {
         if(x < getRoomNumber(C.north)) {
            this.setMazeExit(C.north, current+1, target);
         }
      }
      
      if(C.east != null) {
         if(x < getRoomNumber(C.east)) {
            this.setMazeExit(C.east, current+1, target);
         }
      }
      
      if(C.south != null) {
         if(x < getRoomNumber(C.south)) {
            this.setMazeExit(C.south, current+1, target);
         }
      }
      
      if(C.west != null) {
         if(x < getRoomNumber(C.west)) {
            this.setMazeExit(C.west, current+1, target);
         }
      }
      
      if(current >= target) {
         this.exit = C;
         return;
      }
   }//End Method setMazeExit
   
}//End class Maze