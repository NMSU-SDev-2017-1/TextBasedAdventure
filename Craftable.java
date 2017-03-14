public class Craftable extends Item{
   public String compatableWith;
   //Constructors
   public Craftable(){
      this.itemName = "":
      this.size = 1;
      this.coinValue = 1;
      this.compatableWith = "";
   }
   public Craftable(String itemName, int size, int coinValue, String compatableWith){
      this.itemName = itemName;
      this.size = size;
      this.coinValue = coinValue;
      this.compatableWith = compatableWith;
   }  
   //Accessors
   //Mutators
}