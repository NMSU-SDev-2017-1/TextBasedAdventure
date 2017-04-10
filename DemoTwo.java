import java.util.Scanner;

public class DemoTwo extends Maze {
   public static void main (String args[]) throws InterruptedException {
      
      Character Player = new Character();
      Maze Dungeon = new Maze();
      
      Player = GameSystem.Prologue();
      Dungeon = CreateMaze();
      
      GameSystem.StartGame();
      
      Dungeon.TraverseMaze(getStart(Dungeon), Player);
      
   }//End main
}//End class