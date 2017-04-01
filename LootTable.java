public class LootTable
{
	private int[] dropRate;
	private Item[] loot;
	private int cursor = 0;
	
	public LootTable(int x)
	{
		dropRate = new int[x];
		loot = new Item[x];
	}
	
	public Item getItem(int x)
	{
		return loot[x];
	}
	
	public int getDropRate(int x)
	{
		return dropRate[x];
	}
	
	public Item[] getAllItems()
	{
		return loot;
	}
	
	public int[] getAllDropRates()
	{
		return dropRate;
	}
	
	public void add(Item x, int y)
	{
		loot[cursor] = x;
		dropRate[cursor] = y;
		cursor++;
	}
}