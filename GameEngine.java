import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

public class GameEngine extends Event
{
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double gameWidth = screenSize.getWidth();
	double gameHeight = screenSize.getHeight();
	TextBox box;
	JFrame gameFrame;
	CountDownLatch latch = new CountDownLatch(0);
	Font font;
	boolean inCombat = false;
	Maze.Node currentLocation;
	Maze M;
	ButtonPanel buttons;
	ButtonPanel buttons2;
	
	public TextBox getTextBox()
	{
		return box;
	}
	
	public class GraphicsPanel extends JPanel
	{
		public GraphicsPanel()
		{
			setPreferredSize(new Dimension((int)gameWidth, (int)gameHeight * 2 / 3));
			setBackground(Color.white);
			
		}
	}
	
	public class ButtonPanel extends JPanel
	{
		public ButtonPanel()
		{
			setPreferredSize(new Dimension((int)gameWidth / 4 - ((int)gameWidth/200), (int)gameHeight / 3 - ((int)gameHeight / 35)));
			setBackground(Color.black);
		}
	}
	
	public class OptionsPanel extends JPanel
	{
		public OptionsPanel()
		{
			setPreferredSize(new Dimension((int)gameWidth / 4 - ((int)gameWidth/200), (int)gameHeight / 3 - ((int)gameHeight / 35)));
			setBackground(Color.black);
		}
	}
	
	public class TextScroll extends JScrollPane
	{
		public TextScroll()
		{
			setPreferredSize(new Dimension((int)gameWidth / 2, (int)gameHeight / 3 - ((int)gameHeight / 35)));
			setBackground(Color.black);
		}
	}
	
	public class TextBox extends JTextArea
	{
		public TextBox()
		{
			setBackground(Color.black);
			setForeground(Color.white);
			setEditable(false);
			setLineWrap(true);
			setWrapStyleWord(true);
			DefaultCaret caret = (DefaultCaret)getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			//setFont(new Font(Font.SERIF, Font.BOLD, (int)gameWidth / 100));
			setFont(font);
		}
	}
	
	public class Options extends JPanel
	{
		public Options(final String name, final Character player, final JFrame frame)
		{
			setPreferredSize(new Dimension((int)gameWidth / 4 - ((int)gameWidth/200), (int)(gameHeight / 3 - ((int)gameHeight / 35)) / 3));
			setBackground(Color.black);
			setBorder(BorderFactory.createLineBorder(Color.white));
			JLabel nameLabel = new JLabel();
			nameLabel.setText(name);
			font = font.deriveFont(Font.BOLD, (int)gameWidth / 50);
			nameLabel.setFont(font);
			//nameLabel.setFont(new Font(Font.SERIF, Font.BOLD, (int)gameWidth / 50));
			nameLabel.setForeground(Color.white);
			setLayout(new GridBagLayout());
			add(nameLabel);
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e)
				{
					System.out.println(name + " clicked");
					if(name.equals("Stats"))
					{  
                  
						String text = "Name: " + player.getPlayerID() + "\n HP: " + player.getHealth() + "\n Attack: " + player.getAttack() + "\n Defense: " + player.getDefense();                  
                  JOptionPane.showMessageDialog(frame, text, "Stats", JOptionPane.PLAIN_MESSAGE);
					}
					if(name.equals("Inventory"))
					{
						String text = "";
						Item[] inventoryList = player.getInventory();
						for(int i = 0; i < inventoryList.length; i++)
						{
							if(inventoryList[i] != null)
							{
								text += inventoryList[i].getItemName();
								text += "\n";
							}
						}
						text += "Coins: ";
						text += player.getCoins();
						text += "\n";
						text += "Inventory size: ";
						text += player.getInventorySize();
						JOptionPane.showMessageDialog(frame, text, "Inventory", JOptionPane.PLAIN_MESSAGE);
					}
					if(name.equals("Equipment"))
					{
						String text = "";
						Item[] equipList = player.getEquipment();
						String empty = "Empty slot";
						String[] slots = {"Head: ", "Torso: ", "Arms: ", "Legs: ", "Primary Weapon: ", "Secondary Weapon: ", "Charm 1: ", "Charm 2: "};
						for(int i = 0; i < slots.length; i++)
						{
							text += slots[i];
							if(equipList[i] == null)
							{
								text += empty;
								text += "\n";
							}
							else
							{
								text += equipList[i].getItemName();
								text += "\n";
							}
						}
						JOptionPane.showMessageDialog(frame, text, "Equipment", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
         );
		}
	}
   
   public class Choices extends JPanel
	{
		public Choices(final String name, final Character player, final JFrame frame, final Maze.Node C, final Maze M, ButtonPanel BP) 
		{
			setPreferredSize(new Dimension((int)gameWidth / 4 - ((int)gameWidth/200), (int)(gameHeight / 3 - ((int)gameHeight / 35)) / 3));
			setBackground(Color.black);
			setBorder(BorderFactory.createLineBorder(Color.white));
			JLabel nameLabel = new JLabel();
			nameLabel.setText(name);
			font = font.deriveFont(Font.BOLD, (int)gameWidth / 50);
			nameLabel.setFont(font);
			nameLabel.setForeground(Color.white);
			setLayout(new GridBagLayout());
			add(nameLabel);
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out.println(name + " clicked");
					if(name.equals("Examine Room"))
					{  
                  String text;
                  if(Maze.getRoomNumber(C) == Maze.getRoomNumber(M.exit)) {
                     text = "You found the exit!";
                  }
                  else {
                     text = "There is nothing here.";
                  }        
                  JOptionPane.showMessageDialog(frame, text, "Room", JOptionPane.PLAIN_MESSAGE);
					}
					if(name.equals("Go Straight"))
					{
					   TraverseMazeEngine(M, C, player, "Straight", BP);
					   delayedWrite(box, "You went straight.", 70);
               }
					if(name.equals("Go Right"))
					{
						TraverseMazeEngine(M, C, player, "Right", BP);
		                delayedWrite(box, "You went right.", 70);
					}
               if(name.equals("Go Left"))
					{                  
						TraverseMazeEngine(M, C, player, "Left", BP);
						delayedWrite(box, "You went left.", 70);
					}
               if(name.equals("Go Back"))
					{                  
						TraverseMazeEngine(M, C, player, "Back", BP);
						delayedWrite(box, "You went back.", 70);
					}
				}
			}
         );
		}
	}
   
   public class EventOptions extends JPanel
   {
	   public EventOptions(final String name, final Character player, final TextBox box)
	   {
		    setPreferredSize(new Dimension((int)gameWidth / 4 - ((int)gameWidth/200), (int)(gameHeight / 3 - ((int)gameHeight / 35)) / 3));
			setBackground(Color.black);
			setBorder(BorderFactory.createLineBorder(Color.white));
			JLabel nameLabel = new JLabel();
			nameLabel.setText(name);
			font = font.deriveFont(Font.BOLD, (int)gameWidth / 50);
			nameLabel.setFont(font);
			nameLabel.setForeground(Color.white);
			setLayout(new GridBagLayout());
			add(nameLabel);
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out.println(name + " clicked.");
					if(name.equals("Examine"))
					{
					
							delayedWrite(box, "Succesful Event!", 5);
						
						
					}
				}
			});
	   }
   }
   
   public class CombatOptions extends JPanel
   {
	   public CombatOptions(final String name, final Character player, final Monster enemy, final TextBox box)
	   {
		    setPreferredSize(new Dimension((int)gameWidth / 4 - ((int)gameWidth/200), (int)(gameHeight / 3 - ((int)gameHeight / 35)) / 3));
			setBackground(Color.black);
			setBorder(BorderFactory.createLineBorder(Color.white));
			JLabel nameLabel = new JLabel();
			nameLabel.setText(name);
			font = font.deriveFont(Font.BOLD, (int)gameWidth / 50);
			nameLabel.setFont(font);
			nameLabel.setForeground(Color.white);
			setLayout(new GridBagLayout());
			add(nameLabel);
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out.println(name + " clicked.");
					if(name.equals("Attack") && enemy.getHp() > 0 && player.getHealth() > 0)
					{
						try
						{
							int dmgOut = Combat.MonsterDamage(enemy, player);
							delayedWrite(box, "You attack the " + enemy.getName() + " for " + dmgOut + " damage!", 5);
							if(enemy.getHp() <= 0)
							{
								delayedWrite(box, "You have slain the " + enemy.getName() + "!", 70);
								currentLocation.monster.defeat = true;
								inCombat = false;
								lootUI(player, enemy);
							}
							else
							{
								int dmgIn = Combat.PlayerDamage(enemy, player);
								delayedWrite(box, "The " + enemy.getName() + " attacks you for " + dmgIn + " damage!", 5);
								if(player.getHealth() <= 0)
								{
									delayedWrite(box, "YOU HAVE DIED.", 70);
									inCombat = false;
									traverseUI(M, player);
								}
							}
						}
						catch(InterruptedException ex)
						{
							ex.printStackTrace();
						}
						
					}
					if(name.equals("Switch weapons") && enemy.getHp() > 0 && player.getHealth() > 0)
					{
						player.weaponSwitch();
						JOptionPane.showMessageDialog(gameFrame, "Weapons switched.", "Notice", JOptionPane.PLAIN_MESSAGE);
					}
				}
			});
	   }
   }
   
   public class LootOptions extends JPanel
   {
	   public LootOptions(String name, Character player, TextBox box, Item loot, int index, Monster enemy)
	   {
		   setPreferredSize(new Dimension((int)gameWidth / 4 - ((int)gameWidth/200), (int)(gameHeight / 3 - ((int)gameHeight / 35)) / 3));
			setBackground(Color.black);
			setBorder(BorderFactory.createLineBorder(Color.white));
			JLabel nameLabel = new JLabel();
			nameLabel.setText(name);
			font = font.deriveFont(Font.BOLD, (int)gameWidth / 50);
			nameLabel.setFont(font);
			nameLabel.setForeground(Color.white);
			setLayout(new GridBagLayout());
			add(nameLabel);
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out.println(name + " clicked.");
					if(loot != null)
					{
						player.addInventoryItem(loot);
						enemy.inventory[index] = null;
						lootUI(player, enemy);
					}
					if(name == "Return" || buttons2.getComponents().length == 2)
					{
						traverseUI(M, player);
					}
					
				}
			});
	   }
   }
   
   public void TraverseMazeEngine(Maze M, Maze.Node C, Character Player, String Path, ButtonPanel BP)  {
	   currentLocation = C;
	   if(Maze.MonsterInRoom(currentLocation) && currentLocation.monster.defeat == false)
	   {
		   combatUI(Player, currentLocation.monster, buttons2, box);
	   }
	   else
	   {
	      if(Maze.getRoomNumber(C) == Maze.getRoomNumber(M.exit)) {
	          Maze.setFoundExit(true, M);
	      }
	      
	     BP.repaint();
	      DisplayRoomEngine(M, C, Player, gameFrame, box, BP);
	      
	      if(C.direction == 1) {
	         if(Path.equals("Straight")) {
	            C.north.direction = 1;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.north);
	            //delayedWrite(box, "You went straight", 70);
	            TraverseMazeEngine(M, C.north, Player, "X", BP);
	         }
	         if(Path.equals("Right")) {
	            C.east.direction = 2;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.east);
	            TraverseMazeEngine(M, C.east, Player, "X", BP);
	         }
	         if(Path.equals("Left")) {
	            C.west.direction = 4;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.west);
	            TraverseMazeEngine(M, C.west, Player, "X", BP);
	         }
	         if(Path.equals("Back")) {
	            C.south.direction = 3;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.south);
	            TraverseMazeEngine(M, C.south, Player, "X", BP);
	         }  
	      }
	      
	      if(C.direction == 2) {
	         if(Path.equals("Straight")) {
	            C.east.direction = 2;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.east);
	            TraverseMazeEngine(M, C.east, Player, "X", BP);
	         }
	         if(Path.equals("Right")) {
	            C.south.direction = 3;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.south);
	            TraverseMazeEngine(M, C.south, Player, "X", BP);
	         }
	         if(Path.equals("Left")) {
	            C.north.direction = 1;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.north);
	            TraverseMazeEngine(M, C.north, Player, "X", BP);
	         }
	         if(Path.equals("Back")) {
	            C.west.direction = 4;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.west);
	            TraverseMazeEngine(M, C.west, Player, "X", BP);
	         }  
	      }
	      
	      if(C.direction == 3) {
	         if(Path.equals("Straight")) {
	            C.south.direction = 3;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.south);
	            TraverseMazeEngine(M, C.south, Player, "X", BP);
	         }
	         if(Path.equals("Right")) {
	            C.west.direction = 4;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.west);
	            TraverseMazeEngine(M, C.west, Player, "X", BP);
	         }
	         if(Path.equals("Left")) {
	            C.east.direction = 2;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.east);
	            TraverseMazeEngine(M, C.east, Player, "X", BP);
	         }
	         if(Path.equals("Back")) {
	            C.north.direction = 1;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.north);
	            TraverseMazeEngine(M, C.north, Player, "X", BP);
	         }  
	      }
	      
	      if(C.direction == 4) {
	         if(Path.equals("Straight")) {
	            C.west.direction = 4;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.west);
	            TraverseMazeEngine(M, C.west, Player, "X", BP);
	         }
	         if(Path.equals("Right")) {
	            C.north.direction = 1;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.north);
	            TraverseMazeEngine(M, C.north, Player, "X", BP);
	         }
	         if(Path.equals("Left")) {
	            C.south.direction = 3;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.south);
	            TraverseMazeEngine(M, C.south, Player, "X", BP);
	         }
	         if(Path.equals("Back")) {
	            C.east.direction = 2;
	            Maze.setCurrentRoom(false, C);
	            Maze.setCurrentRoom(true, C.east);
	            TraverseMazeEngine(M, C.east, Player, "X", BP);
	         }  
	      }
      }     
   }//End method TraverseMazeEngine
   
	public GameEngine()
	{
		try
		{
			font = Font.createFont(Font.TRUETYPE_FONT, new File("Vecna.otf"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		font = font.deriveFont(Font.BOLD, (int)gameWidth / 100);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		UIManager.put("OptionPane.font", font);
	}
	
	public void createAndShowGameUI(Character player1, Maze M) 
	{
		
		gameFrame = new JFrame();
		JPanel gamePanel = new JPanel();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setTitle("TBAD");
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gameFrame.setUndecorated(true);
		FlowLayout bottomLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(bottomLayout);
		buttons = new ButtonPanel();
        buttons2 = new ButtonPanel();
		OptionsPanel options = new OptionsPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
      buttons2.setLayout(new BoxLayout(buttons2, BoxLayout.Y_AXIS));
		Options stats = new Options("Stats", player1, gameFrame);
		Options inventory = new Options("Inventory", player1, gameFrame);
		Options equipment = new Options("Equipment", player1, gameFrame);
		buttons.add(stats);
		buttons.add(inventory);
		buttons.add(equipment);
		box = new TextBox();
		TextScroll scroll = new TextScroll();
		scroll.setViewportView(box);
      DisplayRoomEngine(M, Maze.FindCurrentRoom(Maze.getStart(M), M), player1, gameFrame, box, buttons2);
      currentLocation = Maze.FindCurrentRoom(Maze.getStart(M), M);
		bottomPanel.add(buttons);
      bottomPanel.add(buttons2);
		bottomPanel.add(scroll);
		//bottomPanel.add(options);
		GraphicsPanel graphics = new GraphicsPanel();
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
		gameFrame.add(gamePanel);
		gamePanel.add(graphics);
		gamePanel.add(bottomPanel);
		gameFrame.pack();
		gameFrame.setVisible(true);
		delayedWrite(box, "What will you do?", 70);
	}
	
	public void combatUI(Character player, Monster enemy, ButtonPanel buttons, TextBox box)
	{
		inCombat = true;
		delayedWrite(box, "A " + enemy.getName() + " appears!", 70);
		buttons.removeAll();
		CombatOptions atk = new CombatOptions("Attack", player, enemy, box);
		CombatOptions wSwitch = new CombatOptions("Switch weapons", player, enemy, box);
		buttons.add(atk);
		buttons.add(wSwitch);
		buttons.revalidate();
		buttons.repaint();
	}
   public void eventUI(Character player, ButtonPanel buttons, TextBox box)
	{
		inCombat = true;
		delayedWrite(box, "An event appears!", 70);
		buttons.removeAll();
		EventOptions evt = new EventOptions("Examine", player, box);
		buttons.add(evt);
		buttons.revalidate();
		buttons.repaint();
	}
	
	public void traverseUI(Maze M, Character player)
	{
		DisplayRoomEngine(M, currentLocation, player, gameFrame,  box, buttons2);
	}
	
	public void lootUI(Character player, Monster enemy)
	{
		buttons2.removeAll();
		LootOptions title = new LootOptions("Loot", player, box, null, 0, enemy);
		buttons2.add(title);
		for(int i = 0; i < enemy.inventory.length; i++)
		{
			if(enemy.inventory[i] != null)
			{
				LootOptions lootOpt = new LootOptions(enemy.inventory[i].getItemName(), player, box, enemy.inventory[i], i, enemy);
				buttons2.add(lootOpt);
			}
		}
		LootOptions ret = new LootOptions("Return", player, box, null, 0, enemy);
		buttons2.add(ret);
		buttons2.revalidate();
		buttons2.repaint();
	}
	
	public void delayedWrite(final TextBox box, final String text, final int delayMillis)
	{
		try
		{
			latch.await();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		latch = new CountDownLatch(1);
		final char[] textArray = text.toCharArray();
		Thread thread = new Thread(new Runnable() {
			public void run() {
		
				for(int i = 0; i < text.length(); i++)
				{
					box.append(String.valueOf(textArray[i]));
					try
					{
						Thread.sleep(delayMillis);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				box.append("\n");
				latch.countDown();
				box.revalidate();
				box.repaint();
			}
		});
		thread.start();
	}
	
	public String readFile(String path, Charset encoding) throws IOException
	{

		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);

	}
	
   public void DisplayRoomEngine(Maze M, Maze.Node C, Character player1, JFrame gameFrame, TextBox box, ButtonPanel buttons)  {
      //*****************************************
      //Call code for displaying room description
      //*****************************************
      
      //Maze.getRoomEvent(C).EventInterpreter(Maze.getRoomEventNumber(Maze.getRoomEvent(C)), player1, C);
      
      //this.delayedWrite(box, "What will you do?", 70);
      buttons.removeAll();
      
      Choices ExamineC = new Choices("Examine Room", player1, gameFrame, C, M, buttons);
      buttons.add(ExamineC);
      
      if(C.north != null) {
         if(C.direction == 1) {  
            Choices straightC = new Choices("Go Straight", player1, gameFrame, C, M, buttons);
            buttons.add(straightC);
         }
         if(C.direction == 4) {
            Choices rightC = new Choices("Go Right", player1, gameFrame, C, M, buttons);
            buttons.add(rightC);
         }
         if(C.direction == 2) {
            Choices leftC = new Choices("Go Left", player1, gameFrame, C, M, buttons);
            buttons.add(leftC);
         }
         if(C.direction == 3) {
            Choices backC = new Choices("Go Back", player1, gameFrame, C, M, buttons);
            buttons.add(backC);
         }
         
      }
         
      if(C.east != null) {
         if(C.direction == 2) {
            Choices straightC = new Choices("Go Straight", player1, gameFrame, C, M, buttons);
            buttons.add(straightC);
         }
         if(C.direction == 1) {
            Choices rightC = new Choices("Go Right", player1, gameFrame, C, M, buttons);
            buttons.add(rightC);
         }
         if(C.direction == 3) {
            Choices leftC = new Choices("Go Left", player1, gameFrame, C, M, buttons);
            buttons.add(leftC);
         }
         if(C.direction == 4) {
            Choices backC = new Choices("Go Back", player1, gameFrame, C, M, buttons);
            buttons.add(backC);
         }
      }
      
      if(C.south != null) {
         if(C.direction == 3){
            Choices straightC = new Choices("Go Straight", player1, gameFrame, C, M, buttons);
            buttons.add(straightC);
         }
         if(C.direction == 2){
            Choices rightC = new Choices("Go Right", player1, gameFrame, C, M, buttons);
            buttons.add(rightC);
         }
         if(C.direction == 4){
            Choices leftC = new Choices("Go Left", player1, gameFrame, C, M, buttons);
            buttons.add(leftC);
         }
         if(C.direction == 1){
            Choices backC = new Choices("Go Back", player1, gameFrame, C, M, buttons);
            buttons.add(backC);
         }
      }

      if(C.west != null) {
         if(C.direction == 4) {
            Choices straightC = new Choices("Go Straight", player1, gameFrame, C, M, buttons);
            buttons.add(straightC);
         }
         if(C.direction == 3) {
            Choices rightC = new Choices("Go Right", player1, gameFrame, C, M, buttons);
            buttons.add(rightC);
         }
         if(C.direction == 1) {
            Choices leftC = new Choices("Go Left", player1, gameFrame, C, M, buttons);
            buttons.add(leftC);
         }
         if(C.direction == 2) {
            Choices backC = new Choices("Go Back", player1, gameFrame, C, M, buttons);
            buttons.add(backC);
         }
      }
      
      if(Maze.getRoomEvent(C).getEventOn() == true) {
         Choices CheckC = new Choices("Examine Room", player1, gameFrame, C, M, buttons);
         buttons.add(CheckC);
      }
      buttons.revalidate();
      buttons.repaint();
         
   }//End method DisplayRoomEngine
   
	public static void main(String[] args)
	{
		Character player = new Character("Tobias");
                Consumable bread = new Consumable("Bread", 1, 5, 2,0,0,0, "Regular Ol' Bread. The 				choice meal of every Navy Seal.", 2);
                player.addInventoryItem(bread);
                Equipment skeletonSword = new Equipment("Skeleton Sword", 1, 200, 0, 4, 0, 0, "P", "A 				skeleton sword. Its " + 
       			  "scuplted bone edge is rather sharp.  ATTACK +4", 1, 1);
                player.equipment[4] = skeletonSword;
      GameEngine test = new GameEngine();
      test.M = new Maze();
      test.M = Maze.GenerateBasicMaze();
      
      test.createAndShowGameUI(player, test.M);
      Skeleton testSkeleton = new Skeleton();
	  Minotaur testMin = new Minotaur();
	  //if(Maze.MonsterInRoom(test.currentLocation))
		 // test.combatUI(player, test.currentLocation.monster, test.buttons2, test.box);
	}
}
