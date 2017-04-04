import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Monster
{
	private String name;
   	//hp changed to public by Greg De La Torre for Demo 1
	public int hp;
   	//Variable was originally private
	private int attack;
   	//Adding inventory to monsters for post-combat drops - Greg
   public Item inventory[];
   //Added loot table so monsters can drop variable loot.
   public LootTable possibleLoot;
      //Adding coins for player reward post-death
   public int coinDropValue;
   //Eventually the random inventory size will be different for all monsters, but it is
   //currently hardcoded as proof of concept. As it is currently implemented, there is
   //a 10% chance of inventory size 1, 70% for 2, 10% for 3, 7% for 4, 3% for 5
   int[] inventoryWeights = {10, 70, 10, 7, 3};
	public int randomInventorySize = RandomNumberGeneration.getRandomWeighted(1, 5, inventoryWeights);
	
	//Constructor
	public Monster(String name, int hp, int attack, int coinDropValue )
	{
		this.name = name;
		this.hp = hp;
		this.attack = attack;
      this.inventory = new Item[randomInventorySize];
      this.coinDropValue = coinDropValue;

	}
	
	//Accessors
	public String getName()
	{
		return name;
	}
	
	public int getHp()
	{
		return hp;
	}
	
	public int getAttack()
	{
		return attack;
	}
   public int getCoinDropValue(){
      return coinDropValue;
   }
	
        //Added for post-death - Greg
	public int getInventoryNum(){
      return inventory.length + 1;
   }

	//Mutators
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setHp(int hp)
	{
		this.hp = hp;
	}


	//Added w/ inventory & equipment
	public String getInventoryList(){
	      int i = 0;
	      String list = "";
	      while(inventory[i] != null){
		 if(i == 0)
		    list = inventory[i].getItemName();
		 else if(i == inventory.length-1)
		    list = list + inventory[i].getItemName();
		 else 
		    list = list + ", " + inventory[i].getItemName();
		 i++;
	      }
	      return list;
	}

	//Method for displaying inventory for pickup by player upon death
	public void deathItems(){
		int j = 1;
		for(int i = 0; i < inventory.length; i++){
		   if(inventory[i] == null)
		      System.out.println(j  + ". Empty");
		   else
            System.out.println(j + ". " + inventory[i].getItemName());
		   j++;
		}//end for
		
        }
        //Added for post-death - Greg
	public void updateDeathItems(){
      List<Item> temp = new ArrayList<Item>();
      Item newIn[] = new Item[10];
      for(int j = 0; j < inventory.length; j++){
         if(inventory[j] != null)
            temp.add(inventory[j]);            
         else{}
      }
      newIn = temp.toArray(newIn);
      for(int k = 0; k <inventory.length; k++){
         inventory[k] = newIn[k];
      }
    }//end updateDeathItems
   
	//takeDamage Written in by Greg De La Torre for Combat Demo
   	public void takeDamage(int damage){
                this.hp = hp - damage;
      }
        //End takeDamage mutator
   
   
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	
	public void attack(Character target)
	{
		target.modHP(-1 * attack);
	}
	
	public void createInventory()
	{
		//int[] lootTableDropRates = possibleLoot.getAllDropRates();
		//Item[] lootTableItems = possibleLoot.getAllItems();
		for(int i = 0; i < inventory.length; i++)
		{
			if(i == possibleLoot.getSize())
				return;
			int[] lootTableDropRates = possibleLoot.getAllDropRates();
			Item[] lootTableItems = possibleLoot.getAllItems();
			if(lootTableItems.length == 0)
				return;
			int x = RandomNumberGeneration.getRandomWeighted(0, lootTableItems.length - 1, lootTableDropRates);
			inventory[i] = lootTableItems[x];
			possibleLoot.remove(x);
		}
	}
}
