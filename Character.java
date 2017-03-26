//Character.java
//Written for: TBAD
//Contains class to create Player object

//Generate Character Object
public class Character{
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


   public Item inventory[];
   public Item equipment[];
   //Constructor
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
   }
   //Accessors
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
   public void getEquipmentList(){
      String empty = "Empty Slot";
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
               System.out.println("Wallet - " + "Beginner's Wallet");
            else
               System.out.println("Head - " + equipment[i].getItemName());
         }
      }
   }
   //Mutators
   public void setID(String newID){
	   playerID = newID;
   }
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


   public void setAtk(int newATK){
	   attack = newATK;
   }
   public void setDef(int newDEF){
	   defense = newDEF;
   }
   public void setLuck(int newLUCK){
	   luck = newLUCK;
   }


   public void modInventorySize(int newSIZE){
	   Item newInventory[] = new Item[newSIZE];
	   for(int i = 0;i < inventory.length; i++){
		   newInventory[i] = inventory[i];
	   }
	   inventory = newInventory;
   }




   public void equipmentMod(){
      attack = baseAttack;
      defense = baseDefense;
      luck = baseLuck;
      maxHP = baseHealthpoints;

      if(healthpoints > maxHP)
         healthpoints = maxHP;

      for(int i = 0; i < equipment.length; i++){
         if(equipment[i] == null)
            ;
         else{
            modMaxHP(equipment[i].getHealthMod());
            modATK(equipment[i].getAttackMod());
            modDEF(equipment[i].getDefenseMod());
            modLUCK(equipment[i].getLuckMod());
         }
      }
   }








   //toString Method
   public String toString(){
       String statLine = "HP: " + healthpoints +"/" + maxHP + ", Attack: " + attack + ", Defense: " + defense + ", Luck: " + luck + ", Inventory Size: " + inventory.length;
       String information = "Player: " + playerID + ", " + statLine;
       return information;
   }
}//end character
