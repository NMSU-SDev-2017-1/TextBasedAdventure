import java.util.Arrays;

//Item.java
//Written by: TBAD
//Item object class, extends to child-item type classes. Defines item characteristics.
//Class is abstract

public class Item extends Character{
   //Instance Variables
   public String itemName;
   public int size;
   public int coinValue;
   public int healthMod;
   public int attackMod;
   public int defenseMod;
   public int luckMod;
   public boolean consumed;
   public String attachment;
   public String description;
   public String itemUse;
   public int rarity;

   //Default Constructor ---- SHOULD NEVER BE USED
   public Item(){
      this.itemName = "";
      this.size = 0;
      this.coinValue = 0;
      this.consumed = false;
   }

   //General Accessors
   public String getItemName(){
      return itemName;
   }
   public int getSize(){
	   return size;
   }
   public int getCoinValue(){
      return coinValue;
   }
   public int getRarity(){
      return rarity;
   }
   //Consumable Accessors
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
   public String getItemDescription(){
      return description;
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

   //General Mutators
   public void setItemName(String newNAME){
	   itemName = newNAME;
   }
   public void setSize(int newSIZE){
	   size = newSIZE;
   }
   public void setCoinValue(int newCOINVALUE){
      coinValue = newCOINVALUE;
   }
   public void setConsumed(){
      consumed = true;
   }

}//end class
