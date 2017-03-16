public class TestBasicMaze {
   public static void main (String args[]) {
   
   Maze basic = new Maze();
   
   basic = Maze.GenerateBasicMaze();
   
   System.out.println(Maze.ArrayRoom(Maze.TrackHighRoom(Maze.getStart(basic), 0, 0)));
   
   //System.out.println("1 = straight, 2 = right, 3 = back, 4 = left.");
   
   //basic.TraverseMaze(Maze.getStart(basic));
   
   //Maze.mazeDiagnostics(Maze.getStart(basic));
   
   Maze RandomTest = new Maze();
   
   //RandomTest = Maze.MazeCreation(5);
   
   //RandomTest = Maze.TMM(3);
   
   //Maze.mazeDiagnostics(Maze.getStart(RandomTest));
  
   }//End main
}//End class