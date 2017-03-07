//NOT READY FOR USE
public class TestMaze {
   public static void main (String args[]) {
   
   Maze test = new Maze();
   
   test.addEntrance(0);
   
   test.addNorthernCorridor(1, Maze.getStart(test));
   test.addNorthernCorridor(1, Maze.moveNorth(Maze.getStart(test)));
   
   test.addSouthernCorridor(2, Maze.getStart(test));
   
   test.addEasternCorridor(3, Maze.getStart(test));
   
   test.addWesternCorridor(4, Maze.getStart(test));
   
   //Maze.mazeRunner(Maze.getStart(test));
   
   Maze.roomChecker(1, Maze.moveNorth(Maze.getStart(test)));
   Maze.roomChecker(2, Maze.getStart(test));
   Maze.roomChecker(3, Maze.getStart(test));
   Maze.roomChecker(4, Maze.getStart(test));
   
   System.out.println();
   
   Maze Tutorial = new Maze(); 
   Tutorial = Maze.GenerateBasicMaze();
   Maze.roomChecker(1, Maze.getStart(Tutorial));
   Maze.roomChecker(2, Maze.getStart(Tutorial));
   Maze.roomChecker(3, Maze.getStart(Tutorial));
   Maze.roomChecker(4, Maze.getStart(Tutorial));
   
   Maze.CheckRoom(Maze.getStart(Tutorial));
   
   Maze.TraverseMaze(Maze.getStart(Tutorial));
   
   System.out.println(Maze.getData(Maze.getStart(Tutorial)));
   
   }//End main
}//End class