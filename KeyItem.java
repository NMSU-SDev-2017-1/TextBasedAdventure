//KeyItem.java
//Written by: TBAD
//Key item constructors & methods, extends from Item Class

public class KeyItem extends Item{
   //Constructors
   public KeyItem(){
      this.itemName = "";
 	   this.size = 1;
   }
   public KeyItem(String itemName, int size){
      this.itemName = itemName;
 	   this.size = size;
   }   
}
