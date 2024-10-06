//2024.10.06 zip
import lombok.*;

import java.awt.*;

@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Auto {
    @Getter @Setter
    String model;
    @Getter @Setter
    AutosTypes type;
    @Getter
    int countOfTire;
    @Getter @Setter
    Color color;

}
