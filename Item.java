public class Item{
   protected String itemName;
   protected int size;
   protected int coinValue;
   //Default Constructor ---- SHOULD NEVER BE USED
   public Item(){
      this.itemName = "";
	   this.size = 0;
      this.coinValue = 0;
   }
   //Accessors
   public String getItemName(){
      return itemName;
   }
   public int getSize(){
	   return size;
   }
   public int getCoinValue(){
      return coinValue;
   }
   //Mutators
   public void setItemName(String newNAME){
	   itemName = newNAME;
   }
   public void setSize(int newSIZE){
	   size = newSIZE;
   }
   public void setCoinValue(int newCOINVALUE){
      coinValue = newCOINVALUE;
   }
}//end class
