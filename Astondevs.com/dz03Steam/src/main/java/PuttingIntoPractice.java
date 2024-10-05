//2024.10.04 zip
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class PuttingIntoPractice {
    static List<Transaction> transactions;
    static List<Transaction> tempList;
    public static void main(String... args) {
        System.out.println("Игры со Steam API");

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader zipper = new Trader("Zipper", "Moskau");
        Trader dipper = new Trader("Dipper", "Rostov");


        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(brian, 2011, 310),
                new Transaction(raoul, 2011, 400),
                new Transaction(zipper, 2011, 300),
                new Transaction(mario, 2011, 700),
                new Transaction(dipper, 2011, 500),

                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2012, 900),
                new Transaction(dipper, 2012, 1100),
                new Transaction(raoul, 2012, 400),
                new Transaction(raoul, 2012, 400),
                new Transaction(zipper, 2012, 300),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("Изначальный список транзакций:\n" + listToStrings(transactions));

        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
    }

    public static void task1(){
        System.out.println("\nTask 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).");
        tempList = transactions.stream().filter(x -> x.getYear() == 2011)
                .sorted((o1, o2) -> o1.getValue() - o2.getValue())
                .toList();

        System.out.println(
                listToStrings(tempList));
    }

    //
    public static void task2(){
        System.out.println("\nTask 2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        List<String> tempList = transactions.stream().
                map(x -> x.getTrader().getCity())
                .distinct()
                .toList();

        System.out.println(tempList);
    }

    public static void task3(){
        System.out.println("\nTask 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        List<String> tempList = transactions.stream()
                .filter(x -> Objects.equals(x.getTrader().getCity(), "Cambridge"))
                .map(x -> x.getTrader().getName())
                .distinct()
                .sorted()
                .toList();

        System.out.println(tempList);
    }

    public static void task4(){
        System.out.println("\nTask 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
        List<String> tempList = transactions.stream()
                .map(x -> x.getTrader().getName())
                .distinct()
                .sorted()
                .toList();

        //Add "," after Name.
        System.out.print("Variant 1: ");
        AtomicInteger count = new AtomicInteger();
        AtomicInteger count2 = new AtomicInteger();
        StringBuilder tempString1 = new StringBuilder();
        tempList.stream()
                .peek(x -> {count.getAndIncrement();})
                .toList().stream()
                .map(x -> {
                    count2.getAndIncrement();
                    if(count2.get() == count.get()) {
                        return x;
                    }
                    return x.concat(", ");
                })
                .forEach(tempString1::append);

        System.out.println(tempString1.toString());

        System.out.print("Variant 2: ");
        StringBuilder tempString2 = new StringBuilder();
        tempList.stream()
                .forEach(x -> tempString2.append(x + ", "));

        System.out.println(tempString2.substring(0, tempString2.length() - 2));

    }

    //
    public static void task5(){
        System.out.println("\nTask 5. Выяснить, существует ли хоть один трейдер из Милана.");
        String cityToFind = "Milan";
        String result = "В списке нет НИ ОДНОГО человек из " + cityToFind;
        if(transactions.stream()
                .anyMatch(x -> Objects.equals(x.getTrader().getCity(), cityToFind))
        ) result = "В списке есть хотя бы ОДИН человек из " + cityToFind;

        System.out.println(result);
    }

    public static void task6(){
        System.out.println("\nTask 6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        String cityToFind = "Cambridge";
        Optional<Integer> summ = transactions.stream()
                .filter(x -> cityToFind.equals(x.getTrader().getCity()))
                .map(x -> x.getValue())
                .reduce((a, b) -> a + b);
        System.out.printf("Сумма всех транзакций из %s равна: %d%n", cityToFind, summ.get());
    }

    public static void task7(){
        System.out.println("\nTask 7. Найти транзакцию с минимальным и максимальным значением.");
        Optional<Transaction> minElement = transactions.stream()
                        .min((o1, o2) -> o1.getValue() - o2.getValue());
        System.out.printf("Минимальный элемент платеж: %d, в транзакции: %s%n", minElement.get().getValue(),  minElement.get());

        Optional<Transaction> maxElement= transactions.stream()
                .max((o1, o2) -> o1.getValue() - o2.getValue());
        System.out.printf("Максимальный элемент платеж: %d, в транзакции: %s%n", maxElement.get().getValue(),  maxElement.get());
    }

    public static void task8(){
        System.out.println("\nTask 8. Какова сумма среди всех транзакций?");

        Optional<Integer> summ = transactions.stream()
                .map(x -> x.getValue())
                .reduce((a, b) -> Integer.sum(a, b));
        System.out.println("Сумма всех транзацкий: " + summ.get());
    }

    public static void task9(){
        System.out.println("\nTask 9. Какова сумма среди всех транзакций, в разрезе по брокерам?");
        List<Trader> listOfTraders = transactions.stream()
                .map(x -> x.getTrader())
                .distinct()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .toList();

        for(Trader trader : listOfTraders){
            Optional<Integer> sum;
            sum = transactions.stream()
                    .filter(x -> Objects.equals(x.getTrader(),trader))
                    .map(x -> x.getValue())
                    .reduce((a, b) -> Integer.sum(a, b));

        System.out.printf("Сумма всех транзацкий по трейдеру: %s, равна: %d"
                , trader.getName(), sum.get());
        System.out.println(". Трейдер: " + trader);
        }
    }

    public static void task10(){
        System.out.println("\nTask 10. Какова сумма среди всех транзакций, в разрезе по городам?");
        List<String> listOfCities = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .toList();

        for(String city : listOfCities){
            Optional<Integer> sum;
            sum = transactions.stream()
                    .filter(x -> Objects.equals(x.getTrader().getCity(), city))
                    .map(x -> x.getValue())
                    .reduce((a, b) -> (a + b));

            System.out.printf("Сумма всех транзацкий по городу: %s, равна: %d%n" , city, sum.get());
        }
    }

    public static void task11(){
        System.out.println("\nTask 11. Какова сумма среди всех транзакций, в разрезе по годам?");
        List<Integer> listOfYears = transactions.stream().map(x -> x.getYear())
                .distinct()
                .sorted()
                .toList();

        for(Integer year : listOfYears){
            Optional<Integer> sum;
            sum = transactions.stream()
                    .filter(x -> Objects.equals(x.getYear(), year))
                    .map(x -> x.getValue())
                    .reduce(Integer::sum);
            System.out.printf("Сумма всех транзацкий по году: %s, равна: %d%n" , year, sum.get());
        }
    }

    public static <E> String listToStrings(List<E> list){
        StringBuilder result = new StringBuilder();
        for(E element : list){
            result.append(element + "\n");
        }
        return result.toString();
    }

}