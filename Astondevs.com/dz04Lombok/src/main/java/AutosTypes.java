//2024.10.06 zip

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum AutosTypes {
    MOTORBIKE("Motorbike", 2)
    , AUTO("Auto", 4)
    , TRUCK("Truck", 6)
    , TRAIN("Truck trailer", 6);

    @Getter
    private final String type;
    @Getter
    private final int countOfTire;
}
