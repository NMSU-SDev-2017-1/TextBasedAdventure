public class Monster
{
	private String name;
   //hp changed to public by Greg De La Torre for Demo 1
	public int hp;
   //Variable was originally private
	private int attack;
	
	//Constructor
	public Monster(String name, int hp, int attack)
	{
		this.name = name;
		this.hp = hp;
		this.attack = attack;
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
	
	//Mutators
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setHp(int hp)
	{
		this.hp = hp;
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