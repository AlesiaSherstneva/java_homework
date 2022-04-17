package Credit.Exercise09.Technics;

import Credit.Exercise09.Properties.Appointment;
import Credit.Exercise09.Properties.Size;

public class AirConditioner extends Household {
    public AirConditioner() {
        super("Кондиционер", 220, 750, Size.LARGE, Appointment.FOR_HOUSE);
    }
}
