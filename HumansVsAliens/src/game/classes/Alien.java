package game.classes;

public class Alien extends Humanoid{
  public Alien(String name) {
    this.health = 20;
    this.attack = 4;
    this.defense = 0;
    this.name = name;
  }

  public void takeDamage(int damage) {
    if (damage > 0) {
      this.setHealth(this.health - damage);
    }
    if (this.health <= 0) {
      this.setHealth(0);
    }
  }
}
