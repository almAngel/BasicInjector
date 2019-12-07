package src.main.Injector;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Injector {

    private Class<?> selectedClass = null;
    private Object selectedImpl = null;

    private static HashMap<Class<?>, Object> knots = new HashMap<>();

    public Injector() {
    }

    public Object get(Class<?> clazz) {
        Class<?> target = null;
        Constructor<?> constructor;
        Parameter[] parameters;
        List<Parameter> resolvedParameters;

        target = resolveType(clazz);

        if (knots.containsKey(target)) {
            return knots.get(target);
        }
        return null;
    }

    private Class<?> resolveType(Class<?> type) {
        if (knots.containsKey(type)) {
            return knots.get(type).getClass();
        }
        return type;
    }

    public Injector tie(Object iface) {
        this.selectedImpl = iface;
        return this;
    }

    public Injector with(Class<?> selClass) {
        this.selectedClass = selClass;
        return this;
    }

    public void make() {
        if(!knots.containsKey(selectedClass)) {
            knots.put(selectedClass, selectedImpl);
        }
    }

    public static int size() {
        return knots.size();
    }
}
