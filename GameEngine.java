import javax.swing.*;
import java.awt.*;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameEngine extends Event
{
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double gameWidth = screenSize.getWidth();
	double gameHeight = screenSize.getHeight();
	TextBox box;

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
			setFont(new Font(Font.SERIF, Font.BOLD, (int)gameWidth / 100));
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
			nameLabel.setFont(new Font(Font.SERIF, Font.BOLD, (int)gameWidth / 50));
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
								text += inventoryList[i];
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
								text += equipList[i];
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
		public Choices(final String name, final Character player, final JFrame frame, final Maze.Node C, final Maze M, final GameEngine GE) 
		{
			setPreferredSize(new Dimension((int)gameWidth / 4 - ((int)gameWidth/200), (int)(gameHeight / 3 - ((int)gameHeight / 35)) / 3));
			setBackground(Color.black);
			setBorder(BorderFactory.createLineBorder(Color.white));
			JLabel nameLabel = new JLabel();
			nameLabel.setText(name);
			nameLabel.setFont(new Font(Font.SERIF, Font.BOLD, (int)gameWidth / 50));
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
                  delayedWrite(box, "You went straight", 70);
					   TraverseMazeEngine(M, C, player, "Straight", GE);
               }
					if(name.equals("Go Right"))
					{
                  delayedWrite(box, "You went right", 70);
						TraverseMazeEngine(M, C, player, "Right", GE);
					}
               if(name.equals("Go Left"))
					{
                  delayedWrite(box, "You went left", 70);
						TraverseMazeEngine(M, C, player, "Left", GE);
					}
               if(name.equals("Go Back"))
					{
                  delayedWrite(box, "You went back", 70);
						TraverseMazeEngine(M, C, player, "Back", GE);
					}
				}
			}
         );
		}
	}
   
   public void TraverseMazeEngine(Maze M, Maze.Node C, Character Player, String Path, GameEngine GE)  {
      if(Maze.getRoomNumber(C) == Maze.getRoomNumber(M.exit)) {
          Maze.setFoundExit(true, M);
      }
      
      JFrame gameFrame = new JFrame();
		JPanel gamePanel = new JPanel();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setTitle("TBAD");
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gameFrame.setUndecorated(true);
		FlowLayout bottomLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(bottomLayout);
		ButtonPanel buttons = new ButtonPanel();
      ButtonPanel buttons2 = new ButtonPanel();
		OptionsPanel options = new OptionsPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
      buttons2.setLayout(new BoxLayout(buttons2, BoxLayout.Y_AXIS));
		Options stats = new Options("Stats", Player, gameFrame);
		Options inventory = new Options("Inventory", Player, gameFrame);
		Options equipment = new Options("Equipment", Player, gameFrame);
		buttons.add(stats);
		buttons.add(inventory);
		buttons.add(equipment);
		box = new TextBox();
		TextScroll scroll = new TextScroll();
		scroll.setViewportView(box);
      DisplayRoomEngine(M, C, Player, gameFrame, box, buttons2, GE);
		bottomPanel.add(buttons);
      bottomPanel.add(buttons2);
		bottomPanel.add(scroll);
		bottomPanel.add(options);
		GraphicsPanel graphics = new GraphicsPanel();
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
		gameFrame.add(gamePanel);
		gamePanel.add(graphics);
		gamePanel.add(bottomPanel);
		gameFrame.pack();
		gameFrame.setVisible(true);
      
      if(C.direction == 1) {
         if(Path.equals("Straight")) {
            C.north.direction = 1;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.north);
            delayedWrite(box, "You went straight", 70);
            TraverseMazeEngine(M, C.north, Player, "X", GE);
         }
         if(Path.equals("Right")) {
            C.east.direction = 2;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.east);
            TraverseMazeEngine(M, C.east, Player, "X", GE);
         }
         if(Path.equals("Left")) {
            C.west.direction = 4;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.west);
            TraverseMazeEngine(M, C.west, Player, "X", GE);
         }
         if(Path.equals("Back")) {
            C.south.direction = 3;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.south);
            TraverseMazeEngine(M, C.south, Player, "X", GE);
         }  
      }
      
      if(C.direction == 2) {
         if(Path.equals("Straight")) {
            C.east.direction = 2;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.east);
            TraverseMazeEngine(M, C.east, Player, "X", GE);
         }
         if(Path.equals("Right")) {
            C.south.direction = 3;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.south);
            TraverseMazeEngine(M, C.south, Player, "X", GE);
         }
         if(Path.equals("Left")) {
            C.north.direction = 1;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.north);
            TraverseMazeEngine(M, C.north, Player, "X", GE);
         }
         if(Path.equals("Back")) {
            C.west.direction = 4;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.west);
            TraverseMazeEngine(M, C.west, Player, "X", GE);
         }  
      }
      
      if(C.direction == 3) {
         if(Path.equals("Straight")) {
            C.south.direction = 3;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.south);
            TraverseMazeEngine(M, C.south, Player, "X", GE);
         }
         if(Path.equals("Right")) {
            C.west.direction = 4;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.west);
            TraverseMazeEngine(M, C.west, Player, "X", GE);
         }
         if(Path.equals("Left")) {
            C.east.direction = 2;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.east);
            TraverseMazeEngine(M, C.east, Player, "X", GE);
         }
         if(Path.equals("Back")) {
            C.north.direction = 1;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.north);
            TraverseMazeEngine(M, C.north, Player, "X", GE);
         }  
      }
      
      if(C.direction == 4) {
         if(Path.equals("Straight")) {
            C.west.direction = 4;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.west);
            TraverseMazeEngine(M, C.west, Player, "X", GE);
         }
         if(Path.equals("Right")) {
            C.north.direction = 1;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.north);
            TraverseMazeEngine(M, C.north, Player, "X", GE);
         }
         if(Path.equals("Left")) {
            C.south.direction = 3;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.south);
            TraverseMazeEngine(M, C.south, Player, "X", GE);
         }
         if(Path.equals("Back")) {
            C.east.direction = 2;
            Maze.setCurrentRoom(false, C);
            Maze.setCurrentRoom(true, C.east);
            TraverseMazeEngine(M, C.east, Player, "X", GE);
         }  
      }     
   }//End method TraverseMazeEngine
   
	public GameEngine()
	{
	}
	
	public void createAndShowGameUI(Character player1, Maze M, GameEngine GE) 
	{
		
		JFrame gameFrame = new JFrame();
		JPanel gamePanel = new JPanel();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setTitle("TBAD");
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gameFrame.setUndecorated(true);
		FlowLayout bottomLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(bottomLayout);
		ButtonPanel buttons = new ButtonPanel();
      ButtonPanel buttons2 = new ButtonPanel();
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
      DisplayRoomEngine(M, Maze.FindCurrentRoom(Maze.getStart(M), M), player1, gameFrame, box, buttons2, GE);
		bottomPanel.add(buttons);
      bottomPanel.add(buttons2);
		bottomPanel.add(scroll);
		bottomPanel.add(options);
		GraphicsPanel graphics = new GraphicsPanel();
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
		gameFrame.add(gamePanel);
		gamePanel.add(graphics);
		gamePanel.add(bottomPanel);
		gameFrame.pack();
		gameFrame.setVisible(true);
		
	}
	
	public void delayedWrite(TextBox box, String text, int delayMillis)
	{
		char[] textArray = text.toCharArray();
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
	}
	
	public String readFile(String path, Charset encoding) throws IOException
	{

		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);

	}
	
   public void DisplayRoomEngine(Maze M, Maze.Node C, Character player1, JFrame gameFrame, TextBox box, ButtonPanel buttons, GameEngine GE)  {
      //*****************************************
      //Call code for displaying room description
      //*****************************************
      
      //Maze.getRoomEvent(C).EventInterpreter(Maze.getRoomEventNumber(Maze.getRoomEvent(C)), player1, C);
      
      this.delayedWrite(box, "What will you do?", 70);
      
      Choices ExamineC = new Choices("Examine Room", player1, gameFrame, C, M, GE);
      buttons.add(ExamineC);
      
      if(C.north != null) {
         if(C.direction == 1) {  
            Choices straightC = new Choices("Go Straight", player1, gameFrame, C, M, GE);
            buttons.add(straightC);
         }
         if(C.direction == 4) {
            Choices rightC = new Choices("Go Right", player1, gameFrame, C, M, GE);
            buttons.add(rightC);
         }
         if(C.direction == 2) {
            Choices leftC = new Choices("Go Left", player1, gameFrame, C, M, GE);
            buttons.add(leftC);
         }
         if(C.direction == 3) {
            Choices backC = new Choices("Go Back", player1, gameFrame, C, M, GE);
            buttons.add(backC);
         }
         
      }
         
      if(C.east != null) {
         if(C.direction == 2) {
            Choices straightC = new Choices("Go Straight", player1, gameFrame, C, M, GE);
            buttons.add(straightC);
         }
         if(C.direction == 1) {
            Choices rightC = new Choices("Go Right", player1, gameFrame, C, M, GE);
            buttons.add(rightC);
         }
         if(C.direction == 3) {
            Choices leftC = new Choices("Go Left", player1, gameFrame, C, M, GE);
            buttons.add(leftC);
         }
         if(C.direction == 4) {
            Choices backC = new Choices("Go Back", player1, gameFrame, C, M, GE);
            buttons.add(backC);
         }
      }
      
      if(C.south != null) {
         if(C.direction == 3){
            Choices straightC = new Choices("Go Straight", player1, gameFrame, C, M, GE);
            buttons.add(straightC);
         }
         if(C.direction == 2){
            Choices rightC = new Choices("Go Right", player1, gameFrame, C, M, GE);
            buttons.add(rightC);
         }
         if(C.direction == 4){
            Choices leftC = new Choices("Go Left", player1, gameFrame, C, M, GE);
            buttons.add(leftC);
         }
         if(C.direction == 1){
            Choices backC = new Choices("Go Back", player1, gameFrame, C, M, GE);
            buttons.add(backC);
         }
      }

      if(C.west != null) {
         if(C.direction == 4) {
            Choices straightC = new Choices("Go Straight", player1, gameFrame, C, M, GE);
            buttons.add(straightC);
         }
         if(C.direction == 3) {
            Choices rightC = new Choices("Go Right", player1, gameFrame, C, M, GE);
            buttons.add(rightC);
         }
         if(C.direction == 1) {
            Choices leftC = new Choices("Go Left", player1, gameFrame, C, M, GE);
            buttons.add(leftC);
         }
         if(C.direction == 2) {
            Choices backC = new Choices("Go Back", player1, gameFrame, C, M, GE);
            buttons.add(backC);
         }
      }
      
      if(Maze.getRoomEvent(C).getEventOn() == true) {
         Choices CheckC = new Choices("Examine Room", player1, gameFrame, C, M, GE);
         buttons.add(CheckC);
      }
         
   }//End method DisplayRoomEngine
   
	public static void main(String[] args)
	{
		Character player = new Character("Tobias");
      Maze M = new Maze();
      M = Maze.GenerateBasicMaze();
      GameEngine test = new GameEngine();
      test.createAndShowGameUI(player, M, test);     
	}
}