public class Equipment extends Item{
   public int healthMod;
   public int attackMod;
   public int defenseMod;
   public int luckMod;
   public String attachment;
   //Constructors
   public Equipment(){
      this.itemName = "";
      this.size = 1;
      this.coinValue = 5;
      this.healthMod = 0;
      this.attackMod = 0;
      this.defenseMod = 0;
      this.luckMod = 0;
      this.attachment = "z"; //0-H, 1-T, 2-A, 3-L, 4-P, 5-S, 6-C, 7-R, 8-B, 9-W
      this.description = "";
   }
   public Equipment(String itemName, int size, int coinValue, int healthMod, int attackMod, int defenseMod, int luckMod, String attachment, String description){
      this.itemName = itemName;
      this.size = size;
      this.coinValue = coinValue;
      this.healthMod = healthMod;
      this.attackMod = attackMod;
      this.defenseMod = defenseMod;
      this.luckMod = luckMod;
      this.attachment = attachment;
      this.description = description;
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
   //Mutators
   public void setItemName(String newNAME){
      itemName = newNAME;
   }
}//end class
