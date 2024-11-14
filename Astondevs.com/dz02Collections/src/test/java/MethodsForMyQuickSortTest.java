import org.junit.jupiter.params.provider.Arguments;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MethodsForMyQuickSortTest {

    public static void main(String[] args) {

        printTitelAndSeparator("GenerateOneCharacter (from 0 to n):\n");
        StringBuilder generateOneCharacterString = new StringBuilder();
        for(int i = 0; i < 1000; i++){
            generateOneCharacterString.append(i + ": " +
                    MyQuickSortTest.generateOneCharacter(i));
        }
        System.out.println(generateOneCharacterString);

        printTitelAndSeparator("GenerateElementOfString (from 0 to n):\n");
        StringBuilder generateElementOfString = new StringBuilder();
        for(int i = 0; i < 22; i++){
            generateElementOfString.append(i + ": " +
                    MyQuickSortTest.generateElementOfString(i, i));
            generateElementOfString.append("\n");
        }
        System.out.println(generateElementOfString);

        printTitelAndSeparator("GenerateStreams:\n");
        Stream<Arguments> stream = MyQuickSortTest
                .generateStreamOfArrayAndArrayExpectedAndComparatorForProvider
                        (Comparator.naturalOrder(), "String");
        int count = 0;
        for (Object arg : stream.toArray()){
            System.out.print("Arguments " + ++count + ": ");
            for (Object obj : ((Arguments) arg).get()){
                System.out.print(obj + " ");
            }
            System.out.println("");
        }
    }
    public static void printTitelAndSeparator(String str){
        printSeparator();
        System.out.println(str);
    }

    public static void printSeparator(){
        System.out.println("-------------------------------------------------");
    }

}
