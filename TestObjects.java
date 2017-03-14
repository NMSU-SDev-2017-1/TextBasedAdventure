import java.util.Scanner;

public class TestObjects {
	public static void main(String[] args) {
	   Scanner scan = new Scanner(System.in);
      Consumable bread = new Consumable("Bread", 1, 5, 2,0,0,0);
      System.out.println("Please enter your username:");
      String name = scan.nextLine();
      Character player = new Character(name);
      System.out.println(player.toString());
      System.out.println();
      System.out.println("You find some bread, do you take it?");
      String playerResponse = scan.nextLine();
      if(playerResponse.equals("y")){    
         player.inventory[0] = bread;
         System.out.println("You added the bread. You now have: ");
         System.out.println(player.getInventoryList());
      }
      System.out.println("Do you eat the bread?");
      String playerResponse2 = scan.nextLine();
      if(playerResponse.equals("y")){ 
         player.modHP(bread.getHealthMod());
         System.out.println("You ate the bread. Your health is now at: " + player.getHealth());
         bread.consumed = true;
         if(bread.consumed == true){
            player.inventory[0] = null;
            System.out.println("You now have: ");
            System.out.println(player.getInventoryList());
         }
      }
   }//end main
}//end class
