public class LootTable
{
	private int[] dropRate;
	private Item[] loot;
	private int cursor = 0;
	private int size;
	
	public LootTable(int x)
	{
		dropRate = new int[x];
		loot = new Item[x];
		size = x;
	}

	public int getSize()
	{
		return size;
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
		if(cursor == size)
		{
			int[] tempDropRate = new int[dropRate.length + 1];
			Item[] tempLoot = new Item[loot.length + 1];
			for(int i = 0; i < loot.length; i++)
			{
				tempDropRate[i] = dropRate[i];
				tempLoot[i] = loot[i];
			}
			dropRate = tempDropRate;
			loot = tempLoot;
		}
		loot[cursor] = x;
		dropRate[cursor] = y;
		cursor++;
	}

	public void remove(int x)
	{
		int counter = 0;
		int[] tempDropRate = new int[dropRate.length - 1];
		Item[] tempLoot = new Item[loot.length - 1];
		for(int i = 0; i < loot.length; i++)
		{
			if(i != x)
			{
				tempDropRate[counter] = dropRate[i];
				tempLoot[counter] = loot[i];
				counter++;
			}
		}
		size--;
		dropRate = tempDropRate;
		loot = tempLoot;
	}
}
