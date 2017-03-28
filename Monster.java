public class Monster
{
	private String name;
   	//hp changed to public by Greg De La Torre for Demo 1
	public int hp;
   	//Variable was originally private
	private int attack;
   	//Adding inventory to monsters for post-combat drops - Greg
    public Item inventory[];

	
	//Constructor
	public Monster(String name, int hp, int attack)
	{
		this.name = name;
		this.hp = hp;
		this.attack = attack;
      this.inventory = new Item[3];

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
	
        //Added for post-death - Greg
	public int getInventoryNum(){
               int i = 0;
               while(inventory[i] != null){
                  i++;
               }
               return i + 1;
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
		if(inventory[0] == null && inventory[1] != null){
			inventory[0] = inventory[1];
			inventory[1] = null;
		}
		if(inventory[1] == null && inventory[2] != null){
			inventory[1] = inventory[2];
			inventory[2] = null;
		}
        }
   
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
}
