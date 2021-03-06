import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
import java.util.List;

//Character.java
//Written by: TBAD
//Contains class to create Player object

//Generate Character Object
public class Character{
   //Instance Variables
   public String playerID;
   public int baseAttack;
   public int baseDefense;
   public int baseLuck;
   public int baseHealthpoints;
   public int maxHP;

   public int attack;
   public int defense;
   public int luck;
   public int healthpoints;
   public int coins;
   public int killScore;

   public Item inventory[];
   public Item equipment[];
   
   //Inherited Constructor
   public Character(){
      this.playerID = "";

      this.baseAttack = 10;
      this.baseDefense = 10;
      this.baseLuck = 10;
      this.baseHealthpoints = 15;
      this.maxHP = 15;

      this.attack = 10;
      this.defense = 10;
      this.luck = 10;
      this.healthpoints = 15;
      this.inventory = new Item[10];
      this.equipment = new Item[10];
      this.coins = 0;
      this.killScore = 0;
   }

   
   //Default Constructor
   public Character(String playerID){
      this.playerID = playerID;

      this.baseAttack = 5;
      this.baseDefense = 10;
      this.baseLuck = 5;
      this.baseHealthpoints = 10;
      this.maxHP = 10;

      this.attack = 5;
      this.defense = 10;
      this.luck = 5;
      this.healthpoints = 10;
      this.inventory = new Item[10];
      this.equipment = new Item[10];
      this.coins = 0;
      this.killScore = 0;
   }
   //Specific Value Constructor
   public Character(String playerID, int attack, int defense, int luck, int healthpoints, int inventorySize){
      this.playerID = playerID;

      this.baseAttack = attack;
      this.baseDefense = defense;
      this.baseLuck = luck;
      this.baseHealthpoints = healthpoints;
      this.maxHP = healthpoints;

      this.attack = attack;
      this.defense = defense;
      this.luck = luck;
      this.healthpoints = healthpoints;
      this.inventory = new Item[inventorySize];
      this.equipment = new Item[10];
      this.coins = 0;
      this.killScore = 0;
   }

   //Accessors
   
   //Edited by Christian Robles
   //Used to retrieve the inventory array
   public Item[] getInventory() {
      return inventory;
   }
   
   public Item[] getEquipment() {
	   return equipment;
   }
   
   public String getPlayerID(){
	   return playerID;
   }
   public int getHealth(){
      return healthpoints;
   }
   public int getAttack(){
      return attack;
   }
   public int getDefense(){
      return defense;
   }
   public int getLuck(){
      return luck;
   }
   public int getInventorySize(){
      return inventory.length;
   }
   public int getCoins(){
      return coins;
   } 
   
   //Produces list of current player inventory
   public String getInventoryList(){
      int i = 0;
      String list = "";
      while(inventory[i] != null){
         if(i == 0)
            list = inventory[i].getItemName();
         else if(i == inventory.length-1)
            list = list + inventory[i].getItemName();
         else 
            list = list + ", " + inventory[i].getItemName();
         i++;
      }
      return list;
   }

   //Produces list of avaiable and filled player equipment slots
   public void getEquipmentList(){
      String empty = "Empty Slot";
      System.out.println();
      for(int i = 0; i < equipment.length; i++){
         if(i == 0){
            if(equipment[i] == null)
               System.out.println("Head - " + empty);
            else
               System.out.println("Head - " + equipment[i].getItemName());
         }
         if(i == 1){
            if(equipment[i] == null)
               System.out.println("Torso - " + empty);
            else
               System.out.println("Torso - " + equipment[i].getItemName());
         }
         if(i == 2){
            if(equipment[i] == null)
               System.out.println("Arms - " + empty);
            else
               System.out.println("Arms - " + equipment[i].getItemName());
         }     
         if(i == 3){
            if(equipment[i] == null)
               System.out.println("Legs - " + empty);
            else
               System.out.println("Legs - " + equipment[i].getItemName());
         }
         if(i == 4){
            if(equipment[i] == null)
               System.out.println("Primary Weapon - " + empty);
            else
               System.out.println("Primary Weapon - " + equipment[i].getItemName());
         }
         if(i == 5){
            if(equipment[i] == null)
               System.out.println("Secondary Weapon - " + empty);
            else
               System.out.println("Secondary Weapon - " + equipment[i].getItemName());
         }
         if(i == 6){
            if(equipment[i] == null)
               System.out.println("Charm #1 - " + empty);
            else
               System.out.println("Charm #1 - " + equipment[i].getItemName());
         }
         if(i == 7){
            if(equipment[i] == null)
               System.out.println("Charm #2 - " + empty);
            else
               System.out.println("Charm #2 - " + equipment[i].getItemName());
         }
         if(i == 8){
            if(equipment[i] == null)
               System.out.println("Bag - " + "Beginner's Bag");
            else
               System.out.println("Bag - " + equipment[i].getItemName());
         }
         if(i == 9){
            if(equipment[i] == null)
               System.out.println("Wallet");
            else
               System.out.println("Wallet");
         }
      }
   System.out.println();
   }


   //Mutators
   public void setID(String newID){
      playerID = newID;
   }
   public void setAtk(int newATK){
      attack = newATK;
      if(attack < 0)
         attack = 0;
   }
   public void setDef(int newDEF){
      defense = newDEF;
      if(defense < 0)
         defense = 0;
   }
   public void setLuck(int newLUCK){
      luck = newLUCK;
      if(luck < 0)
         luck = 0;
   }
   
   public void setMaxHP(int newMaxHP){
      maxHP = newMaxHP;
   }

   //Player stat modifiers
   public void modHP(int newHP){
      if(healthpoints + newHP > maxHP)
         healthpoints = maxHP;
      else   
         healthpoints = healthpoints + newHP;
   }
   public void modMaxHP(int newMaxHP){
	   maxHP = maxHP + newMaxHP;
   }
   public void modATK(int newATK){
	   attack = attack + newATK;
   }
   public void modDEF(int newDEF){
	   defense = defense + newDEF;
   }
   public void modLUCK(int newLUCK){
	   luck = luck + newLUCK;
   }
   public void modCoins(int newCOINS){
      coins = coins + newCOINS;
   }
   
   //Modifies inventory size based off of equipped bag object
   public void modInventorySize(int newSIZE){
	   Item newInventory[] = new Item[newSIZE];
	   for(int i = 0;i < inventory.length; i++){
		   newInventory[i] = inventory[i];
	   }
	   inventory = newInventory;
   }

   //Modifies player stats based on equipment
   public void equipmentMod(){
      attack = baseAttack;
      defense = baseDefense;
      luck = baseLuck;
      maxHP = baseHealthpoints;
      int fullHP = 0;

      if(healthpoints >= maxHP){
         healthpoints = maxHP;
         fullHP = 1;
      }
   
      //Check Head Equip
      if(equipment[0] == null)
         ;
      else{
         modMaxHP(equipment[0].getHealthMod());
         modATK(equipment[0].getAttackMod());
         modDEF(equipment[0].getDefenseMod());
         modLUCK(equipment[0].getLuckMod());
      }//end else
      
      //Check Torso Equip
      if(equipment[1] == null)
         ;
      else{
         modMaxHP(equipment[1].getHealthMod());
         modATK(equipment[1].getAttackMod());
         modDEF(equipment[1].getDefenseMod());
         modLUCK(equipment[1].getLuckMod());
      }//end else
      
      //Check Arms Equip
      if(equipment[2] == null)
         ;
      else{
         modMaxHP(equipment[2].getHealthMod());
         modATK(equipment[2].getAttackMod());
         modDEF(equipment[2].getDefenseMod());
         modLUCK(equipment[2].getLuckMod());
      }//end else
      
      //Check Legs Equip
      if(equipment[3] == null)
         ;
      else{
         modMaxHP(equipment[3].getHealthMod());
         modATK(equipment[3].getAttackMod());
         modDEF(equipment[3].getDefenseMod());
         modLUCK(equipment[3].getLuckMod());
      }//end else
      
      //Check Primary Weapon Equip
      if(equipment[4] == null)
         ;
      else{
         modMaxHP(equipment[4].getHealthMod());
         modATK(equipment[4].getAttackMod());
         modDEF(equipment[4].getDefenseMod());
         modLUCK(equipment[4].getLuckMod());
      }//end else
      
      //Check Charm 1 Equip
      if(equipment[6] == null)
         ;
      else{
         modMaxHP(equipment[6].getHealthMod());
         modATK(equipment[6].getAttackMod());
         modDEF(equipment[6].getDefenseMod());
         modLUCK(equipment[6].getLuckMod());
      }//end else
      
      //Check Charm 2 Equip
      if(equipment[7] == null)
         ;
      else{
         modMaxHP(equipment[7].getHealthMod());
         modATK(equipment[7].getAttackMod());
         modDEF(equipment[7].getDefenseMod());
         modLUCK(equipment[7].getLuckMod());
      }//end else

      if(fullHP == 1)
         healthpoints = maxHP;

   }//end equipmentMod

   //adds item to player inventory
   public void addInventoryItem(Item newItem){
      int i = 1;
      while(inventory[i] != null){
         i++;
      }
      if(i >= inventory.length)
         System.out.println("You cannot hold any more items.");
      else{
         inventory[i] = newItem;
         System.out.println("You added " + newItem.getItemName() + " to your inventory.");
      }
   }//end addInventoryItem
   
   //Method for player to access and use items within their inventory
   public void useInventory(){
      Scanner scan = new Scanner(System.in);
      System.out.println();
      System.out.println(getInventoryList());
      System.out.println();
      System.out.println("Do you want to examine an item?");
      System.out.println("1. Yes");
      System.out.println("2. No");    
      int itemOption = scan.nextInt();
      if(itemOption == 1){
         int useOption = 1;
         int i = 0;
	 System.out.println();
         System.out.println("Which item do you wish to examine?");
         while(inventory[i] != null){
            System.out.println( useOption +". " + inventory[i].getItemName());
            useOption++;
            i++;
         }
         int numberOfItems = useOption;
         int itemSelection = scan.nextInt();
         if(itemSelection <= useOption && inventory[itemSelection-1] != null){
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("1. Check");
            System.out.println("2. Use");
            System.out.println("3. Exit");
            int itemAction = scan.nextInt();
            if(itemAction == 1){
               System.out.println(inventory[itemSelection-1].getItemDescription());
               useInventory();
            }
            else if(itemAction == 2){
               if(inventory[itemSelection-1].getAttachment() == "X")
                  useItem(inventory[itemSelection-1], itemSelection-1);
               else
                  equipItem(inventory[itemSelection-1], itemSelection-1);
            }//end else if itemAction == 2
            else if(itemAction == 3)
               useInventory();
            else
               System.out.println("That is not a correct input.");
         }//end if
      
      }//end itemOption == 1 if
      else if(itemOption == 2){
         System.out.println();
      } 
      else
         System.out.println("That is not a correct input."); 
      updateInventory(inventory);
   }

   //Modifies player based off of item's values
   public void useItem(Item selectedItem, int index){
      modHP(selectedItem.getHealthMod());
      modATK(selectedItem.getAttackMod());
      modDEF(selectedItem.getDefenseMod());
      modLUCK(selectedItem.getLuckMod());
      System.out.println("You used: " + inventory[index].getItemName() + ".");
      if(selectedItem.getAttachment() == "X")
         inventory[index] = null;
   }//end useItem
   
   //Equips a selected item to the player in the correct index of the equipment array
   public void equipItem(Item selectedItem, int index){
      Scanner scan = new Scanner(System.in);
      if(selectedItem.getAttachment() == "H"){
         if(equipment[0] != null){
            addInventoryItem(equipment[0]);
            equipment[0] = selectedItem;
            inventory[index] = null;
            System.out.println("You equipped " + selectedItem.getItemName() + " to your head.");
         }
         else{
            equipment[0] = selectedItem;
            inventory[index] = null;
            System.out.println("You equipped " + selectedItem.getItemName() + " to your head.");
         }
      }
      else if(selectedItem.getAttachment() == "T"){
         equipment[1] = selectedItem;
         inventory[index] = null;
         System.out.println("You equipped " + selectedItem.getItemName() + " to your torso.");
      }
      else if(selectedItem.getAttachment() == "A"){
         equipment[2] = selectedItem;
         inventory[index] = null;
         System.out.println("You equipped " + selectedItem.getItemName() + " to your arms.");
      }
      else if(selectedItem.getAttachment() == "L"){
         equipment[3] = selectedItem;
         inventory[index] = null;
         System.out.println("You equipped " + selectedItem.getItemName() + " to your legs.");
      }
      
      else if(selectedItem.getAttachment() == "P"){
         System.out.println("Where would you like to equip this item?");
         System.out.println("1. Primary");
         System.out.println("2. Secondary");
         int weaponChoice = scan.nextInt();
         if(weaponChoice == 1){
            if(equipment[4] != null){
               addInventoryItem(equipment[4]);
               equipment[4] = selectedItem;
               inventory[index] = null;
               System.out.println("You equipped " + selectedItem.getItemName() + " as your Primary Weapon.");
            }
            else{
               equipment[4] = selectedItem;
               inventory[index] = null;
               System.out.println("You equipped " + selectedItem.getItemName() + " as your Primary Weapon.");
            }
         }//end if weaponChoice == 1
         else if(weaponChoice == 2){
            if(equipment[4] == null){
               System.out.println("You currently do not have a Primary Weapon attached. The " + selectedItem.getItemName() + " will be set to your Primary Weapon slot.");
               equipment[4] = selectedItem;
               inventory[index] = null;
            }
            else if(equipment[5] != null){
               addInventoryItem(equipment[5]);
               equipment[5] = selectedItem;
               inventory[index] = null;
               System.out.println("You equipped " + selectedItem.getItemName() + " as your Secondary Weapon.");
            }
            else{
               equipment[5] = selectedItem;
               inventory[index] = null;
               System.out.println("You equipped " + selectedItem.getItemName() + " as your Secondary Weapon.");
            }
         }//end if weapon choice == 2
         else
            System.out.println("That is not a correct input.");
      }  
      else if(selectedItem.getAttachment() == "C"){
         equipment[6] = selectedItem;
         inventory[index] = null;
         System.out.println("You equipped " + selectedItem.getItemName() + " as your first charm .");
      }
      else if(selectedItem.getAttachment() == "R"){
         equipment[7] = selectedItem;
         inventory[index] = null;
         System.out.println("You equipped " + selectedItem.getItemName() + " as your second charm.");
      }
      else if(selectedItem.getAttachment() == "B"){
         equipment[8] = selectedItem;
         inventory[index] = null;
         System.out.println("You equipped " + selectedItem.getItemName() + " as your new bag.");
      }
      //Removed Wallet item - Wallet will not have upgradable limit
      else
         System.out.println("This item cannot be equipped.");
      updateInventory(inventory);
   }//end equipItem

   //Updates the player's inventory, removes used items
   public void updateInventory(Item inventory[]){
      List<Item> temp = new ArrayList<Item>();
      Item newIn[] = new Item[10];
      for(int j = 0; j < inventory.length; j++){
         if(inventory[j] != null)
            temp.add(inventory[j]);            
         else{}
      }
      newIn = temp.toArray(newIn);
      for(int k = 0; k <inventory.length; k++){
         inventory[k] = newIn[k];
      }
   }//end updateInventory
   
   //Allows player to switch their primary and secondary weapon - Used primarily with combat class
   public void weaponSwitch(){
      if(equipment[4] == null || equipment[5] == null){
         System.out.println("You cannot switch at this time.");
         return;
      }
      Item secondaryToPrimary = new Item();
      secondaryToPrimary = equipment[4];
      equipment[4] =  equipment[5];
      equipment[5] = secondaryToPrimary;
   }//end weaponSwitch      

   //Display Character Status Method
   public String status(){
       String statLine = "HP: " + healthpoints +"/" + maxHP + ", Attack: " + attack + ", Defense: " + defense + ", Luck: " + luck + ", Coin: " + coins + ", Inventory Size: " + inventory.length;
       String information = "Player: " + playerID + ", " + statLine;
       return information;
   }//end status

}//end class
