public class Enemy implements Mortal{
    int health;
    String name = "ErrorName";

    public Enemy(String name, int health){
        this.name = name;
        this.health = health;
    }
    public Enemy(String name){
        this(name, 100);
    }
    public Enemy(int health){
        this("WithOutName", health);
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int takeDamage(int damage){
        if(!isAlive()){
            System.out.printf("Alert: %s is already! dead%n", name);
            return health;
        }
        health -= damage;
        System.out.printf("Alert: %s is damaged %d, rest %d%n", name, damage, health);
        if(!isAlive()) System.out.printf("Alert: %s is dead%n", name);
        return health;
    }

    @Override
    public boolean isAlive() {
        if(health > 0) return true;
        return false;
    }
}

