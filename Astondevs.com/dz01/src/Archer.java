import java.util.Random;

public class Archer extends Hero{

    public Archer(String name){
        super(name);
        this.typ = "Archer";
    }

    @Override
    public void attackEnemy(){
        System.out.printf("Alert: Archer %s is attacking%n", name);
    }

    @Override
    public void attackEnemy(Enemy enemy){
        int damage = new Random().nextInt(15);
        this.attackEnemy(enemy, damage);
    }

}
