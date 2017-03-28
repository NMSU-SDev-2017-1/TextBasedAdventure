import java.util.Arrays;

public class Item{
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



    //Test for Consume



}//end class
