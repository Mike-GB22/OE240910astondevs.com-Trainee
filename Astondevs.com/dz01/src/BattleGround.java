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

        if(opponent1.isAlive())  return opponent1;
        else return opponent2;
    }

    private void printStartMsg() {
        System.out.println("---------------------");
        System.out.printf("Battle: %s VS %s %n", opponent1, opponent2);
        System.out.println("---------------------");
    }

    private void printEndMsg() {
        System.out.println("---------------------");
        System.out.printf("%s %s is winner. Rest health %d %n", winner.typ, winner.name, winner.health);
        System.out.println("---------------------");
    }

    public void start() {
        printStartMsg();
        winner = battle();
        printEndMsg();
    }

    public static void main(String[] args) {
        BattleGround battle1 = new BattleGround(
                new Warrior("Adam")
                , new Mage("Merlin"));

        battle1.start();
    }
}
