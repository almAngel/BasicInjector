package src.main.Injector;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Injector {

    private Class<?> selectedClass = null;
    private Object selectedImpl = null;

    private static HashMap<Class<?>, Object> knots = new HashMap<>();

    public Injector() {}

    public Object get(Class<?> clazz) {
        Class<?> target = null;
        Constructor<?> constructor;
        Parameter[] parameters;
        List<Parameter> resolvedParameters;

        try {
            target = resolveType(clazz);

            constructor = target.getConstructors()[0];
            parameters = constructor.getParameters();
            resolvedParameters = new ArrayList<>();

            if(parameters.length != 0) {
                for (Parameter param: resolvedParameters) {
                    resolvedParameters.add(param);
                }
            } else {
                return constructor.newInstance(parameters);
            }

            return constructor.newInstance(resolvedParameters);
        }
        catch (IllegalAccessException iae) {}
        catch (InvocationTargetException ite) {}
        catch (InstantiationException ie) {}


        return null;
    }

    private static Class<?> resolveType(Class<?> type) {
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
        knots.put(selectedClass, selectedImpl);
    }
}
