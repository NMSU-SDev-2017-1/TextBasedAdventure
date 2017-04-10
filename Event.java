import java.util.Scanner;

public class Event extends Item {
   private boolean Event_On;
   private boolean Event_Completed;
   private int Event_Number;
   private int Event_Attempts;
   private String Event_Description;
  
   public Event() {
      Event_On = false;
      Event_Completed = false;
      Event_Number = 0;
      Event_Attempts = 0;
      Event_Description = "";
   }//End Constructor 
   
   //Event setters start here
   public void setEventOn(boolean newEventOn) {
      Event_On = newEventOn;
   }//End Method setEventOn
   
   public void setEventCompleted(boolean newEventCompleted) {
      Event_Completed = newEventCompleted;
   }//End Method setEventCompleted 
   
   public void setEventNumber(int newEventNumber) {
      Event_Number = newEventNumber;
   }//End Method setEventNumber
   
   public void setEventAttempts(int newEventAttempts) {
      Event_Attempts = newEventAttempts;
   }//End Method setEventAttempts
   //Event setters end here
   
   //Event getters start here
   public boolean getEventOn() {
      return Event_On;
   }//End Method getEventOn
   
   public boolean getEventCompleted() {
      return Event_Completed;
   }//End Method getEventCompleted
   
   public int getEventNumber() {
      return Event_Number;
   }//End Method getEventNumber
   
   public int getEventAttempts() {
      return Event_Attempts;
   }//End Method getEventAttempts
   //Event getters end here
   
   public void EventInterpreter(int EventNumber, Character Player) throws InterruptedException {
      if(EventNumber == 1) {
         this.Event_001_GoldenStatue(this.getEventAttempts(), Player);
      }
      if(EventNumber == 2) {
         this.Event_002_TreasureChest_Gold(this.getEventAttempts(), Player);
      }
      if(EventNumber == 3) {
         this.Event_003_TreasureChest_RandomWeapon(this.getEventAttempts(), Player);
      }
      if(EventNumber == 4) {
         this.Event_004_TreasureChest_RandomArmor(this.getEventAttempts(), Player);
      }
   }//End Method EventInterpreter
   
   public void EventAssignment(int EventNumber) {
      if(EventNumber == 1) {
         this.setEventNumber(EventNumber);
      }
   }//End Method EventInterprete
   
   public static void ActivateEvent(Event E) {
      E.Event_On = true;
   }
   
   public void Event_001_GoldenStatue(int Visits, Character Player) throws InterruptedException {
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
   
   public void Event_002_TreasureChest_Gold(int Visits, Character Player) throws InterruptedException {
      Thread.sleep(300);
      Scanner scan = new Scanner(System.in);
      int choice;
      int GoldTreasure;
      boolean loopOut;
      boolean attemptedBreak;
      attemptedBreak = false;
      loopOut = false;
      if(this.getEventCompleted() == true) {
         GameSystem.readFast("You look back towards that tiny corner, the chest is still there. It is open, you almost " + 
            "want to look inside again, but you decide against it. You already got your Gold.");
         return;
      }//End event completed check
      if(Visits == 0) {
         GameSystem.readFast("You almost don't see it, but just by chance you notice it - a Tresure Chest! It doesn't look " + 
            "very strong, you might be able to break it open.");
         while(loopOut == false) { 
            GameSystem.readFast("What will you do?");
            Thread.sleep(100);
            System.out.println("(1)Examine the area.   (2)Examine the Treasure Chest.   (3)Try and open the Treasure Chest.");
            System.out.println("(4)Break open the Treasure Chest.   (5)Do Nothing.");
            choice = scan.nextInt();
            Thread.sleep(200);
            if(choice == 1) {
               GameSystem.readFast("You look around the room, aside from what you noticed when you entered the room you don't " +
               "notice anything else. Even around the Treasure Chest there is nothing suspicious.");
               Thread.sleep(300);
               continue;
            }//End choice one
            
            if(choice == 2) {
               GameSystem.readFast("You take a step forward and get a good look at the Treasure Chest. It's not very high quality, " + 
                  "the chest is made of wood with banded iron around it. The chest is locked with a large, iron padlock.");
               if(KeyItem.hasKeyItem("Iron Key", Player) == true)
                  GameSystem.readFast("You might have a key...");
               else
                  GameSystem.readFast("You should find a key...");
               Thread.sleep(300);
               continue;
            }//End choice two
         
            if(choice == 3) {
               GameSystem.readFast("You crouch down and examine the padlock.");
               Thread.sleep(200);
               GameSystem.read("..........");
               Thread.sleep(200);
               if(KeyItem.hasKeyItem("Iron Key", Player) == true) {
                  GameSystem.readFast("You are positive you have the key for this lock, you reach into your pouch and pull out an " +
                     "Iron Key. You slowly insert the key into the lock");
                  Thread.sleep(200);
                  GameSystem.readFast("...CLICK...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest is unlocked! Eagerly you opened the chest and looked inside.");
                  Thread.sleep(200);
                  GoldTreasure = (int)(Math.random() * (300 - 100) + 100);
                  GameSystem.readFast(Player.getPlayerID() + " Gained " + GoldTreasure + " Gold Coins!");
                  this.setEventCompleted(true);
                  return;
               }//End open with key.
               else {
                  GameSystem.readFast("You don't have a key for this Treasure Chest. You might be able to break it open.");
               }//End fail to open with no key
               continue;
            }//End choice three
          
            if(choice == 4) {
               if(attemptedBreak == false) {
               if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  GoldTreasure = (int)(Math.random() * (300 - 100) + 100);
                  GameSystem.readFast(Player.getPlayerID() + " Gained " + GoldTreasure + " Gold Coins!");
                  this.setEventCompleted(true);
                  return;
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
                  continue;
               }
               }//End AttemptedBreak
               else {//Attempted to break the chest, and failed.
                  GameSystem.readFast("Maybe you can break it this time?");
                  Thread.sleep(300);
                  if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  GoldTreasure = (int)(Math.random() * (300 - 100) + 100);
                  GameSystem.readFast(Player.getPlayerID() + " Gained " + GoldTreasure + " Gold Coins!");
                  this.setEventCompleted(true);
                  return;
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
               }
               GameSystem.read("......");
               continue;
               }
            }//End choice four
         
            if(choice == 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End choice five
         
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End fail choice
            this.Event_Attempts++;
         }//End loop
      }//End first visit
      if(Visits >=1) {
         GameSystem.readFast("You look towards the corner, the Treasure Chest is still there. It looks undisturbed.");
         while(loopOut == false) { 
            GameSystem.readFast("What will you do?");
            Thread.sleep(100);
            System.out.println("(1)Examine the area.   (2)Examine the Treasure Chest.   (3)Try and open the Treasure Chest.");
            System.out.println("(4)Break open the Treasure Chest.   (5)Do Nothing.");
            choice = scan.nextInt();
            Thread.sleep(200);
            if(choice == 1) {
               GameSystem.readFast("You look around the room, aside from what you noticed when you entered the room you don't " +
               "notice anything else. Even around the Treasure Chest there is nothing suspicious.");
               Thread.sleep(300);
               continue;
            }//End choice one
            
            if(choice == 2) {
               GameSystem.readFast("You take a step forward and get a good look at the Treasure Chest. It's not very high quality, " + 
                  "the chest is made of wood with banded iron around it. The chest is locked with a large, iron padlock.");
               if(KeyItem.hasKeyItem("Iron Key", Player) == true)
                  GameSystem.readFast("You might have a key...");
               else
                  GameSystem.readFast("You should find a key...");
               Thread.sleep(300);
               continue;
            }//End choice two
         
            if(choice == 3) {
               GameSystem.readFast("You crouch down and examine the padlock.");
               Thread.sleep(200);
               GameSystem.read("..........");
               Thread.sleep(200);
               if(KeyItem.hasKeyItem("Iron Key", Player) == true) {
                  GameSystem.readFast("You are positive you have the key for this lock, you reach into your pouch and pull out an " +
                     "Iron Key. You slowly insert the key into the lock");
                  Thread.sleep(200);
                  GameSystem.readFast("...CLICK...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest is unlocked! Eagerly you opened the chest and looked inside.");
                  Thread.sleep(200);
                  GoldTreasure = (int)(Math.random() * (300 - 100) + 100);
                  GameSystem.readFast(Player.getPlayerID() + " Gained " + GoldTreasure + " Gold Coins!");
                  this.setEventCompleted(true);
                  return;
               }//End open with key.
               else {
                  GameSystem.readFast("You don't have a key for this Treasure Chest. You might be able to break it open.");
               }//End fail to open with no key
               continue;
            }//End choice three
          
            if(choice == 4) {
               if(attemptedBreak == false) {
               if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  GoldTreasure = (int)(Math.random() * (300 - 100) + 100);
                  GameSystem.readFast(Player.getPlayerID() + " Gained " + GoldTreasure + " Gold Coins!");
                  this.setEventCompleted(true);
                  return;
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
                  continue;
               }
               }//End AttemptedBreak
               else {//Attempted to break the chest, and failed.
                  GameSystem.readFast("Maybe you can break it this time?");
                  Thread.sleep(300);
                  if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  GoldTreasure = (int)(Math.random() * (300 - 100) + 100);
                  GameSystem.readFast(Player.getPlayerID() + " Gained " + GoldTreasure + " Gold Coins!");
                  this.setEventCompleted(true);
                  return;
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
               }
               GameSystem.read("......");
               continue;
               }
            }//End choice four
         
            if(choice == 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End choice five
         
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End fail choice
            this.Event_Attempts++;
         }//End loop      
      }//End later visits
   }//End Method Event_002_TreasureChest_Gold
   
   public void Event_003_TreasureChest_RandomWeapon(int Visits, Character Player) throws InterruptedException {
      Thread.sleep(300);
      Scanner scan = new Scanner(System.in);
      int choice;
      int WeaponType; //1 = Iron Sword : 2 = Iron Bow & Arrows : 3 = Iron Dagger : 4 = Iron Mace
      boolean loopOut;
      boolean attemptedBreak;
      attemptedBreak = false;
      loopOut = false;
      if(this.getEventCompleted() == true) {
         GameSystem.readFast("You look back towards that tiny corner, the chest is still there. It is open, you almost " + 
            "want to look inside again, but you decide against it. You already got your Weapon.");
         return;
      }//End event completed check
      if(Visits == 0) {
         GameSystem.readFast("You almost don't see it, but just by chance you notice it - a Tresure Chest! It doesn't look " + 
            "very strong, you might be able to break it open.");
         while(loopOut == false) { 
            GameSystem.readFast("What will you do?");
            Thread.sleep(100);
            System.out.println("(1)Examine the area.   (2)Examine the Treasure Chest.   (3)Try and open the Treasure Chest.");
            System.out.println("(4)Break open the Treasure Chest.   (5)Do Nothing.");
            choice = scan.nextInt();
            Thread.sleep(200);
            if(choice == 1) {
               GameSystem.readFast("You look around the room, aside from what you noticed when you entered the room you don't " +
               "notice anything else. Even around the Treasure Chest there is nothing suspicious.");
               Thread.sleep(300);
               continue;
            }//End choice one
            
            if(choice == 2) {
               GameSystem.readFast("You take a step forward and get a good look at the Treasure Chest. It's not very high quality, " + 
                  "the chest is made of wood with banded iron around it. The chest is locked with a large, iron padlock.");
               if(KeyItem.hasKeyItem("Iron Key", Player) == true)
                  GameSystem.readFast("You might have a key...");
               else
                  GameSystem.readFast("You should find a key...");
               Thread.sleep(300);
               continue;
            }//End choice two
         
            if(choice == 3) {
               GameSystem.readFast("You crouch down and examine the padlock.");
               Thread.sleep(200);
               GameSystem.read("..........");
               Thread.sleep(200);
               if(KeyItem.hasKeyItem("Iron Key", Player) == true) {
                  GameSystem.readFast("You are positive you have the key for this lock, you reach into your pouch and pull out an " +
                     "Iron Key. You slowly insert the key into the lock");
                  Thread.sleep(200);
                  GameSystem.readFast("...CLICK...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest is unlocked! Eagerly you opened the chest and looked inside.");
                  Thread.sleep(200);
                  WeaponType = (int)(Math.random() * (5-1) + 1);                  
                  if(WeaponType == 1) {
                     Equipment IronSword = new Equipment("Iron Sword", 2, 150, 0, 3, 0, 0, "P",
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronMace.getItemName() + "!");
                     Player.addInventoryItem(IronMace);
                     this.setEventCompleted(true);
                     return;
                  }
                 
               }//End open with key.
               else {
                  GameSystem.readFast("You don't have a key for this Treasure Chest. You might be able to break it open.");
               }//End fail to open with no key
               continue;
            }//End choice three
          
            if(choice == 4) {
               if(attemptedBreak == false) {
               if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  WeaponType = (int)(Math.random() * (5-1) + 1);                  
                  if(WeaponType == 1) {
                     Equipment IronSword = new Equipment("Iron Sword", 2, 150, 0, 3, 0, 0, "P",
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronMace.getItemName() + "!");
                     Player.addInventoryItem(IronMace);
                     this.setEventCompleted(true);
                     return;
                  }
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
                  continue;
               }
               }//End AttemptedBreak
               else {//Attempted to break the chest, and failed.
                  GameSystem.readFast("Maybe you can break it this time?");
                  Thread.sleep(300);
                  if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  WeaponType = (int)(Math.random() * (5-1) + 1);                  
                  if(WeaponType == 1) {
                     Equipment IronSword = new Equipment("Iron Sword", 2, 150, 0, 3, 0, 0, "P",
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronMace.getItemName() + "!");
                     Player.addInventoryItem(IronMace);
                     this.setEventCompleted(true);
                     return;
                  }
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
               }
               GameSystem.read("......");
               continue;
               }
            }//End choice four
         
            if(choice == 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End choice five
         
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End fail choice
            this.Event_Attempts++;
         }//End loop
      }//End first visit
      if(Visits >=1) {
         GameSystem.readFast("You look towards the corner, the Treasure Chest is still there. It looks undisturbed.");
         while(loopOut == false) { 
            GameSystem.readFast("What will you do?");
            Thread.sleep(100);
            System.out.println("(1)Examine the area.   (2)Examine the Treasure Chest.   (3)Try and open the Treasure Chest.");
            System.out.println("(4)Break open the Treasure Chest.   (5)Do Nothing.");
            choice = scan.nextInt();
            Thread.sleep(200);
            if(choice == 1) {
               GameSystem.readFast("You look around the room, aside from what you noticed when you entered the room you don't " +
               "notice anything else. Even around the Treasure Chest there is nothing suspicious.");
               Thread.sleep(300);
               continue;
            }//End choice one
            
            if(choice == 2) {
               GameSystem.readFast("You take a step forward and get a good look at the Treasure Chest. It's not very high quality, " + 
                  "the chest is made of wood with banded iron around it. The chest is locked with a large, iron padlock.");
               if(KeyItem.hasKeyItem("Iron Key", Player) == true)
                  GameSystem.readFast("You might have a key...");
               else
                  GameSystem.readFast("You should find a key...");
               Thread.sleep(300);
               continue;
            }//End choice two
         
            if(choice == 3) {
               GameSystem.readFast("You crouch down and examine the padlock.");
               Thread.sleep(200);
               GameSystem.read("..........");
               Thread.sleep(200);
               if(KeyItem.hasKeyItem("Iron Key", Player) == true) {
                  GameSystem.readFast("You are positive you have the key for this lock, you reach into your pouch and pull out an " +
                     "Iron Key. You slowly insert the key into the lock");
                  Thread.sleep(200);
                  GameSystem.readFast("...CLICK...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest is unlocked! Eagerly you opened the chest and looked inside.");
                  Thread.sleep(200);
                  WeaponType = (int)(Math.random() * (5-1) + 1);                  
                  if(WeaponType == 1) {
                     Equipment IronSword = new Equipment("Iron Sword", 2, 150, 0, 3, 0, 0, "P",
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronMace.getItemName() + "!");
                     Player.addInventoryItem(IronMace);
                     this.setEventCompleted(true);
                     return;
                  }
               }//End open with key.
               else {
                  GameSystem.readFast("You don't have a key for this Treasure Chest. You might be able to break it open.");
               }//End fail to open with no key
               continue;
            }//End choice three
          
            if(choice == 4) {
               if(attemptedBreak == false) {
               if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  WeaponType = (int)(Math.random() * (5-1) + 1);                  
                  if(WeaponType == 1) {
                     Equipment IronSword = new Equipment("Iron Sword", 2, 150, 0, 3, 0, 0, "P",
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronMace.getItemName() + "!");
                     Player.addInventoryItem(IronMace);
                     this.setEventCompleted(true);
                     return;
                  }
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
                  continue;
               }
               }//End AttemptedBreak
               else {//Attempted to break the chest, and failed.
                  GameSystem.readFast("Maybe you can break it this time?");
                  Thread.sleep(300);
                  if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  WeaponType = (int)(Math.random() * (5-1) + 1);                  
                  if(WeaponType == 1) {
                     Equipment IronSword = new Equipment("Iron Sword", 2, 150, 0, 3, 0, 0, "P",
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronMace.getItemName() + "!");
                     Player.addInventoryItem(IronMace);
                     this.setEventCompleted(true);
                     return;
                  }
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
               }
               GameSystem.read("......");
               continue;
               }
            }//End choice four
         
            if(choice == 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End choice five
         
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End fail choice
            this.Event_Attempts++;
         }//End loop      
      }//End later visits
   }//End Method Event_003_TreasureChest_RandomWeapon
   
   public void Event_004_TreasureChest_RandomArmor(int Visits, Character Player) throws InterruptedException {
      Thread.sleep(300);
      Scanner scan = new Scanner(System.in);
      int choice;
      int ArmorType; //1 = Iron Helmet : 2 = Iron Chainmail : 3 = Iron Armguards : 4 = Iron Cuisses
      boolean loopOut;
      boolean attemptedBreak;
      attemptedBreak = false;
      loopOut = false;
      if(this.getEventCompleted() == true) {
         GameSystem.readFast("You look back towards that tiny corner, the chest is still there. It is open, you almost " + 
            "want to look inside again, but you decide against it. You already got your Armor.");
         return;
      }//End event completed check
      if(Visits == 0) {
         GameSystem.readFast("You almost don't see it, but just by chance you notice it - a Tresure Chest! It doesn't look " + 
            "very strong, you might be able to break it open.");
         while(loopOut == false) { 
            GameSystem.readFast("What will you do?");
            Thread.sleep(100);
            System.out.println("(1)Examine the area.   (2)Examine the Treasure Chest.   (3)Try and open the Treasure Chest.");
            System.out.println("(4)Break open the Treasure Chest.   (5)Do Nothing.");
            choice = scan.nextInt();
            Thread.sleep(200);
            if(choice == 1) {
               GameSystem.readFast("You look around the room, aside from what you noticed when you entered the room you don't " +
               "notice anything else. Even around the Treasure Chest there is nothing suspicious.");
               Thread.sleep(300);
               continue;
            }//End choice one
            
            if(choice == 2) {
               GameSystem.readFast("You take a step forward and get a good look at the Treasure Chest. It's not very high quality, " + 
                  "the chest is made of wood with banded iron around it. The chest is locked with a large, iron padlock.");
               if(KeyItem.hasKeyItem("Iron Key", Player) == true)
                  GameSystem.readFast("You might have a key...");
               else
                  GameSystem.readFast("You should find a key...");
               Thread.sleep(300);
               continue;
            }//End choice two
         
            if(choice == 3) {
               GameSystem.readFast("You crouch down and examine the padlock.");
               Thread.sleep(200);
               GameSystem.read("..........");
               Thread.sleep(200);
               if(KeyItem.hasKeyItem("Iron Key", Player) == true) {
                  GameSystem.readFast("You are positive you have the key for this lock, you reach into your pouch and pull out an " +
                     "Iron Key. You slowly insert the key into the lock");
                  Thread.sleep(200);
                  GameSystem.readFast("...CLICK...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest is unlocked! Eagerly you opened the chest and looked inside.");
                  Thread.sleep(200);
                  ArmorType = (int)(Math.random() * (5-1) + 1);                  
                  if(ArmorType == 1) {
                     Equipment IronHelmet = new Equipment("Iron Helmet", 2, 150, 0, 0, 2, 0, "H",
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronCuisses.getItemName() + "!");
                     Player.addInventoryItem(IronCuisses);
                     this.setEventCompleted(true);
                     return;
                  }
                 
               }//End open with key.
               else {
                  GameSystem.readFast("You don't have a key for this Treasure Chest. You might be able to break it open.");
               }//End fail to open with no key
               continue;
            }//End choice three
          
            if(choice == 4) {
               if(attemptedBreak == false) {
               if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  ArmorType = (int)(Math.random() * (5-1) + 1);                  
                  if(ArmorType == 1) {
                     Equipment IronHelmet = new Equipment("Iron Helmet", 2, 150, 0, 0, 2, 0, "H",
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronCuisses.getItemName() + "!");
                     Player.addInventoryItem(IronCuisses);
                     this.setEventCompleted(true);
                     return;
                  }
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
                  continue;
               }
               }//End AttemptedBreak
               else {//Attempted to break the chest, and failed.
                  GameSystem.readFast("Maybe you can break it this time?");
                  Thread.sleep(300);
                  if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  ArmorType = (int)(Math.random() * (5-1) + 1);                  
                  if(ArmorType == 1) {
                     Equipment IronHelmet = new Equipment("Iron Helmet", 2, 150, 0, 0, 2, 0, "H",
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronCuisses.getItemName() + "!");
                     Player.addInventoryItem(IronCuisses);
                     this.setEventCompleted(true);
                     return;
                  }
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
               }
               GameSystem.read("......");
               continue;
               }
            }//End choice four
         
            if(choice == 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End choice five
         
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End fail choice
            this.Event_Attempts++;
         }//End loop
      }//End first visit
      if(Visits >=1) {
         GameSystem.readFast("You look towards the corner, the Treasure Chest is still there. It looks undisturbed.");
         while(loopOut == false) { 
            GameSystem.readFast("What will you do?");
            Thread.sleep(100);
            System.out.println("(1)Examine the area.   (2)Examine the Treasure Chest.   (3)Try and open the Treasure Chest.");
            System.out.println("(4)Break open the Treasure Chest.   (5)Do Nothing.");
            choice = scan.nextInt();
            Thread.sleep(200);
            if(choice == 1) {
               GameSystem.readFast("You look around the room, aside from what you noticed when you entered the room you don't " +
               "notice anything else. Even around the Treasure Chest there is nothing suspicious.");
               Thread.sleep(300);
               continue;
            }//End choice one
            
            if(choice == 2) {
               GameSystem.readFast("You take a step forward and get a good look at the Treasure Chest. It's not very high quality, " + 
                  "the chest is made of wood with banded iron around it. The chest is locked with a large, iron padlock.");
               if(KeyItem.hasKeyItem("Iron Key", Player) == true)
                  GameSystem.readFast("You might have a key...");
               else
                  GameSystem.readFast("You should find a key...");
               Thread.sleep(300);
               continue;
            }//End choice two
         
            if(choice == 3) {
               GameSystem.readFast("You crouch down and examine the padlock.");
               Thread.sleep(200);
               GameSystem.read("..........");
               Thread.sleep(200);
               if(KeyItem.hasKeyItem("Iron Key", Player) == true) {
                  GameSystem.readFast("You are positive you have the key for this lock, you reach into your pouch and pull out an " +
                     "Iron Key. You slowly insert the key into the lock");
                  Thread.sleep(200);
                  GameSystem.readFast("...CLICK...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest is unlocked! Eagerly you opened the chest and looked inside.");
                  Thread.sleep(200);
                  ArmorType = (int)(Math.random() * (5-1) + 1);                  
                  if(ArmorType == 1) {
                     Equipment IronHelmet = new Equipment("Iron Helmet", 2, 150, 0, 0, 2, 0, "H",
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronCuisses.getItemName() + "!");
                     Player.addInventoryItem(IronCuisses);
                     this.setEventCompleted(true);
                     return;
                  }
               }//End open with key.
               else {
                  GameSystem.readFast("You don't have a key for this Treasure Chest. You might be able to break it open.");
               }//End fail to open with no key
               continue;
            }//End choice three
          
            if(choice == 4) {
               if(attemptedBreak == false) {
               if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  ArmorType = (int)(Math.random() * (5-1) + 1);                  
                  if(ArmorType == 1) {
                     Equipment IronHelmet = new Equipment("Iron Helmet", 2, 150, 0, 0, 2, 0, "H",
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronCuisses.getItemName() + "!");
                     Player.addInventoryItem(IronCuisses);
                     this.setEventCompleted(true);
                     return;
                  }
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
                  continue;
               }
               }//End AttemptedBreak
               else {//Attempted to break the chest, and failed.
                  GameSystem.readFast("Maybe you can break it this time?");
                  Thread.sleep(300);
                  if(Player.getAttack() >= 8) {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("The Treasure Chest broke open! Eagerly you throw the chest's remnants aside and look " + 
                     "for your spoils.");
                  Thread.sleep(200);
                  ArmorType = (int)(Math.random() * (5-1) + 1);                  
                  if(ArmorType == 1) {
                     Equipment IronHelmet = new Equipment("Iron Helmet", 2, 150, 0, 0, 2, 0, "H",
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronCuisses.getItemName() + "!");
                     Player.addInventoryItem(IronCuisses);
                     this.setEventCompleted(true);
                     return;
                  }
               }
               else {
                  GameSystem.readFast("You decide to trust your strength over the Treasure Chest's durability. " + 
                     "You brace yourself and prepare a heavy kick.");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(200);
                  GameSystem.readFast("...CRASH...");
                  Thread.sleep(500);
                  GameSystem.read("......");
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-4);
                  attemptedBreak = true;
               }
               GameSystem.read("......");
               continue;
               }
            }//End choice four
         
            if(choice == 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End choice five
         
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
               GameSystem.readFast("You decide to do nothing for now.");
               this.setEventAttempts(Visits+1);
               return;
            }//End fail choice
            this.Event_Attempts++;
         }//End loop      
      }//End later visits
   }//End Method Event_004_TreasureChest_RandomArmor
   
   public void Event_005_MonsterBattle_Skeleton(int Visits, Character Player) throws InterruptedException {
      Thread.sleep(300);
      Scanner scan = new Scanner(System.in);
      int choice;
      int battleType;
      boolean loopOut;


      loopOut = false;
      if(this.getEventCompleted() == true) {
         GameSystem.readFast("You look back towards that tiny corner, the chest is still there. It is open, you almost " + 
            "want to look inside again, but you decide against it. You already got your Weapon.");
         return;
      }//End event completed check
      if(Visits == 0) {
         battleType = (int)(Math.random() * (4-1) + 1);
         battleType = battleType * Player.getLuck();
         if(battleType >= 15 && battleType <= 35) {
            GameSystem.readFast("Skchchchchchchchchchc");
            Thread.sleep(200);
            GameSystem.readFast("You look towards the sound. A Skeleton is marching towards you, its bones rattling with every " + 
               "step it took. Your eyes meet empty sockets and you prepare to fight...");
         }
         if(battleType > 35) {
            GameSystem.readFast("Skchchchchchchchchchc");
            Thread.sleep(400);
            GameSystem.readFast("You look towards the sound. A Skeleton is pacing aimlessly back and forth, " + 
               "its bones rattling with every step it took. It doesn't look like it's guarding anything, but you can't be sure.");
         }
         if(battleType < 15) {
            GameSystem.readFast("Skchchchchchchchchchc");
            Thread.sleep(100);
            GameSystem.readFast("Before you can react to the noise, a sharp pain pierces your side. You grit your teeth and fling " + 
               "yourself away from the source of the pain. Quickly you turn, and you are greeted with a Skeleton leaping towards you, " + 
               "Your eyes meet lifeless sockets and you prepare to fight.");
         }
      }
   }//End Method Event_005_MonsterBattle_Skeleton
   
   
}//End Class Event