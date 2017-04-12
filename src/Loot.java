//Loot.java
//Written by: TBAD
//Loot item constructors & methods, extends from Item Class

public class Loot extends Item{
   //Constructors
   public Loot(){
      this.itemName = "";
      this.size = 1;
      this.coinValue = 1;
   }
   public Loot(String itemName, int size, int coinValue){
      this.itemName = itemName;
      this.size = size;
      this.coinValue = coinValue;
   }   
   //Accessors inherited from Item Master Class
   //Mutators inherited from Item Master Class
}
