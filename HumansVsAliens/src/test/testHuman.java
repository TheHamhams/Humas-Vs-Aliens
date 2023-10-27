package test;

import game.classes.Human;
import org.junit.Test;
import org.junit.Before;

public class testHuman {
  static Human HUMAN;
  static int DAMAGE = 5;

  @Before
  public void beforeEachTest() {
    HUMAN = new Human("Bob");
  }

  @Test
  public void testHumanCreation() {
    assert(HUMAN.getHealth() == 20);
    assert(HUMAN.getAttack() == 2);
    assert(HUMAN.getDefense() == 2);
    assert(HUMAN.getName().equals("Bob"));
  }

  @Test
  public void testHumanTakeDamage() {
    HUMAN.takeDamage(DAMAGE);
    assert(HUMAN.getHealth() == 17);
  }

  @Test
  public void testHumanTakeNegativeDamage() {
    HUMAN.takeDamage(-DAMAGE);
    assert(HUMAN.getHealth() == 20);
  }
}
