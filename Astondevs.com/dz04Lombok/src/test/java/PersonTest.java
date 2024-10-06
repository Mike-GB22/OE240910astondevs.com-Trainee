//2024.10.06 zip
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

class PersonTest {
    Person personOne;
    Person personTwo;
    Person personNewBorn = Person.builder().birthDate(LocalDate.now()).build();

    final boolean genFlanAMan = true;
    final boolean genFlanAWoman = false;

    final String name1 = "Ivan";
    final String name2 = "Alexandra";

    final LocalDate bd1 = LocalDate.of(1999, Month.AUGUST, 1);
    final LocalDate bd2 = LocalDate.of(2015, Month.DECEMBER, 31);

    final Color eyeColor1 = Color.BLUE;
    final Color eyeColor2 = Color.GRAY;

    final Color hairColor1 = Color.WHITE;
    final Color hairColor2 = Color.YELLOW;

    final int height1 = 180;
    final int height2 = 110;

    final int weight1 = 100;
    final int weight2 = 35;

    Person makeAPersonOne(){
        return new Person(name1, bd1, height1, weight1, genFlanAMan, eyeColor1, hairColor1);
    }

    @BeforeEach
    void before(){
        personOne = makeAPersonOne();
        personTwo = new Person(name2, bd2, height2, weight2, genFlanAWoman, eyeColor2, hairColor2);
    }
    @Test
    void getAge() {
        assertEquals(getAgeForTest(personOne.getBirthDate()), personOne.getAge());
        assertEquals(getAgeForTest(personTwo.getBirthDate()), personTwo.getAge());

        assertNotEquals(getAgeForTest(personTwo.getBirthDate()), personOne.getAge());
        assertNotEquals(getAgeForTest(personOne.getBirthDate()), personTwo.getAge());
    }

    int getAgeForTest(LocalDate birthDate) {
        LocalDate nowLD = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(birthDate, nowLD);
    }


    @Test
    void isAdult() {
        assertTrue(personOne.isAdult());
        assertEquals(personTwo.getAge() >= Person.ADULT_AGE, personTwo.isAdult());
        assertFalse(personNewBorn.isAdult());
    }

    @Test
    void testEquals() {
        assertTrue(personOne.equals(makeAPersonOne()));
        assertFalse(personOne.equals(personTwo));
    }

    @Test
    void canEqual() {
        assertTrue(personOne.canEqual(personTwo));
        assertFalse(personOne.canEqual("String"));
    }

    @Test
    void testHashCode() {
        assertEquals(makeAPersonOne().hashCode(), personOne.hashCode());
        assertNotEquals(personTwo.hashCode(), personOne.hashCode());
    }

    @Test
    void testToString() {
        assertEquals(makeAPersonOne().toString(), personOne.toString());
        assertNotEquals(personTwo.toString(), personOne.toString());
    }

    @Test
    void builder() {
        Person personMadeByBuilder = Person.builder()
                .name(name2)
                .birthDate(bd2)
                .isAMan(genFlanAWoman)
                .height(height2)
                .weight(weight2)
                .eyesColor(eyeColor2)
                .hairColor(hairColor2)
                .build();
        assertEquals(personTwo, personMadeByBuilder);
    }

    @Test
    void getName() {
        assertEquals(name1, personOne.getName());
        assertEquals(name2, personTwo.getName());
    }

    @Test
    void getBirthDate() {
        assertEquals(bd1, personOne.getBirthDate());
        assertEquals(bd2, personTwo.getBirthDate());
    }

    @Test
    void getHeight() {
        assertEquals(height1, personOne.getHeight());
        assertEquals(height2, personTwo.getHeight());
        assertNotEquals(height2, personOne.getHeight());
    }

    @Test
    void getWeight() {
        assertEquals(weight1, personOne.getWeight());
        assertEquals(weight2, personTwo.getWeight());
        assertNotEquals(weight2, personOne.getWeight());
    }

    @Test
    void isAMan() {
        assertEquals(genFlanAMan, personOne.isAMan());
        assertEquals(genFlanAWoman, personTwo.isAMan());
    }

    @Test
    void getEyesColor() {
        assertEquals(eyeColor1, personOne.getEyesColor());
        assertEquals(eyeColor2, personTwo.getEyesColor());
    }

    @Test
    void getHairColor() {
        assertEquals(hairColor1, personOne.getHairColor());
        assertEquals(hairColor2, personTwo.getHairColor());
    }

    @Test
    void setName() {
        personOne.setName(name2);
        assertEquals(name2, personOne.getName());
    }

    @Test
    void setBirthDate() {
        personOne.setBirthDate(bd2);
        assertEquals(bd2, personOne.getBirthDate());
    }

    @Test
    void setHeight() {
        personOne.setHeight(height2);
        assertEquals(height2, personOne.getHeight());
    }

    @Test
    void setWeight() {
        personOne.setWeight(weight2);
        assertEquals(weight2, personOne.getWeight());
    }

    @Test
    void setAMan() {
        personOne.setAMan(genFlanAWoman);
        assertEquals(genFlanAWoman, personOne.isAMan());
    }

    @Test
    void setEyesColor() {
        personOne.setEyesColor(eyeColor2);
        assertEquals(eyeColor2, personOne.getEyesColor());
    }

    @Test
    void setHairColor() {
        personOne.setHairColor(hairColor2);
        assertEquals(hairColor2, personOne.getHairColor());
    }
}