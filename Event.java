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
   
   public void EventInterpreter(int EventNumber, Character Player, Maze.Node C) throws InterruptedException {
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
      if(EventNumber == 5) {
         this.Event_005_MonsterBattle_Skeleton(this.getEventAttempts(), Player);
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
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
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1, 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1, 4);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1, 3);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1, 6);
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
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1, 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1, 4);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1, 3);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1, 6);
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
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
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1, 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1, 4);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1, 3);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1, 6);
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
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
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1, 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1, 4);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1, 3);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1, 6);
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
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1, 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1, 4);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1, 3);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1, 6);
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
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
                     "A solid Iron Sword, it isn't of very high quality, but it will get the job done.  ATTACK +3", 1, 1);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronSword.getItemName() + "!");
                     Player.addInventoryItem(IronSword);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(WeaponType == 2) {
                     Equipment IronBowAndArrows = new Equipment("Iron Bow & Arrows", 2, 200, 0, 2, 0, 0, "P",
                     "An Iron Bow & Arrows, it isn't of very high quality, but it gets the job done, from a range.  ATTACK +2", 1, 4);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronBowAndArrows.getItemName() + "!");
                     Player.addInventoryItem(IronBowAndArrows);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 3) {
                     Equipment IronDagger = new Equipment("Iron Dagger", 2, 100, 0, 2, 0, 3, "P",
                     "A small Iron Dagger, it isn't very high quality, but it might be useful.  ATTACK +2 : LUCK +3", 1, 3);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronDagger.getItemName() + "!");
                     Player.addInventoryItem(IronDagger);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(WeaponType == 4) {
                     Equipment IronMace = new Equipment("Iron Mace", 3, 200, 0, 5, -2, 0, "P",
                     "A heavy Iron Mace, it isn't very high quality, but its weight will definitly add to its power.  ATTACK +5 : DEFENSE -2", 1, 6);
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
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
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1, 0);
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
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1, 0);
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
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
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1, 0);
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
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
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1, 0);
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
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1, 0);
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
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
                     "A solid Iron Helmet, it isn't of very high quality, but it looks sturdy enough.  DEF +3", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronHelmet.getItemName() + "!");
                     Player.addInventoryItem(IronHelmet);
                     this.setEventCompleted(true);
                     return;
                  }
                  if(ArmorType == 2) {
                     Equipment IronChainmail = new Equipment("Iron Chainmail", 2, 300, 0, 0, 4, 0, "T",
                     "A solid suit of Iron Chainmail, it isn't of very high quality, but it looks sturdy enough.  DEFENSE +4", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronChainmail.getItemName() + "!");
                     Player.addInventoryItem(IronChainmail);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 3) {
                     Equipment IronArmguards = new Equipment("Iron Armguards", 2, 150, 0, 0, 2, 0, "P",
                     "A couple of Iron Armguards, they aren't of very high quality, they look sturdy enough.  DEFENSE +2", 1, 0);
                     GameSystem.readFast(Player.getPlayerID() + " Gained: " + IronArmguards.getItemName() + "!");
                     Player.addInventoryItem(IronArmguards);
                     this.setEventCompleted(true);
                     return;
                  }
                  
                  if(ArmorType == 4) {
                     Equipment IronCuisses = new Equipment("Iron Cuisses", 2, 200, 0, 0, 2, 0, "P",
                     "A couple of Iron Cuisses, they aren't of very high quality, but they look sturdy enough.  DEFENSE +2", 1, 0);
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
                  Player.modHP(-2);
                  if(Player.getHealth() <= 0) {
                     Defeat.PlayerDefeat();
		               return;
		            }
                  GameSystem.readFast("The Treasure Chest was tougher than it looked, and judging by the sharp pain in your foot" + 
                  "not only did you fail to break the chest, you also injured yourself.");
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
      String choice;
      int battleType;
      
      Skeleton MrBones = new Skeleton();
      
      if(this.getEventCompleted() == true) {
         GameSystem.readFast("You smell it before you see it; a dusty aroma that is hanging in the air. You look towards its source " + 
            "and identify a pile of bones, the remains of the Skeleton you 'killed' earlier. Maybe there is more to loot?");
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
            MrBones.print();
            Thread.sleep(500);
            Combat.standardCombat(MrBones, Player);
            this.setEventCompleted(true);
            return;
         }
         if(battleType > 35) {
            GameSystem.readFast("Skchchchchchchchchchc");
            Thread.sleep(400);
            GameSystem.readFast("You look towards the sound. A Skeleton is pacing aimlessly back and forth, " + 
               "its bones rattling with every step it took. It doesn't look like it's guarding anything, but you can't be sure.");
            MrBones.print();
            Thread.sleep(500);
            System.out.println("(1)Sneak attack.   (2)Try and sneak past the Skeleton.");
            choice = scan.next();
            Thread.sleep(300);
            if(choice == "1") {
               GameSystem.readFast("You might not get another opportunity like this - You decide to attack.");
               Thread.sleep(500);
               GameSystem.read("..........");
               Thread.sleep(500);
               GameSystem.read("You take a step.");
               Thread.sleep(500);
               GameSystem.read("..........");
               Thread.sleep(500);
               GameSystem.read("You take another step.");
               Thread.sleep(500);
               GameSystem.read("..........");
               Thread.sleep(500);
               GameSystem.read("You attack! The Skeleton somehow managed to look more surprised than its empty sockets already did.");
               Thread.sleep(300);
               Combat.advantageCombat(MrBones, Player);
               this.setEventCompleted(true);
               return;
            }
            if(choice == "2") {
               GameSystem.readFast("You decide you don't want to fight the Skeleton right now. Slowly you take a step.");
               Thread.sleep(500);
               GameSystem.read("..........");
               Thread.sleep(500);
               GameSystem.read("You take another step.");
               GameSystem.read("......CRUNCH.");
               Thread.sleep(400);
               GameSystem.readFast("You stepped on a bone! The Skeleton's head snapped towards your direction. Despite its lack of " + 
                  "muscles, it manages to charge towards you faster than you thought possible for a bone-man (woman?).");
               Thread.sleep(300);
               GameSystem.read("It looks like you are going to have to fight.");
               Thread.sleep(300);
               Combat.standardCombat(MrBones, Player);
               this.setEventCompleted(true);
               return;
            }
            if(!choice.equals("1") && !choice.equals("2")) {
               GameSystem.readFast("SKRCHCHCHCHCCHCHCHC!");
               Thread.sleep(500);
               GameSystem.read("Before you can make a decision, the Skeleton made it for you. It charges towards you at an incredible " + 
                  "speed. You adjust yourself and prepare to battle.");
               Thread.sleep(500);
               GameSystem.read("But as you are readjusting your stance your footing becomes unsteady due to stepping on uneaven ground!.");
               Thread.sleep(300);
               GameSystem.read("The Skeleton did not hesitate to capitalize on your misfortune. As it attacks you brace yourself..");
               Thread.sleep(300);
               Combat.advantageMonsterCombat(MrBones, Player);
               this.setEventCompleted(true);
               return;
            }
         }
         if(battleType < 15) {
            GameSystem.readFast("Skchchchchchchchchchc");
            Thread.sleep(100);
            GameSystem.readFast("Before you can react to the noise, a sharp pain pierces your side. You grit your teeth and fling " + 
               "yourself away from the source of the pain. Quickly you turn, and you are greeted with a Skeleton leaping towards you, " + 
               "Your eyes meet lifeless sockets and you prepare to fight.");
            Player.modHP(-3);
            if(Player.getHealth() <= 0) {
                Defeat.PlayerDefeat();
		          return;
		      }
            GameSystem.read("You enter battle injured.");
            MrBones.print();
            Thread.sleep(500);
            Combat.standardCombat(MrBones, Player);
            this.setEventCompleted(true);
            return;
         }
      }
   }//End Method Event_005_MonsterBattle_Skeleton
   
   public void Event_006_FallingRocks(int Visits, Character Player, Maze.Node C) throws InterruptedException {
      
      if(this.getEventCompleted() == true) {
         GameSystem.readFast("You can see a large pile of rocks, the remains of what almost killed you. " +
            "You take special care to avoid going near it.");
         return;   
      }
      
      Scanner scan = new Scanner(System.in);
      String choice;
      String choice2, lookedChoice;
      
      System.out.println();
      System.out.println("What will you do?");
      
      if(C.north != null) {
         if(C.direction == 1)  
            System.out.printf("\n(1)You can go straight, ");
         if(C.direction == 2)
            System.out.printf("\n(4)You can go left, ");
         if(C.direction == 3)
            System.out.printf("\n(3)You can go back, ");
         if(C.direction == 4)
            System.out.printf("\n(2)You can go right, ");
      }
         
      if(C.east != null) {
         if(C.direction == 1)
            System.out.printf("(2)you can go right, ");
         if(C.direction == 2)
            System.out.printf("(1)you can go straight, ");
         if(C.direction == 3)
            System.out.printf("(4)you can go left, ");
         if(C.direction == 4)
            System.out.printf("(3)you can go back, ");
      }
      
      if(C.south != null) {
         if(C.direction == 1)
            System.out.printf("(3)you can go back, ");
         if(C.direction == 2)
            System.out.printf("(2)you can go right, ");
         if(C.direction == 3)
            System.out.printf("(1)you can go straight, ");
         if(C.direction == 4)
            System.out.printf("(4)you can go left, ");
      }

      if(C.west != null) {
         if(C.direction == 1)
            System.out.printf("(4)you can go left,");
         if(C.direction == 2)
            System.out.printf("(3)you can go back, ");
         if(C.direction == 3)
            System.out.printf("(2)you can go right, ");
         if(C.direction == 4)
            System.out.printf("(1)you can go straight, ");
      }
      
      choice = scan.nextLine();
      
      Thread.sleep(400);
      
      GameSystem.readFast("You take a couple steps, suddenly you hear a loud rumble. The ground shakes, knocking you off balance " + 
         "and causing you to stumble. As the ground shakes you look up, purely by chance, and you see the ceiling collapse! " + 
         "Large rocks fall, there isn't much time for you to make a choice.");
      Thread.sleep(300);
      GameSystem.readFast("You could take a chance and look around for cover, but you aren't sure if you have time for that. " +
         "You could brace yourself and hope that the heavy rocks don't land on you. You could jump to safety, but where would it " + 
         "it be safe to jump? All you can see right now is what is right in front of you, which unfortunately doesn't have cover, " + 
         "but maybe the rocks won't fall there.");
      Thread.sleep(400);
      System.out.println("(1)Look for cover.   (2)Brace yourself.   (3)Dive to your left.");
      System.out.println("(4)Dive to your right.   (5)Leap back.   (6)Leap forwards.");
      choice2 = scan.nextLine();
      Thread.sleep(400);
      if(choice2.equals("1")) {
         String choice3;
         GameSystem.readFast("There isn't much time, you decide to look for cover.");
         Thread.sleep(400);
         System.out.println("(1)Look left.   (2)Look right.   (3)Look behind you.");
         choice3 = scan.nextLine();
         boolean lookleft, lookright, lookbehind;
         lookleft = lookright = lookbehind = false;
         Thread.sleep(400);
         if(choice3.equals("1")) {
            GameSystem.readFast("You quickly look to your left. You can see a Large Stone Slab leaning against the wall, " + 
               "it looks sturdy. The ground leading up to the Slab is uneven and several rocks are jutting from the ground.");
            lookleft = true;
         }
         if(choice3.equals("2")) {
            GameSystem.readFast("You quickly look to your right. The wall to your right has partially collapsed, leaving " + 
               "little room to maneuver.");
            lookright = true;
         }
         if(choice3.equals("3")) {
            GameSystem.readFast("You quickly look behind you. You see the reason you lost your balance, the ground you are " + 
               "standing on has risen, you don't know how far you will have to fall if you jump back, but it could save you " + 
               "from the rocks falling right now.");
            lookbehind = true;
         }
         if(!choice3.equals("1") && !choice3.equals("2") && !choice3.equals("3")) {
            GameSystem.read("You are frozen in fear. Rocks crash down upon you, without even making a sound you are buried.");
            Defeat.PlayerDefeat();
		      return;
         }
         Thread.sleep(300);
         System.out.println("(1)Brace yourself.   (2)Dodge to your left.   (3)Dodge to your right.");
         System.out.println("(4)Leap back.   (5)Leap forwards.");
         lookedChoice = scan.nextLine();
         Thread.sleep(400);
         if(lookedChoice.equals("1")) {
            GameSystem.readFast("You decide that you didn't like what you saw. You barely have time to readjust your footing and " + 
               "raise your arms. You hear several large rocks crash on the ground around you.");
            Thread.sleep(300);
            GameSystem.read("Then the rocks crashed onto you.");
            Thread.sleep(300);
            GameSystem.readFast("The first one to hit was the size of your head - with one arm you bash it away.");
            GameSystem.readFast("The second one was much larger, you grunt as the weight crashes against you. Your your stance " + 
               "crumbles as more rocks land on you burying you under their weight.");
            Thread.sleep(500);
            int damage;
            damage = 10 - Player.getDefense();
            if(damage <= 0)
               damage = 1;
            Player.modHP(-damage);
            if(Player.getHealth() <= 0) {
               GameSystem.read("............");
               Thread.sleep(500);
               Defeat.PlayerDefeat();
            }
            else {
               GameSystem.read("You can barely move, the weight is crushing the air from your lungs. You slowly shift your weight " + 
                  "to your right foot, and you manage to reposition your left foot.");
               Thread.sleep(300);
               GameSystem.read("The rocks are still crushing you, but you manage to take a shallow breath as you prepare to escape. " +
                  "You use your legs and push upwards. Most of the smaller rocks are pressing against you, and it doesn't look like " +
                  "you are in danger of them crushing you further, as you push your way out.");
               Thread.sleep(300);
               GameSystem.read("With a heave you push the largest rock off of you. As you do, smaller rocks fall down and serve as " + 
                  "unsteady footholds for you as you slowly crawled out.");
               Thread.sleep(400);
               this.setEventCompleted(true);
               return;
            }
         }
         if(lookedChoice.equals("2")) {
            if(lookleft == true) {
               GameSystem.readFast("You decide that you would rather take cover than risk getting burried alive. You quickly " + 
                  "dash to your left, rocks are already crashing to the ground, but it's too late to change your decision now. " + 
                  "You move swiftly despite the uneven ground, its a good thing you looked first, tripping would cost you your life.");
               GameSystem.readFast("At last you reach cover, diving under the stone structure you turn to see what you barely managed" +
                  " to avoid. Rocks are still falling, a majority of them landing where you were standing mere moments ago. Several " + 
                  "of them land on the stone covering you, their landing resounds through the cave like thunder. A few more seconds later" +
                  " and suddenly the thundering stops, dust fills the room along with a chilling silence. You take a careful step out " +
                  "of your hasty cover and stand up, it looks like you survived by the skin of your teeth.");
               Thread.sleep(400);
               this.setEventCompleted(true);
               return;
            }
            else {
               GameSystem.readFast("You decide to dodge to your left. Quickly you turn your head to face the right direction, " +
                  "and you are briefly elated that there is a large stone slab that looks perfect for cover. Without the time to " +
                  "think, you dash towards your salvation");
               Thread.sleep(300);
               GameSystem.read("Then you tripped.");
               Thread.sleep(300);
               GameSystem.readFast("You tumble to the ground, your vision explodes in a searing light, pain attacks you from " + 
                  "every direction. Amidst the light and pain you feel sharp jabs into your body, you figue you must be tumbling. " +
                  "After what felt like an eternity, your vision begins to clear and the pain starts to dull.");
               Thread.sleep(300);
               GameSystem.readFast("Your head is throbbing and your entire body feels like lead. You manage to bring a hand to " + 
                  "your head, you feel a warm wetness.");
               GameSystem.read("Blood");
               Thread.sleep(300);
               GameSystem.readFast("You drag youself up into a sitting position and lean back against the wall. Dust still hangs " +
                  "heavy in the air, so you doubt you passed out, which is good. The pain has reduced to a dull throbbing, and your " + 
                  "vision is no longer tunnling either. With effort, you check your body for further injuries. Aside from some " +
                  "cuts and scratches that cover your body - likely from when you tripped - there isn't anyt injury of concern.");
               Thread.sleep(300);
               GameSystem.read("Well, aside from your head.");
               Thread.sleep(300);
               GameSystem.readFast("You drag yourself to your feet, the bleeding has stopped, but you still need to get out of here" +
                  ". Its time to move.");
               this.setEventCompleted(true);
               return;
            }
         }
         if(lookedChoice.equals("3")) {
            if(lookright == true) {
               GameSystem.readFast("You decide to go right, you don't have time to look around for a better option, and you can " +
                  "probably press yourself against the wall to avoid the collapsing ceilling. Quickly, you dive towards the wall " +
                  "and press yourself against the wall. You can hear the rocks crashing to the ground, and you feal a tremor as " +
                  "a large one lands right behind you. You hold on tighter as the tremors increase in magnitude.");
               Thread.sleep(300);
            }
            else {
            
            }
         }
         if(lookedChoice.equals("4")) {
         
         }
         if(lookedChoice.equals("5")) {
         
         }
         if(!lookedChoice.equals("1") && !lookedChoice.equals("2") && !lookedChoice.equals("3") && !lookedChoice.equals("4") && !lookedChoice.equals("5")) {
            GameSystem.read("You lose your balance...");
            Defeat.PlayerDefeat();
		      return;
         }
      }
      if(choice2.equals("2")) {
         
      }
      if(choice2.equals("3")) {
      
      }
      if(choice2.equals("4")) {
      
      }
      if(choice2.equals("5")) {
      
      }
      if(choice2.equals("6")) {
      
      }
      if(!choice2.equals("1") && !choice2.equals("2") && !choice2.equals("3") && !choice2.equals("4") && !choice2.equals("5") && !choice2.equals("6")) {
         GameSystem.read("You are frozen in fear, as the rocks crash down around you, you briefly regret your weakness.");
         Defeat.PlayerDefeat();
		   return;
      }//End Fail Choice
      
      
   }//End Method Event_006_FallingRocks
   
   
}//End Class Event