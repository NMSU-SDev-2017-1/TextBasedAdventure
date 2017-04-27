import java.util.Scanner;
import java.util.Random;

//TestObjects.java
//Written by: TBAD
//Class implements and tests game objects
//Demo 2 - 4/11/17

public class TestObjects {
	public static void main(String[] args) throws InterruptedException {
	   Scanner scan = new Scanner(System.in);
           Consumable bread = new Consumable("Bread", 1, 5, 2,0,0,0, "Regular Ol' Bread. The choice meal of every Navy Seal.", 2);
           System.out.println("Please enter your username:");
           String name = scan.nextLine();
           Character player = new Character(name);
           System.out.println(player.status());
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
                 System.out.println("You continue through the dungeon...");
                 Skeleton testSkeleton = new Skeleton();
                 Minotaur testMinotaur = new Minotaur();
                 Goblin testGoblin = new Goblin();
                 Random rand = new Random(System.currentTimeMillis());
                 int randomInt = rand.nextInt(10 - 1) + 1;
	             if(randomInt <= 5){
                    System.out.println("A SKELETON APPEARS!");
                    testSkeleton.print();
                    Combat.standardCombat(testSkeleton, player);
                 }
                 else if(randomInt >8 && randomInt <=10){
                    System.out.println("A MIGHTY MINOTAUR APPEARS!");
                    testMinotaur.print();
                    Combat.standardCombat(testMinotaur, player);
                 }
                 else{
                    System.out.println("A GOBLIN APPEARS!");
                    testGoblin.print();
                    Combat.standardCombat(testGoblin, player);
                 }
              }//end playerAction == 1
              else if(playerAction == 2){
                 player.useInventory();       
              }
              else if(playerAction == 3){
                 System.out.print("You currently have the following items equipped:");
                 player.getEquipmentList();
              }
              else if(playerAction == 4){
                 System.out.println(player.status());
              } 
              else
                 System.out.println("That is not a correct input.");
           }//end action while 
           System.out.println("GAME OVER...or is it?");
        }//end main
}//end class
