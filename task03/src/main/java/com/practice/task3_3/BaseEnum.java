package com.practice.task3_3;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseEnum<E extends BaseEnum>
        implements Comparable<E>, Serializable {

    private String name;
    private int ordinal;

    public final String name() {
        return name;
    }

    public final int ordinal() {
        return ordinal;
    }

    public static Map<String, BaseEnum> init(String[] names, Class<? extends BaseEnum> clazz) {
        Map<String, BaseEnum> map = new HashMap<>();
        try {
            BaseEnum parent = clazz.getDeclaredConstructor().newInstance();
            parent.name = "Parent" + clazz.getSimpleName();
            parent.ordinal = -1;
            map = parent.createEnumMap(names, clazz);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    private Map<String, BaseEnum> createEnumMap(String[] names, Class<? extends BaseEnum> clazz) {
        Map<String, BaseEnum> map = new HashMap<>();
        try {
            for (int i = 0; i < names.length; i++) {
                BaseEnum currentEnum = clazz.getDeclaredConstructor().newInstance();
                currentEnum.ordinal = i;
                currentEnum.name = names[i];
                map.put(names[i], currentEnum);
            }
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }

    public final Class getDeclaringClass() {
        Class clazz = getClass();
        Class zuper = clazz.getSuperclass();
        return (zuper == BaseEnum.class) ? clazz : zuper;
    }

    @Override
    public final int compareTo(BaseEnum o) {
        return this.ordinal - o.ordinal;
    }

    public String toString() {
        return name;
    }

    public final boolean equals(Object o) {
        return this == o;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @SuppressWarnings("deprecated")
    protected final void finalize() {
    }

    private void readObject(ObjectInputStream in) throws IOException {
        throw new InvalidObjectException("Enum cannot be deserialized");
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("can't deserialize enum");
    }
}