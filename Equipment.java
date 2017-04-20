//Equipment.java
//Written by: TBAD
//Equipment item constructors & methods, extends from Item Class

public class Equipment extends Item{
   //INstance Variables
   public int healthMod;
   public int attackMod;
   public int defenseMod;
   public int luckMod;
   public String attachment;
   public int weaponType; //4-14-2017 Added by Christian Robles to account for the type of weapon.

   //Default Constructor
   public Equipment(){
      this.itemName = "";
      this.size = 1;
      this.coinValue = 5;
      this.healthMod = 0;
      this.attackMod = 0;
      this.defenseMod = 0;
      this.luckMod = 0;
      this.attachment = "z"; //0-H, 1-T, 2-A, 3-L, 4-P(Weapons - Primary), 5-P(Weapons - Secondary), 6-C, 7-R, 8-B, 9-W
      this.description = "";
      this.rarity = 1;
      this.weaponType = 0; //0 = Armor; 1 = Sword; 2 = Great Sword; 3 = Dagger; 4 = Bow & Arrows; 5 = Flail; 6 = Mace;
                           //7 = Spear; 8 = Polearm; 9 = Battle Gloves; 10 = Magic Staff; 11 = Hammer;
   }
   //Specific Value Constructor
   //4-14-2017 Christian Robles added newWeaponType int value to Specific Value Constructor.
   public Equipment(String itemName, int size, int coinValue, int healthMod, int attackMod, int defenseMod, int luckMod, String attachment, String description, int rarity, int newWeaponType){
      this.itemName = itemName;
      this.size = size;
      this.coinValue = coinValue;
      this.healthMod = healthMod;
      this.attackMod = attackMod;
      this.defenseMod = defenseMod;
      this.luckMod = luckMod;
      this.attachment = attachment;
      this.description = description;
      this.rarity = rarity;
      this.weaponType = newWeaponType;
   }

   //Accessors
   
   public String getItemName(){
      return itemName;
   }
   public int getHealthMod(){
      return healthMod;
   }
   public int getAttackMod(){
      return attackMod;
   }
   public int getDefenseMod(){
      return defenseMod;
   } 
   public int getLuckMod(){
      return luckMod;
   }  
   public String getAttachment(){
      return attachment;
   }
   public String getItemUse(){
      return itemUse;
   }
   public boolean getConsumed(){
      return consumed;
   }
   public String getItemDescription(){
      return description;
   }
   
   //4-14-2017 Christian Robles added accessor for weaponType.
   public int getWeaponType() {
      return weaponType;
   }

   //Mutators
   public void setItemName(String newNAME){
      itemName = newNAME;
   }
   
   //4-14-2017 Christian Robles added Mutator for weaponType.
   public void setWeaponType(int newWeaponType) {
      weaponType = newWeaponType;
   }

}//end class
