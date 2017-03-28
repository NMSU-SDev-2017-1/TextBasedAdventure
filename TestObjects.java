import java.util.Scanner;

public class TestObjects {
	public static void main(String[] args) {
	   Scanner scan = new Scanner(System.in);
      Consumable bread = new Consumable("Bread", 1, 5, 2,0,0,0, "Regular Ol' Bread. The choice meal of every Navy Seal.");
      System.out.println("Please enter your username:");
      String name = scan.nextLine();
      Character player = new Character(name);
      System.out.println(player.toString());
      System.out.println();
      System.out.println("Welcome to the Dungeon.");
      System.out.println();
      System.out.println("You find some bread, do you take it?");
      System.out.println("1. Yes");
      System.out.println("2. No");
      int playerResponse = scan.nextInt();
      if(playerResponse == 1){    
         player.addInventoryItem(bread);
      }
      else
         System.out.println("You chose to leave the bread behind.");
      System.out.println();
      while(player.healthpoints > 0){
         player.equipmentMod();
         System.out.println("What is your next action?");
         System.out.println("1. Move");
         System.out.println("2. View Inventory");
         System.out.println("3. View Equipment");
         System.out.println("4. Check Status");
         int playerAction = scan.nextInt();
         if(playerAction == 1){
            System.out.println("You continue through the dungeon...A SKELETON APPEARS!");
            Skeleton testSkeleton = new Skeleton();
		      testSkeleton.printSkeleton();
            System.out.println(testSkeleton.inventory[0].getAttachment());
            System.out.println(bread.getAttachment());
            Combat.advantageCombat(testSkeleton, player);
         }//end playerAction == 1
         else if(playerAction == 2){
            player.useInventory();
         }
         else if(playerAction == 3){
            System.out.print("You currently have the following items equipped:");
            player.getEquipmentList();
         }
         else if(playerAction == 4){
            System.out.println(player.toString());
         } 
      }//end action while 
      System.out.println("GAME OVER...or is it?");
   }//end main
}//end class
