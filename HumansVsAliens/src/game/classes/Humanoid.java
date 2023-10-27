package game.classes;

public class Humanoid {
  int health;
  int attack;
  int defense;
  String name;
  public int getHealth() {
    return this.health;
  }
  public void setHealth(int health) {
    this.health = health;
  }
  public int getAttack() {
    return this.attack;
  }
  public int getDefense() {
    return this.defense;
  }
  public int setDefense(int defense) {
    return this.defense = defense;
  }
  public String getName() {
    return this.name;
  }
}
