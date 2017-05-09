import java.util.Scanner;

//Class.java
//Written by: TBAD
//Scripts for enemy VS player combat

public class Combat{
   
   //Standard Combat Method, can be used with any monster object. 
   public static void standardCombat(Monster monster, Character player) throws InterruptedException {
      int criticalHit = player.getAttack() + (player.getAttack()/2);
      Scanner scan = new Scanner(System.in);
	   while(player.healthpoints >0){
	       GameSystem.readFast("What is your next action?");
	       System.out.println("(1)Attack.   (2)View Inventory.   (3)Check Status");
          System.out.println("(4)Switch Active Weapon.   (5)Run.");            
	       System.out.println();
	       int engagedAction = scan.nextInt();
	       if(engagedAction == 1){
	          System.out.println();
		       GameSystem.readFast("You attack the " + monster.getName() + ".");
	      	 MonsterDamage(monster, player);
             if(monster.getHp() <= 0) {
                Defeat.enemyDefeat(monster, player);
                return;
             }
	          System.out.println();
		       System.out.println("The " + monster.getName() + " strikes back.");
		       PlayerDamage(monster, player);
	          System.out.println();
		       if(player.getHealth() <= 0) {
                Defeat.PlayerDefeat();
		          System.out.println("You've been dealt a fatal blow...");
		          return;
		       }
	       }
	       else if(engagedAction == 2){
		       player.useInventory();
          }	       
	       else if(engagedAction == 3){
	          System.out.println();
		       System.out.println(player.status());
             System.out.println();
	       }
	       else if(engagedAction == 4){
		       player.weaponSwitch();
             player.equipmentMod();
             if(player.equipment[4] == null)
                return;
             else
                System.out.println(player.equipment[4].getItemName() + " is now your Active Weapon.");
	       } 
	       else if(engagedAction == 5){
		       System.out.println("You attempt to flee but the " + monster.getName() + " cuts you off!");
		       System.out.println("There's no escaping this fight!");
	       }
         else
            System.out.println("That is not a correct input.");
	    }//end while (Combat)
   }//end standardCombat
   
   //Player advantage combat method, gives player critical hit at the beginning of the battle.
   public static void advantageCombat(Monster monster, Character player) throws InterruptedException{
      Scanner scan = new Scanner(System.in);
      System.out.println("You caught the enemy off-guard and dealt a critical blow!");
      CriticalMonsterDamage(monster, player);
      if(monster.hp <=0){
         Defeat.enemyDefeat(monster, player);
         return;
      }
      while(player.healthpoints >0){
	       GameSystem.readFast("What is your next action?");
	       System.out.println("(1)Attack.   (2)View Inventory.   (3)Check Status");
          System.out.println("(4)Switch Active Weapon.   (5)Run.");            
	       System.out.println();
	       int engagedAction = scan.nextInt();
	       if(engagedAction == 1){
	          System.out.println();
		       GameSystem.readFast("You attack the " + monster.getName() + ".");
	      	 MonsterDamage(monster, player);
             if(monster.getHp() <= 0) {
                Defeat.enemyDefeat(monster, player);
                return;
             }
	          System.out.println();
		       System.out.println("The " + monster.getName() + " strikes back.");
		       PlayerDamage(monster, player);
	          System.out.println();
		       if(player.getHealth() <= 0) {
                Defeat.PlayerDefeat();
		          System.out.println("You've been dealt a fatal blow...");
		          return;
		       }
	       }
	       else if(engagedAction == 2){
		       player.useInventory();
          }	       
	       else if(engagedAction == 3){
	          System.out.println();
		       System.out.println(player.status());
             System.out.println();
	       }
	       else if(engagedAction == 4){
		       player.weaponSwitch();
             player.equipmentMod();
             if(player.equipment[4] == null)
                return;
             else
                System.out.println(player.equipment[4].getItemName() + " is now your Active Weapon.");
	       } 
	       else if(engagedAction == 5){
		       System.out.println("You attempt to flee but the " + monster.getName() + " cuts you off!");
		       System.out.println("There's no escaping this fight!");
	       }
         else
            System.out.println("That is not a correct input.");
	    }//end while (Combat
   }//end advantageCombat
   
   public static void advantageMonsterCombat(Monster monster, Character player) throws InterruptedException{
      Scanner scan = new Scanner(System.in);
      System.out.println("The " + monster.getName() + " caught you off guard!");
      CriticalPlayerDamage(monster, player);
      if(player.getHealth() <=0){
         Defeat.PlayerDefeat();
         return;
      }
      while(player.healthpoints >0){
	       GameSystem.readFast("What is your next action?");
	       System.out.println("(1)Attack.   (2)View Inventory.   (3)Check Status");
          System.out.println("(4)Switch Active Weapon.   (5)Run.");            
	       System.out.println();
	       int engagedAction = scan.nextInt();
	       if(engagedAction == 1){
	          System.out.println();
		       GameSystem.readFast("You attack the " + monster.getName() + ".");
	      	 MonsterDamage(monster, player);
             if(monster.getHp() <= 0) {
                Defeat.enemyDefeat(monster, player);
                return;
             }
	          System.out.println();
		       System.out.println("The " + monster.getName() + " strikes back.");
		       PlayerDamage(monster, player);
	          System.out.println();
		       if(player.getHealth() <= 0) {
                Defeat.PlayerDefeat();
		          System.out.println("You've been dealt a fatal blow...");
		          return;
		       }
	       }
	       else if(engagedAction == 2){
		       player.useInventory();
          }	       
	       else if(engagedAction == 3){
	          System.out.println();
		       System.out.println(player.status());
             System.out.println();
	       }
	       else if(engagedAction == 4){
		       player.weaponSwitch();
             player.equipmentMod();
             if(player.equipment[4] == null)
                return;
             else
                System.out.println(player.equipment[4].getItemName() + " is now your Active Weapon.");
	       } 
	       else if(engagedAction == 5){
		       System.out.println("You attempt to flee but the " + monster.getName() + " cuts you off!");
		       System.out.println("There's no escaping this fight!");
	       }
         else
            System.out.println("That is not a correct input.");
	    }//end while (Combat
   }//end advantageMonsterCombat
   
   public static int PlayerDamage(Monster Mon, Character Player) throws InterruptedException {
      int damage;
      damage = Mon.getAttack() - Player.getDefense();
      if(damage <= 0) {
        // GameSystem.read("You take no damage.");
      }
      else {
         //GameSystem.read("You take " + damage + " damage.");
         Player.modHP(-damage);
      }
	  return damage;
   }//End method PlayerDamage
   
   public static void CriticalPlayerDamage(Monster Mon, Character Player) throws InterruptedException {
      int crit;
      crit = Mon.getAttack()+(Mon.getAttack()/2) - Player.getDefense();
      if(crit <= 0) {
         //GameSystem.read("You took no damage.");
      }
      else {
         //GameSystem.read("You took " + crit + " critical damage!");
         Player.modHP(-crit);
      }
   }//End method CriticalPlayerDamage
   
   public static int MonsterDamage(Monster Mon, Character Player) throws InterruptedException {
      int damage;
      damage = Player.getAttack() - Mon.getDefense();
      if(damage <= 0) {
         //GameSystem.read("You dealt no damage.");
      }
      else {
         //GameSystem.read(Mon.getName() + " took " + damage + " damage.");
         Mon.modMonsterHP(-damage);
      }
	  return damage;
   }//End method MonsterDamage
   
   public static void CriticalMonsterDamage(Monster Mon, Character Player) throws InterruptedException {
      int crit;
      crit = Player.getAttack()+(Player.getAttack()/2) - Mon.getDefense();
      if(crit <= 0) {
         GameSystem.read("You dealt no damage.");
      }
      else {
         GameSystem.read(Mon.getName() + " took " + crit + " critical damage!");
         Mon.modMonsterHP(-crit);
      }
   }//End method MonsterPlayerDamage
   
}//end class
