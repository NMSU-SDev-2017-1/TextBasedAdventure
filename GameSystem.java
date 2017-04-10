import java.util.Scanner;
public class GameSystem extends Character {

   public static void read(String s) throws InterruptedException {
      int charCount;
      charCount = 0;
      for(int i = 0; i < s.length(); i++) {
         //play();
         System.out.print(s.charAt(i));
         charCount++;
         if(charCount >= 50 && s.charAt(i) == ' ') {
            System.out.println();
            charCount = 0;
         }
         Thread.sleep(70);  
      }//End loop
      System.out.println();
      System.out.println();
   }//End method read
   
   public static void readFast(String s) throws InterruptedException {
      int charCount;
      charCount = 0;
      for(int i = 0; i < s.length(); i++) {
         //play();
         System.out.print(s.charAt(i));
         charCount++;
         if(charCount >= 50 && s.charAt(i) == ' ') {
            Thread.sleep(100);
            System.out.println();
            charCount = 0;
         }
         Thread.sleep(30);  
      }//End loop
      System.out.println();
      System.out.println();
   }//End method read
   
   public static boolean DreamChoice() throws InterruptedException {
      int i = 1;
      boolean loop = true;
      while(loop = true) {   
         Scanner scan = new Scanner(System.in);
         String s = scan.nextLine();
         s = s.toLowerCase();
         if(s.equals("yes")) {
            if(i < 3)
               read("That name fits you.");
            else
               read("Finally, I don't think you are cut out for this.");
            return true;
         }
         if(s.equals("no")) {
            return false;
         }
         if(i == 1) {
            read("Try speaking more clearly this time.");
            i++;
            continue;
         }
         if(i == 2) {
            read("Yes or No... It isn't that hard.");
            i++;
            continue;
         }
         if(i == 3) {
            read("Other abstract beings would be angry with you. I am only dissapointed.");
            i++;
            continue;
         }
         if(i >= 4) {
            read("......");
            i++;
            continue;
         }
      }
      return false;  
   }//End method choice
   
   public static void play() {
   }//End method play
   
   public static void HeroChoiceOne(Character Player) throws InterruptedException {
         Scanner scan = new Scanner(System.in);
         boolean hero1 = false;
         int heroChoiceTracker = 0;
         boolean heroChoiceOne, heroChoiceTwo, heroChoiceThree, heroChoiceFour, heroChoiceFive;
         heroChoiceOne = heroChoiceTwo = heroChoiceThree = heroChoiceFour = heroChoiceFive = false;
         while(hero1 != true) {//Start choice loop one
            Thread.sleep(400);
            if(heroChoiceOne == false) {
               System.out.print("(1)Examine the crowd to your right.  ");
               heroChoiceTracker++;
               if(heroChoiceTracker >= 3) {
                  System.out.println();
                  heroChoiceTracker = 0;
               }
            }
            if(heroChoiceTwo == false) {
               System.out.print("(2)Examine the crowd to your left.  ");
               heroChoiceTracker++;
               if(heroChoiceTracker >= 3) {
                  System.out.println();
                  heroChoiceTracker = 0;
               }
            }
            if(heroChoiceThree == false) {
               System.out.print("(3)Examine your environment.  ");
               heroChoiceTracker++;
               if(heroChoiceTracker >= 3) {
                  System.out.println();
                  heroChoiceTracker = 0;
               }
            }
            if(heroChoiceFour == false) {
               System.out.print("(4)Observe silently.  ");
               heroChoiceTracker++;
               if(heroChoiceTracker >= 3) {
                  System.out.println();
                  heroChoiceTracker = 0;
               }
            }
            if(heroChoiceFive == false) {
               System.out.print("(5)Demand an explanation.  ");
               heroChoiceTracker++;
               if(heroChoiceTracker >= 3) {
                  System.out.println();
                  heroChoiceTracker = 0;
               }
            }
            int ChoiceLoopOneC1;
            ChoiceLoopOneC1 = scan.nextInt();
            if(ChoiceLoopOneC1 == 1 && heroChoiceOne == false) {//Start examine right group
               Thread.sleep(100);
               GameSystem.readFast("Your body feels heavy and you struggle to turn your head right. The crowd is facing away from you, " + 
                  "about twenty people total. " + 
                  "You aren't able to make out any distinctive features. However, they appear to all be male. They are as still " + 
                  "as statues.");
               System.out.println("(1)It is creepy.  (2)It makes you wary.  (3)It's intriguing.");
               int ChoiceLoopOneC2;
               ChoiceLoopOneC2 = scan.nextInt();
               if(ChoiceLoopOneC2 == 1) {
                  Player.modDEF(-1);
               }
               if(ChoiceLoopOneC2 == 2) {
                  Player.modDEF(1);
               }
               if(ChoiceLoopOneC2 == 3) {
                  Player.modLUCK(-2);
                  Player.modATK(1);
                  Player.modDEF(1);
               }
               if(ChoiceLoopOneC2 > 3 || ChoiceLoopOneC2 < 1) {
                  Player.modMaxHP(-2);
               }
               heroChoiceOne = true;
            }//End examine right group
            if(ChoiceLoopOneC1 == 2 && heroChoiceTwo == false) {//Start examine left group
               Thread.sleep(100);
               GameSystem.readFast("Your body feels heavy and you struggle to turn your head left. The crowd is facing away from you, " + 
                  "about twenty people total. " + 
                  "You aren't able to make out any distinctive features. However, they appear to all be female. Each person sways left " + 
                  "to right in synch with each other.");
               System.out.println("(1)It is creepy.  (2)It makes you wary.  (3)It's intriguing.");
               int ChoiceLoopOneC3;
               ChoiceLoopOneC3 = scan.nextInt();
               if(ChoiceLoopOneC3 == 1) {
                  Player.modDEF(-1);
               }
               if(ChoiceLoopOneC3 == 2) {
                  Player.modDEF(1);
               }
               if(ChoiceLoopOneC3 == 3) {
                  Player.modLUCK(-2);
                  Player.modATK(1);
                  Player.modDEF(1);
               }
               if(ChoiceLoopOneC3 != 1 && ChoiceLoopOneC3 != 2 && ChoiceLoopOneC3 != 3) {
                  Player.modMaxHP(-2);
               }
               heroChoiceTwo = true;
            }//End examine left group
            if(ChoiceLoopOneC1 == 3 && heroChoiceThree == false) {//Start examine environment
               Thread.sleep(100);
               if(heroChoiceFour == false) {
                  GameSystem.readFast("Your body feels like its made of lead, you manage to muster the strength to look around. " +
                  "You look up first, the crimson sun shines down upon you, but the light is strange, you are looking directly " +
                  "at it, but it doesn't blind you at all. You lower your gaze, the pale ground stretches across the horizon, aside from " +
                  "the two groups of people, there is nothing here.");
               }
               else {
                  GameSystem.readFast("Your body feels like its made of lead, you manage to muster the strength to look around. " +
                  "You look up first, the crimson sun shines down upon you, but the light is strange, you are looking directly " +
                  "at it, but it doesn't blind you at all. You lower your gaze, the pale ground stretches across the horizon without end. " + 
                  "unable to move your body, you struggle to turn your head around to try and get a glimps of what caused that strange sound. " + 
                  "You are just able to make out a large structure, it appears to be leaning to your left.");
               }
               heroChoiceThree = true;
               heroChoiceFour = true;
            }//End examine environment
            if(ChoiceLoopOneC1 == 4 && heroChoiceFour == false) {//Start Observe Silently
               Thread.sleep(100);
               GameSystem.readFast("You decide to bide your time. It wouldn't be smart to do anything recklessly after all.");
               Thread.sleep(400);
               GameSystem.read("...........");
               Thread.sleep(400);
               GameSystem.read("..GRHhrrhHRRHRHrhhHSChchchchCHRRGGH......");
               Thread.sleep(400);
               GameSystem.read("...........");
               Thread.sleep(400);
               GameSystem.readFast("Aside from an interesting sound, nothing seems to have happened.  You still can't move your body " +
                  "but it seems that you can slightly move your head. It is time to do something.");
               heroChoiceFour = true;
            }//End Observe Silently
            if(ChoiceLoopOneC1 == 5 && heroChoiceFive == false) {//Start Demand an explanation
               Thread.sleep(100);
               GameSystem.readFast("This isn't right, you need to know what is going on.");
               Player.modATK(2);
               Thread.sleep(500);
               GameSystem.read("I am glad you are curious, to put it simply");
               Thread.sleep(100);
               System.out.println("This");
               Thread.sleep(100);
               System.out.println("Is");
               Thread.sleep(100);
               System.out.println("A");
               Thread.sleep(100);
               System.out.println("Game.");
               Thread.sleep(400);
               GameSystem.read("I only play this game with Heroes, you see, these people...");
               Thread.sleep(200);
               GameSystem.read("Are dead");
               Thread.sleep(200);
               System.out.println("(1)Why are they dead?   (2)Why are they here?   (3)What do you want?   (4)Do Nothing.");
               Thread.sleep(400);
               int heroLoopChoiceC3 = scan.nextInt();
               if(heroLoopChoiceC3 == 1) {//Start hero question one
                  Thread.sleep(200);
                  GameSystem.read("They were killed.");
                  Player.modATK(1);
                  Player.modDEF(-1);
               }//End hero question one
               if(heroLoopChoiceC3 == 2) {//Start hero question two
                  Thread.sleep(200);
                  GameSystem.read("They are trapped.");
                  Player.modLUCK(1);
                  Player.modATK(-1);
               }//End hero question two
               if(heroLoopChoiceC3 == 3) {//Start hero question three
                  Thread.sleep(200);
                  GameSystem.read("I want to help.");
                  Player.modDEF(1);
                  Player.modLUCK(-1);
               }//End hero question three
               if(heroLoopChoiceC3 == 4) {//Start hero question four
                  Player.modMaxHP(2);
               }//End hero question four
               if(heroLoopChoiceC3 != 1 && heroLoopChoiceC3 != 2 && heroLoopChoiceC3 != 3 && heroLoopChoiceC3 != 4) {//Start hero question fail
                  Thread.sleep(200);
                  GameSystem.read("Cat got your tongue?");
                  Player.modATK(-1);
                  Player.modDEF(-1);
                  Player.modLUCK(-1);
               }//End hero question fail
               Thread.sleep(400);
               GameSystem.read("Since you are a Hero you get to help them. I will bring back to life one group " + 
                  "of your choosing.");
               Thread.sleep(200);
               System.out.println("(1)Why are they in groups?   (2)Why can't you bring them all back?");
               Thread.sleep(200);
               int heroLoopChoiceC4 = scan.nextInt();
               if(heroLoopChoiceC4 == 1) {
                  GameSystem.read("Who knows? maybe it is because they died a certain way?");
                  Thread.sleep(400);
                  GameSystem.readFast("............");
               }
               if(heroLoopChoiceC4 == 2) {
                  GameSystem.read("I can't do that.");
                  Thread.sleep(400);
                  GameSystem.readFast("............");
               }
               if(heroLoopChoiceC4 != 1 && heroLoopChoiceC4 != 2) {
                  GameSystem.readFast("............");
               }
               GameSystem.read("You can only save one group Hero.");
               Thread.sleep(400);
               heroChoiceOne = heroChoiceTwo = heroChoiceThree = heroChoiceFour = heroChoiceFive = true; 
               hero1 = true;
            }//End Demand an explanation
            heroChoiceTracker = 0;
         }//End choice loop one   
   }//End method HeroChoiceOne
   
   public static void HeroChoiceTwo(int PlayerChoice) throws InterruptedException {
      if(PlayerChoice == 1) {
         read("Interesting choice hero, was it the right one? If you live long enough I guess you will find out.");
         Thread.sleep(500);
         read("Hahahahaha.");
         Thread.sleep(500);
         read("Goodbye Hero. Good luck.");
      }
      if(PlayerChoice == 2) {
         read("Interesting choice hero, was it the right one? If you live long enough I guess you will find out.");
         Thread.sleep(500);
         read("Hahahahaha.");
         Thread.sleep(500);
         read("Goodbye Hero. Good luck.");
      }
      if(PlayerChoice != 1 && PlayerChoice != 2) {
         read("I like you Hero, they all deserve to stay dead.");
         Thread.sleep(500);
         read("Hahahahaha.");
         Thread.sleep(500);
         read("Goodbye 'Hero'.");
      }
   }//End method HeroChoiceTwo
   
   public static void FreedomChoiceOne(Character Player) throws InterruptedException {
      Scanner scan = new Scanner(System.in);
      Thread.sleep(500);
      int freedomChoiceC1, freedomChoiceC2, freedomChoiceC3;
      boolean slowLie, fastLie, shout, listen;
      int counter;
      int fallingSpeed;
      int penalty, reward;
      boolean freedomLoop;
      freedomLoop = false;
      fallingSpeed = 0;
      penalty = 0;
      reward = 0;
      counter = 0;
      fastLie = false;
      slowLie = false;
      shout = false;
      listen = true;
      while(freedomLoop != true) {
         if(fallingSpeed == -1)
            readFast("You are falling quickly.");
         if(fallingSpeed == 0)
            readFast("You are still falling.");
         if(fallingSpeed == 1)
            readFast("You are falling slowly");
         Thread.sleep(300);
         
         System.out.println("(1)Slow your descent.   (2)Hasten your descent.   (3)Listen");
         System.out.println("(4)Shout.");
         freedomChoiceC1 = scan.nextInt();
         Thread.sleep(300);
         switch(freedomChoiceC1) {
            case 1:
               if(fallingSpeed > 0) {
                  readFast("You can't go any faster.");
                  if(fastLie == true) {
                     penalty++;
                     fastLie = true;
                     slowLie = false;
                     shout = false;
                     listen = true;
                  }
               }
               else {
                  readFast("You tuck your arms to your side and lean downward. Immediately you feel the air " + 
                     "rush past you even faster");
                  fallingSpeed = 1;
                  if(fastLie == true) {
                     penalty++;
                     fastLie = true;
                     slowLie = false;
                     shout = false;
                     listen = true;
                  }
               }
               break;
            
            case 2:
               if(fallingSpeed < 0)
                  readFast("You can't go any slower.");
                  if(slowLie == true) {
                     penalty++;
                     fastLie = false;
                     slowLie = true;
                     shout = false;
                     listen = true;
                  }
               else {
                  readFast("You stretch your arms outwards and straighten yourself. The air rushing past you hits your " +
                  "body like a sandbag, and you fall slower.");
                  fallingSpeed = -1;
                  if(slowLie == true) {
                     penalty++;
                     fastLie = false;
                     slowLie = true;
                     shout = false;
                     listen = true;
                  }
               }
               break;
            
            case 3:
               readFast("You strain your ears and attempt to listen. It is unlikely you will hear anything, " + 
               "the air rushing past your ears is deafening.");
               Thread.sleep(300);
               read("......");
               Thread.sleep(100);
               read("......");
               Thread.sleep(100);
               read("......");
               if(listen == false) {
                     penalty++;
               }
               else
                  reward++;
               freedomChoiceC2 = (int)(Math.random() * (4-1) + 1);
               if(freedomChoiceC2 == 1) {
                  read("...You hear nothing...");
                  shout = true;
                  listen = false;
                  slowLie = false;
                  fastLie = false;
               }
               if(freedomChoiceC2 == 2) {
                  read("...Faster...");
                  shout = false;
                  listen = false;
                  fastLie = true;
                  slowLie = false;
               }
               if(freedomChoiceC2 == 3) {
                  read("...Slower...");
                  shout = false;
                  listen = false;
                  fastLie = false;
                  slowLie = true;
               }
               
               break;
               
            case 4:
               readFast("You do your best to gather your breath and shout with all of your might!");
               Thread.sleep(300);
               read("......");
               Thread.sleep(100);
               read("......");
               Thread.sleep(100);
               read("......");
               Thread.sleep(300);
               counter++;
               freedomChoiceC3 = (int)(Math.random() * (4-1) + 1);
               if(shout == true) {
                  shout = false;
                  listen = true;
                  fastLie = false;
                  slowLie = false;
                  if(freedomChoiceC3 == 1) {
                     Player.modATK(reward+1);
                     read("You feel a rush of hot air. It makes you feel strong");
                  }
                  if(freedomChoiceC3 == 2) {
                     Player.modDEF(reward+1);
                     read("You feel a rush of hot air. It makes you feel tough.");
                  }
                  if(freedomChoiceC3 == 3) {
                     Player.modLUCK(reward+1);
                     read("You feel a rush of hot air.");
                     read("......");
                  }
                  if(freedomChoiceC3 == 4) {
                     Player.modMaxHP(reward+1);
                     read("You feel a rush of hot air. It feels soothing.");
                  }
               }
               else {
                  shout = false;
                  listen = true;
                  fastLie = true;
                  slowLie = true;
                  if(freedomChoiceC3 == 1) {
                     Player.modATK(-(penalty+1));
                     read("You feel a rush of freezing air. You feel weak.");
                  }
                  if(freedomChoiceC3 == 2) {
                     Player.modDEF(-(penalty+1));
                     read("You feel a rush of freezing air. You feel frail.");
                  }
                  if(freedomChoiceC3 == 3) {
                     Player.modLUCK(-(penalty+1));
                     read("You feel a rush of freezing air.");
                     read("......");
                  }
                  if(freedomChoiceC3 == 4) {
                     Player.modMaxHP(-(penalty+1));
                     read("You feel a rush of freezing air. It hurts.");
                  }
               }
               break;
               
            default:
               readFast("You keep falling.");
               break;
               
         }//End switch
         if(counter >= 5)
            freedomLoop = true;
      }//End loop 
      readFast("Without warning, you land.");
      Thread.sleep(200);
      read("......");
      Thread.sleep(200);
      read("It hurt.");
      Thread.sleep(500);
      read("I hope you were lucky, but I think you are going to die very quickly.");
      Thread.sleep(300);
      readFast("Hahahahahahahaha");
      Thread.sleep(500);
   }//End Method FreedomChoiceOne
   
   public static Character Prologue() throws InterruptedException {
      Scanner scan = new Scanner(System.in);
      int multChoice;
   
      GameSystem.read("Hello...");
      Thread.sleep(1000);
      GameSystem.read("..........");
      Thread.sleep(1500);   
      GameSystem.read("Who are you?");
      Thread.sleep(500);
      Character Player = new Character();
      boolean choseName = false;
      while(choseName != true) {
         String name = scan.nextLine();
         Player.setID(name);
         Thread.sleep(800);
         GameSystem.read("..........");
         Thread.sleep(800);
         GameSystem.read("So your name is " + Player.getPlayerID() + "?");
         if(GameSystem.DreamChoice() == true)
            choseName = true;
         else {
            GameSystem.read("... Tell me your name.");
            continue;
         }
      }//end name loop
      Thread.sleep(800);
      GameSystem.read("Tell me " + Player.getPlayerID() + ", what are you?");
      Thread.sleep(500);
      System.out.println("(1)I am a Hero.  (2)I am a What I Want To Be.  (3)I am a Villain");
      multChoice = scan.nextInt();
      if(multChoice == 1) {//Start Hero Main Choice
         Thread.sleep(500);
         GameSystem.read("Weakling.");
         Player.modDEF(3);
         Player.modLUCK(-3);
         //Start Path One
         Thread.sleep(500);
         System.out.println();
         GameSystem.readFast("The world around you swirled in a nauseating fashion. The darkness that previously enveloped you " +
            "broke away to reveal a strange scene - two crowds of people stood unmoving, one to your left the other to your right. " + 
            "You didn't have time to examine them as the world around you continued to twist " +
            "itself into existance; the ground, a pale slate, streched itself beyond the horizon, a dark, red, sun appeared and began" + 
            " to rise and set at an unnaturally speed, it was hypnotizing. " + 
            "After what seemed to be an eternity the sun finally stopped directly above you, casting a bloody light on the ground. ");
         System.out.println();
         Thread.sleep(500);
         GameSystem.read("You gather your wits and prepare yourself. What do you do?");
         Thread.sleep(500);
         //Activate method to innitate player information process one
         GameSystem.HeroChoiceOne(Player);
         //End player information process one
         Thread.sleep(500);
         GameSystem.read("Tell me 'Hero', what will you do?");
         Thread.sleep(500);
         System.out.println("(1)Save the group to your left.   (2)Save the group to your right.");
         int nextHeroChoice;
         nextHeroChoice = scan.nextInt();
         HeroChoiceTwo(nextHeroChoice);
         //End player choice process one
         //End Path One
         Thread.sleep(1000);
      }//END Hero Main Choice
      if(multChoice == 2) {//Start Freedom Main Choice
         Thread.sleep(500);
         GameSystem.read("Liar.");
         Player.modLUCK(3);
         Player.modATK(-3);
         //Start Path Two
         Thread.sleep(500);
         System.out.println();
         GameSystem.readFast("The ground fell from under your feet! You struggle to steady youself as you tumble through the air. " + 
            "AFter what seemed like an eternity of falling, you manage to take control of your descent. You keep falling.");
         Thread.sleep(200);
         GameSystem.read("......");
         GameSystem.read("......");
         GameSystem.read("......");
         GameSystem.read("......");
         GameSystem.read("You don't stop falling, and it doesn't look like you will stop anytime soon.");
         System.out.println();
         Thread.sleep(500);
         GameSystem.read("You gather your wits and prepare yourself. What are you going to do?");
         Thread.sleep(500);
         //Activate method to innitate player information process one
         GameSystem.FreedomChoiceOne(Player);
         //End player information process one
         readFast("You pull yourself off of the ground. After checking your body, making sure nothing importent was broken.");
         Thread.sleep(200);
         read("Nothing was broken.");
         Thread.sleep(200);
         readFast("You don't have the time to appreciate your luck, a wave of exhaustion washes over you. You try and fight it, " +
            "but you fail. Inky darkness obscures your vision as you collapse.");
         Thread.sleep(1000);
         //End Path Two
      }//END Freedom Main Choice
      if(multChoice == 3) {//Start Villain Main Choice
        Thread.sleep(500);
        GameSystem.read("I like you. Too bad you made the wrong choice.");
        Player.setAtk(20);
        Player.setDef(1);
        Player.setLuck(1);
        Player.setMaxHP(10);
        //Start Path Two
        Thread.sleep(500);
        readFast("Darkness envelops you.");
        Thread.sleep(300);
        read(".......");
        Thread.sleep(300);
        read(".......");
        Thread.sleep(300);
        read("It is comforting.");
        Thread.sleep(1000); 
        //End Path Two
      }//END Villain Main Choice
      if(multChoice != 1 && multChoice != 2 && multChoice != 3) {//Start Fail Main Choice
        Thread.sleep(500);
        GameSystem.read("You are a Failure.");
        Player.setAtk(8);
        Player.setDef(5);
        Player.setLuck(4);
        Player.setMaxHP(15);
        //Start Path fail
        Thread.sleep(500);
        readFast("Darkness envelops you.");
        Thread.sleep(1000);
        //End Path fail
      }//END Fail Main Choice
      return Player;
   }
   
   public static void StartGame() throws InterruptedException {
      readFast("Your eyes flutter open, as the inky darkness fades away it reveals...");
      Thread.sleep(100);
      read("......");
      Thread.sleep(100);
      readFast("A cave ceiling.");
      Thread.sleep(100);
      read("......");
      Thread.sleep(100);
      read("You should do something.");
   }//End method StartGame
   
   public static void EnterMaze(Character Player, Maze M) {
   
   }//End method EnterMaze
   
   public static void EnterCamp(Character Player, Maze M) {
   
   }//End Method EnterCamp

}//End class Reader