import java.util.Random;

public class Mage  extends Hero{

    public Mage(String name){
        super(name);
        this.typ = "Mage";
    }
    @Override
    public void attackEnemy(){
        System.out.printf("Alert: Mage %s is attacking%n", name);
    }

    @Override
    public void attackEnemy(Enemy enemy){
        int damage = new Random().nextInt(10);
        this.attackEnemy(enemy, (int) (damage*0.5));
        if(enemy.isAlive()) this.attackEnemy(enemy, damage);
        if(enemy.isAlive()) this.attackEnemy(enemy, (int) (damage*1.3));
    }

}

