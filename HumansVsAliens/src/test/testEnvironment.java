package test;

import game.classes.Alien;
import game.classes.Human;
import org.junit.Before;
import org.junit.Test;

import static game.Environment.*;


public class testEnvironment {
  Human HUMAN;
  Alien ALIEN;

  @Before
  public void beforeEachTest() {
    HUMAN = new Human("Bob");
    ALIEN = new Alien("Borpo");
  }

  @Test
  public void testHumanFastAttack() {
    fastAttack(HUMAN, ALIEN);
    assert(ALIEN.getHealth() == 16);
  }

  @Test
  public void testAlienFastAttack() {
    fastAttack(ALIEN, HUMAN);
    assert(HUMAN.getHealth() == 16);
  }

  @Test
  public void testHumanStrongAttack() {
    strongAttack(HUMAN, ALIEN);
    assert(ALIEN.getHealth() == 16);
  }

  @Test
  public void testAlienStrongAttack() {
    strongAttack(ALIEN, HUMAN);
    assert(HUMAN.getHealth() == 14);
  }

  @Test
  public void testHumanDefend() {
    defend(HUMAN, ALIEN);
    assert(HUMAN.getDefense() == 3);
    assert(ALIEN.getHealth() == 18);
  }

  @Test
  public void testSap() {
    sap(HUMAN);
    assert(HUMAN.getDefense() == 1);
  }

}
