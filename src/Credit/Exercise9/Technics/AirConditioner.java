package Credit.Exercise9.Technics;

import Credit.Exercise9.Properties.Appointment;
import Credit.Exercise9.Properties.Size;

public class AirConditioner extends Household {
    public AirConditioner() {
        super("Кондиционер", 220, 750, Size.LARGE, Appointment.FOR_HOUSE);
    }
}
