public class TestBasicMaze extends Maze {
   public static void main (String args[]) throws InterruptedException {
   
   Maze Test = new Maze();
   
   Character Player = new Character();
   
   Test = CreateMaze();
     
   mazeDiagnostics(Maze.getStart(Test), Test);
   
   Test.TraverseMaze(getStart(Test), Player);

   }//End main
}//End class