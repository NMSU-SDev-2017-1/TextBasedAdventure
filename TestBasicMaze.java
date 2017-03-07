public class TestBasicMaze {
   public static void main (String args[]) {
   
   Maze basic = new Maze();
   
   basic = Maze.GenerateBasicMaze();
   
   System.out.println("1 = straight, 2 = right, 3 = back, 4 = left.");
   
   //basic.TraverseMaze(Maze.getStart(basic));
   
   Maze.mazeDiagnostics(Maze.getStart(basic));
  
   
   
   }//End main
}//End class