package org.citopt.connde.constants;

/**
 * Constant terms and values.
 * @author Imeri Amil
 */
public final class Constants {

    //Regex for acceptable usernames
    public static final String USERNAME_REGEX = "^[_'.@A-Za-z0-9-]*$";
    
    public static final String ADMIN = "ROLE_ADMIN";

    public static final String USER = "ROLE_USER";

    public static final String ANONYMOUS = "ROLE_ANONYMOUS";
    
    public static final String[][] componentTypes = { 
									{ "Raspberry Pi", "DEVICE" },
									{ "Arduino", "DEVICE" },
	    							{ "Computer", "DEVICE" },
									{ "Audio System", "DEVICE" },
									{ "Camera", "DEVICE" },
									{ "Gateway", "DEVICE" },
									{ "Laptop", "DEVICE" },
									{ "NodeMCU", "DEVICE" },
									{ "Smartphone", "DEVICE" },
									{ "Smartwatch", "DEVICE" },
									{ "TV", "DEVICE" },
									{ "Voice Controller", "DEVICE" },
									{ "Temperature", "SENSOR" },
									{ "Motion", "SENSOR" },
									{ "Camera", "SENSOR" },
									{ "Location", "SENSOR" },
									{ "Gas", "SENSOR" },
									{ "Sound", "SENSOR" },
									{ "Touch", "SENSOR" },
									{ "Humidity", "SENSOR" },
									{ "Vibration", "SENSOR" },
									{ "Gyroscope", "SENSOR" },
									{ "Proximity", "SENSOR" },
									{ "Light", "SENSOR" },
									{ "Buzzer", "ACTUATOR" },
									{ "Speaker", "ACTUATOR" },
									{ "Switch", "ACTUATOR" },
									{ "LED", "ACTUATOR" },
									{ "Light", "ACTUATOR" },
									{ "Vibration", "ACTUATOR" },
									{ "Motor", "ACTUATOR" },
									{ "Heater", "ACTUATOR" },
									{ "Air Conditioner", "ACTUATOR" } };

    private Constants() {
    }
}
