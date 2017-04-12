//Created by Christian Robles
import java.util.Scanner;
public class BossLevelEvents {
   private boolean Event_On;
   private boolean Event_Completed;
   private int Event_Number;
   private int Event_Attempts;
   private String Event_Description;
  
   public BossLevelEvents() {
      Event_On = false;
      Event_Completed = false;
      Event_Number = 0;
      Event_Attempts = 0;
      Event_Description = "";
   }//End Constructor 
   
   //Event setters start here
   public void setBossEventOn(boolean newEventOn) {
      Event_On = newEventOn;
   }//End Method setEventOn
   
   public void setBossEventCompleted(boolean newEventCompleted) {
      Event_Completed = newEventCompleted;
   }//End Method setEventCompleted 
   
   public void setBossEventNumber(int newEventNumber) {
      Event_Number = newEventNumber;
   }//End Method setEventNumber
   
   public void setBossEventAttempts(int newEventAttempts) {
      Event_Attempts = newEventAttempts;
   }//End Method setEventAttempts
   //Event setters end here
   
   //Event getters start here
   public boolean getBossEventOn() {
      return Event_On;
   }//End Method getEventOn
   
   public boolean getBossEventCompleted() {
      return Event_Completed;
   }//End Method getEventCompleted
   
   public int getBossEventNumber() {
      return Event_Number;
   }//End Method getEventNumber
   
   public int getBossEventAttempts() {
      return Event_Attempts;
   }//End Method getEventAttempts
   //Event getters end here
   
   public void BossEventAssignment(int EventNumber) {
      if(EventNumber == 1) {
         this.setBossEventNumber(EventNumber);
      }
   }//End Method EventInterprete
   
   public static void ActivateBossEvent(BossLevelEvents BLE) {
      BLE.Event_On = true;
   }
   
   public void BossEventInterpreter(int EventNumber, Character Player) throws InterruptedException {
      if(EventNumber == 1) {
         Boss_Event_001_BossBattle_Minotaur(Player);
      }
   }//End Method EventInterpreter
   
   //Start Boss Events.
   
   public void Boss_Event_001_BossBattle_Minotaur(Character Player) throws InterruptedException {
      Thread.sleep(300);
      Scanner scan = new Scanner(System.in);
      String choice;
      
      Minotaur MrCow = new Minotaur();
      
      if(this.getBossEventCompleted() == true) {
         GameSystem.readFast("You fought the Minotaur here, but the only evidence of the fierce battle was the various craters " + 
            "the Minotaur's attacks left on the ground.");
         return;
      }//End event completed check
      GameSystem.readFast("...BOOM...");
      Thread.sleep(2000);
      GameSystem.readFast("...BOOM...");   
      Thread.sleep(1500);
      GameSystem.readFast("...BOOM...");
      Thread.sleep(1000);
      GameSystem.readFast("...BOOM...");
      Thread.sleep(500);
      GameSystem.readFast("...BOOM...");
      Thread.sleep(250);
      GameSystem.readFast("...BOOM...");
      Thread.sleep(100);
      GameSystem.readFast("...BOOM...");
      Thread.sleep(100);
      GameSystem.readFast("...BOOM...");
      Thread.sleep(50);
      GameSystem.readFast("...BOOM...");
      Thread.sleep(40);
      GameSystem.readFast("...BOOM...");
      Thread.sleep(30);
      GameSystem.readFast("...BOOM...");
      Thread.sleep(20);
      GameSystem.readFast("...CRASH...");
      Thread.sleep(300);
      GameSystem.readFast("The wall in front of you exploded in a cloud of dust and a shower of stone!");
      Thread.sleep(300);
      GameSystem.read("Your heart pounded. Time seemed to slow as your body tensed, ready to respond to this new threat.");
      Thread.sleep(300);
      GameSystem.readFast("...Thump...");
      Thread.sleep(200);
      GameSystem.readFast("...Thump...");
      Thread.sleep(400);
      GameSystem.readFast("...Thump...");
      Thread.sleep(600);
      GameSystem.readFast("...Thump...");
      Thread.sleep(800);
      GameSystem.readFast("...Thump...");
      Thread.sleep(1000);
      GameSystem.readFast("...Thump...");
      Thread.sleep(1200);
      GameSystem.readFast("...Thump...");
      Thread.sleep(1400);
      GameSystem.readFast("...Thump...");
      Thread.sleep(1600);
      GameSystem.readFast("...Thump...");
      Thread.sleep(1800);
      GameSystem.readFast("...Thump...");
      Thread.sleep(2000);
      GameSystem.readFast("...Thump...");
      Thread.sleep(1000);
      GameSystem.readFast("You don't have many options. You could dive to your left, but if you do that you will " + 
         "be diving into a cloud of dust, who knows what is in there. You could dive to your right, but there is a rather large and " + 
         "sharp looking chunk of stone flying in that direction, should you risk colliding with it? Lastly, you could stand " + 
         "your ground and brace for whatever is coming out of the wall.");
      Thread.sleep(300);
      System.out.println("(1)Dive to your left.   (2)Dive to your right.   (3)Stand your ground.");
      choice = scan.next();
      if(choice.equals("1")) {//Start Dive into dust cloud
         //Diving into the cloud is the luck option.
         //A high luck roll allows the player to see the Minotaur as it exits the hole
         // and get a pre-emptive strike in combat.
         //A low luck roll blinds the player to the Minotaur, so both end up seeing
         // each other at the same time for a normal battle.
      }//End Dive into dust cloud
      if(choice.equals("2")) {//Start Dive to the stone spike
         //Diving towards the stone spike allows you to avoid the Minotaur, but
         // You take damage from the stone spike equal to 8 - player defense.
         //Combat with Minotaur is normal.
      }//End Dive to the stone spike
      if(choice.equals("3")) {//Start Stand your ground
         //Minotaur charges into Player and they both collide.
         //Minotaur Attack is compared with Player Attack,
         // whoever has the higher attack gets a pre-emptive bonus
         // in combat. Equal attack goes in Minotaur's favor.
      }//End Stand your ground
      if(!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {//End Fail choice
         //Player is frozen, Minotaur charges into player, knocking them down
         // and inflicting 4 points of true damage while also getting
         // a pre-emptive combat bonus.
      }//End Fail choice   
   }//End Method Boss_Event_001_BossBattle_Minotaur
   
}//End class BossLevelEvents