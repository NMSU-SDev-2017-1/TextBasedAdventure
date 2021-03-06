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
   
   public static KeyItem IronKey() {
      KeyItem ironKey = new KeyItem("Iron Key", 1);
      return ironKey;
   }
   
   public static boolean hasKeyItem(String keyItemName, Character Player) {
      Item PI[] = Player.getInventory();
      String keyItemString;
      keyItemString = "";
      for(int i = 0; i < PI.length; i++) {
         if(PI[i] != null)
            keyItemString = PI[i].getItemName();
         if(keyItemName.equals(keyItemString) == true) 
            return true;
      }//End loop
      return false;   
   }   
}
