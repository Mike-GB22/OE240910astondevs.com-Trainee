import java.util.Random;

public class Warrior extends Hero{

    public Warrior(String name) {
        super(name);
        this.typ = "Warrior";
    }

    @Override
    public void attackEnemy(){
        System.out.printf("Alert: Warrior %s is attacking %n", name);
    }

    public void attackEnemy(Enemy enemy){
        int damage = new Random().nextInt(20);
        this.attackEnemy(enemy, damage);
    }

}

