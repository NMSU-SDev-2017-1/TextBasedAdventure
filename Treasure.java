public class Treasure extends Item {

   public Treasure() {
      itemName = "";
      size = 1;
      coinValue = 500;
   }//End Constructor
   
   public Treasure(String newName, int newSize, int newCoinValue) {
      itemName = newName;
      size = newSize;
      coinValue = newCoinValue;
   }//End Overloaded Constructor
   
}//End Class