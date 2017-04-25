import javax.swing.*;
import java.awt.*;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class EventEngine extends GameEngine {
   private boolean Event_On;
   private boolean Event_Completed;
   private int Event_Number;
   private int Event_Attempts;
   private String Event_Description;
  
   public EventEngine() {
      Event_On = false;
      Event_Completed = false;
      Event_Number = 0;
      Event_Attempts = 0;
      Event_Description = "";
   }//End Constructor 
   
   //Event setters start here
   public void setEvenEnginetOn(boolean newEventOn) {
      Event_On = newEventOn;
   }//End Method setEventOn
   
   public void setEventEngineCompleted(boolean newEventCompleted) {
      Event_Completed = newEventCompleted;
   }//End Method setEventCompleted 
   
   public void setEventEngineNumber(int newEventNumber) {
      Event_Number = newEventNumber;
   }//End Method setEventNumber
   
   public void setEventEngineAttempts(int newEventAttempts) {
      Event_Attempts = newEventAttempts;
   }//End Method setEventAttempts
   //Event setters end here
   
   //Event getters start here
   public boolean getEventEngineOn() {
      return Event_On;
   }//End Method getEventOn
   
   public boolean getEventEngineCompleted() {
      return Event_Completed;
   }//End Method getEventCompleted
   
   public int getEventEngineNumber() {
      return Event_Number;
   }//End Method getEventNumber
   
   public int getEventEngineAttempts() {
      return Event_Attempts;
   }//End Method getEventAttempts
   //Event getters end here
   
   public void EventEngineInterpreter(int EventNumber, Character Player, Maze.Node C) throws InterruptedException {
      if(EventNumber == 1) {
         this.Event_001_GoldenStatue(this.getEventAttempts(), Player);
      }
   }//End Method EventInterpreter
   
   public void EventEngineAssignment(int EventNumber) {
      if(EventNumber == 1) {
         this.setEventEngineNumber(EventNumber);
      }
   }//End Method EventInterprete
   
   public static void ActivateEventEngine(EventEngine E) {
      E.Event_On = true;
   }
   
   public void EventEngine_001_GoldenStatue(int Visits, Character Player) throws InterruptedException {
      Thread.sleep(300);
      Scanner scan = new Scanner(System.in);
      int choice;
      Treasure GoldenStatue = new Treasure("Golden Statue", 1, 1000);
      boolean loopOut;
      loopOut = false;
      if(this.getEventCompleted() == true) {
         GameSystem.readFast("In the center of the room the Pedestal stood, still just as pristine as it was when you first " + 
            "took the Golden Statue. The charred ground served as a reminder to the fiery trap that guarded the statue.");
         return;
      }//End event completed check
      if(Visits == 0) {
         GameSystem.readFast("Right in the center of the room it stood proudly. A Golden Statue, the size of your torso, " + 
            "stood on a large, stone, Pedestal. Its golden shine is almost too alluring to ignore.");
         while(loopOut == false) { 
            GameSystem.readFast("What will you do?");
            Thread.sleep(100);
            System.out.println("(1)Examine the area.   (2)Examine the Pedestal.   (3)Examine the Golden Statue.");
            System.out.println("(4)Quickly Grab the Golden Statue.   (5)Carefully Grab the Golden Statue.   (6)Do Nothing.");
            choice = scan.nextInt();
            Thread.sleep(200);
            if(choice == 1) {
               GameSystem.readFast("You look around the room, aside from what you noticed when you entered the room you don't " +
               "notice anything else. You look up, you see more of the same as the rest of the room, with the exception of a series " + 
               "of strange holes perforating the ceiling.");
               Thread.sleep(300);
               continue;
            }//End choice one
            
            if(choice == 2) {
               GameSystem.readFast("You lean forward to get a good look at the Pedestal. It is made of smooth stone and stands " + 
                  "at just barely above your waist. Upon closer inspection you notice a pattern that covers the side of the Pedestal." +
                  "You lean closer to the pattern and can see what look like wings. You take a couple more minutes to carefully examine" +
                  " the whole Pedestal, but you notice nothing else.");
               Thread.sleep(300);
               continue;
            }//End choice two
         
            if(choice == 3) {
               GameSystem.readFast("You slowly walk around the Pedestal to get a good look at the Golden Statue. It looked like a robed " +
                  "woman, the robes flowed over the woman's feet. The craftsmanship was astounding, each crease and fold of the robe was " +
                  "highly detailed, the robe itself look like finely woven cloth, frozen in the midst of a breezy day.");
               GameSystem.readFast("The woman was just as detailed, her hands were clasped together in front of her face" +
                  " as if she was praying. " + 
                  "If you had the time you could count each strand of her hair, it was so realistic it was slightly creepy." +
                  " Her face is frozen in surprise, her eyes - wide open - were different than those of a human, they looked " + 
                  "like a cat's eyes.  Stepping back you can appreciate its beauty from a distance, its size is nothing to " + 
                  "ignore, it is definitly likely to be pretty heavy if it is pure gold.");
               GameSystem.readFast("There is no doubt about it, this Statue is definitly worth a lot.");
               Thread.sleep(300);
               continue;
            }//End choice three
          
            if(choice == 4) {
               GameSystem.readFast("It only took a single moment. You dash forward and leap towards the Golden Statue! " +
                  "In one swift motion you grab the Golden Statue with both arms and bring it close to your body. " + 
                  " The momentum of your leap carries both you and the statue forward. While you are midair you " + 
                  "hear a loud click. As you tumble to the ground, clinging to the statue, you feel a blast of heat on your " + 
                  "back, by the time you lood behind you towards the heat's source its over. The ground around the Pedestal is scorched, but the " + 
                  "Pedestal is completely undamaged, in fact it looks pristine.");
               GameSystem.readFast("It looks like you made the right choice, now you have a Golden Statue.");
               Player.addInventoryItem(GoldenStatue);
               this.setEventCompleted(true);
               return;
            }//End choice four
         
            if(choice == 5) {
               GameSystem.readFast("You proceed cautiously, you step forward carefully and reach towards the statue, nothing happens." +
               " Slowly, you take hold of the statue with both hands and lift!");
               Thread.sleep(200);
               GameSystem.read(".........");
               Thread.sleep(200);
               GameSystem.readFast("It's heavy! you barely lifted it off the Pedestal.");
               Thread.sleep(200);
               GameSystem.readFast("....CLICK....");
               Player.modHP(-4);
               if(Player.getHealth() <= 0) {
                Defeat.PlayerDefeat();
		          return;
		         }
               GameSystem.readFast("Fire rained down from above. The heat was intense. As the flames bathed over you, you grit your " +
                  "teeth and threw yourself backward, still holding the Golden Statue. You manage to get out of the fire with the " + 
                  "treasure, but it cost you.");
                  Player.addInventoryItem(GoldenStatue);
                  this.setEventCompleted(true);
                  return;
            }//End choice five
         
            if(choice == 6) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End choice six
         
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End fail choice
            this.Event_Attempts++;
         }//End loop
      }//End first visit
      if(Visits >=1) {
         GameSystem.readFast("The Pedestal is still in the center of the room, and the Golden Statue was still on top of it, " + 
            "its golden shine was alluring.");
         while(loopOut == false) { 
            GameSystem.readFast("What will you do?");
            Thread.sleep(100);
            System.out.println("(1)Examine the area.   (2)Examine the Pedestal.   (3)Examine the Golden Statue.");
            System.out.println("(4)Quickly Grab the Golden Statue.   (5)Carefully Grab the Golden Statue.   (6)Do Nothing.");
            choice = scan.nextInt();
            Thread.sleep(200);
            if(choice == 1) {
               GameSystem.readFast("You look around the room, aside from what you noticed when you entered the room you don't " +
               "notice anything else. You look up, you see more of the same as the rest of the room, with the exception of a series " + 
               "of strange holes perforating the ceiling.");
               Thread.sleep(300);
               continue;
            }//End choice one
            
            if(choice == 2) {
               GameSystem.readFast("You lean forward to get a good look at the Pedestal. It is made of smooth stone and stands " + 
                  "at just barely above your waist. Upon closer inspection you notice a pattern that covers the side of the Pedestal." +
                  "You lean closer to the pattern and can see what look like wings. You take a couple more minutes to carefully examine" +
                  " the whole Pedestal, but you notice nothing else.");
               Thread.sleep(300);
               continue;
            }//End choice two
         
            if(choice == 3) {
               GameSystem.readFast("You slowly walk around the Pedestal to get a good look at the Golden Statue. It looked like a robed " +
                  "woman, the robes flowed over the woman's feet. The craftsmanship was astounding, each crease and fold of the robe was " +
                  "highly detailed, the robe itself look like finely woven cloth, frozen in the midst of a breezy day.");
               GameSystem.readFast("The woman was just as detailed, her hands were clasped together in front of her face" +
                  " as if she was praying. " + 
                  "If you had the time you could count each strand of her hair, it was so realistic it was slightly creepy." +
                  " Her face is frozen in surprise, her eyes - wide open - were different than those of a human, they looked " + 
                  "like a cat's eyes.  Stepping back you can appreciate its beauty from a distance, its size is nothing to " + 
                  "ignore, it is definitly likely to be pretty heavy if it is pure gold.");
               GameSystem.readFast("There is no doubt about it, this Statue is definitly worth a lot.");
               Thread.sleep(300);
               continue;
            }//End choice three
          
            if(choice == 4) {
               GameSystem.readFast("It only took a single moment. You dash forward and leap towards the Golden Statue! " +
                  "In one swift motion you grab the Golden Statue with both arms and bring it close to your body. " + 
                  " The momentum of your leap carries both you and the statue forward. While you are midair you " + 
                  "hear a loud click. As you tumble to the ground, clinging to the statue, you feel a blast of heat on your " + 
                  "back, by the time you look behind you towards the heat's source its over. The ground around the Pedestal is scorched, but the " + 
                  "Pedestal is completely undamaged, in fact it looks pristine.");
               GameSystem.readFast("It looks like you made the right choice, now you have a Golden Statue.");
               Player.addInventoryItem(GoldenStatue);
               this.setEventCompleted(true);
               return;
            }//End choice four
         
            if(choice == 5) {
               GameSystem.readFast("You proceed cautiously, you step forward carefully and reach towards the statue, nothing happens." +
               " Slowly, you take hold of the statue with both hands and lift!");
               Thread.sleep(200);
               GameSystem.read(".........");
               Thread.sleep(200);
               GameSystem.readFast("It's heavy! you barely lifted it off the Pedestal.");
               Thread.sleep(200);
               GameSystem.readFast("....CLICK....");
               Player.modHP(-4);
               if(Player.getHealth() <= 0) {
                Defeat.PlayerDefeat();
		          return;
		         }
               GameSystem.readFast("Fire rained down from above. The heat was intense. As the flames bathed over you, you grit your " +
                  "teeth and threw yourself backward, still holding the Golden Statue. You manage to get out of the fire with the " + 
                  "treasure, but it cost you.");
                  Player.addInventoryItem(GoldenStatue);
                  this.setEventCompleted(true);
                  return;
            }//End choice five
         
            if(choice == 6) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End choice six
         
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End fail choice
            this.Event_Attempts++;
         }//End loop
      }//End later visits
   }//End Method Event_001_GoldenStatue
}