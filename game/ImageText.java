package game;
import java.awt.*; 
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*; 
import javax.xml.soap.Text;

public class ImageText extends JFrame
{    
    Font font, font2;
    String text, text2;
    BufferedImage img, img1, img2, imgPlay, imgQuit;
    int x,y, w, h, m;
    int swidth, sheight;
    boolean t,rSize=false, imgtext=false;
    Rectangle play, quit, Tbox, hi;
  private ImageText(String arg){
     
     font = new Font(Font.MONOSPACED, Font.BOLD, 32);
     font2 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
     t=true;
     x=200;
     y=100;
     w = 400;
     h= 400;
     Toolkit tk = Toolkit.getDefaultToolkit();
     swidth = ((int) tk.getScreenSize().getWidth());
     sheight = ((int) tk.getScreenSize().getHeight());
     
     play = new Rectangle(187,143,90,32);
     quit = new Rectangle(188,242,84,30);
     Tbox = new Rectangle(170,400, 570, 200);
     try {
        img = ImageIO.read(new File("src/game/deadpool-suicide-kings.jpg"));
        img1 = ImageIO.read(new File("src/game/deadpool-wallpapers-wilson-wallpaper.jpg"));
        imgPlay = ImageIO.read(new File("src/game/play.png"));
        imgQuit = ImageIO.read(new File("src/game/quit.png"));
        img2 = ImageIO.read(new File("src/game/1200x630bf.jpg"));
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
        System.out.println(e.getX() + " " + (e.getY()));
        if(play.contains(e.getPoint())){
        	
            System.out.println("Play");
            m = 1;
            dothis();
        } if(quit.contains(e.getPoint())){
            System.out.println("Quit");
            System.exit(DISPOSE_ON_CLOSE);
        }
        if(play.contains(e.getPoint())){
        	m=2;
        	dothis();
        }
        
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
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
    System.out.println(this.getWidth());

  }
  public static void main(String[] args) {
     
	  ImageText i =new ImageText("test");
  // i.run();
 
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
     switch (m){
    	 case 1 :
    		 g.drawImage(img1, x-200, y-60, x+swidth, y+sheight, 0, 0, img1.getWidth(), img1.getHeight(), null);
             text = "Welcome to adventure pool!!!";
             g.setColor(Color.black);
             g.drawRect(Tbox.x, Tbox.y, Tbox.width, Tbox.width);
             g.setColor(Color.white);
             g.fillRect(Tbox.x, Tbox.y, Tbox.width, Tbox.height);
             g.setColor(Color.WHITE);
             g.setFont(font);
             g.drawString(text,200, 400);
             
             text2 = "here u get to be me, Deadpool welcome...$" +"whos your favorite superhero???";
             if(!imgtext){
             Timg(text2, g);
             imgtext = true;
             		}else{
             			g.drawString(text2, 200, 450);
             		}
    break;
    	 case 2:
    		 g.drawImage(img2, x-200, y-60, x+swidth, y+sheight, 0, 0, img1.getWidth(), img1.getHeight(), null);
             text = "Welcome to adventure pool!!!";
             g.setColor(Color.black);
             g.drawRect(Tbox.x, Tbox.y, Tbox.width, Tbox.width);
             g.setColor(Color.white);
             g.fillRect(Tbox.x, Tbox.y, Tbox.width, Tbox.height);
             g.setColor(Color.WHITE);
             g.setFont(font);
             g.drawString(text,200, 400);
        
         break;
    	 case 3:
         g.drawImage(img2, x-200, y-60, x+swidth, y+sheight, 0, 0, img1.getWidth(), img1.getHeight(), null);
         text = "Welcome to adventure pool!!!";
         g.setColor(Color.black);
         g.drawRect(Tbox.x, Tbox.y, Tbox.width, Tbox.width);
         g.setColor(Color.white);
         g.fillRect(Tbox.x, Tbox.y, Tbox.width, Tbox.height);
         g.setColor(Color.WHITE);
         g.setFont(font);
         g.drawString(text,200, 400);
    	 
    		
    	 break;
    	 default:
    		 text = " Hello, Im DEADPOOL!!";
             text2 = "here u get to be me, Deadpool welcome..." +"whos your favorite superhero???"+ " i love you joon khaysa mam7oona daloo3a";
             g.drawImage(img, x-300, y-100, x+swidth, y+sheight, 0, 0, img.getWidth(), img.getHeight(), null);
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
    	 this.
        swidth = this.getWidth();
        sheight = this.getHeight();
         System.out.println(swidth);
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
      int x = 10;
      int xt =200;
      int yt = 450;
      for(int i = 0; i<tx.length(); i++){
     	 
          g.setColor(Color.black);
          g.setFont(font2);
          char c = carray[i];
          if (c == '$'){
        	  
              	 x=0;
              	 //xt = xt+100;
              	 yt = yt+40;
              	System.out.println("here");
           
          }else{

          g.drawString(String.valueOf(c), xt+x, yt);
          x = x+12;
          try {
              Thread.sleep(70);
         } catch (InterruptedException e) {
             /// TODO Auto-generated catch block
             e.printStackTrace();
         }
          //int temp =xt +x;
         /* if(temp > Tbox.width+150){
         	 x=0;
         	 //xt = xt+100;
         	 yt = yt+40;
         	
         	System.out.println("here");
          }*/
      }
  }
      
  }
}
