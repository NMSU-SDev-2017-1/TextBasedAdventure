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
      System.out.println("Welcome to the Dungeon.");
      System.out.println();
      System.out.println("You find some bread, do you take it?");
      System.out.println("1. Yes");
      System.out.println("2. No");
      int playerResponse = scan.nextInt();
      if(playerResponse == 1){    
         player.inventory[0] = bread;
         System.out.println();
         System.out.println("You added the bread. You now have: ");
         System.out.println(player.getInventoryList());
         System.out.println();
      }
      else
         System.out.println("You chose to leave the bread behind.");
      System.out.println();
      while(player.healthpoints != 0){
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
            while(player.healthpoints !=0){
               System.out.println("What is your next action?");
               System.out.println("1. Attack");
               System.out.println("2. View Inventory");
               System.out.println("3. Check Status");
               System.out.println("4. Run");
               int engagedAction = scan.nextInt();
               
               if(engagedAction == 1){
                  System.out.println("You attack the Skeleton.");
                  testSkeleton.takeDamage(player.getAttack());
                  System.out.println("You deal " + player.getAttack() + " damage.");
                  if(testSkeleton.hp == 0){
                     System.out.println("Your attack destroys the skeleton. It turns to dust, leaving only it's weapon.");
                     Equipment skeletonSword = new Equipment("Skeleton Sword", 1, 10, 0, 2, 0, 0, 'P');
                     System.out.println("Do you take the skeleton sword?");
                     System.out.println("1. Yes");
                     System.out.println("2. No");
                     int swordResponse = scan.nextInt();
                     if(swordResponse == 1){    
                        player.equipment[4] = skeletonSword;
                        System.out.println();
                        System.out.println("You added the Sword. You now have the following items equiped: ");
                        player.getEquipmentList();
                        System.out.println();
                     }
                     else
                        System.out.println("You chose to leave the sword behind.");
                        System.out.println();

                     return;
                  }
                  System.out.println("The Skeleton strikes back.");
                  player.modHP(-(testSkeleton.getAttack()));
                  System.out.println("You take " + testSkeleton.getAttack() + " damage.");
                  System.out.println("Status after combat cycle: ");
                  System.out.println(player.toString());
                  if(player.healthpoints == 0){
                     System.out.println("You've been dealt a fatal blow...");
                     return;
                  }
               }
               else if(engagedAction == 2){
                  System.out.println();
                  System.out.println("Your current inventory:");
                  System.out.println(player.getInventoryList());
                  System.out.println();
                  System.out.println("Will you use an item?");
                  System.out.println("1. Yes");
                  System.out.println("2. No");    
                  int itemOption = scan.nextInt();
                  if(itemOption == 1){
                     int useOption = 1;
                     int i = 0;
                     System.out.println("Which item will you use?");
                     while(player.inventory[i] != null){
                        System.out.println( useOption +". " +player.inventory[i].getItemName());
                        useOption++;
                        i++;
                     }
                     int numberOfItems = useOption;
                     int itemSelection = scan.nextInt();
                     if(itemSelection <= useOption && player.inventory[itemSelection-1] != null){
                        System.out.println("You used " + player.inventory[itemSelection-1].getItemName() + ".");
                        player.modHP(2);
                        player.inventory[itemSelection-1] = null;
                     }
                  }
                  else if(itemOption == 2){
                     System.out.println();
                  }       
               }
               else if(engagedAction == 3){
                  System.out.println(player.toString());
               }
               else if(engagedAction == 4){
                  System.out.println("You attempt to flee but the skeleton cuts you off!");
                  System.out.println("There's no escaping this fight!");
               } 
               
               
            }//end while (Combat)
         }//end playerAction == 1
         else if(playerAction == 2){
            System.out.println();
            System.out.println("Your current inventory:");
            System.out.println(player.getInventoryList());
            System.out.println();
            System.out.println("Will you use an item?");
            System.out.println("1. Yes");
            System.out.println("2. No");    
            int itemOption = scan.nextInt();
            if(itemOption == 1){
               int useOption = 1;
               int i = 0;
               System.out.println("Which item will you use?");
               while(player.inventory[i] != null){
                  System.out.println( useOption +". " +player.inventory[i].getItemName());
                  useOption++;
                  i++;
               }
               int numberOfItems = useOption;
               int itemSelection = scan.nextInt();
               if(itemSelection <= useOption && player.inventory[itemSelection-1] != null){
                  System.out.println("You used " + player.inventory[itemSelection-1].getItemName() + ".");
                  player.modHP(2);
                  player.inventory[itemSelection-1] = null;
               }
            }//
            else if(itemOption == 2){
               System.out.println();
            }    
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
