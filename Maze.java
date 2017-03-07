import java.util.Scanner;

public class Maze {
   private Node entrance;
   private Node exit;
private class Node {
   private int[] roomData;
   private int direction;
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
   }//End Node constructor
   
}//End private class

   public Maze() {
      entrance = null;
      exit = null;
   }
   
   public static Node getStart(Maze M) {
      return M.entrance;
   }//End Method getStart
   
   public static int getDirection(Node C) {
      return C.direction;
   }//End Method getDirection
   
   public static Node getExit(Maze M) {
      return M.exit;
   }//End Method getExit
   
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
   
   //Use this method to change a rooms data.
   //This method is the ONLY WAY ROOM DATA SHOULD BE CHANGED.
   public static int[] setRoomData(int a) {
      final int newRoomData[] = new int[1];
      newRoomData[0] = a;
      return newRoomData;
   }//End method setRoomData
   
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
   
   public static int getRoomNumber(Node C) {
      return C.roomData[0];
   }//End method getRoomNumber
   
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
   }//End Method Interperator
   
   public static Maze GenerateEntrance(int Type) {
      //Direction: North = 1, East = 2, South = 3, West = 4
      Maze MazeStart = new Maze();
      
      MazeStart.addEntrance(setRoomData(0));
      Node Position = MazeStart.entrance;
      
      if(Type == 1) {//If Type == 1, direction entered into the maze is North with 3 corridors leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
         MazeStart.addEasternCorridor(setRoomData(2), Position);
         MazeStart.addWesternCorridor(setRoomData(3), Position);
      }
      
      if(Type == 2) {//If Type == 2, direction entered into the maze is East with 3 corridors leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         MazeStart.addSouthernCorridor(setRoomData(2), Position);
         MazeStart.addNorthernCorridor(setRoomData(3), Position);
      }   
      
      if(Type == 3) {//If Type == 3, direction entered into the maze is South with 3 corridors leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         MazeStart.addWesternCorridor(setRoomData(2), Position);
         MazeStart.addEasternCorridor(setRoomData(3), Position);
      }
      
      if(Type == 4) {//If Type == 4, direction entered into the maze is West with 3 corridors leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         MazeStart.addNorthernCorridor(setRoomData(2), Position);
         MazeStart.addSouthernCorridor(setRoomData(3), Position);
      }
      
      if(Type == 5) {//If Type == 5, direction entered into the maze is North with East and West corridors leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         MazeStart.addWesternCorridor(setRoomData(2), Position);
      }
      
      if(Type == 6) {//If Type == 6, direction entered into the maze is North with East and North corridors leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
         MazeStart.addEasternCorridor(setRoomData(2), Position);
      }  
      
      if(Type == 7) {//If Type == 7, direction entered into the maze is North with North and West corridors leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
         MazeStart.addWesternCorridor(setRoomData(2), Position);
      }
      
      if(Type == 8) {//If Type == 8, direction entered into the maze is East with East and South corridors leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         MazeStart.addSouthernCorridor(setRoomData(2), Position);
      }
      
      if(Type == 9) {//If Type == 9, direction entered into the maze is East with East and North corridors leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
         MazeStart.addNorthernCorridor(setRoomData(2), Position);
      }    
      
      if(Type == 10) {//If Type == 10, direction entered into the maze is East with South and North corridors leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         MazeStart.addNorthernCorridor(setRoomData(2), Position);
      }  
      
      if(Type == 11) {//If Type == 11, direction entered into the maze is South with South and West corridors leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         MazeStart.addWesternCorridor(setRoomData(2), Position);
      }
      
      if(Type == 12) {//If Type == 12, direction entered into the maze is South with South and East corridors leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
         MazeStart.addEasternCorridor(setRoomData(2), Position);
      }
      
      if(Type == 13) {//If Type == 13, direction entered into the maze is South with West and East corridors leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         MazeStart.addEasternCorridor(setRoomData(2), Position);
      }
      
      if(Type == 14) {//If Type == 14, direction entered into the maze is West with West and North corridors leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         MazeStart.addNorthernCorridor(setRoomData(2), Position);
      }
      
      if(Type == 15) {//If Type == 15, direction entered into the maze is West with West and South corridors leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
         MazeStart.addSouthernCorridor(setRoomData(2), Position);
      }
      
      if(Type == 16) {//If Type == 16, direction entered into the maze is West with North and South corridors leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
         MazeStart.addSouthernCorridor(setRoomData(2), Position);
      }
      
      if(Type == 17) {//If Type == 17, direction entered into the maze is North with a Northern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
      }
      
      if(Type == 18) {//If Type == 18, direction entered into the maze is North with an Eastern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
      }
      
      if(Type == 19) {//If Type == 19, direction entered into the maze is North with a Western corridor leading deeper into the maze.
         MazeStart.entrance.direction = 1;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
      }
      
      if(Type == 20) {//If Type == 20, direction entered into the maze is East with an Eastern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
      }
      
      if(Type == 21) {//If Type == 21, direction entered into the maze is East with a Southern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
      }
      
      if(Type == 22) {//If Type == 22, direction entered into the maze is East with a Northern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 2;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
      }
      
      if(Type == 23) {//If Type == 23, direction entered into the maze is South with a Southern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
      }
      
      if(Type == 24) {//If Type == 24, direction entered into the maze is South with a Western corridor leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
      }
      
      if(Type == 25) {//If Type == 25, direction entered into the maze is South with an Eastern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 3;
         MazeStart.addEasternCorridor(setRoomData(1), Position);
      }
      
      if(Type == 26) {//If Type == 26, direction entered into the maze is West with a Western corridor leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addWesternCorridor(setRoomData(1), Position);
      }
      
      if(Type == 27) {//If Type == 27, direction entered into the maze is West with a Northern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addNorthernCorridor(setRoomData(1), Position);
      }
      
      if(Type == 28) {//If Type == 28, direction entered into the maze is West with a Southern corridor leading deeper into the maze.
         MazeStart.entrance.direction = 4;
         MazeStart.addSouthernCorridor(setRoomData(1), Position);
      }
      
      return MazeStart;
      
   }//End Method GenerateEntrance
   
   public static Maze GenerateRandomMaze() {
      Maze RandomMaze = new Maze();
      
      RandomMaze = GenerateEntrance((int)(Math.random() * (29-1) + 1));
      RandomMaze.addEntrance(setRoomData(0));    
      
      Node Position = RandomMaze.entrance;
      
      
      
      return RandomMaze;
   }//End Method GenerateRandomMaze
   
   public static Maze StartToFinish(int range) {
      
      Maze Beeline = new Maze();
      
      Beeline = GenerateEntrance((int)(Math.random() * (29 - 1) + 1));
      Beeline.addEntrance(setRoomData(0));
      
      Node Position = Beeline.entrance;
      
      boolean wentNorth, wentEast, wentSouth, wentWest;
      wentNorth = wentEast = wentSouth = wentWest = false; 
      
      int a, b, c, d;
      a = b = c = d = 0;
      
      if(Position.north != null)//a = north
         a = getRoomNumber(Position.north);
      if(Position.east != null)//b = east
         b = getRoomNumber(Position.east);
      if(Position.south != null)//c = south
         c = getRoomNumber(Position.south);
      if(Position.west != null)//d = west
         d = getRoomNumber(Position.west);
      
      int rN = 0;
      if(a > b) {
         if(a > c) {
            if(a > d) {//a is the highest room number
               Position = moveNorth(Position);
               wentNorth = true;
               rN = a;
            }//End if a>d
            else {//d is the highest room number
               Position = moveWest(Position);
               wentWest = true;
               rN = d;
            }//End else
         }//End if a>c
         else {
            if(c > d) {//c is the highest room number
               Position = moveSouth(Position);
               wentSouth = true;
               rN = c;
            }//End if c>d
            else {//d is the highest room number
               Position = moveWest(Position);
               wentWest = true;
               rN = d;
            }//End else
         }//End else
      }//End if a>b
      else {
         if(b > c) {
            if(b > d) {//b is the highest room number
               Position = moveEast(Position);
               wentEast = true;
               rN = b;
            }//End if b>d
            else {//d is the highest room number
               Position = moveWest(Position);
               wentWest = true;
               rN = d;
            }//End else
         }//End if b>c
         else {
            if(c > d) {//c is the highest room number
               Position = moveSouth(Position);
               wentWest = true;
               rN = c;
            }//End if c>d
            else {//d is the highest room number
               Position = moveWest(Position);
               wentWest = true;
               rN = d;
            }//End else
         }//End else
      }//End else
      
      int stop = 0;
      int tracker = 0;      
      boolean wentRight, wentLeft, twiceRight, twiceLeft; 
      wentRight = wentLeft = twiceRight = twiceLeft = false;
      
      
      while(stop < range) {
         if(wentNorth == true) {//If you are starting facing North
            int room = (int)(Math.random() * (range - (range/2)) + (range/2));
            int path = 0;
            while(tracker < room) {
               path = (int)(Math.random() * (4 - 1) + 1);//1 = north, 2 = east, 3 = west.
               if(path == 1) {//path is north facing
                  rN++;
                  Beeline.addNorthernCorridor(setRoomData(rN), Position);
                  moveNorth(Position);
                  wentNorth = true;
                  wentEast = false;
                  wentSouth = false;
                  wentWest = false;
                  tracker++;
                  break;
               }
               if(path == 2) {//path is east facing
                  if(wentRight == true)
                     twiceRight = true;
                  if(twiceRight == true) {
                     twiceRight = false;
                     continue;   
                  }//End double right error
                  wentRight = true;
                  rN++;
                  Beeline.addEasternCorridor(setRoomData(rN), Position);
                  moveEast(Position);
                  wentEast = true;
                  wentNorth = false;
                  wentSouth = false;
                  wentWest = false;
                  tracker++;
                  break;
               }
               if(path == 3) {//path is west facing
                  if(wentLeft == true)
                     twiceLeft = true;
                  if(twiceLeft == true) {
                     twiceLeft = false;
                     continue;   
                  }//End double right error
                  wentLeft = true;
                  rN++;
                  Beeline.addWesternCorridor(setRoomData(rN), Position);
                  moveWest(Position);
                  wentEast = false;
                  wentNorth = false;
                  wentSouth = false;
                  wentWest = true;
                  tracker++;
                  break;
               }
            }//End while: beeline generator north
         }//End wentNorth check
         
         if(wentEast == true) {//If you are starting facing East
         
         }//End wentEast check
         
         if(wentSouth == true) {//If you are starting facing South
         
         }//End wentSouth check
         
         if(wentWest == true) {//If you are starting facing West
         
         }//End wentWest check
      }//End while loop
      
      return Beeline;
   }//End Method StartToFinish
   
}//End class Maze