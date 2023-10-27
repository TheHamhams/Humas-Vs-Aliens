package game;

import game.classes.Alien;
import game.classes.Human;
import java.util.Scanner;

import static java.lang.Integer.*;


public class Environment {
  public static void main(String[] args) {
    Human player = new Human("Bob");
    Alien alien = new Alien("Borpo");

    while (true) {
      humanAction(player, alien);
      if (alien.getHealth() <= 0) {
        System.out.println("You win!");
        break;
      }

      alienAction(player, alien);
      if (player.getHealth() <= 0) {
        System.out.println("You lose!");
        break;
      }
    }

  }
  public static <T, R> void fastAttack(T player, R enemy) {
    if (player instanceof Human) {
      ((Alien) enemy).takeDamage(((Human) player).getAttack());
      ((Alien) enemy).takeDamage(((Human) player).getAttack());
    }
    else if (player instanceof Alien) {
      ((Human) enemy).takeDamage(((Alien) player).getAttack());
      ((Human) enemy).takeDamage(((Alien) player).getAttack());
    }
  }

  public static <T, R> void strongAttack(T player, R enemy) {
    if (player instanceof Human)
      ((Alien) enemy).takeDamage(((Human) player).getAttack() * 2);
    else if (player instanceof Alien)
      ((Human) enemy).takeDamage(((Alien) player).getAttack() * 2);
  }

  public static void defend(Human player, Alien enemy) {
    player.setDefense(player.getDefense() + 1);
    enemy.takeDamage(player.getAttack());
  }

  public static void sap(Human enemy) {
    enemy.setDefense(enemy.getDefense() - 1);
  }

  public static void humanAction(Human player, Alien alien) {
    Scanner input = new Scanner(System.in);
    System.out.println(" ");
    System.out.println("Your health: " + player.getHealth());
    System.out.println("Alien health: " + alien.getHealth());
    System.out.println("Choose an action:");
    System.out.println("1. Fast Attack");
    System.out.println("2. Strong Attack");
    System.out.println("3. Defend");

    String action = input.nextLine();
    int actionNumber;

    try {
      actionNumber = parseInt(action);
    } catch (NumberFormatException e) {
      actionNumber = 0;
    }

    switch (actionNumber) {
      case 1:
        fastAttack(player, alien);
        break;
      case 2:
        strongAttack(player, alien);
        break;
      case 3:
        defend(player, alien);
        break;
      default:
        humanAction(player, alien);
        break;
    }
  }

  public static void alienAction(Human player, Alien alien) {
    int random = (int) (Math.random() * 3);
    switch (random) {
      case 0:
        fastAttack(alien, player);
        System.out.println("Alien used fast attack!");
        break;
      case 1:
        strongAttack(alien, player);
        System.out.println("Alien used strong attack!");
        break;
      case 2:
        sap(player);
        System.out.println("Alien used sap!");
        break;
      default:
        alienAction(player, alien);
        break;
    }
  }

}