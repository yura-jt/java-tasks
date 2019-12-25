package com.practice.task3_3;

import java.util.Map;

public final class Language extends BaseEnum {
    private static final String[] VALUES = {"ESPERANTO", "DOTHRAKI", "SINDARIN",
            "QUENYA", "KLINGON", "VALYRIAN"};

    private static final Map<String, Language> enums;

    static {
        Class currentClass = new Object() {}.getClass().getEnclosingClass();
        enums = init(VALUES, currentClass);
    }

    public static Language valueOf(String name) {
        if (enums.containsKey(name)) {
            return enums.get(name);
        } else {
            throw new IllegalArgumentException("There is no such element in Enum");
        }
    }

    public static Language[] values() {
        Language[] result = new Language[enums.size()];
        Object[] values = enums.values().toArray();
        for (int i = 0; i < values.length; i++) {
            result[i] = (Language) values[i];
        }
        return result;
    }
}
