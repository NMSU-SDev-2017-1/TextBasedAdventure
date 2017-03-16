//Character.java
//Written for: TBAD
//Contains class to create Player object

//Generate Character Object
public class Character{
   public String playerID;
   protected int attack;
   protected int defense;
   protected int luck;
   protected int healthpoints;
   protected Item inventory[];
   protected Item equipment[];
   //Constructor
   public Character(String playerID){
      this.playerID = playerID;
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
   public String getEquipmentList(){
      int i = 0;
      String list = "";
      while(equipment[i] != null){
         if(i == 0)
            list = equipment[i].getItemName();
         else if(i == equipment.length-1)
            list = list + equipment[i].getItemName();
         else 
            list = list + ", " + equipment[i].getItemName();
         i++;
      }
      return list;
   }
   //Mutators
   public void setID(String newID){
	   playerID = newID;
   }
   public void modHP(int newHP){
	   healthpoints = healthpoints + newHP;
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
   //toString Method
   public String toString(){
	   String statLine = "HP: " + healthpoints + ", Attack: " + attack + ", Defense: " + defense + ", Luck: " + luck + ", Inventory Size: " + inventory.length;
       String information = "Player: " + playerID + ", " + statLine;
	   return information;
   }
}//end character