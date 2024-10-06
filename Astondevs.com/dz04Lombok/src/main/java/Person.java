//2024.10.05
import lombok.*;

import java.awt.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Person {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private LocalDate birthDate;
    @Getter @Setter
    private int height;
    @Getter @Setter
    private int weight;
    @Getter @Setter
    private boolean isAMan;
    @Getter @Setter
    private Color eyesColor;
    @Getter @Setter
    private Color hairColor;

    public final static int ADULT_AGE = 18;
    int getAge(){
        LocalDate localDateNow = LocalDate.now();
        if(birthDate == null || localDateNow.isBefore(birthDate))
            throw new IllegalStateException("The Person is not born, birthDate is " + birthDate);
        long age = ChronoUnit.YEARS.between(birthDate, localDateNow);

        return (int) age;
    }
    boolean isAdult(){
        return getAge() >= ADULT_AGE;
    }
}
