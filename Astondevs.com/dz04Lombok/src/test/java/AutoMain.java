import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class AutoMain {
    public static void main(String[] args) {
        List<Auto> autosList = new MyArrayList<>();
        autosList.add(Auto.builder()
                .model("BMW")
                .color(Color.RED)
                .countOfTire(4)
                .type(AutosTypes.AUTO)
                .build());

        autosList.add(Auto.builder()
                .model("WWW")
                .color(Color.GRAY)
                .type(AutosTypes.TRUCK)
                .build());

        autosList.add(new Auto("Dirdik", AutosTypes.MOTORBIKE, 2, Color.BLACK));

        for(Auto auto : autosList){
            System.out.println(auto);
        }

    }
}
