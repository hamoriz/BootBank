package com.hamori.util;

import java.util.Random;

/**
 * Author: Zoltan_Hamori
 */
public class DatabaseSetupUtil {

    private static Random random = new Random();

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
