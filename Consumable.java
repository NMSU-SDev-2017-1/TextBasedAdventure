//Consumable.java
//Written by: TBAD
//Consumable item constructors, extend from Item Class

public class Consumable extends Item{
   
   //Default Constructor
   public Consumable(){
      this.itemName = "";
      this.size = 1;
      this.coinValue = 5;
      this.healthMod = 0;
      this.attackMod = 0;
      this.defenseMod = 0;
      this.luckMod = 0;
      this.consumed = false;
      this.description = "";
      this.attachment = "X";
      this.itemUse = "consume";
      this.rarity = 1;
   }
   //Specific Value Constructor
   public Consumable(String itemName, int size, int coinValue, int healthMod, int attackMod, int defenseMod, int luckMod, String description, int rarity){
      this.itemName = itemName;
      this.size = size;
      this.coinValue = coinValue;
      this.healthMod = healthMod;
      this.attackMod = attackMod;
      this.defenseMod = defenseMod;
      this.luckMod = luckMod;
      this.consumed = false;
      this.description = description;
      this.attachment = "X";
      this.itemUse = "consume";
      this.rarity = rarity;
   }      
}//end class
