//package game;
import java.awt.*; 
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
    BufferedImage img, img1;
    int x, y, w, h;
    int swidth, sheight;
    boolean t;
    Rectangle play, quit, Tbox;
  private ImageText(String arg){
     
	 //setUndecorated(true);
	 setResizable(false);
	 //setLocationRelativeTo(null);
	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     font = new Font(Font.MONOSPACED, Font.BOLD, 32);
     font2 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
     t=true;
     x=200;
     y=100;
     w = 400;
     h= 400;
     swidth = screenSize.width;
     sheight = screenSize.height;
     play = new Rectangle(sheight/2,swidth/3,90,32);
     quit = new Rectangle(188,242,84,30);
     Tbox = new Rectangle(170,400, 570, 200);
     try {
        img = ImageIO.read(new File("deadpool-suicide-kings.jpg"));
        img1 = ImageIO.read(new File("deadpool-wallpapers-wilson-wallpaper.jpg"));
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
            t = !t;
            dothis();
        }else if(quit.contains(e.getPoint())){
            System.out.println("Quit");
            System.exit(DISPOSE_ON_CLOSE);
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
    this.getContentPane().add(panel); 
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);

  }
  public static void main(String[] args) {
     
	  ImageText i =new ImageText("test");
  // i.run();
 
  }
  public void paint (Graphics g){
     g.setColor(Color.black);
     g.fillRect(0, 0, swidth, sheight);
     //System.out.println(t);
    
     if(t){
         
         text = " Hello, Im DEADPOOL!!";
         text2 = "here u get to be me, Deadpool welcome..." +"whos your favorite superhero???"+ " i love you joon khaysa mam7oona daloo3a";
         g.drawImage(img, x, y-40, x+w+350, y+h+60, 0, 0, img.getWidth(), img.getHeight(), null);
         g.setColor(Color.white);
         g.setFont(font);
         g.drawString(text, 200, 550);
         g.drawString("Play", swidth/3, sheight/2 + 32);
         g.drawString("quit", 200,300);
         g.drawRect(play.x+5,play.y+30, play.width, play.height);
         g.drawRect(quit.x+5,quit.y+35, quit.width, quit.height);
    
     }else{
         g.drawImage(img1, x-200, y-60, x+w+400, y+h+100, 0, 0, img1.getWidth(), img1.getHeight(), null);
         text = "Welcome to adventure pool!!!";
         g.setColor(Color.black);
         g.drawRect(Tbox.x, Tbox.y, Tbox.width, Tbox.width);
         g.setColor(Color.white);
         g.fillRect(Tbox.x, Tbox.y, Tbox.width, Tbox.height);
         g.setColor(Color.WHITE);
         g.setFont(font);
         g.drawString(text,200, 400);
         
         text2 = "here u get to be me, Deadpool welcome..." +"whos your favorite superhero???"+ " i love you joon khaysa mam7oona daloo3a";
         Timg(text2, g);
         
            }
         
    
     }

  public void run(){
     while(true){
        
         System.out.println(t);
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
          g.drawString(String.valueOf(c), xt+x, yt);
          x = x+12;
          try {
              Thread.sleep(70);
         } catch (InterruptedException e) {
             /// TODO Auto-generated catch block
             e.printStackTrace();
         }
          int temp =xt +x;
          if(temp > Tbox.width+150){
         	 x=0;
         	 //xt = xt+100;
         	 yt = yt+40;
         	
         	System.out.println("here");
      }
  }
      
  }
}
