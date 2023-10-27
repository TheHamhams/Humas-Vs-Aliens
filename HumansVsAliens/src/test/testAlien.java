package test;

import game.classes.Alien;
import org.junit.Before;
import org.junit.Test;


public class testAlien {
  static Alien ALIEN;
  static int DAMAGE = 5;

  @Before
  public void beforeAllTests() {
    ALIEN = new Alien("Borpo");
  }

  @Test
  public void testAlienCreation() {
    assert(ALIEN.getHealth() == 20);
    assert(ALIEN.getAttack() == 4);
    assert(ALIEN.getDefense() == 0);
    assert(ALIEN.getName().equals("Borpo"));
  }

  @Test
  public void testAlienTakeDamage() {
    ALIEN.takeDamage(DAMAGE);
    assert(ALIEN.getHealth() == 15);
  }

  @Test
  public void testAlienTakeNegativeDamage() {
    ALIEN.takeDamage(-DAMAGE);
    assert(ALIEN.getHealth() == 20);
  }

  @Test
  public void testAlienTakeDamageOverHealth() {
    ALIEN.takeDamage(25);
    assert(ALIEN.getHealth() == 0);
  }
}
