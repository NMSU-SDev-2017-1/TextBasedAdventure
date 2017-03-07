public class Consumable extends Item{
   public int healthMod;
   public int attackMod;
   public int defenseMod;
   public int luckMod;
   public boolean consumed;
   //Constructors
   public Consumable(){
      this.itemName = "";
 	   this.size = 1;
      this.coinValue = 5;
      this.healthMod = 0;
      this.attackMod = 0;
      this.defenseMod = 0;
      this.luckMod = 0;
      this.consumed = false;
   }
   public Consumable(String itemName, int size, int coinValue, int healthMod, int attackMod, int defenseMod, int luckMod){
      this.itemName = itemName;
 	   this.size = size;
      this.coinValue = coinValue;
      this.healthMod = healthMod;
      this.attackMod = attackMod;
      this.defenseMod = defenseMod;
      this.luckMod = luckMod;
      this.consumed = false;
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
   //Mutators
   public void setItemName(String newNAME){
      itemName = newNAME;
   }
}//end class