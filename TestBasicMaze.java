public class TestBasicMaze {
   public static void main (String args[]) {
   
   //Maze.TestVarious();
   
   Maze basic = new Maze();
   
   //Maze clone = new Maze();
   
   //clone.addEntrance(Maze.setRoomData(0));
   basic = Maze.GenerateBasicMaze();
   
   //clone = Maze.Clone(basic);
   //clone.addNorthernCorridor(Maze.setRoomData(39), Maze.getStart(clone));
   //Maze.mazeDiagnostics(Maze.getStart(basic));
   
   //Maze.mazeDiagnostics(Maze.getStart(clone));
   
   //Maze.TrackMaxRoom(Maze.getStart(basic), basic);
   
   //System.out.println(Maze.getMaxMazeRoom(Maze.getMazeVar(basic)));
   //System.out.println(Maze.TrackHighRoom(Maze.getStart(basic)));
   
   //System.out.println("1 = straight, 2 = right, 3 = back, 4 = left.");
   
   //basic.TraverseMaze(Maze.getStart(basic));
   

   
   Maze Test = new Maze();
   
   Test = Maze.RandomMazeGeneration();//Maze.CreateMaze();
   
   Maze.mazeDiagnostics(Maze.getStart(Test));
   
   }//End main
}//End class