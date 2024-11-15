//2024.11.14

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyQuickSortTest {

    static final int COUNT_OF_EVERY_TEST = 21;
    static final int COUNT_OF_ELEMENTS_OF_ARRAY = 500;
    MyQuickSort myQuickSort;

    @BeforeEach
    void setUp() {
        myQuickSort = new MyQuickSort();
    }

    @ParameterizedTest
    @DisplayName("DIRECT. sort(array)")
    @MethodSource("arrayAndArrayExpectedProvider_Direct")
    void sort_Params_OnlyArray(Object[] array, Object[] arrayExpected) {
        //Arrange
        //Act
        myQuickSort.sort(array);

        //Assert
        assertArrayEquals(arrayExpected, array);
    }

    @ParameterizedTest
    @DisplayName("DIRECT. sort(array, Comparator.naturalOrder())")
    @MethodSource("arrayAndArrayExpectedAndComparatorProvider_Direct")
    void sort_Params_ArrayAndComparator_Direct(Object[] array, Object[] arrayExpected, Comparator comparator) {
        //Arrange
        //Act
        myQuickSort.sort(array, comparator);

        //Assert
        assertArrayEquals(arrayExpected, array);
    }

    @ParameterizedTest
    @DisplayName("REVERSE. sort(array, Comparator.reverseOrder())")
    @MethodSource("arrayAndArrayExpectedAndComparatorProvider_Reverse")
    void sort_Params_ArrayAndComparator_Reverse(Object[] array, Object[] arrayExpected, Comparator comparator) {
        //Arrange
        //Act
        myQuickSort.sort(array, comparator);

        //Assert
        assertArrayEquals(arrayExpected, array);
    }

    static public Stream<Arguments> arrayAndArrayExpectedProvider_Direct(){
        return arrayAndArrayExpectedAndComparatorProvider_Direct()
                .map(x -> Arguments.of(x.get()[0], x.get()[1]));
    }

    static public Stream<Arguments> arrayAndArrayExpectedAndComparatorProvider_Direct() {
        return arrayAndArrayExpectedAndComparatorProvider(Comparator.naturalOrder());
    }

    static public Stream<Arguments> arrayAndArrayExpectedAndComparatorProvider_Reverse() {
        return arrayAndArrayExpectedAndComparatorProvider(Comparator.reverseOrder());
    }

    static public Stream<Arguments> arrayAndArrayExpectedAndComparatorProvider(Comparator comparator){
        Stream<Arguments> streamOfIntegers =
                generateStreamOfArrayAndArrayExpectedAndComparatorForProvider(comparator, "Integer");

        Stream<Arguments> streamOfDoubles =
                generateStreamOfArrayAndArrayExpectedAndComparatorForProvider(comparator, "Double");

        Stream<Arguments> streamOfStrings =
                generateStreamOfArrayAndArrayExpectedAndComparatorForProvider(comparator, "String");


        return Stream.concat(
                Stream.concat(streamOfIntegers, streamOfDoubles),
                streamOfStrings);
    }

    static public Stream<Arguments> generateStreamOfArrayAndArrayExpectedAndComparatorForProvider
            (Comparator comparator, String typeOfGeneration){
        Arguments[] arguments = new Arguments[COUNT_OF_EVERY_TEST];
        
        for(int numberOfTestOfThisKindOfGeneration = 0
            ; numberOfTestOfThisKindOfGeneration < COUNT_OF_EVERY_TEST
                ; numberOfTestOfThisKindOfGeneration++){
            
            List<Object> arrayToSort = new ArrayList<>(COUNT_OF_ELEMENTS_OF_ARRAY);
            List<Object> arrayExpected = new ArrayList<>(COUNT_OF_ELEMENTS_OF_ARRAY);

            fillingTwoListsWithIdenticalElements
                    (arrayToSort, arrayExpected, numberOfTestOfThisKindOfGeneration, typeOfGeneration);
            
            arrayExpected.sort(comparator);
            arguments[numberOfTestOfThisKindOfGeneration] = Arguments.of(
                    arrayToSort.toArray()
                    , arrayExpected.toArray()
                    , comparator);
            //System.out.println("-2--> " + arrayToSort);
            //System.out.println("-1--> " + arrayExpected);
        }
        
        return Arrays.stream(arguments);
    }
    static public void fillingTwoListsWithIdenticalElements
            (List array1, List array2, int shift, String typeOfGeneration){
        for(int j = 0; j < COUNT_OF_ELEMENTS_OF_ARRAY; j++){
            Object element = 0;
            if (typeOfGeneration.equals("String")) element = generateElementOfString(j, shift);
            else if (typeOfGeneration.equals("Double")) element = generateElementOfDouble(j, shift);
            else element = generateElementOfInteger(j, shift);
            
            array1.add(element);
            array2.add(element);
        }
    }

    static public Integer generateElementOfInteger(int index, int shift){
        int number = index % 2 == 0 ? index : COUNT_OF_ELEMENTS_OF_ARRAY - index;

        number -= COUNT_OF_ELEMENTS_OF_ARRAY / 2;
        if(shift > 0) number *= 3 << (shift * 2);
        return number;
    }

    static public Double generateElementOfDouble(int index, int shift){
        int integerNumber = generateElementOfInteger(index, shift);
        int digits = String.valueOf(integerNumber).length();
        if (integerNumber < 0) digits--;
        double doubleNumber = integerNumber / Math.pow(10, digits) + integerNumber;
        return doubleNumber;
    }

    static public String generateElementOfString(int index, int shift){
        StringBuilder stringBuilder = new StringBuilder();
        for (int countOfCharacters = 0; countOfCharacters < shift + 1; countOfCharacters++){
            stringBuilder.append(generateOneCharacter(index + countOfCharacters * shift));
        }
        return stringBuilder.toString();
    }

    static public Character generateOneCharacter(int index){
        final int alphabetA = 'A';
        final int alphabetZ = 'Z';
        final int sizeOfAlphabetAZ = alphabetZ - alphabetA + 1;

        final int alphabeta = 'a';
        final int alphabetz = 'z';

        int numberOfSymbol = (index / 4) % sizeOfAlphabetAZ;
        int typeOfCharacter = index % 4;
        int character = 0;
        if (typeOfCharacter == 1) character = alphabetA + numberOfSymbol;
        else if (typeOfCharacter == 2) character = alphabetz - numberOfSymbol;
        else if (typeOfCharacter == 3) character = alphabetZ - numberOfSymbol;
        else character = alphabeta + numberOfSymbol;
        return (char) character;
    }
}