package game.classes;

public class Human extends Humanoid {
  public Human(String name) {
    this.health = 20;
    this.attack = 2;
    this.defense = 2;
    this.name = name;
  }

  public void takeDamage(int damage) {
    if (damage - this.defense > 0) {
      this.setHealth(this.health - damage + this.defense);
    }
    if (this.health <= 0) {
      this.setHealth(0);
    }
  }
}
