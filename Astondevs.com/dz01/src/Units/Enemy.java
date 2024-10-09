package Units;

public class Enemy implements Mortal{
    double health;
    String name = "Anonymous";

    public Enemy(String name, double health){
        this.name = name;
        this.health = health;
    }
    public Enemy(String name){
        this(name, 100);
    }
    public Enemy(double health){
        this("WithOutName", health);
    }

    public void setHealth(double health){
        this.health = health;
    }

    public double getHealth() {
        return health;
    }

    public double takeDamage(double damage){
        if(!isAlive()){
            System.out.printf("Alert: %s is already! dead%n", name);
            return health;
        }
        damage = this.dodgeAnAttack(damage);
        health -= damage;
        System.out.printf("Alert: %s is damaged %.2f, rest %.0f%n", name, damage, health);
        if(!isAlive()) System.out.printf("Alert: %s is dead%n", name);
        System.out.println("");
        return health;
    }

    public double dodgeAnAttack(double damage){
        return damage;
    }

    @Override
    public boolean isAlive() {
        if(health > 0) return true;
        return false;
    }
}

