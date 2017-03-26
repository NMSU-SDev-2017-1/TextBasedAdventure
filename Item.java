public class Item{
   protected String itemName;
   protected int size;
   protected int coinValue;
   public int healthMod;
   public int attackMod;
   public int defenseMod;
   public int luckMod;
   public boolean consumed;
   //Default Constructor ---- SHOULD NEVER BE USED
   public Item(){
      this.itemName = "";
	   this.size = 0;
      this.coinValue = 0;
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




    //Test for Consume



}//end class
