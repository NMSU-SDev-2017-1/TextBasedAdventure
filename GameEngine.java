import javax.swing.*;
import java.awt.*;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameEngine
{
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double gameWidth = screenSize.getWidth();
	double gameHeight = screenSize.getHeight();

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
		public Options(String name, Character player, JFrame frame)
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
			addMouseListener(new MouseAdapter()
			{
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
			});
		}
	}
	
	public GameEngine()
	{
		
		Character player1 = new Character("Troy");
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
		OptionsPanel options = new OptionsPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		Options stats = new Options("Stats", player1, gameFrame);
		Options inventory = new Options("Inventory", player1, gameFrame);
		Options equipment = new Options("Equipment", player1, gameFrame);
		buttons.add(stats);
		buttons.add(inventory);
		buttons.add(equipment);
		TextBox box = new TextBox();
		TextScroll scroll = new TextScroll();
		scroll.setViewportView(box);
		bottomPanel.add(buttons);
		bottomPanel.add(scroll);
		bottomPanel.add(options);
		GraphicsPanel graphics = new GraphicsPanel();
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
		gameFrame.add(gamePanel);
		gamePanel.add(graphics);
		gamePanel.add(bottomPanel);
		gameFrame.pack();
		gameFrame.setVisible(true);
/* 		try{
			delayedWrite(box, readFile("test.txt", StandardCharsets.UTF_8), 35);
		}
		catch(IOException e) {
			e.printStackTrace();
		} */
		delayedWrite(box, "Hello, world!", 70);
		
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
	
	public static void main(String[] args)
	{
		GameEngine test = new GameEngine();
	}
}