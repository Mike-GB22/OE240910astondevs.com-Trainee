abstract public class Hero extends Enemy{

    String typ = "Ghost";
    public Hero(String name){
        super(name);
    }

    public String getName(){
        return name;
    }

//    public void attackEnemy(){
//        System.out.printf("Alert: Hero %s is attacking%n", name);
//    }

    abstract public void attackEnemy();
    abstract public void attackEnemy(Enemy enemy);

    public boolean attackEnemy(Enemy enemy, int damage){
        if(!this.isAlive()) return false;
        System.out.printf("Alert: %s %s is attacking on %s, damage %d %n"
                , typ, name, enemy.name, damage);
        enemy.takeDamage(damage);
        return true;
    }


}
