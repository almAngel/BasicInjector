package main.Injector;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;

public class InjectorBehaviorImpl {

    public static void findAndInject(String inPath) {
        Reflections reflections = new Reflections(inPath, new FieldAnnotationsScanner());

        Set<Field> annotated = reflections.getFieldsAnnotatedWith(Inject.class);

        for (Field field : annotated) {
            while (!field.isAccessible()) {
                field.setAccessible(true);
            }
            if (field.isAccessible()) {
                try {
                    if (Modifier.isStatic(field.getModifiers())) {
                        field.set(field, new Injector().get(field.getType()));
                    } else {
                        field.set(new Injector().get(field.getDeclaringClass()),
                                new Injector().get(field.getType()));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void findAllInjectables(String inPath) throws InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections(inPath);

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Injectable.class);

        if(annotated.size() > 0) {
            for (Class<?> clazz : annotated) {
                //FIRST OFF, REGISTER THE CLASS INSTANCE
                new Injector().tie(clazz.newInstance()).with(clazz).make();
            }
        }
    }

}