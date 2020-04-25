package Utils;

import java.util.Random;

public class BaseClass {
    public static final String baseURI = "http://10.144.108.127:9000";

    public static long getRandomNumber() {
        return java.lang.System.currentTimeMillis();
    }

    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }


}
