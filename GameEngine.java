import javax.swing.*;
import java.awt.*;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class GameEngine
{
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double gameWidth = screenSize.getWidth();
	double gameHeight = screenSize.getHeight();
	double gameUnits = gameWidth * gameHeight / 10000;
	
//	public static int getWorkingWidth()
//	{
//		return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
//	}
//	
//	public static int getWorkingHeight()
//	{
//		return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
//	}
//	
	public class GraphicsPanel extends JPanel
	{
		public GraphicsPanel()
		{
			setPreferredSize(new Dimension((int)gameWidth, (int)gameHeight * 2 / 3));
			setBackground(Color.white);
			
		}
		
//		public void paintComponent(Graphics g)
//		{
//			super.paintComponent(g);
//			g.setColor(Color.white);
//			g.drawRect(0, 0, gameWidth, gameHeight * 2 / 3 - (gameWidth / 100));
//		}
		
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
			//setPreferredSize(new Dimension(gameWidth / 2, gameHeight / 3 - (gameHeight / 50)));
			setBackground(Color.black);
			setForeground(Color.white);
			setEditable(false);
			setLineWrap(true);
			setWrapStyleWord(true);
			setFont(new Font(Font.SERIF, Font.BOLD, 16));
		}
	}
	
	public GameEngine()
	{
		
		JFrame gameFrame = new JFrame();
		JPanel gamePanel = new JPanel();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setTitle("TBAD");
		//gameFrame.setPreferredSize(new Dimension(gameWidth, gameHeight));
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gameFrame.setUndecorated(true);
		FlowLayout bottomLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(bottomLayout);
		ButtonPanel buttons = new ButtonPanel();
		OptionsPanel options = new OptionsPanel();
		TextBox box = new TextBox();
		TextScroll scroll = new TextScroll();
		scroll.setViewportView(box);
		bottomPanel.add(buttons);
		bottomPanel.add(scroll);
		//bottomPanel.add(box);
		bottomPanel.add(options);
		GraphicsPanel graphics = new GraphicsPanel();
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
		gameFrame.add(gamePanel);
		gamePanel.add(graphics);
		gamePanel.add(bottomPanel);
		//gameFrame.add(Box.createRigidArea(new Dimension(0, 5)));
		gameFrame.pack();
		gameFrame.setVisible(true);
		try{
			delayedWrite(box, readFile("test.txt", StandardCharsets.UTF_8), 35);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
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