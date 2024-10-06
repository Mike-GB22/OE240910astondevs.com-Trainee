import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        Person ivan = Person.builder().name("Ivan")
                .birthDate(LocalDate.of(1990, Month.APRIL, 1))
                .isAMan(true)
                .build();

        Person petr = new Person("Petr", LocalDate.of(1995, Month.JANUARY, 12)
                , 180, 80, true, Color.GREEN, new Color(210, 196, 183));

        Person alex = Person.builder().name("Alexandra")
                .birthDate(LocalDate.of(2019, Month.JULY, 21))
                .eyesColor(Color.BLUE)
                .hairColor(new Color(246, 241, 213))
                .isAMan(false)
                .build();

        List<Person> personsList = new MyArrayList<>();
        personsList.add(ivan);
        personsList.add(petr);
        personsList.add(alex);

        for(Person person : personsList){
            System.out.println(person.getName() + ", age: " + person.getAge() + ": isAdult: " + person.isAdult());
            System.out.println("Full info: " + person + "\n");

        }
    }
}
