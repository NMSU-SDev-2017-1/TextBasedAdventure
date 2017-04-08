package game;
import sun.audio.*;

import java.awt.*; 
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*; 
import javax.xml.soap.Text;
import javax.swing.*;

public class Image extends JFrame
{    
		Font font, font2;
	    String text, text2;
	    BufferedImage mScreen, img1, Skele, imgPlay, imgQuit,textBox;
	    BufferedImage button1, button2, button3, button4;
	    int x,y, w, h, GameState;
	    int swidth, sheight;
	    boolean rSize=false, imgtext=false;
	    Rectangle play, quit, B1,B2,B3,B4, hi;
	private Image(String arg){
	     
	     font = new Font(Font.MONOSPACED, Font.BOLD, 32);
	     font2 = new Font(Font.SANS_SERIF, Font.BOLD, 12);
	     x=200;
	     y=100;
	     w = 400;
	     h= 400;
	     Toolkit tk = Toolkit.getDefaultToolkit();
	     swidth = ((int) tk.getScreenSize().getWidth());
	     sheight = ((int) tk.getScreenSize().getHeight());
	     
	     play = new Rectangle(187,143,90,32);
	     quit = new Rectangle(188,242,84,30);
	     B1 = new Rectangle( 200,200,90,32);
	     B2 = new Rectangle(200,240,90,32);
	     try {
	        mScreen = ImageIO.read(new File("src/game/darkest-dungeon-title-screen.jpg"));
	        img1 = ImageIO.read(new File("src/game/dungeons-and-dragons-strategy-1.jpg"));
	        imgPlay = ImageIO.read(new File("src/game/play.png"));
	        imgQuit = ImageIO.read(new File("src/game/quit.png"));
	        Skele = ImageIO.read(new File("src/game/Skeleton.jpg"));
	        textBox = ImageIO.read(new File("src/game/Tbox.jpeg"));
	        button1 = ImageIO.read(new File("src/game/Button1.png"));
	        button2 = ImageIO.read(new File("src/game/Button2.png"));
	        button3 = ImageIO.read(new File("src/game/Button3.png"));
	        button4 = ImageIO.read(new File("src/game/Button4.png"));
	        
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
    
    JPanel panel = new JPanel(); 
    this.setSize(swidth,sheight);
    panel.setBackground(Color.white); 
    panel.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		//System.out.println(e.getX() + " " + (e.getY()));
		if(play.contains(e.getPoint())){
			System.out.println("Play");
			GameState = 1;
			dothis();
		}else if(quit.contains(e.getPoint())){
			System.out.println("Quit");
			System.exit(DISPOSE_ON_CLOSE);
		}else if(B1.contains(e.getPoint())){
			GameState = 2;
			dothis();
		}else if(B2.contains(e.getPoint())){
			GameState = 3;
			dothis();
		}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

    }
    		);
    addComponentListener(new ComponentAdapter() {
  	  public void componentResized(ComponentEvent comp) {
  	    if(comp.getID()==comp.COMPONENT_RESIZED){
  	    rSize =true;
  	    dothis();
  	    }
  	  }
  	});
    this.getContentPane().add(panel); 
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);

  }
  public static void main(String[] args) {
     
   Image i =new Image("test");
  // i.run();
 
  }
  public static void music(){
	  File clip = new File("");
	  Clip clips = null;
	try {
		clips = AudioSystem.getClip();
	} catch (LineUnavailableException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  try {
		clips.open(AudioSystem.getAudioInputStream(clip));
	} catch (LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedAudioFileException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  clips.start();
  }
  
  public void paint (Graphics g){
		 
	     g.setColor(Color.black);
	     g.fillRect(0, 0, swidth, sheight);
	     //System.out.println(t);
	     if(rSize){
	    	swidth = this.getWidth();
	    	sheight = this.getHeight();
	    	System.out.println(swidth);
	    	rSize = false;
	     }
	     switch (GameState){
	    	 case 1 :
	    		 g.drawImage(img1, x-200, y-60, x+swidth, y+sheight, 0, 0, img1.getWidth(), img1.getHeight(), null);
	    		 g.drawImage(textBox,x-200, y+700, swidth, sheight+100, 0, 0, textBox.getWidth(), textBox.getHeight()+400, null);
	             text = "Welcome to the game!!!";
	             g.setColor(Color.black);
	             g.drawRect(B1.x+200,B1.y+600, B1.width, B1.height);
	             g.drawImage(button1, B1.x+5,B1.y+30,B1.x+5+B1.width, B1.height+B1.y+30,0,0, button1.getWidth(), button1.getHeight(), null);
	             g.setColor(Color.white);
	             g.drawRect(B2.x+5,B2.y+35, B2.width, B2.height);
	             g.setColor(Color.black);
	             g.drawImage(button2, B2.x+5, B2.y+35, B2.x+5+B2.width, B2.height+B2.y+35, 0, 0, button2.getWidth(), button2.getHeight(), null);
	             g.setFont(font);
	             g.drawString(text,x+400, y+800);
	             text2 = "here u get to be me, Deadpool welcome...$" +"press 1 to continue 2 to quit";
	             if(!imgtext){
	             Timg(text2, g);
	             imgtext = true;
	             		}else{
	             			//g.drawString(text2,x+200, y+830);
	             		}
	           //g.setColor(Color.white);
	             //g.fillRect(Tbox.x, Tbox.y, Tbox.width, Tbox.height);
	             //g.setColor(Color.WHITE);
	            break;
	    	 case 2:
	    		 g.drawImage(img1, x-200, y-60, x+swidth, y+sheight, 0, 0, img1.getWidth(), img1.getHeight(), null);
	    		 g.drawImage(Skele, x+200, y, x+swidth, y+sheight, 0, 0, Skele.getWidth()+200, Skele.getHeight(), null);
	             text = "FIGHT ME!!!";
	             g.setColor(Color.WHITE);
	             g.drawString(text,200, 400);g.drawRect(quit.x+5,quit.y+35, quit.width, quit.height);
	             
	         break;
	    	 case 3:
	    		 g.drawImage(img1, x-200, y-60, x+swidth, y+sheight, 0, 0, img1.getWidth(), img1.getHeight(), null);
	    		 text = "Welcome to adventure pool!!!";
	    		 g.setColor(Color.black);
	    		 //g.drawRect(Tbox.x, Tbox.y, Tbox.width, Tbox.width);
	    		 g.setColor(Color.white);
	    		 //g.fillRect(Tbox.x, Tbox.y, Tbox.width, Tbox.height);
	    		 g.setColor(Color.WHITE);
	    		 g.setFont(font);
	    		 g.drawString(text,200, 400);
	    	 
	    		
	    	 break;
	    	 default:
	    		 text = " Hello, Im DEADPOOL!!";
	             text2 = "here u get to be me, Deadpool welcome..." +"whos your favorite superhero???";
	             g.drawImage(mScreen, x-300, y-100, x+swidth, y+sheight, 0, 0, mScreen.getWidth(), mScreen.getHeight(), null);
	             g.setColor(Color.white);
	             g.setFont(font);
	             g.drawString(text, 200, 550);
	             //g.drawString("Play", 200,300);
	             //g.drawString("quit", 200,300);
	             g.drawRect(play.x+5,play.y+30, play.width, play.height);
	             g.drawRect(quit.x+5,quit.y+35, quit.width, quit.height);
	             g.drawImage(imgPlay, play.x+5,play.y+30,play.x+5+play.width, play.height+play.y+30,0,0, imgPlay.getWidth(), imgPlay.getHeight(), null);
	             g.drawImage(imgQuit, quit.x+5,quit.y+30,quit.x+5+quit.width, quit.height+quit.y+35,0,0, imgQuit.getWidth(), imgQuit.getHeight(), null);
	            }
	         
	    
	     }
  public void run(){
	  while(true){
		
		  //System.out.println(t);
		  this.repaint();
		  try {
			  Thread.sleep(4000);
		} catch (InterruptedException e) {
			/// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
  }
  public void dothis(){
	  this.repaint();
  }
  public void Timg(String tx, Graphics g){
	  
	  char[] carray = tx.toCharArray();
      int temp = 10;
      int xt = x+400;
      int yt = y+830;
      for(int i = 0; i<tx.length(); i++){
     	 
          g.setColor(Color.black);
          g.setFont(font2);
          char c = carray[i];
          if (c == '$'){
        	  
              	temp=0;
              	 //xt = xt+100;
              	 yt = yt+40;
              	System.out.println("here");
           
          }else{

          g.drawString(String.valueOf(c), xt+temp, yt);
          temp = temp+12;
          try {
              Thread.sleep(70);
         } catch (InterruptedException e) {
             /// TODO Auto-generated catch block
             e.printStackTrace();
         }
          //int temp2 =xt +x;
         /* if(tem2p > Tbox.width+150){
         	 x=0;
         	 //xt = xt+100;
         	 yt = yt+40;
         	
         	System.out.println("here");
          }*/
      }
  }
      
  }
}