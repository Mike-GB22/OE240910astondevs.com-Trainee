import Units.Hero;
import Units.Mage;
import Units.Warrior;
import Units.Weapons.MagicWands.Wand;
import Units.Weapons.Swords.Sword;

public class BattleGround {
    Hero opponent1;
    Hero opponent2;
    Hero winner;

    public BattleGround(Hero opp1, Hero opp2){
        opponent1 = opp1;
        opponent2 = opp2;
    }

    private Hero battle(){
        while(opponent1.isAlive() && opponent2.isAlive()) {
            opponent1.attackEnemy(opponent2);
            opponent2.attackEnemy(opponent1);
        }

        if(opponent1.isAlive()) return opponent1;
        else return opponent2;
    }

    private void printStartMsg() {
        TrainingGround.printSplitter();
        System.out.printf("Battle: %s VS %s %n", opponent1.getName(), opponent2.getName());
        TrainingGround.printSplitter();
    }

    private void printEndMsg() {
        TrainingGround.printSplitter();
        System.out.printf("%s %s is the winner. Rest health is %.0f %n"
                , winner.getTypeOfHero(), winner.getName(), winner.getHealth());
        TrainingGround.printSplitter();
    }

    public void start() {
        printStartMsg();
        winner = battle();
        printEndMsg();
    }

    public static void main(String[] args) {
        System.out.println("Battle 1. Default weapons!");
        BattleGround battle1 = new BattleGround(
                new Warrior("Adam")
                , new Mage("Merlin"));

        battle1.start();

        System.out.println("Battle 2. Change weapons!");
        BattleGround battle2 = new BattleGround(
                new Warrior("Adam", new Wand())
                , new Mage("Merlin", new Sword()));

        battle2.start();
    }
}
